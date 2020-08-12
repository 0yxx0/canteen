package com.yc.canteen.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yc.canteen.dao.DBHelper;
import com.yc.canteen.dao.IFoodsTypeDao;
import com.yc.canteen.entity.FoodsType;
import com.yc.canteen.util.StringUtil;


public class FoodsTypeDaoImpl implements IFoodsTypeDao {
	@Override
	public int add(FoodsType nt) {
		long tno = new Date().getTime();
		DBHelper db = new DBHelper();
		String sql = "insert into foodstype values(?, ?, 1)";
		return db.update(sql, tno, nt.getTname());
	}
	
	@Override
	public List<FoodsType> finds() {
		DBHelper db = new DBHelper();
		String sql = "select tno, tname from foodstype where status != 0";
		return db.finds(FoodsType.class,sql);
	}
	


	@Override
	public List<FoodsType> findAll() {
		DBHelper db = new DBHelper();
		String sql = "select tno, tname, status from foodstype ";
		return db.finds(FoodsType.class,sql);
	}
	
	@Override
	public List<FoodsType> findIndex() {
		DBHelper db = new DBHelper();
		String sql = "select tno, tname, status from foodstype where status !=0 ";
		return db.finds(FoodsType.class,sql);
	}
	@Override
	public int update(FoodsType nt) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "update foodstype set ";
		if( !StringUtil.checkNull(nt.getTname())) {
			sql +="tname=?,";
			params.add(nt.getTname());
		}
		
		if(nt.getStatus() != -1) {
			sql += "status=?,";
			params.add(nt.getStatus());
		}
		
		sql = sql.substring(0, sql.lastIndexOf(",")) + " where tno=?";
		params.add(nt.getTno());
		return db.update(sql, params);
	}
	
	@Override
	public int delete(String tno) {
		DBHelper db = new DBHelper();
		String sql = "delete from foodstype where tno=?";
		return db.update(sql, tno);
	}

}