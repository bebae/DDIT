package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDaoImp;
import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.buyer.vo.BuyerVo;

public class BuyerServiceImp implements IBuyerService {
	
	private final IBuyerDao dao;

	private static IBuyerService service ;
	
	public static IBuyerService getInstance() {
		if(service == null) service = new BuyerServiceImp();
		return service;
	}
	
	// 생성자
	private BuyerServiceImp() {
		dao = BuyerDaoImp.getInstance();	// 싱글톤 객체 가져오기
	}

	@Override
	public List<BuyerVo> selectIdName() {
		return dao.selectIdName();
	}

	@Override
	public BuyerVo selectDetails(String buyerId) {
		return dao.selectDetails(buyerId);
	}

}
