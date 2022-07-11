package config;

import domain.dao.UserDao;
import domain.dao.UserDaoImpl;
import lombok.Getter;
import service.UserService;
import service.UserServiceImpl;

@Getter
public class ServletContextConfig {
	private static ServletContextConfig instance = null;
	
	/*
	 * Custom IoC (객체관리)
	 */
	
	//Service
	private UserService userService;
	
	//Repository
	private UserDao userDao;
	
	public ServletContextConfig() {}
	
	public static ServletContextConfig getInstance() {
		if(instance == null) {
			instance = new ServletContextConfig();
			instance.setIoc();
		}
		return instance;
	}
	
	private void setIoc() {
		if(userDao == null) {
			userDao = new UserDaoImpl();
		}
		
		if(userService == null) {
			userService = new UserServiceImpl();
		}
	}
}
