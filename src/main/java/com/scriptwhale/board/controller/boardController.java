package com.scriptwhale.board.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scriptwhale.board.dao.BoardDao;
import com.scriptwhale.board.service.BoardService;
import com.scriptwhale.board.util.PaginateUtil;
import com.scriptwhale.board.vo.BoardVO;
import com.scriptwhale.board.vo.PageVO;

@Controller
public class boardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardDao boardDao;

	/* 글 목록 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String boardList(HttpSession ses, Model model) {
		return"redirect:/1";
	}
	
	/* 글 목록 */
	@RequestMapping(value = "/{pageNo}", method = RequestMethod.GET)
	public String boardListGo(@PathVariable int pageNo, Model model) {
		
		System.out.println("boardList in");
		
		int numPage = 3;
		int numBlock = 5;
		
		int start = (numPage*pageNo)-3;
		int end = 3;
		
		PageVO pageVO = new PageVO();
		pageVO.setStart(start);
		pageVO.setEnd(end);
		System.out.println("board start : "+start);
		System.out.println("board end : "+end);
		
		int total = boardDao.boardTotalCount();
		System.out.println("board total num : "+total);
		
		String url = "/";
		
		String paginate = PaginateUtil.getPaginate(pageNo, total, numPage, numBlock, url);
		
		
		model.addAttribute("list",boardService.boardList(pageVO) );
		model.addAttribute("paginate",paginate );
		return "board";
	}

	/* 글작성 폼 */
	@RequestMapping(value = "/boardWhite", method = RequestMethod.GET)
	public String boardWhitePage(HttpSession ses) {

		/*
		 * if(ses.getAttribute("idx").equals("")) { return "redirect:/"; }
		 */
		System.out.println("boardController boardWhite page in");
		System.out.println("user idx : " + ses.getAttribute("userConfig.idx"));
		System.out.println("user name : " + ses.getAttribute("userConfig.name"));

		return "boardWhite";
	}

	/* 글 insert */
	@RequestMapping(value = "/boardWhite", method = RequestMethod.POST)
	public String boardWhiteGo(HttpServletRequest req) {

		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		String userNo = req.getParameter("userNo");

		System.out.println("boardController boardWhite insert config");
		System.out.println("title :  " + title);
		System.out.println("contents :  " + contents);
		System.out.println("userNo :  " + userNo);

		BoardVO boardVO = new BoardVO();
		boardVO.setTitle(title);
		boardVO.setContents(contents);
		boardVO.setUserNo(Integer.parseInt(userNo));

		int result = boardService.boardInsert(boardVO);

		System.out.println("board insert result : " + result);

		return "redirect:/";
	}

	/* 글상세 */
	@RequestMapping(value = "/post/{no}", method = RequestMethod.GET)
	public String boardPost(@PathVariable("no") int no, Model model) {

		System.out.println("boardPost in");

		model.addAttribute("board", boardService.boardPost(no));

		return "boardPost";
	}

	/* 글 수정 폼 */
	@RequestMapping(value = "/update/{no}", method = RequestMethod.GET)
	public String boardUpdate(@PathVariable("no") int no, Model model) {

		System.out.println("boardUpdate get in");

		model.addAttribute("board", boardService.boardUpdateContents(no));

		return "boardUpdate";
	}

	/* 글 수정 폼 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String boardUpdate(HttpServletRequest req, Model model) {

		System.out.println("boardUpdate post in");

		BoardVO boardVO = new BoardVO();

		boardVO.setIdx(Integer.parseInt(req.getParameter("idx")));
		boardVO.setTitle(req.getParameter("title"));
		boardVO.setContents(req.getParameter("contents"));

		System.out.println("idx : " + req.getParameter("idx"));
		System.out.println("title : " + req.getParameter("title"));
		System.out.println("contents : " + req.getParameter("contents"));

		int result = boardService.boardUpdate(boardVO);

		if (result > 0) {
			model.addAttribute("board", boardService.boardPost(Integer.parseInt(req.getParameter("idx"))));
		} else {
			return "error";
		}
		return "boardPost";
	}

	/*----------------------------*/

	/* 댓글작성 */
	@ResponseBody
	@RequestMapping(value = "/ajax/comment", method = RequestMethod.GET,  produces = "application/json;charset=UTF-8")
	public   Map<String, Object> ajaxCommentCreate(@RequestParam(value = "userNo") String userNo, 
												   @RequestParam(value = "boardNo") String boardNo,
											       @RequestParam(value = "contents") String contents) {
		
		System.out.println("ajaxCommentCreate GET in");

		System.out.println("userNo : "+userNo);
		System.out.println("boardNo : "+boardNo);
		System.out.println("contents : "+contents);
		
		return boardService.commentInsert(Integer.parseInt(userNo) ,Integer.parseInt(boardNo), contents);
	}


	
	@ResponseBody
	@RequestMapping(value = "/ajax/commentList/{boardNo}", method = RequestMethod.GET,  produces = "application/json;charset=UTF-8")
	public   Map<String, Object> ajaxCommentList(@PathVariable("boardNo") String boardNo,
												 @RequestParam(value = "num") String num) {
		
		System.out.println("ajaxCommentList GET in");

		System.out.println("boardNo : "+boardNo);
		
		return boardService.commentList(Integer.parseInt(boardNo), Integer.parseInt(num));
	}
	
	 

}
