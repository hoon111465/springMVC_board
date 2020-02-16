package com.scriptwhale.board.dao;

import java.util.List;

import com.scriptwhale.board.vo.BoardVO;
import com.scriptwhale.board.vo.CommentVO;
import com.scriptwhale.board.vo.PageVO;

public interface BoardDao {
	
	public int boardInsert(BoardVO boardVO);
	
	public List<BoardVO> boardList(PageVO pageVO);
	
	public int boardTotalCount();
	
	public BoardVO boardPost(int no);
	
	public BoardVO boardUpdateContents(int no);
	
	public int boardUpdate(BoardVO boardVO);

	/* 댓글 */
	public int commentInsert(CommentVO commentVO);
	
	public List<CommentVO> commentList(PageVO pageVO);
	
	public int commentListTotalCount(int boardNo);
}
