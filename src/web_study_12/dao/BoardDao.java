package web_study_12.dao;

import java.util.List;

import web_study_12.dto.Board;

public interface BoardDao {
	List<Board> selectBoardByAll();
	int insertBoard(Board board); 
	int updateBoard(Board board); 
	int deleteBoard(Board board);
	Board checkPassword(String pass, String num);
	Board selectBoardByNum(int num);
	void updateReadCount(int num);
}
