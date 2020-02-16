package com.scriptwhale.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scriptwhale.board.vo.UserVO;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession ses;
	
	public void setSes(SqlSession ses) {
		this.ses = ses;
	}

	/* 회원가입 */
	@Override
	public int userJoin(UserVO userVO) {
		return ses.insert("userM.userJoinGo", userVO);
	}
	
	/* 로그인 */
	@Override
	public UserVO userLogin(UserVO userVO) {
		return ses.selectOne("userM.userlogin",userVO);
	}

}
