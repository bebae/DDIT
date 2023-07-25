package kr.or.ddit.service.impl;

import kr.or.ddit.dao.BookDao;
import kr.or.ddit.dao.ProductDao;
import kr.or.ddit.service.BookService;
import kr.or.ddit.service.ProductService;
import kr.or.ddit.vo.BookVO;
import kr.or.ddit.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//서비스 클래스 : 비즈니스 로직(기능 수행)
//스프링 MVC 구조에서 Controller와 DAO를 연결하는 역할
/*
 스프링 프레임워크는 직접 클래스를 호출하는 것을 지양하고,
 인터페이스를 호출하는 것을 좋아함. 
 인터페이스를 통해 접근하는 것을 권장하고 있기 때문에.(확장성)
 
 Impl : implment의 약어
 */
//"스프링아 이 클래스는 서비스 클래스야"라고 알려주면. 프링이가 자바빈으로 등록해줌
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;


	@Override
	public int productAddProduct(ProductVO productVO) {
		return productDao.processAddProduct(productVO);
	}

	@Override
	public List<ProductVO> products() {
		return productDao.products();
	}

	@Override
	public ProductVO product(String productId) {
		return productDao.product(productId);
	}
}






