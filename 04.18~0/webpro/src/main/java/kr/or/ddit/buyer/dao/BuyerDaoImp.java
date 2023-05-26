package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.buyer.vo.BuyerVo;
import kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory;

public class BuyerDaoImp implements IBuyerDao {

	private static IBuyerDao dao;
	
	public static IBuyerDao getInstance() {
		if(dao == null) dao = new BuyerDaoImp();
		return dao;
	}
	
	private BuyerDaoImp() {}

	@Override
	public List<BuyerVo> selectIdName() {
		 SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		 List<BuyerVo> buyerVo = null;
		 
		 try {
			 buyerVo = session.selectList("buyer.getBuyer");
		 } finally {
			 if(session != null) session.close();
		 }
		 
		return buyerVo;
	}

	@Override
	public BuyerVo selectDetails(String buyerId) {
		 SqlSession session = MyBatisSqlSessionFactory.getSqlSession();
		 BuyerVo vo = null;
		 
		 try {
			 vo = session.selectOne("buyer.getDetails", buyerId);
		 } finally {
			 if(session != null) session.close();
		 }
		 
		return vo;
	}

}
