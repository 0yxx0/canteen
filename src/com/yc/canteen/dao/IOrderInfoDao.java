package com.yc.canteen.dao;

import java.util.List;
import java.util.Map;

import com.yc.canteen.entity.OrderInfo;

public interface IOrderInfoDao {


	List<Map<String, String>> finds(String mno);

	int add(String cnos, double price, String mno);

	List<OrderInfo> week();

}
