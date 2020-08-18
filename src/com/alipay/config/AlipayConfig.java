package com.alipay.config;

public class AlipayConfig {
	// 商户appid
	public static String APPID = "2021000117694661";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCIuybBzOuaXXbO0z/Wg/QvI9TauQIUHiuyysGgzjh8mcyrMPeiLXnKJ/hkc3JfvDS+6+MW3dGW/bEVNgFAbl1teF+a+4uOZl7Uz7zQyPB8YRpEugXYMvU4hmvWJf9eImKLEZChYooTczhxL+LgSoW2Nepomr071SKXidKydvCdlXrSUg4jXvxlIc9yjxrkCsREdkxtEb1z0kQ07ufp3QjUYpOf4ovcInDDgUnWLgnmcdZyXZR5LfIhlGR9ZbhZ2hTS81NPpEKdnb7oOplJqRfqTdZTTDrMTN7tdCitsFM2nx58LWrjjVhvkSDtem5yNndQXy9EgWX9yS83j4F59y5xAgMBAAECggEAFfRO/dFEh024lO8QkgYwAB21wMTyE37gr12lB4f1Q/SCC37aVD0PECmo1aA/3iVfJsTDetl1HNRxSaGZQ9o0wC4S09TODLhdQ7hzbebFzoLc7+oapCNSgpf62rDRNzE4N3JDkdY7q3HVvz7cI/1zSNWRZOhruB655jEoFqXIbtTjbesCEKd5WHf3h9pDoPOzrj0IZcvjE1B6ommNkmgzsENF4HPEDkhNX7wCmWvUO+v1YVxqKunUjTfE17UTFg4ofIdFfXXRZQBPDM8E7Wu+SE3AABk34OSadgauC0IgAxdiQRWflVWoTRebEhIYjSkI5rEsdBc87dzgXqCw9LcXvQKBgQDiWWC3uj0DjH4FILOz8Y+u3O7+2KuTbzqFfp9vhkUjiv++si2QpvRN5zg8L14GNXEYKEUnpEl7IQePo5xEBJJfqmSAgoUYWtnzLlMfNY1YZurfiLb6BQrhDGPx2CmM0DiIZ1hFGKKJb0fHqLtLZoXX0aDeZ9urLqw7megcQhOIAwKBgQCapG4Q3bjaK6Ngcz1VZtT7t0HbPmsOnr5g6EZfQnCzku31ULqvmJ98s5/e4iMmgqdt2rp1db87cmVSZOs561PC0FoILsP21iYmu62uRmbUmqrYScNB2Jd4c3CAWpIB/10KmXhSQ78yrXo4EbQBB4QBLWPQPDCK+ng/aJgBj/RHewKBgGRdxWkyh8N/FJIpggWUY2XiSYdvhAUIGScAkqndG+M6y1Q/pbyyiznQATuOtV6Da/aORLvjOUIDz1p97dirPkx1PcNOHL5D6sjODcWU9WvxlswvzxLmEYDhAaBHfYUW/zpcuONKnSfb1DRQOVyhxU+BgJed7eXl+DEleaquEgMJAoGAHBdciyHLz433yrCEZrwcWnFqvCn1hp1dlfr7tZg7ItPA+Dwm/XjrF9sFYpaPrhIz2efO0UGHcIQSVcpRVJ8kAxKYGD5uiKtUGNsk7LCLQ3mpKUsU9iQjN9U4jYhmV4iM3T0Nt1vpIoqS1haZLUqxNwmIxS3533UqXNJiMn508HsCgYAsOeyXJIhhfxcwKJAo2vKdZz8lxFGwBZ9U62LMQwtBbL45rTWCV/amUAtgxKVnqNbp5QL6fooEdhr6cEaJrz5zU9BN7uSRlQj+2B0RaHtmBvVP1/oe70QT99AXNXL7uEy0oDOfJDsRSFLTmg53lzMTFMLXnj4XZhTxK6qAqi/nCA==";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://yfesen.natappfree.cc/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	public static String return_url = "http://yfesen.natappfree.cc/alipay.trade.wap.pay-JAVA-UTF-8/return_url.jsp";
	// 请求网关地址
	public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjrEVFMOSiNJXaRNKicQuQdsREraftDA9Tua3WNZwcpeXeh8Wrt+V9JilLqSa7N7sVqwpvv8zWChgXhX/A96hEg97Oxe6GKUmzaZRNh0cZZ88vpkn5tlgL4mH/dhSr3Ip00kvM4rHq9PwuT4k7z1DpZAf1eghK8Q5BgxL88d0X07m9X96Ijd0yMkXArzD7jg+noqfbztEKoH3kPMRJC2w4ByVdweWUT2PwrlATpZZtYLmtDvUKG/sOkNAIKEMg3Rut1oKWpjyYanzDgS7Cg3awr1KPTl9rHCazk15aNYowmYtVabKwbGVToCAGK+qQ1gT3ELhkGnf3+h53fukNqRH+wIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
}
