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
import com.yc.canteen.util.RequestParamUtil;

@WebServlet("/foods")
public class FoodsController extends BasicServlet {
	private static final long serialVersionUID = 7272032383900864487L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String op = request.getParameter("op");

		if ("upload".equals(op)) {
			upload(request, response);
		} else if ("add".equals(op)) {
			add(request, response);
		} else if ("findf".equals(op)) {
			findf(request, response);
		} else if ("finds".equals(op)) {
			finds(request, response);
		} else if ("findTid".equals(op)) {
			findTid(request, response);
		} else if ("findByNid".equals(op)) {
			findByNid(request, response);
		} else if ("findIndex".equals(op)) {
			findIndex(request, response);
		} else if ("findByCondition".equals(op)) {
			findByCondition(request, response);
		} else if ("findByFno".equals(op)) {
			findByFno(request, response);
		} else if ("findHot".equals(op)) {
			findHot(request, response);
		} else if ("findFood".equals(op)) {
			findFood(request, response);
		} else if ("findAll".equals(op)) {
			findAll(request, response);
		} else if ("update".equals(op)) {
			update(request, response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FoodsInfo info = RequestParamUtil.getParams(FoodsInfo.class, request);

		IFoodsBiz foodsBiz = new FoodsBizImpl();
		this.send(response, foodsBiz.update(info));
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IFoodsBiz foodsBiz = new FoodsBizImpl();
		this.send(response, 200, "", foodsBiz.findAll());
	}

	private void findHot(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IFoodsBiz foodsBiz = new FoodsBizImpl();
		this.send(response, 200, "", foodsBiz.findHot());

	}

	private void findByFno(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fno = request.getParameter("fno");
		IFoodsBiz foodsInfoBiz = new FoodsBizImpl();
		this.send(response, 200, "", foodsInfoBiz.findByFno(fno));

	}

	private void findByCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		String tno = request.getParameter("tno");
		String fname = request.getParameter("fname");
		IFoodsBiz foodsInfoBiz = new FoodsBizImpl();
		this.send(response, foodsInfoBiz.findByCondition(tno, fname, page, rows));

	}

	// 首页查询商品信息
	private void findIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IFoodsBiz foodsBiz = new FoodsBizImpl();
		this.send(response, 200, "", foodsBiz.findIndex());

	}

	// 后台报表页面查询商品信息
	private void findFood(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IFoodsBiz foodsBiz = new FoodsBizImpl();
		this.send(response, 200, "", foodsBiz.findFood());

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

	// view_foods页面查询商品信息
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
		PageContext pagecontext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true,
				2048, true);
		int result = -1;
		try {
			FoodsInfo news = fuu.upload(FoodsInfo.class, pagecontext);
			System.out.println(news);
			IFoodsBiz newsBiz = new FoodsBizImpl();
			result = newsBiz.add(news);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.send(response, result);
	}

	private void upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FileUploadUtil fuu = new FileUploadUtil();
		PageContext pagecontext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true,
				2048, true);
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String, String> map = fuu.uploadPic(pagecontext);

			result.put("fileName", map.get("fileName"));
			result.put("url", "../../" + map.getOrDefault("upload", ""));
			result.put("uploaded", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.send(response, result);
	}
}
