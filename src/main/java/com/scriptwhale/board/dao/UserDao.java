package com.scriptwhale.board.dao;

import com.scriptwhale.board.vo.UserVO;

public interface UserDao {
	public int userJoin(UserVO userVO);
	public UserVO userLogin(UserVO userVO);
}
