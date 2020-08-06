package com.yc.canteen.dao.impl;

import java.util.Date;

import com.yc.canteen.dao.DBHelper;
import com.yc.canteen.dao.IAdminInfoDao;
import com.yc.canteen.entity.AdminInfo;

public class AdminInfoDaoImpl implements IAdminInfoDao {
	public AdminInfo login(AdminInfo af) {
		DBHelper db = new DBHelper();
		String sql="select aid, aname, pwd, tel, status from admininfo where aname=? and pwd=?";
		return db.find(AdminInfo.class, sql,af.getAname(),af.getPwd());
	};

	public int reg(AdminInfo af) {
		DBHelper db = new DBHelper();
		String sql="insert into admininfo values(0, ?, md5(?), ?, 1)";
		return db.update(sql, af.getAname(), af.getPwd(), af.getTel());
	}
}
