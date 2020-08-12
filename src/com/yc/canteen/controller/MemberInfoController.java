package com.yc.canteen.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.canteen.biz.IMemberInfoBiz;
import com.yc.canteen.biz.impl.MemberInfoBizImpl;
import com.yc.canteen.entity.MemberInfo;
import com.yc.canteen.util.RequestParamUtil;
import com.yc.canteen.util.SessionKey;

@WebServlet("/member")
public class MemberInfoController extends BasicServlet {
	private static final long serialVersionUID = 2524015900753870596L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String op =request.getParameter("op");
		
		if("login".equals(op)){
			login(request, response);
		}else if("info".equals(op)) {
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
		this.send(response, 200, "", obj);
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MemberInfo mf = RequestParamUtil.getParams(MemberInfo.class,request);
		
		IMemberInfoBiz memberInfoBiz = new MemberInfoBizImpl();
		mf = memberInfoBiz.login(mf);
		if(mf==null) {
			this.send(response, 500, "", null);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute(SessionKey.CURRENTLOGINUSER,mf);
			session.setAttribute("CURRENTLOGINUSER",mf);
			this.send(response, 200, "", null);
		}
	}

}