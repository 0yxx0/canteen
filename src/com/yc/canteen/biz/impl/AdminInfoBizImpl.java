package com.yc.canteen.biz.impl;

import java.util.List;

import com.yc.canteen.biz.IAdminInfoBiz;
import com.yc.canteen.dao.IAdminInfoDao;
import com.yc.canteen.dao.impl.AdminInfoDaoImpl;
import com.yc.canteen.entity.AdminInfo;
import com.yc.canteen.util.StringUtil;

public class AdminInfoBizImpl implements IAdminInfoBiz {
	public AdminInfo login(AdminInfo af) {
		if(StringUtil.checkNull(af.getAname(),af.getPwd())) {
			return null;
		}
			
		   IAdminInfoDao adminInfoDao = new AdminInfoDaoImpl();
		   return adminInfoDao.login(af);
	};
	
	@Override
	public int reg(AdminInfo af) {
		if(StringUtil.checkNull(af.getAname(),af.getPwd(),af.getTel())) {
			return -1;
		}
			
		   IAdminInfoDao adminInfoDao = new AdminInfoDaoImpl();
		   return adminInfoDao.reg(af);
	}
	
	@Override
	public List<AdminInfo> find(AdminInfo af) {
		 IAdminInfoDao adminInfoDao = new AdminInfoDaoImpl();
		   return adminInfoDao.find(af);
	}

}
