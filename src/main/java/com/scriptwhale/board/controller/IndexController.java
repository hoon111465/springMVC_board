package com.scriptwhale.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scriptwhale.board.service.IndexService;
import com.scriptwhale.board.vo.IndexVO;

@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private IndexService indexService;
	
	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String indexpage(Model model, HttpSession session) {
		
		logger.info("index");
		
		List<IndexVO> boardList = indexService.selectBoardList();
		
		model.addAttribute("list", boardList);
		
		
		return "index";
	}
	
	public String insertPage() {
		
		
		return "insert";
	}
	
	
	

}
