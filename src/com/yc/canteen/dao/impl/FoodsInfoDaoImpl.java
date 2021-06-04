package com.yc.canteen.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.canteen.dao.DBHelper;
import com.yc.canteen.dao.IFoodsInfoDao;
import com.yc.canteen.entity.FoodsInfo;
import com.yc.canteen.util.StringUtil;

public class FoodsInfoDaoImpl implements IFoodsInfoDao {

	@Override
	public List<FoodsInfo> findAll() {
		DBHelper db = new DBHelper();
		String sql = "select * from foodsinfo ";
		return db.finds(FoodsInfo.class, sql);
	}

	@Override
	public int update(FoodsInfo f) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "update foodsinfo set ";
		if (!StringUtil.checkNull(f.getFname())) {
			sql += "fname=?,";
			params.add(f.getFname());
		}

		if (f.getStatus() != -1) {
			sql += "status=?,";
			params.add(f.getStatus());
		}

		sql = sql.substring(0, sql.lastIndexOf(",")) + " where fno=?";
		params.add(f.getFno());
		return db.update(sql, params);
	}

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

	// 前台主页面查询食品信息
	public List<FoodsInfo> findIndex() {
		DBHelper db = new DBHelper();
		String sql = "select fno, fname, price, tno, pics from foodsinfo f1 where 4 > (select count(fno) from "
				+ "foodsinfo f2 where f1.tno=f2.tno and f1.fno<f2.fno) order by f1.tno asc, f1.fno desc";
		return db.finds(FoodsInfo.class, sql); // TODO Auto-generated method stub
	}

	// 后台报表页面查询食品
	public List<FoodsInfo> findFood() {
		DBHelper db = new DBHelper();
		String sql = "select fno, fname from foodsinfo where status = 1";
		return db.finds(FoodsInfo.class, sql); // TODO Auto-generated method stub
	}

	@Override
	public List<FoodsInfo> findHot() {
		DBHelper db = new DBHelper();
		String sql = "select fno, fname, price, tno, pics, sales from foodsinfo ORDER BY sales DESC LIMIT 0,3";
		return db.finds(FoodsInfo.class, sql); // TODO Auto-generated method stub
	}

	@Override
	public List<FoodsInfo> findByCondition(String tno, String fname, int page, int rows) {
		DBHelper db = new DBHelper();
		String sql = "select fno, f.tno, tname, fname, price, sales, intro, pics, f.status from foodsinfo f, foodstype t "
				+ "where f.tno=t.tno";
		List<Object> params = new ArrayList<Object>();
		if (!StringUtil.checkNull(tno)) {
			sql += " and f.tno = ?";
			params.add(tno);
		}

		if (!StringUtil.checkNull(fname)) {
			sql += " and fname like concat('%', ?, '%')";
			params.add(fname);
		}
		sql += " order by fno desc limit ?, ?";
		params.add((page - 1) * rows);
		params.add(rows);
		return db.finds(FoodsInfo.class, sql, params);
	}

	@Override
	public int total(String tno, String fname) {
		DBHelper db = new DBHelper();
		String sql = "select count(fno) from foodsinfo where 1=1";
		List<Object> params = new ArrayList<Object>();
		if (!StringUtil.checkNull(tno)) {
			sql += " and tno = ?";
			params.add(tno);
		}

		if (!StringUtil.checkNull(fname)) {
			sql += " and fname like concat('%', ?, '%')";
			params.add(fname);
		}

		return db.total(sql, params);
	}

	@Override
	public FoodsInfo findByFno(String fno) {
		DBHelper db = new DBHelper();
		String sql = "select fno, fname, price, intro, pics from foodsinfo where fno=?";
		return db.find(FoodsInfo.class, sql, fno);
	}

	@Override
	public List<FoodsInfo> findByTno(String tno, int page, int rows) {
		DBHelper db = new DBHelper();
		String sql = "select fno, fname, price, intro, pics from foodsinfo where fno=?";
		return db.finds(FoodsInfo.class, sql, tno, (page - 1) * rows, rows);
	}

	@Override
	public int total(String tno) {
		DBHelper db = new DBHelper();
		String sql = "select count(fno) from foodsinfo where tno=?";
		return db.total(sql, tno);
	}
}
