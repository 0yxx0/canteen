package com.yc.canteen.dao;

import java.util.List;

import com.yc.canteen.entity.MemberInfo;

public interface IMemberInfoDao {

	MemberInfo login(MemberInfo mf);

	List<MemberInfo> finds();

	public int reg(MemberInfo mf);

	public MemberInfo find(MemberInfo mf);

	public int change(String pwd);

	List<MemberInfo> findAll();

}
