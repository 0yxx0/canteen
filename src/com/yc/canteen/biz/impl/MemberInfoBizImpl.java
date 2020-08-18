package com.yc.canteen.biz.impl;

import java.util.List;

import com.yc.canteen.biz.IMemberInfoBiz;
import com.yc.canteen.dao.IMemberInfoDao;
import com.yc.canteen.dao.impl.AdminInfoDaoImpl;
import com.yc.canteen.dao.impl.MemberInfoDaoImpl;
import com.yc.canteen.entity.MemberInfo;
import com.yc.canteen.util.StringUtil;

public class MemberInfoBizImpl implements IMemberInfoBiz{

	@Override
	public MemberInfo login(MemberInfo mf) {
		if(StringUtil.checkNull(mf.getNickName(),mf.getPwd())) {
			return null;
		}
			
		   IMemberInfoDao memberInfoDao = new MemberInfoDaoImpl();
		   return memberInfoDao.login(mf);
	}
	
	@Override
	public List<MemberInfo> finds() {
		 IMemberInfoDao memberInfoDao = new MemberInfoDaoImpl();
		   return memberInfoDao.finds();
	}
	
	@Override
	public int reg(MemberInfo mf) {
		if(StringUtil.checkNull(mf.getNickName(),mf.getPwd(),mf.getEmail())) {
			return -1;
		}
			
		   IMemberInfoDao memberInfoDao = new MemberInfoDaoImpl();
		   return memberInfoDao.reg(mf);
	}
	
	@Override
	public MemberInfo find(MemberInfo mf) {
		if(StringUtil.checkNull(mf.getNickName())) {
			return null;
		}
		   IMemberInfoDao memberInfoDao = new MemberInfoDaoImpl();
		   return memberInfoDao.find(mf);
	}
	
	@Override
	public int change(String pwd) {
		if(StringUtil.checkNull(pwd)) {
			return -1;
		}
		   IMemberInfoDao memberInfoDao = new MemberInfoDaoImpl();
		   return memberInfoDao.change(pwd);
	}
}
