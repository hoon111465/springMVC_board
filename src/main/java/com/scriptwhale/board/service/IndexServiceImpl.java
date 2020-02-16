package com.scriptwhale.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scriptwhale.board.dao.IndexDao;
import com.scriptwhale.board.vo.IndexVO;

@Service("IndexService")
public class IndexServiceImpl implements IndexService {
	
	@Autowired
	private IndexDao indexDao;
	
	public void setIndexDao(IndexDao indexDao) {
		this.indexDao = indexDao;
	}
	
	@Override
	public List<IndexVO> selectBoardList() {
		// TODO Auto-generated method stub
		return indexDao.selectBoardList();
	}

}
