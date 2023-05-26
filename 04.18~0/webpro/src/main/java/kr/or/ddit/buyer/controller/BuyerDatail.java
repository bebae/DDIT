package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImp;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVo;

/**
 * Servlet implementation class BuyerDatail
 */
@WebServlet("/buyerDatail.do")
public class BuyerDatail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송 시 데이터 받기
		String buyerId = request.getParameter("id");
		// service 객체 얻기
		IBuyerService servie = BuyerServiceImp.getInstance();
		
		// service 메소드 호출
		BuyerVo buyerVo = servie.selectDetails(buyerId);
		
		// request 객체로 결과를 저장 한다.
		request.setAttribute("requestVo", buyerVo);
		
		// view 페이지로 이동 
		request.getRequestDispatcher("/05~jQuery/0526/detail.jsp").forward(request, response);
				
	}

}
