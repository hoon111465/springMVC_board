package com.scriptwhale.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scriptwhale.board.vo.BoardVO;
import com.scriptwhale.board.vo.CommentVO;
import com.scriptwhale.board.vo.PageVO;

@Repository("BoardDao")
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession ses;
	
	public void setSes(SqlSession ses) {
		this.ses = ses;
	}
	
	/* 글쓰기 */
	@Override
	public int boardInsert(BoardVO boardVO) {
		return ses.insert("boardM.boardInsert", boardVO);
	}
	
	/* 글 목록 */
	@Override
	public List<BoardVO> boardList(PageVO pageVO) {
		return ses.selectList("boardM.boardList", pageVO);
	}
	
	/* 글 전체 숫자 */
	@Override
	public int boardTotalCount() {
		return ses.selectOne("boardM.boardListTotalCount");
	}
	
	/* 글 상세 */
	@Override
	public BoardVO boardPost(int no) {
		return ses.selectOne("boardM.boardPost",no);
	}

	/* 글 수정 폼 */
	@Override
	public BoardVO boardUpdateContents(int no) {
		return ses.selectOne("boardM.boardUpdateContent", no);
	}
	
	/* 글 수정 */
	@Override
	public int boardUpdate(BoardVO boardVO) {
		return ses.update("boardM.boardPostUpdate", boardVO);
	}
	
	/*----------------------------*/
	
	/* 댓글작성 */
	@Override
	public int commentInsert(CommentVO commentVO) {
		return ses.insert("commentM.commentInsert", commentVO);
	}
	
	/* 댓글 리스트 */
	@Override
	public List<CommentVO> commentList(PageVO pageVO) {
		return ses.selectList("commentM.commentList", pageVO);
	}
	
	/* 댓글 리스트 토탈수 */
	@Override
	public int commentListTotalCount(int boardNo) {
		return ses.selectOne("commentM.commentListTotalCount", boardNo);
	}
}
