package com.yc.canteen.listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.yc.canteen.util.FileUploadUtil;
import com.yc.canteen.util.StringUtil;

public class ApplicationListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		String path = application.getInitParameter("uploadPath");
		if(StringUtil.checkNull(path)) {
			path= "../pics";
		}
		
		File file = new File(application.getRealPath(""), path);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		FileUploadUtil.PATH = path;
	}

}
