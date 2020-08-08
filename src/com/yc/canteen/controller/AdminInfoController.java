package com.yc.canteen.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.canteen.biz.IAdminInfoBiz;
import com.yc.canteen.biz.impl.AdminInfoBizImpl;
import com.yc.canteen.entity.AdminInfo;
import com.yc.canteen.util.RequestParamUtil;
import com.yc.canteen.util.SessionKey;


@WebServlet("/admin")
public class AdminInfoController extends BasicServlet {
	private static final long serialVersionUID = 3933654788891134284L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String op =request.getParameter("op");
		
		if("login".equals(op)) {
			login(request,response);
		}else if("reg".equals(op)) {
			reg(request, response);
		}else if("info".equals(op)) {
			info(request, response);
		}else if("find".equals(op)) {
			find(request, response);
		}
	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
		   AdminInfo af = RequestParamUtil.getParams(AdminInfo.class,request);
		      
		      IAdminInfoBiz adminInfoBiz = new AdminInfoBizImpl();
			  this.send(response, adminInfoBiz.find(af));
		
	}

	private void info(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("CURRENTLOGINADMIN");
		if(obj == null) {
			this.send(response, 500, "", null);
			return;
		}
		this.send(response, 200, "", obj);
		
	}

	private void reg(HttpServletRequest request, HttpServletResponse response) throws IOException {
	      AdminInfo af = RequestParamUtil.getParams(AdminInfo.class,request);
	      
	      IAdminInfoBiz adminInfoBiz = new AdminInfoBizImpl();
		  this.send(response, adminInfoBiz.reg(af));
	}



	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		AdminInfo af = RequestParamUtil.getParams(AdminInfo.class,request);
		
		IAdminInfoBiz adminInfoBiz = new AdminInfoBizImpl();
		af = adminInfoBiz.login(af);
		
		if(af==null) {
			this.send(response, 500);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("CURRENTLOGINADMIN",af);
			this.send(response, 200);
		}
	}
}
