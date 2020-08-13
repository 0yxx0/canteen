package com.yc.canteen.biz.impl;

import java.util.List;
import java.util.Map;

import com.yc.canteen.biz.IOrderInfoBiz;
import com.yc.canteen.dao.IOrderInfoDao;
import com.yc.canteen.dao.impl.OrderInfoDaoImpl;
import com.yc.canteen.util.StringUtil;


public class OrderInfoBizImpl implements IOrderInfoBiz {

	@Override
	public int add(String cnos, double price, String ano) {
		if(StringUtil.checkNull(cnos,ano)) {
			return -1;
		}
		
		IOrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
		return orderInfoDao.add(cnos, price,ano);
	}
	@Override
	public List<Map<String, String>> finds(Integer mno) {
		IOrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
		return orderInfoDao.finds(mno);
	}
}
