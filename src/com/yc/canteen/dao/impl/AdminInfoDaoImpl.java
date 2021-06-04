package com.yc.canteen.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.canteen.dao.DBHelper;
import com.yc.canteen.dao.IAdminInfoDao;
import com.yc.canteen.entity.AdminInfo;
import com.yc.canteen.util.StringUtil;

public class AdminInfoDaoImpl implements IAdminInfoDao {
	public AdminInfo login(AdminInfo af) {
		DBHelper db = new DBHelper();
		String sql = "select aid, aname, pwd, tel, status from admininfo where aname=? and pwd=?";
		return db.find(AdminInfo.class, sql, af.getAname(), af.getPwd());
	}

	public int reg(AdminInfo af) {
		DBHelper db = new DBHelper();
		String sql = "insert into admininfo values(?, ?, ?, ?, 1)";
		return db.update(sql, af.getAid(), af.getAname(), af.getPwd(), af.getTel());
	}

	@Override
	public List<AdminInfo> find(AdminInfo af) {
		DBHelper db = new DBHelper();
		String sql = "select aid, aname, pwd, tel, status from admininfo where status<?";
		return db.finds(AdminInfo.class, sql, af.getStatus());
	}

	@Override
	public int delete(String aid) {
		DBHelper db = new DBHelper();
		String sql = "delete from admininfo where aid=?";
		return db.update(sql, aid);
	}

	@Override
	public int update(AdminInfo af) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "update admininfo set ";
		if (!StringUtil.checkNull(af.getAname())) {
			sql += "aname=?,";
			params.add(af.getAname());
		}

		if (af.getStatus() != -1) {
			sql += "status=?,";
			params.add(af.getStatus());
		}

		if (!StringUtil.checkNull(af.getPwd())) {
			sql += "pwd=?,";
			params.add(af.getPwd());
		}

		if (!StringUtil.checkNull(af.getTel())) {
			sql += "tel=?,";
			params.add(af.getTel());
		}

		sql = sql.substring(0, sql.lastIndexOf(",")) + " where aid=?";
		params.add(af.getAid());
		return db.update(sql, params);
	}
}