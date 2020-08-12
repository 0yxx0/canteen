package com.yc.canteen.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.canteen.dao.DBHelper;
import com.yc.canteen.dao.ICartInfoDao;
import com.yc.canteen.entity.CartInfo;

public class CartInfoDaoImpl implements ICartInfoDao{
	
	@Override
	public List<Map<String, Object>> findCart(String mno) {
		DBHelper db = new DBHelper();
		String sql="select cno, fno from cartinfo where mno=?";
		return db.finds(sql, mno);
	}
	@Override
	public List<CartInfo> finds(String mno) {
		DBHelper db = new DBHelper();
		String sql="select cno, c.fno, num, price, pics, fname from cartinfo c, foodsinfo f where c.fno=f.fno and mno=?";
		return db.finds(CartInfo.class, sql, mno);
	}
	@Override
	public int updateNum(String cno, int num) {
		DBHelper db = new DBHelper();
		String sql="update cartinfo set num = num + ? where cno=?";
		return db.update(sql, num, cno);
	}
	@Override
	public int add(CartInfo cf) {
		DBHelper db = new DBHelper();
		String sql="insert into cartinfo values(?, ?, ?, ?)";
		return db.update(sql, cf.getCno(), cf.getMno(), cf.getFno(), cf.getNum());
	}
	@Override
	public int delete(String cno) {
		DBHelper db = new DBHelper();
		String sql="delete from cartinfo where cno=?";
		return db.update(sql, cno);
	}
	@Override
	public int delete(String[] cnos) {
		DBHelper db = new DBHelper();
		String sql="delete from cartinfo where cno in(";
		List<Object> params = new ArrayList<Object>();
		for(String cno: cnos) {
			sql +="?,";
			params.add(cno);
		}
		sql +=sql.substring(0, sql.lastIndexOf(",")) + ")";
		return db.update(sql, params);
	}


	
}