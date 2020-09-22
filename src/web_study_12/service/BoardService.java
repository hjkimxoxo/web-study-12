package web_study_12.service;

import java.sql.Connection;
import java.util.List;

import web_study_12.dao.BoardDao;
import web_study_12.dao.impl.BoardDaoImpl;
import web_study_12.ds.JdbcUtil;
import web_study_12.dto.Board;

public class BoardService {
	private BoardDaoImpl dao = BoardDaoImpl.getInstance();
	private Connection con = JdbcUtil.getConnection();

	public BoardService() {
		dao.setCon(con);
	}

	public List<Board> getBoards() {
		return dao.selectBoardByAll();
	}
	
	public int insertBoard(Board board) {
		return dao.insertBoard(board);
	}
	
	public int updateBoard(Board board) {
		return dao.updateBoard(board);
	}
	
	public Board selectByNum(int num) {
		return dao.selectBoardByNum(num);
	}
	
	public void updateReadCount(int num) {
		dao.updateReadCount(num);
	}
	
	public int deleteBoard(Board board) {
		return dao.deleteBoard(board);
	}
	
	
	
}
