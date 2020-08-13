package com.yc.canteen.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.canteen.biz.IOrderInfoBiz;
import com.yc.canteen.biz.impl.OrderInfoBizImpl;
import com.yc.canteen.entity.MemberInfo;

@WebServlet("/order")
public class OrderInfoController extends BasicServlet{
	private static final long serialVersionUID = -1614905698871207884L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("add".equals(op)) {//添加订单
			add(request,response);
		}else if("find".equals(op)) {//根据会员编号查询订单信息
			find(request,response);
		}
	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session  = request.getSession();
		Object obj = session.getAttribute("currentLoginMember");
		if(obj == null) {
			this.send(response, 500,"",null);
			return;
		}
		MemberInfo mf = (MemberInfo) obj;
		IOrderInfoBiz orderInfoBiz = new OrderInfoBizImpl();
		List<Map<String,String>>list = orderInfoBiz.finds(mf.getMno());
		if(list == null || list.isEmpty()) {
			this.send(response, 200,null,null);
			return;
		}
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		Map<String,Object> foods = null;
		
		String preOno=list.get(0).get("ono");
		String curOno =preOno;
		Map<String,Object> map = new HashMap<String,Object>();//存放一个订单数据
		List<Map<String,Object>> temp = new ArrayList<Map<String,Object>>();//存放一个订单下的所有商品信息
		
		//第一个订单数据
		map.put("ono", list.get(0).get("ono"));
		map.put("odate", list.get(0).get("odate"));
		map.put("price", list.get(0).get("price"));
		map.put("status", list.get(0).get("status"));
		
		
		for(Map<String,String> rt:list) {
			curOno = rt.get("ono");
			
			if(!preOno.equals(curOno)) {//说明是另一个订单了
				preOno = curOno;
				map.put("foods",temp);
				result.add(map);
				
				map = new HashMap<String,Object>();
				temp = new ArrayList<Map<String,Object>>();
				map.put("ono", rt.get("ono"));
				map.put("odate", rt.get("odate"));
				map.put("price", rt.get("price"));
				map.put("status", rt.get("status"));
			}
			
			foods = new HashMap<String,Object>();
			foods.put("fname", rt.get("fname"));
			foods.put("pics", rt.get("pics").split(";")[0]);
			foods.put("nums", rt.get("nums"));
			foods.put("price", rt.get("price"));
			temp.add(foods);
		}

		map.put("foods",temp);
		result.add(map);
		this.send(response, 200,null,result);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cnos = request.getParameter("cnos");
		double price = Double.parseDouble(request.getParameter("price"));
		String ano = request.getParameter("ano");
		
		IOrderInfoBiz orderInfoBiz = new OrderInfoBizImpl();
		int result = orderInfoBiz.add(cnos, price,ano);
		if(result>0) {
			this.send(response, 200,null,null);
			return;
		}
		this.send(response,500,null,null);
	}

}
