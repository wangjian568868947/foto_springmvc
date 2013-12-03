package cn.wangjianlog.service;

import java.util.List;

import javax.annotation.Resource;

import org.dom4j.util.UserDataAttribute;
import org.hibernate.annotations.Source;
import org.springframework.stereotype.Service;

import cn.wangjianlog.dao.IUserDao;
import cn.wangjianlog.model.Pager;
import cn.wangjianlog.model.User;
import cn.wangjianlog.model.UserException;

@Service("userService")
public class UserService implements IUserService {

	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		User u = userDao.loadByUsername(user.getUsername());
		if(u!=null) throw new UserException("用户已经存在");
		userDao.add(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public User load(int id) {
		return userDao.load(id);
	}

	@Override
	public List<User> list() {
		return userDao.list();
	}

	@Override
	public Pager<User> find() {
		return userDao.find();
	}

	@Override
	public User login(String username, String password) {
		User u = userDao.loadByUsername(username);
		if(u==null) throw new UserException("登录用户不存在");
		if(!u.getPassword().equals(password)) throw new UserException("密码不正确");
		return u;
	}

}
