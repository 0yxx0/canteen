package com.yc.canteen.biz.impl;

import java.util.List;
import java.util.Map;

import com.yc.canteen.biz.IOrderInfoBiz;
import com.yc.canteen.dao.IOrderInfoDao;
import com.yc.canteen.dao.impl.OrderInfoDaoImpl;
import com.yc.canteen.entity.OrderInfo;
import com.yc.canteen.util.StringUtil;

public class OrderInfoBizImpl implements IOrderInfoBiz {

	@Override
	public int add(String cnos, double price, String mno) {
		if (StringUtil.checkNull(cnos)) {
			return -1;
		}

		IOrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
		return orderInfoDao.add(cnos, price, mno);
	}

	@Override
	public List<Map<String, String>> finds(String mno) {
		IOrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
		return orderInfoDao.finds(mno);
	}

	@Override
	public List<OrderInfo> all() {
		List<OrderInfo> listOrder;
		IOrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
		listOrder = orderInfoDao.all();
		System.out.println(listOrder);
		return listOrder;
	}
}
