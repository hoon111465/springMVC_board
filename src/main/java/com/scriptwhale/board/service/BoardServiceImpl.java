package com.scriptwhale.board.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scriptwhale.board.dao.BoardDao;
import com.scriptwhale.board.util.PaginateUtil;
import com.scriptwhale.board.vo.BoardVO;
import com.scriptwhale.board.vo.CommentVO;
import com.scriptwhale.board.vo.PageVO;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	/* 글쓰기 */
	@Override
	public int boardInsert(BoardVO boardVO) {
		return boardDao.boardInsert(boardVO);
	}
	
	/* 글 목록 */
	/*
	 * @Override public Map<String, Object> boardList(int pageNo) { Map<String,
	 * Object> map = new ConcurrentHashMap<>();
	 * 
	 * int numPage = 3; int numBlock = 3;
	 * 
	 * int start = (numPage*pageNo)-2; int end = (numPage*pageNo);
	 * 
	 * PageVO pageVO = new PageVO(); pageVO.setStart(start); pageVO.setEnd(end);
	 * 
	 * List<BoardVO>list = boardDao.boardList(pageVO); int total =
	 * boardDao.boardTotalCount();
	 * 
	 * String url = "/"+pageNo;
	 * 
	 * String paginate = PaginateUtil.getPaginate(pageNo, total, numPage, numBlock,
	 * url); map.put("list",list); map.put("paginate",paginate);
	 * 
	 * return map; }
	 */
	
	@Override
	public List<BoardVO> boardList(PageVO pageVO) {
		return boardDao.boardList(pageVO);
	}
	
	/* 글 상세 */
	@Override
	public BoardVO boardPost(int no) {
		return boardDao.boardPost(no);
	}
	
	/* 글 수정 폼 */
	@Override
	public BoardVO boardUpdateContents(int no) {
		return boardDao.boardUpdateContents(no);
	}
	
	/* 글 수정 */
	@Override
	public int boardUpdate(BoardVO boardVO) {
		return boardDao.boardUpdate(boardVO);
	}
	

	/*----------------------------*/
	
	/* 댓글작성 */
	@Override
	public Map<String, Object> commentInsert(int userNo, int boardNo, String contents) {
		CommentVO commentVO = new CommentVO();
		
		commentVO.setUserNo(userNo);
		commentVO.setBoardNo(boardNo);
		commentVO.setContents(contents);
		
		Map<String, Object> map = new ConcurrentHashMap<>();
		
		int result = boardDao.commentInsert(commentVO);
		System.out.println("comment insert : "+ result);
		map.put("result",result);
		
		return map;
	}
	
	/* 댓글 리스트 */
	@Override
	public Map<String, Object> commentList(int boardNo, int num) {
		
		Map<String, Object> map = new ConcurrentHashMap<>();
		
		int start = (2*num)-2;
		int end = 2;
		int total = boardDao.commentListTotalCount(boardNo);
		
		if(start>total) {
			start = total;
		}
		
		System.out.println("comment total = "+total);
		System.out.println("comment start = "+start+", end = "+ end );
		
		PageVO pageVO = new PageVO();
		pageVO.setStart(start);
		pageVO.setEnd(end);
		pageVO.setBoardNo(boardNo);
		
		List<CommentVO> list = boardDao.commentList(pageVO);
	
		
	
		map.put("cList", list);
		
		return map;
	}
	
}


