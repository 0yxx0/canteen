package com.yc.canteen.biz;

import java.util.List;

import com.yc.canteen.entity.FoodsType;


public interface IFoodsTypeBiz {
     public int add(FoodsType nt);
	
	public List<FoodsType> findAll();
	
	public List<FoodsType> finds();
	
	public int update(FoodsType nt);

	public int delete(String tno);
}
