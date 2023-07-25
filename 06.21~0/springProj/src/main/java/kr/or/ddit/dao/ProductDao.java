package kr.or.ddit.dao;

import kr.or.ddit.vo.BookVO;
import kr.or.ddit.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//DAO(Data Access Object) 클래스
// 매퍼xml(book_SQL.xml)을 실행함
//Repository 어노테이션 : 데이터에 접근하는 클래스라고
//		스프링에게 알려줌. 스프링이 자바빈으로 등록해서 관리함
@Slf4j
@Repository
public class ProductDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	public int processAddProduct(ProductVO  productVO) {
        return sqlSessionTemplate.insert("product.processAddProduct", productVO);
    }

	public List<ProductVO> products() {
		return sqlSessionTemplate.selectList("product.products");
	}

	public ProductVO product(String productId) {
        return sqlSessionTemplate.selectOne("product.product", productId);
	}
}







