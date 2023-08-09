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
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
        File uploadPath = new File(uploadFolder, getFolder());

        log.info("업로드 폴더 경로 : " + uploadPath);

        // 업로드 경로의 폴더가 없다면 생성
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
            String filenameWithDate = getFolder() + File.separator + uploadFileName;
            attachVO.setFilename("/" + filenameWithDate.replace("\\", "/")); // replace를 통해 역슬래시를 슬래시로 변경
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
    public List<BookInfoVO> listBook(Map<String, Object> map){
        return this.bookInfoDao.listBook(map);
    }

    @Override
    public int getBookInfoTotal(Map<String, Object> map) {
        return this.bookInfoDao.getBookInfoTotal(map);
    }

    @Override
    public BookInfoVO detailBook(String bookId) {
        return this.bookInfoDao.detailBook(bookId);
    }

    @Override
    public int updateBookPost(BookInfoVO bookInfoVO) {
        // 1) 도서 정보 수정
        int result = this.bookInfoDao.updateBookPost(bookInfoVO);

        // 2) 첨부파일 수정
        ///////////////// 파일 수정 시작

        // 2-1) 파일이 있음(파일 수정)

        if (bookInfoVO.getBookImage().getSize() > 0) {
            log.info("수정 파일 있음");
            // 업로드 폴더 설정
            String uploadFolder = "C:/Users/PC-03/git/DDIT/06.21~0/springProj/src/main/webapp/resources/images/";

            // 연월일 폴더 설정
            File uploadPath = new File(uploadFolder, getFolder());

            // 업로드 경로의 폴더가 없다면 생성
            if(!uploadPath.exists()) {
                uploadPath.mkdirs();
            }

            log.info("업로드 폴더 경로 : " + uploadPath);

            // 원래 파일명 할당 변수
            MultipartFile multipartFile = bookInfoVO.getBookImage();
            String uploadFileName = multipartFile.getOriginalFilename();

            // 파일 정보 확인
            log.info("수정 파일명 : " + uploadFileName);
            log.info("수정 파일크기 : " + multipartFile.getSize());
            log.info("수정 MIME타입 : " + multipartFile.getContentType());


            // 같은날 같은 이름의 파일 중복 방지를 위해
            UUID uuid = UUID.randomUUID();
            uploadFileName = uuid + "_" + uploadFileName;



            File saveFile = new File(uploadPath, uploadFileName);
            try {
                multipartFile.transferTo(saveFile);

                // /imges/2023/07/28/UUID_파일이름.jpg 처리
                String filenameWithDate = getFolder() + File.separator + uploadFileName;

                // 파일 복사 설계(복사할 대상 경로, 파일명)
                AttachVO  attachVO = new AttachVO();
                // SEQ(자동생성), book_id, filename
                attachVO.setBookId(bookInfoVO.getBookId());
                attachVO.setFilename("/" + filenameWithDate.replace("\\", "/")); // replace를 통해 역슬래시를 슬래시로 변경

                // Attach 테이블 update 처리
                result += this.bookInfoDao.updateAttach(attachVO);

            } catch (IllegalStateException e) {
                log.error(e.getMessage());
                result = 0;
            } catch (IOException e) {
                log.error(e.getMessage());
                result = 0;
            }
        } else {
        // 2-2) 파일이 없음(파일은 수정안함)
            log.info("수정 파일 없음");
            return result;
        }
        ///////////////// 파일 수정 끝

        return result;
    }

    @Override
    public int deleteBookPost(BookInfoVO bookInfoVO) {
        return this.bookInfoDao.deleteBookPost(bookInfoVO);
    }

    /// 연원일 폴더 생성
    public String getFolder(){
        SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String str = sdf.format(date);
        return str.replace("-", File.separator);
    }

}
