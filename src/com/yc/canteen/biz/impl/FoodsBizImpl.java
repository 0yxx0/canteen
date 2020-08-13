package com.yc.canteen.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yc.canteen.biz.IFoodsBiz;
import com.yc.canteen.dao.IFoodsInfoDao;
import com.yc.canteen.dao.IFoodsTypeDao;
import com.yc.canteen.dao.impl.FoodsInfoDaoImpl;
import com.yc.canteen.dao.impl.FoodsTypeDaoImpl;
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
	
	@Override
	public Map<String, Object> findIndex() {
		Map<String, Object> map = new HashMap<String,Object>();
		IFoodsTypeDao typeDao = new FoodsTypeDaoImpl();
		IFoodsInfoDao foodsInfoDao = new FoodsInfoDaoImpl();
		map.put("types", typeDao.findIndex());
		map.put("foods", foodsInfoDao.findIndex());
		return map;
	}
	
	@Override
	public Map<String, Object> findHot() {
		Map<String, Object> map = new HashMap<String,Object>();
		IFoodsInfoDao foodsInfoDao = new FoodsInfoDaoImpl();
		IFoodsTypeDao typeDao = new FoodsTypeDaoImpl();
		map.put("hots", foodsInfoDao.findHot());
		map.put("types", typeDao.findIndex());
		return map;
	}
	
	@Override
	public Map<String, Object> findByCondition(String tno, String fname, int page, int rows) {
		IFoodsInfoDao foodsInfoDao = new FoodsInfoDaoImpl();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("total", foodsInfoDao.total(tno, fname));
		map.put("rows", foodsInfoDao.findByCondition(tno, fname, page, rows));
		return map;
	}
	
	@Override
	public FoodsInfo findByFno(String fno) {
		IFoodsInfoDao foodsInfoDao = new FoodsInfoDaoImpl();
		return foodsInfoDao.findByFno(fno);
	}
	
	@Override
	public List<FoodsInfo> findByTno(String tno, int page, int rows) {
		IFoodsInfoDao foodsInfoDao = new FoodsInfoDaoImpl();
		return foodsInfoDao.findByTno(tno, page, rows);
	}
	
	@Override
	public Map<String, Object> findByTnos(String tno, int page, int rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		IFoodsInfoDao foodsInfoDao = new FoodsInfoDaoImpl();
		map.put("total", foodsInfoDao.total(tno));
		map.put("rows", foodsInfoDao.findByTno(tno, page, rows));
		return map;
	}
}
