package com.yc.canteen.biz.impl;

import java.util.List;

import com.yc.canteen.biz.IFoodsTypeBiz;
import com.yc.canteen.dao.IFoodsTypeDao;
import com.yc.canteen.dao.impl.FoodsTypeDaoImpl;
import com.yc.canteen.entity.FoodsType;
import com.yc.canteen.util.StringUtil;


public class FoodsTypeBizImpl implements IFoodsTypeBiz{

	@Override
	public int add(FoodsType ft) {
		if(StringUtil.checkNull(ft.getTno(),ft.getTname())) {
			return -1;
		}
		IFoodsTypeDao foodsTypeDao = new FoodsTypeDaoImpl();
		return foodsTypeDao.add(ft);
	}
	
	@Override
	public List<FoodsType> findAll() {
		IFoodsTypeDao foodsTypeDao = new FoodsTypeDaoImpl();
		return foodsTypeDao.findAll();
	}
	
	@Override
	public List<FoodsType> finds() {
		IFoodsTypeDao foodsTypeDao = new FoodsTypeDaoImpl();
		return foodsTypeDao.finds();
	}
	
	@Override
	public int update(FoodsType nt) {
		if(StringUtil.checkNull(nt.getTno())) {
			return -1;
		}
		IFoodsTypeDao foodsTypeDao = new FoodsTypeDaoImpl();
		return foodsTypeDao.update(nt);
	}
	
	@Override
	public int delete(String tno) {
		if(StringUtil.checkNull(tno)) {
			return -1;
		}
		IFoodsTypeDao foodsTypeDao = new FoodsTypeDaoImpl();
		return foodsTypeDao.delete(tno);
	}
}
