package com.yc.canteen.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.canteen.biz.IFoodsTypeBiz;
import com.yc.canteen.biz.impl.FoodsTypeBizImpl;
import com.yc.canteen.entity.FoodsType;
import com.yc.canteen.util.RequestParamUtil;

@WebServlet("/types")
public class FoodsTypeController extends BasicServlet {
	private static final long serialVersionUID = 3730068103996211087L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String op =request.getParameter("op");
		
		if("add".equals(op)) {
			add(request,response);
		}else if("update".equals(op)) {
			update(request,response);
		}else if("findAll".equals(op)) {
			findAll(request,response);
		}else if("finds".equals(op)) {
			finds(request,response);
		}else if("delete".equals(op)) {
			delete(request, response);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tno = request.getParameter("tno");
		IFoodsTypeBiz foodsTypeBiz = new FoodsTypeBizImpl();
		this.send(response, foodsTypeBiz.delete(tno));
	}

	private void finds(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IFoodsTypeBiz typeBiz = new FoodsTypeBizImpl();
		this.send(response, typeBiz.finds());
		
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IFoodsTypeBiz typeBiz = new FoodsTypeBizImpl();
		this.send(response, typeBiz.findAll());
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FoodsType type =RequestParamUtil.getParams(FoodsType.class, request);
		
		IFoodsTypeBiz typeBiz = new FoodsTypeBizImpl();
		this.send(response, typeBiz.update(type));
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FoodsType type =RequestParamUtil.getParams(FoodsType.class, request);
		
		System.out.println(type);
		IFoodsTypeBiz typeBiz = new FoodsTypeBizImpl();
		this.send(response, typeBiz.add(type));
	}


}
