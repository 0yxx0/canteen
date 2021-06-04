package com.yc.canteen.dao;

import java.util.List;

import com.yc.canteen.entity.MemberInfo;

public interface IMemberInfoDao {

	MemberInfo login(MemberInfo mf);

	List<MemberInfo> finds();

	public int reg(MemberInfo mf);

	public MemberInfo find(MemberInfo mf);

	List<MemberInfo> findAll();

	public int change(MemberInfo m);

}
