package com.yc.canteen.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.canteen.dao.DBHelper;
import com.yc.canteen.dao.IMemberInfoDao;
import com.yc.canteen.entity.MemberInfo;
import com.yc.canteen.util.StringUtil;

public class MemberInfoDaoImpl implements IMemberInfoDao {

	@Override
	public MemberInfo login(MemberInfo mf) {
		DBHelper db = new DBHelper();
		String sql = "select mno, nickName, pwd, email, status from memberinfo where nickName=? and pwd=?";
		return db.find(MemberInfo.class, sql, mf.getNickName(), mf.getPwd());
	}

	@Override
	public List<MemberInfo> findAll() {
		DBHelper db = new DBHelper();
		String sql = "select mno, nickName, pwd, email, status from memberinfo";
		return db.finds(MemberInfo.class, sql);
	}

	@Override
	public List<MemberInfo> finds() {
		DBHelper db = new DBHelper();
		String sql = "select nickName, email from memberinfo where status =1";
		return db.finds(MemberInfo.class, sql);
	}

	@Override
	public int reg(MemberInfo mf) {
		DBHelper db = new DBHelper();
		String sql = "insert into memberinfo values(?, ?, ?, ?, now(), 1)";
		return db.update(sql, mf.getMno(), mf.getNickName(), mf.getPwd(), mf.getEmail());
	}

	@Override
	public MemberInfo find(MemberInfo mf) {
		DBHelper db = new DBHelper();
		String sql = "select mno from memberinfo where nickName=?";
		return db.find(MemberInfo.class, sql, mf.getNickName());
	}

	@Override
	public int change(MemberInfo m) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "update memberinfo set ";

		if (!StringUtil.checkNull(m.getNickName())) {
			sql += "nickName=?,";
			params.add(m.getNickName());
		}

		if (m.getStatus() != -1) {
			sql += "status=?,";
			params.add(m.getStatus());
		}

		sql = sql.substring(0, sql.lastIndexOf(",")) + " where mno=?";
		params.add(m.getMno());
		return db.update(sql, params);
	}
}
