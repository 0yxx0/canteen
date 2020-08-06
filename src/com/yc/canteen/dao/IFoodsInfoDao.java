package com.yc.canteen.dao;

import java.util.List;

import com.yc.canteen.entity.FoodsInfo;

public interface IFoodsInfoDao {

	int add(FoodsInfo foods);

	List<FoodsInfo> findByPage(int page, int rows);

}
