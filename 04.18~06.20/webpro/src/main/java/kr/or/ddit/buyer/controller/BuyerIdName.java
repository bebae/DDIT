package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImp;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVo;

@WebServlet("/buyerIdName.do")
public class BuyerIdName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BuyerIdName() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송 시 데이터 받기(지금은 없음)
		
		// service 객체 얻기
		IBuyerService servie = BuyerServiceImp.getInstance();
		
		// service 메소드 호출
		List<BuyerVo> buyerVoList = servie.selectIdName();
		
		// request 객체로 결과를 저장 한다.
		request.setAttribute("requestVoList", buyerVoList);
		
		// view 페이지로 이동 
			// forword방식(request 객체 데이터 공유, URL 변화 없음) - DB 변화가 없는 경우 적합
			// redirect방식(request 객체 데이터 공유X, URL 변화 있음) - DB 변화가 있는 경우 적합
		// json 방식 ( request 객체를 jsp에 넘겨서 json을 생성)
		request.getRequestDispatcher("/05~jQuery/0526/idName.jsp").forward(request, response);
		
		
	}


}
