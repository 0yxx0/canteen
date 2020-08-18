package com.yc.canteen.dao.impl;

import java.util.List;

import com.yc.canteen.dao.DBHelper;
import com.yc.canteen.dao.IMemberInfoDao;
import com.yc.canteen.entity.MemberInfo;

public class MemberInfoDaoImpl implements IMemberInfoDao {

	@Override
	public MemberInfo login(MemberInfo mf) {
		DBHelper db = new DBHelper();
		String sql="select mno, nickName, pwd, email, status from memberinfo where nickName=? and pwd=?";
		return db.find(MemberInfo.class, sql,mf.getNickName(),mf.getPwd());
	}
	
	@Override
	public List<MemberInfo> finds() {
			DBHelper db = new DBHelper();
			String sql = "select nickName, email from memberinfo where status =1";
			return db.finds(MemberInfo.class,sql);
	}
	
	@Override
	public int reg(MemberInfo mf) {
		DBHelper db = new DBHelper();
		String sql="insert into memberinfo values(?, ?, ?, ?, now(), 1)";
		return db.update(sql, mf.getMno(), mf.getNickName(), mf.getPwd(), mf.getEmail());
	}
	
	@Override
	public MemberInfo find(MemberInfo mf) {
		DBHelper db = new DBHelper();
		String sql="select mno from memberinfo where nickName=?";
		return db.find(MemberInfo.class, sql, mf.getNickName());
	}
	
	@Override
	public int change(String pwd) {
		DBHelper db = new DBHelper();
		String sql="update memberinfo set pwd=? where pwd=777777";
		return db.update(sql, pwd);
	}
}
