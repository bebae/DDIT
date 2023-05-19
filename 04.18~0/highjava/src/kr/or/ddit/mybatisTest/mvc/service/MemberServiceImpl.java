package kr.or.ddit.mybatisTest.mvc.service;

import kr.or.ddit.mybatisTest.mvc.dao.IMemberDao;
import kr.or.ddit.mybatisTest.mvc.dao.MemberDaoImpl;
import kr.or.ddit.mybatisTest.mvc.vo.MemberVo;

import java.util.List;
import java.util.Map;

public class MemberServiceImpl implements IMemberService {
    private final IMemberDao dao;     // DAO 객체가 저장될 변수 선언
    private static MemberServiceImpl service;      // 싱글톤 인스턴스 객체

    private MemberServiceImpl() {
//        dao = new MemberDaoImpl();
        dao = MemberDaoImpl.getInstance();
    }

    public static MemberServiceImpl getInstance() {
        if(service == null) service = new MemberServiceImpl();
        return service;
    }

    @Override
    public int insertMember(MemberVo memberVo) {
        return dao.insertMember(memberVo);
    }

    @Override
    public int deleteMember(String memId) {
        return dao.deleteMember(memId);
    }

    @Override
    public int updateMember(MemberVo memberVo) {
        return dao.updateMember(memberVo);
    }

    @Override
    public List<MemberVo> getAllMember() {
        return dao.getAllMember();
    }

    @Override
    public int getMemberCount(String memId) {
        return dao.getMemberCount(memId);
    }

    public int updateMember2(Map<String, String> paramMap){
        return dao.updateMember2(paramMap);
    }
}
