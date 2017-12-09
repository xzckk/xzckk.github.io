package org.tarena.cloudnote.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.cloudnote.dao.UserDAO;
import org.tarena.cloudnote.entity.NoteBook;
import org.tarena.cloudnote.entity.User;
import org.tarena.cloudnote.util.NoteResult;
import org.tarena.cloudnote.util.NoteUtil;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDAO userDao;
	public NoteResult loadusers() {
		NoteResult result=new NoteResult();
		List<User> users=userDao.findAll();
		result.setStatus(0);
		result.setMsg("loaded successfuly");
		result.setData(users);
		return result;
	}
	@Transactional(readOnly=true)
	public NoteResult checklogin(String name, String password) {
		NoteResult result=new NoteResult();
		//check username and password
		User user=userDao.findByName(name);
//		System.out.println(user.getCn_user_au());
		if (user==null) {
			result.setStatus(1);
			result.setMsg("username doesn't exit");
			result.setData(null);
			return result;
		}
		//password
		String md5_password=NoteUtil.md5(password);
		if (!user.getCn_user_password().equals(md5_password)) {
			result.setStatus(2);
			result.setMsg("wrong password");
			result.setData(null);
			return result;
		}
		//equals("A") adding later
		if (user.getCn_user_au()==null) {
			result.setStatus(3);
			result.setMsg("plesase wait for authorized");
			result.setData(null);
			return result;
		}
		result.setStatus(0);
		result.setMsg("login successfully");
		//Cookie
		result.setData(user.getCn_user_id());
		return result;
	}

	@Transactional 
	public NoteResult regist(String name, String password, String nick) {
		NoteResult result=new NoteResult();
		//checking
		User has_user=userDao.findByName(name);
		if(has_user!=null){
			result.setStatus(1);
			result.setMsg("please change username");
			result.setData(null);
			return result;
		}
		//other
		User user=new User();
		String userId=NoteUtil.createId();
		user.setCn_user_id(userId); 
		user.setCn_user_name(name); 
		String md5_password=NoteUtil.md5(password);
		user.setCn_user_password(md5_password); //jiami password
		user.setCn_user_nick(nick); 
		user.setCn_user_token(null); 
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("regist succussfully");
		result.setData(null);
		return result;
	}
	@Transactional 
	public NoteResult authorize(String name) {
		NoteResult result=new NoteResult();
		System.out.println(name);
		//other
		User user=new User();
		user.setCn_user_name(name); 
		userDao.authorize(user);
		result.setStatus(0);
		result.setMsg("authorize succussfully");
		result.setData(null);
		return result;
	}
}