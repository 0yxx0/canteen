package com.yc.canteen.dao;

import java.util.List;
import java.util.Map;

public interface IOrderInfoDao {

	int add(String cnos, double price, String ano);

	List<Map<String, String>> finds(Integer mno);

}
