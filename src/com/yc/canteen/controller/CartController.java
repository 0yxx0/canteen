package com.yc.canteen.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.canteen.biz.ICartInfoBiz;
import com.yc.canteen.biz.impl.CartInfoBizImpl;
import com.yc.canteen.entity.CartInfo;
import com.yc.canteen.entity.MemberInfo;
import com.yc.canteen.util.RequestParamUtil;

@WebServlet("/cart")

public class CartController extends BasicServlet{
	private static final long serialVersionUID = 5982019310483371794L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String op =request.getParameter("op");
		
		if("info".equals(op)) {
			info(request, response);
		}else if("update".equals(op)) {
			update(request,response);
		}else if("add".equals(op)) {
			add(request,response);
		}else if("find".equals(op)) {
			find(request,response);
		}else if("findByCnos".equals(op)) {
			findByCnos(request,response);
		}else if("Increase".equals(op)) {
			Increase(request, response);
		}else if("Decrease".equals(op)) {
			Decrease(request, response);
		}else if("delete".equals(op)) {
			delete(request, response);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cno = request.getParameter("cno");
		ICartInfoBiz cartInfoBiz= new CartInfoBizImpl();
		this.send(response, 200,"",cartInfoBiz.delete(cno));
		
	}

	private void Decrease(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cno = request.getParameter("cno");
		ICartInfoBiz cartInfoBiz= new CartInfoBizImpl();
		this.send(response, 200,"",cartInfoBiz.Decrease(cno));
		
	}

	private void Increase(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cno = request.getParameter("cno");
		ICartInfoBiz cartInfoBiz= new CartInfoBizImpl();
		this.send(response, 200,"",cartInfoBiz.Increase(cno));

		
	}

	private void findByCnos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cnos = request.getParameter("cnos");
		ICartInfoBiz cartInfoBiz= new CartInfoBizImpl();
		this.send(response, 200,"",cartInfoBiz.findByCnos(cnos));
		
	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("CURRENTLOGINUSER");
		if(obj == null) {
			this.send(response, 500,"",null);
			return;
		}
		
		//查数据库
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		MemberInfo mf = (MemberInfo) obj;
		this.send(response, 200,"",cartInfoBiz.finds(String.valueOf(mf.getMno())));
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CartInfo cf = RequestParamUtil.getParams(CartInfo.class, request);
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		String cno = UUID.randomUUID().toString().replace("-", "");
		cf.setCno(cno);
		int result = cartInfoBiz.add(cf);
		if(result>0) {
			this.send(response, 200, cno, null);
		}else {
			this.send(response, 500,"",null);
		}
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cno = request.getParameter("cno");
		int num = Integer.parseInt(request.getParameter("num"));
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		int result = cartInfoBiz.updateNum(cno, num);
		if(result > 0) {
			this.send(response,200,"",null);
		}else {
			this.send(response, 500,"",null);
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
