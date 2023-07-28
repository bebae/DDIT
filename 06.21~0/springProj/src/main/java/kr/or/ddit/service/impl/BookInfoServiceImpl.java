package kr.or.ddit.service.impl;

import kr.or.ddit.dao.BookInfoDao;
import kr.or.ddit.service.BookInfoService;
import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BookInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class BookInfoServiceImpl implements BookInfoService {

    @Autowired
    BookInfoDao bookInfoDao;

    @Override
    public int addBookPost(BookInfoVO bookInfoVO) {
        int result = this.bookInfoDao.addBookPost(bookInfoVO);

        // AttachVO에 bookId, filename이 넘겨줘야 함
        AttachVO attachVO = new AttachVO();
        attachVO.setBookId(bookInfoVO.getBookId());

        // 첨부파일 처리 시작 //////////
        // private MultipartFile bookImage;
        String uploadFolder = "C:/Users/PC-03/git/DDIT/06.21~0/springProj/src/main/webapp/resources/images/";
//        String uploadFolder = "C:\\Users\\PC-03\\git\\DDIT\\06.21~0\\springProj\\src\\main\\webapp\\resources\\images\\";

        // 연/월/일 폴더 생성 --> 예) 2023-07-28 이라면 images 밑에 2023/07/28 폴더 생성
        SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String str = sdf.format(date);
        File uploadPath = new File(uploadFolder, str.replace("-", File.separator));
        log.info("uploadPath : " + uploadPath);

        log.info("업로드 폴더 경로 : " + uploadPath);

        if(!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        MultipartFile multipartFile = bookInfoVO.getBookImage();
        String uploadFileName = multipartFile.getOriginalFilename();
        log.info("파일명 : " + uploadFileName);
        log.info("파일크기 : " + multipartFile.getSize());
        log.info("MIME타입 : " + multipartFile.getContentType());

        // 같은날 같은 이름의 파일 중복 방지를 위해
        UUID uuid = UUID.randomUUID();
        uploadFileName = uuid + "_" + uploadFileName;

        // 파일 객체 복사 설계(복사할 대상 경로, 파일명)
        File saveFile = new File(uploadPath, uploadFileName);
        try {
            multipartFile.transferTo(saveFile);

            // /imges/2023/07/28/UUID_파일이름.jpg 처리
            attachVO.setFilename("/" + str.replace("-", File.separator).replace("\\", "/") + uploadFileName);
            result += this.bookInfoDao.addAttach(attachVO);

        } catch (Exception e) {
            log.error(e.getMessage());
            result = 0;
        }

        // 첨부파일 처리 끝 //////////
        return result;
    }

    // 도서 코드 생성
    @Override
    public String getBookId(){
        return this.bookInfoDao.getBookId();
    }

    // 도서 목록
    @Override
    public List<BookInfoVO> listBook(){
        return this.bookInfoDao.listBook();
    }
}
