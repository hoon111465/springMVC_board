package com.scriptwhale.board.service;

import java.util.List;
import java.util.Map;

import com.scriptwhale.board.vo.BoardVO;
import com.scriptwhale.board.vo.CommentVO;
import com.scriptwhale.board.vo.PageVO;

public interface BoardService {
	
	public int boardInsert(BoardVO boardVO);
	public List<BoardVO> boardList(PageVO pageVO);
	public BoardVO boardPost(int no);
	public BoardVO boardUpdateContents(int no);
	public int boardUpdate(BoardVO boardVO);
	
	/* 댓글 */
	public Map<String, Object> commentInsert(int userNo, int boardNo, String contents);
	public Map<String, Object> commentList(int boardNo, int num);

}
