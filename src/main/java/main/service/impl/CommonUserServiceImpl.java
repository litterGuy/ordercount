package main.service.impl;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import main.dao.CommonUserDao;
import main.model.CommonUser;
import main.service.CommonUserService;
import main.utils.MD5Util;

@Service
public class CommonUserServiceImpl implements CommonUserService {
	
	private final static Logger log = Logger.getLogger(CommonUserServiceImpl.class);
	
	@Resource
	private CommonUserDao dao;
	
	@Override
	public boolean userLogin(CommonUser commonuser) {
		if(commonuser == null){
			log.info("the parameter is null should return an error information");
			return false;
		}else{
			CommonUser user = dao.userLogin(commonuser);
			String encryption = MD5Util.toMD5(commonuser.getPassword()); 
			log.error(encryption);
			if(user == null || !encryption.equalsIgnoreCase(user.getPassword())){
				return false;
			}
			return true;
		}
	}

}
