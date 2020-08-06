package com.yc.canteen.dao.impl;

import java.util.List;

import com.yc.canteen.dao.DBHelper;
import com.yc.canteen.dao.IFoodsInfoDao;
import com.yc.canteen.entity.FoodsInfo;

public class FoodsInfoDaoImpl implements IFoodsInfoDao {

	@Override
	public int add(FoodsInfo foods) {
		DBHelper db = new DBHelper();
		String sql = "insert into foodsinfo values(0, ?, ?, ?, ?, ?, 1, 0)";
		return db.update(sql, foods.getFname(), foods.getTno(), foods.getPrice(), foods.getIntro(), foods.getPics());
	}
	
	@Override
	public List<FoodsInfo> findByPage(int page, int rows) {
		DBHelper db = new DBHelper();
		String sql = "select fno, f.tno, tname, fname, price, sales, intro, pics, f.status from foodsinfo f, foodstype t "
				+ "where f.tno=t.tno order by fno desc limit ?, ?";
		return db.finds(FoodsInfo.class, sql, (page - 1) * rows, rows);
	}
}
