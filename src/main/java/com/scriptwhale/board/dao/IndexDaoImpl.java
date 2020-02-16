package com.scriptwhale.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scriptwhale.board.vo.IndexVO;

@Repository("IndexDao")
public class IndexDaoImpl implements IndexDao {
	
	@Autowired
	private SqlSession ses;
	
	public void setSes(SqlSession ses) {
		this.ses = ses;
	}
	
	@Override
	public List<IndexVO> selectBoardList() {
		return ses.selectList("index.selectBoardList");
	}

}
