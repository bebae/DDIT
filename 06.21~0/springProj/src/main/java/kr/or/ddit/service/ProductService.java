package kr.or.ddit.service;

import kr.or.ddit.vo.ProductVO;

import java.util.List;

//서비스 interface : 비즈니스 로직
public interface ProductService {

	public int productAddProduct(ProductVO productVO);

	public List<ProductVO> products();

	ProductVO product(String productId);


}
