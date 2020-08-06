package com.yc.canteen.biz.impl;

import java.util.List;
import java.util.Map;

import com.yc.canteen.biz.IFoodsBiz;
import com.yc.canteen.dao.IFoodsInfoDao;
import com.yc.canteen.dao.impl.FoodsInfoDaoImpl;
import com.yc.canteen.entity.FoodsInfo;
import com.yc.canteen.util.StringUtil;


public class FoodsBizImpl implements IFoodsBiz {

	@Override
	public int add(FoodsInfo foods) {
		if(StringUtil.checkNull(foods.getTno(), foods.getFname(), foods.getIntro())) {
			return -1;
		}
		IFoodsInfoDao newsDao = new FoodsInfoDaoImpl();
		return newsDao.add(foods);
	}
	@Override
	public List<FoodsInfo> find() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public FoodsInfo findByNid(String nid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//view_goods页面查询
	@Override
	public List<FoodsInfo> findByPage(int page, int rows) {
		IFoodsInfoDao goodsInfoDao = new FoodsInfoDaoImpl();
		return goodsInfoDao.findByPage(page, rows);
	}
	@Override
	public Map<String, Object> findByTid(String tno, int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}
}
