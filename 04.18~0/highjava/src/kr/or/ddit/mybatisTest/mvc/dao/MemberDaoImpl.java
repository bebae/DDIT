package kr.or.ddit.mybatisTest.mvc.dao;

import kr.or.ddit.mybatisTest.mvc.vo.MemberVo;
import kr.or.ddit.util.DBUtil3;
import kr.or.ddit.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDaoImpl implements IMemberDao {

    private static MemberDaoImpl memDao;

    private MemberDaoImpl() {}

    public static MemberDaoImpl getInstance() {
        if(memDao == null) memDao = new MemberDaoImpl();
        return memDao;
    }

    @Override
    public int insertMember(MemberVo memberVo) {
        SqlSession session = null;
        int cnt = 0;
        try {
            session = MyBatisSqlSessionFactory.getSqlSession();
            cnt = session.insert("member.insertMember", memberVo);
            if (cnt > 0) session.commit();
        } finally {
            if(session != null) session.close();
        }

        return cnt;
    }

    @Override
    public int deleteMember(String memId) {
        SqlSession session = null;
        int cnt = 0;
        try {
            session = MyBatisSqlSessionFactory.getSqlSession();
            cnt = session.delete("member.deleteMember", memId);
            if (cnt > 0) session.commit();
        } finally {
            if(session != null) session.close();
        }

        return cnt;
    }

    @Override
    public int updateMember(MemberVo memberVo) {
        SqlSession session = null;
        int cnt = 0;
        try {
            session = MyBatisSqlSessionFactory.getSqlSession();
            cnt = session.update("member.updateMember", memberVo);
            if (cnt > 0) session.commit();
        } finally {
            if(session != null) session.close();
        }

        return cnt;
    }

    @Override
    public List<MemberVo> getAllMember() {
        SqlSession session = null;
        List<MemberVo> memberList = new ArrayList<>(); // 반환할 리스트 객체 생성
        try {
            session = MyBatisSqlSessionFactory.getSqlSession();
            memberList = session.selectList("member.getAllMember");
        } finally {
            if(session != null) session.close();
        }
        return memberList; // 리스트 객체 반환
    }

    @Override
    public int getMemberCount(String memId) {
        SqlSession session = null;
        int cnt = 0;
        try {
            session = MyBatisSqlSessionFactory.getSqlSession();
            cnt = session.selectOne("member.getMemberCount", memId);
            if (cnt > 0) session.commit();
        } finally {
            if(session != null) session.close();
        }
        return cnt;
    }

    @Override
    public int updateMember2(Map<String, String> paramMap) {
        SqlSession session = null;
        int cnt = 0;

        try {
            session = MyBatisSqlSessionFactory.getSqlSession();
            cnt = session.update("member.updateDetail", paramMap);
//            if (cnt > 0) session.commit();
        } finally {
            if(session != null) session.close();
        }
        return cnt;
    }

}
