package com.yc.canteen.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.yc.canteen.biz.IFoodsBiz;
import com.yc.canteen.biz.impl.FoodsBizImpl;
import com.yc.canteen.entity.FoodsInfo;
import com.yc.canteen.util.FileUploadUtil;


@WebServlet("/foods")
public class FoodsController extends BasicServlet{
	private static final long serialVersionUID = 7272032383900864487L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String op = request.getParameter("op");
		
		
		if("upload".equals(op)) {
			upload(request, response);
		} else if("add".equals(op)) {
			add(request, response);
		} else if("findf".equals(op)) {
			findf(request, response);
		} else if("finds".equals(op)) {
			finds(request, response);
		} else if("findTid".equals(op)) {
			findTid(request, response);
		} else if("findByNid".equals(op)) {
			findByNid(request, response);
		}
	}

	private void findByNid(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nid = request.getParameter("nid");
		IFoodsBiz newsBiz = new FoodsBizImpl();
		this.send(response, newsBiz.findByNid(nid));
		
	}

	private void findTid(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IFoodsBiz newsBiz = new FoodsBizImpl();
		this.send(response, newsBiz.find());
	}

	//view_foods页面查询商品信息
	private void finds(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		
		IFoodsBiz newsBiz = new FoodsBizImpl();
		this.send(response, newsBiz.findByPage(page, rows));
		
	}

	private void findf(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tid = request.getParameter("tid");
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		
		IFoodsBiz newsBiz = new FoodsBizImpl();
		this.send(response, newsBiz.findByTid(tid, page, rows));
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FileUploadUtil fuu = new FileUploadUtil();
		PageContext pagecontext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 2048, true);
		int result = -1;
		try {
			FoodsInfo news = fuu.upload(FoodsInfo.class, pagecontext);
			System.out.println(news);
			IFoodsBiz newsBiz = new FoodsBizImpl();
			result = newsBiz.add(news);
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.send(response, result);
	}

	private void upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
			FileUploadUtil fuu = new FileUploadUtil();
			PageContext pagecontext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 2048, true);
		    Map<String, Object> result = new HashMap<String, Object>();
		    try {
		    	Map<String, String> map = fuu.uploadPic(pagecontext);
		    	
		    	result.put("fileName", map.get("fileName"));
		    	result.put("url", "../../" + map.getOrDefault("upload", ""));
		    	result.put("uploaded", 1);
		    } catch(Exception e) {
		    	e.printStackTrace();
		    }
		    this.send(response, result);
	} 
}
