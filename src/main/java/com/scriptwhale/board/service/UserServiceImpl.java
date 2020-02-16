package com.scriptwhale.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scriptwhale.board.dao.UserDao;
import com.scriptwhale.board.vo.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	/* 회원가입 */
	@Override
	public int userJoin(UserVO userVO) {
		return userDao.userJoin(userVO);
	}
	
	/* 로그인 */
	@Override
	public UserVO userLogin(UserVO userVO) {
     	return userDao.userLogin(userVO);
	}
	
}
