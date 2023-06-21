package kr.or.ddit.mybatisTest.mvc.dao;

import kr.or.ddit.mybatisTest.mvc.vo.MemberVo;

import java.util.List;
import java.util.Map;


/**
 * 실제 DB와 연결하는 SQL문 수행 결과를 Service에 전달하는 Interface<br>
 * 메소드 하나가 DB와 관련된 작업 1개를 수행함
 */
public interface IMemberDao {
    /**
     * MemberVo 객체에 담겨진 자료를 DB에 insert하는 메소드
     * @param memberVo memVo DB에 insert할 자료가 저장된 VO 객체
     * @return 작업 성공 : 1, 작업 실패 : 0
     */
    public int insertMember(MemberVo memberVo);

    /**
     * 회원 ID를 받아 해당 회원 정보를 삭제하는 메소드
     * @param memId 삭제할 회원 ID
     * @return 작업 성공 : 1, 작업 실패 : 0
     */
    public int deleteMember(String memId);

    /**
     * MemberVo객체에 저장된 자료를 DB에 update하는 메소드
     * @param memberVo 업데이트할 회원 정보가 저장된 MemberVo객체
     * @return 작업 성공 : 1, 작업 실패 : 0
     */
    public int updateMember(MemberVo memberVo);

    /**
     * DB 전체 회원 정보를 가져와서 List에 담아서 반환하는 메소드
     *
     * @return MemberVo 객체가 저장된 List
     */
    public List<MemberVo> getAllMember();

    /**
     * 회원 ID를 매개변수로 받아서 해당 회원ID의 개수를 반환하는 메소드
     * @param memId 검색할 회원ID
     * @return  검색되 회원ID 개수
     */
    public int getMemberCount(String memId);

    /**
     * 회원 ID를 받아 MemberVo객체에 저장된 자료 중 속성 한 개를 DB에 update하는 메소드
     *      // key값 정보 ==> 회원ID(memid), 수정할 컬럼명(field), 수정할 데이터(data)
     * @param paraMap 수정항목, 수정할 값, 수정할 회원 ID
     * @return 작업 성공 : 1, 작업 실패 : 0
     */
    int updateMember2(Map<String, String> paraMap);
}
