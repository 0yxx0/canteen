package com.yc.canteen.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.canteen.biz.ICartInfoBiz;
import com.yc.canteen.biz.impl.CartInfoBizImpl;
import com.yc.canteen.entity.MemberInfo;

@WebServlet("/cart")

public class CartController extends BasicServlet{
	private static final long serialVersionUID = 5982019310483371794L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String op =request.getParameter("op");
		
		if("info".equals(op)) {
			info(request, response);
		}
	}

	private void info(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("CURRENTLOGINUSER");

		if(obj == null) {
			this.send(response, 500, "", null);
			return;
		}
		
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		MemberInfo mf = (MemberInfo) obj;
		this.send(response, 200, "", cartInfoBiz.findCart(String.valueOf(mf.getMno())));
		
	}
}
