package com.yc.canteen.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//拦截front下的请求
@WebFilter(filterName = "CheckFrontFilter",value ="/front/*")
public class CheckFrontFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		if(request.getSession().getAttribute("CURRENTLOGINUSER") == null) {//未登录，不允许访问
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			String basePath = request.getScheme() + "://" +request.getServerName()+ ":" + request.getServerPort() + request.getContextPath() + "/";
			out.print("<script> alert('请先登录...'); location.href='" +basePath+"login.html'</script>");
			out.flush();
			return;
		}
		
		//获取用户请求的路径
		String path = request.getRequestURI();
		
		//获取请求的项目名
		String base = request.getContextPath();//DayFresh
		
		path = path.replace(base,"");
		
		request.getRequestDispatcher("../WEB-INF" + path).forward(request,response);
		return;
	}

}
