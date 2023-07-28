package kr.or.ddit.controller;

import kr.or.ddit.service.ProductService;
import kr.or.ddit.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

// 스프링에서 인식할 수 있게 자바빈으로 등록하도록 처리하는 @Controlle
@Slf4j
@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    // WEB-INF/views/shopping/welcome.jsp 로 가도록 하기위함
    // WEB_INF는 서버에서 숨김 처리되는 파일이라 경로명으로 접근을 불가

    @RequestMapping(value =  "/shopping/welcome", method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView mav) {
        mav.setViewName("shopping/welcome");
        return mav;
    }

    // 상품 추가
    @RequestMapping(value =  "/shopping/addProduct", method = RequestMethod.GET)
    public ModelAndView addProduct(ModelAndView mav) {
        mav.setViewName("shopping/addProduct");
        return mav;
    }

    // 상품 (추가 후) 등록
    @RequestMapping(value =  "/shopping/processAddProduct", method = RequestMethod.POST)
    public ModelAndView processAddProduct(ModelAndView mav, ProductVO  productVO) {
        log.info("productVO : " + productVO);

        // 파일 업로드 시작

        // 1) 업로드 폴더 설정
        String uploadFolder = "C:\\Users\\PC-03\\git\\DDIT\\06.21~0\\springProj\\src\\main\\webapp\\resources\\images";
//        log.info("uploadFolder : " + uploadFolder);

        MultipartFile multipartFile = productVO.getProductImage();

        String fileName = multipartFile.getOriginalFilename();
        log.info("----------------------------------------------");
        log.info("파일명 : " + fileName);
        log.info("파일 크기 : " + multipartFile.getSize());

        // 랜덤값 생성
        UUID uuid = UUID.randomUUID();
        fileName = uuid + "_" + fileName;

        File saveFile = new File(uploadFolder, fileName);
        try {
            // 파일 복사 실행 부분
            multipartFile.transferTo(saveFile);

            // prodductVO 객체의 filename 멤버변수에 업로드될 이미지의 명을 set
            productVO.setFilename(multipartFile.getOriginalFilename());

            int result = productService.productAddProduct(productVO);
            log.info("result : " + result);

            mav.setViewName("redirect:/shopping/products");
            return mav;
        } catch (IOException e) {
            mav.setViewName("redirect:/shopping/addProduct");
            throw new RuntimeException(e);
        }
        // 파일 업로드 끝
    }

    // 상품 목록
    @RequestMapping(value =  "/shopping/products", method = RequestMethod.GET)
    public ModelAndView products(ModelAndView mav) {
        List<ProductVO> attr = productService.products();
        mav.addObject("listOfProducts",  attr);
        log.info("attr : " + attr);

        mav.setViewName("shopping/products");
        return mav;
    }

    // 상품 상세
    @RequestMapping(value =  "/shopping/product", method = RequestMethod.GET)
    public ModelAndView product(ModelAndView mav, @RequestParam String productId) {
        ProductVO productVO = productService.product(productId);
        mav.addObject("product",  productVO);
        log.info("productVO : " + productVO);

        // product.jsp 에서 사용하는 ${vo.productId} 등등의 데이터를 설정
        mav.addObject("vo", productVO);

        // forwarding
        mav.setViewName("shopping/product");

        return mav;
    }

    // 상품 주문
    @RequestMapping(value = "/shopping/addCart",  method = RequestMethod.POST)
    public ModelAndView addCart(ModelAndView mav, @RequestParam String productId, HttpServletRequest request) {
        log.info("productId : " + productId);

        HttpSession session = request.getSession();

        // trim() : 공백제거
        if (productId == null || productId.trim().isEmpty()) {
            mav.setViewName("redirect:/shopping/products");
            return mav;
        }

        ProductVO product = this.productService.product(productId);

        // 상품 결과가 없다면
        if (product == null) {
            mav.setViewName("redirect:/shopping/exceptionNoProductId");
        }

        // 상품이 있다면 장바구니 처리
        ArrayList<ProductVO> list = (ArrayList<ProductVO>) session.getAttribute("cartlist");

        // 장바구니 세션이 없다면 생성
        if (list == null) {
            list = new ArrayList<ProductVO>();
            session.setAttribute("cartlist", list);
        }

        int cnt = 0;
        for (ProductVO vo : list) {
            if (vo.getProductId().equals(productId)) {
                cnt++;
                // 장바구니에 상품이 이미 들어있다면 상품 개수를 1 증가시킴
                vo.setQuantity(vo.getQuantity() + 1);
            }
        }

        // 상품코드가 DB에 있으면서 장바구니에는 상품이 없다면
        if(cnt == 0) {
            // quantity를 1로 처리
            assert product != null;
            product.setQuantity(1);
            list.add(product);    // 장바구니에 P1234 상품에 넣기
        }

        // 장바구니 확인
        for (ProductVO vo : list) {
            log.info("ProductVO : "+ vo +"<br><hr><br>");
        }

        // 상품 상세 페이지로 이동
        mav.setViewName("redirect:/shopping/product?productId="+productId);

        return mav;
    }

    /*
     * JSON : 자바스크립트 객체 표기법
     *      - 텍스트에 기반을 둔 데이터 저장 및 교환을 위한 구문임
     *      - 브라우저와 서버 간에 데이터를 교환할 때 데이터는 텍스트일 뿐임
     *      - 모든 JS 객체를 JSON으로 변환하고 JSON을 서버로 보낼 수 있음
     *      - 서버에서 받은 JSON을 JS객체로 변환할 수 있음
     */
    // 장바구니 처리
//    @ResponseBody       // 리턴 타입이 JSON으로 변환되어 리턴하게 하는 부분
    @RequestMapping(value = "/shopping/cart",  method = RequestMethod.GET)
    public ModelAndView cart(ModelAndView mav, HttpServletRequest request) {
        // 장바구니 세션
        HttpSession session = request.getSession();

        String cartId = session.getId();
//        log.info("cartId : " + cartId);

        ArrayList<ProductVO> list = (ArrayList<ProductVO>) session.getAttribute("cartlist");
//        log.info("cartList : " + list);

        // Model
        mav.addObject("cartId", cartId);

        // .jsp에서 ${cartlist}라고 하면 username은 무시됨
        // .jsp에서 ${username}가 안 찍히고 있음
//        mav.addObject("username", list);
        mav.addObject("cartlist", list);

        // View
        mav.setViewName("shopping/cart");

        // forwarding
        return mav;
    }

    // removeCart 쇼핑카드의 상품 1개 삭제 하기
    @RequestMapping(value = "/shopping/removeCart", method = RequestMethod.GET)
    public ModelAndView removeCart(ModelAndView mav, HttpServletRequest request, @RequestParam String cartId) {

        if (cartId == null || cartId.trim().isEmpty()) {
            mav.setViewName("redirect:/shopping/products");
            return mav;
        }

        ProductVO vo = this.productService.product(cartId);
        if (vo == null) {
            mav.setViewName("redirect:/shopping/exceptionNoProductId");
            return mav;
        }

        HttpSession session = request.getSession();
        ArrayList<ProductVO> list = (ArrayList<ProductVO>) session.getAttribute("cartlist");

        // 쇼핑카드의 상품 1개 삭제
        if (list != null) {
            for (Iterator<ProductVO> iterator = list.iterator(); iterator.hasNext();) {
                ProductVO productVO = iterator.next();
                if (productVO.getProductId().equals(cartId)) {
                    iterator.remove();
                    break;
                }
            }
        }

        // 장바구니에 아무 상품도 남아있지 않으면 "cartlist" 속성을 null로 설정
        if (list == null || list.isEmpty()) {
            session.setAttribute("cartlist", null);
        }

        mav.setViewName("redirect:/shopping/cart");
        return mav;
    }

    // deleteCart : 장바구니 상품 전체 삭제하기
    @RequestMapping(value = "/shopping/deleteCart", method = RequestMethod.GET)
    public ModelAndView deleteCart(ModelAndView mav, HttpServletRequest request, @RequestParam String cartId) {

        if (cartId != null && !cartId.trim().isEmpty()) {
            HttpSession session = request.getSession();
//            session.setAttribute("cartlist", null);
            session.removeAttribute("cartlist");
        }
        mav.setViewName("redirect:/shopping/cart");
        return mav;
    }

    // /shopping/shippingInfo : 장바구니에서 주문하기 하면 입력하는 회원배송정보
    @RequestMapping(value = "/shopping/shippingInfo", method = RequestMethod.GET)
    public ModelAndView shippingInfo(ModelAndView mav, @RequestParam String cartId) {
        log.info("cartId : " + cartId);

        // shippingInfo.jsp에  cartId를 사용하기 위한 설정
        mav.addObject("cartId", cartId);

        mav.setViewName("shopping/shippingInfo");
        return mav;
    }

    // /shopping/processShippingInfo : 주문 처리 기능
    @RequestMapping(value = "/shopping/processShippingInfo", method = RequestMethod.POST)
    public ModelAndView processShippingInfo(ModelAndView mav, @RequestParam Map<String, Object> params) {

        mav.addObject("map", params);

        mav.setViewName("shopping/orderConfirmation");
        return mav;
    }

    // /shopping/thankCustomer : 주문 요청 완료
    @ResponseBody       // 비동기(ajax)를 사용할 때 사용해야 함
    @RequestMapping(value = "/shopping/thankCustomer", method = RequestMethod.POST)
    public String thankCustomer(HttpSession session, @RequestParam Map<String, Object> params) {
        log.info("params : " + params);

        // 넘겨줘야 하는 값(shippingDate, cartId)
        Map<String, String> shippingMap = new HashMap<String, String>();
        shippingMap.put("shippingDate", params.get("shippingDate").toString());
        shippingMap.put("cartId", params.get("cartId").toString());

        session.setAttribute("shippingMap", shippingMap);

        session.removeAttribute("cartlist");
        // ajax를 이용한 비동기에선 mav를 사용하지 않음
//        mav.setViewName("shopping/thankCustomer");

        return "success";
    }
    // orderConfirmation.jsp에  비동기 방식으로 처리하고 난 뒤에 location.href = "/shopping/thankCustomer"; 를 통해 오는 방식이라 GET
    @RequestMapping(value = "/shopping/thankCustomer", method = RequestMethod.GET)
    public ModelAndView thanksCustomer(ModelAndView mav) {
        mav.setViewName("shopping/thankCustomer");
        return mav;
    }

    // /shopping/checkOutCancelled :  가로 이  로주문 영수증의 취소 버튼
    @RequestMapping(value = "/shopping/checkOutCancelled", method = RequestMethod.GET)
    public ModelAndView checkOutCancelled(ModelAndView mav, HttpSession session) {
        session.removeAttribute("cratlist");

        mav.setViewName("shopping/checkOutCancelled");
        return mav;
    }

}
