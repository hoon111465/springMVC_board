package com.scriptwhale.board.service;

import com.scriptwhale.board.vo.UserVO;

public interface UserService {
	public int userJoin(UserVO userVO);
	public UserVO userLogin(UserVO userVO);
}
