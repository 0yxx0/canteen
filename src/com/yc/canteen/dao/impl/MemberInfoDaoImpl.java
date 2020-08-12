package com.yc.canteen.dao.impl;

import com.yc.canteen.dao.DBHelper;
import com.yc.canteen.dao.IMemberInfoDao;
import com.yc.canteen.entity.MemberInfo;

public class MemberInfoDaoImpl implements IMemberInfoDao {

	@Override
	public MemberInfo login(MemberInfo mf) {
		DBHelper db = new DBHelper();
		String sql="select mno, nickName, realName, pwd, tel, status from memberinfo where nickName=? and pwd=?";
		return db.find(MemberInfo.class, sql,mf.getNickName(),mf.getPwd());
	}
}
