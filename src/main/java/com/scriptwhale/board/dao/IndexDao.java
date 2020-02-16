package com.scriptwhale.board.dao;

import java.util.List;

import com.scriptwhale.board.vo.IndexVO;

public interface IndexDao {
	
	public List<IndexVO> selectBoardList();

}
