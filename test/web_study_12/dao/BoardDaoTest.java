package web_study_12.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_study_12.dao.impl.BoardDaoImpl;
import web_study_12.dto.Board;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardDaoTest {
	private static BoardDaoImpl dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		dao = BoardDaoImpl.getInstance();
	}

	@Test
	public void test01SelectBoardByAll() {
		System.out.print("selectAll");
		List<Board> list = dao.selectBoardByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
	
	//@Test
	public void test02InsertBoard() {
		System.out.println("insert");
		Board b = new Board("김혜진", "test@sfd", "1234", "타이틀", "컨텐트");
		int res = dao.insertBoard(b);
		Assert.assertEquals(1, res);
		System.out.println("------확인------");
		List<Board> list = dao.selectBoardByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
				
	}
	
	//@Test
	public void test03CheckPassword() {
//		System.out.println("check");
//		String num = "9";
//		String pass = "1234";
//		Board b = dao.checkPassword(num, pass);
//		Assert.assertNotNull(b);
//		System.out.println(b);
	}	

	
	@Test
	public void test04SelectBoardByNum() {
		  System.out.println("testSelectBoardByNum()");
	        Board board = dao.selectBoardByNum(1);
	        Assert.assertNotNull(board);
	        System.out.println(board);
	}
	
	//@Test
	public void test05UpdateBoard() {
		Board b = dao.selectBoardByNum(10);
		b.setName("김혜진변경");
		b.setEmail("이메일변경");
		b.setPass("비번번경");
		b.setTitle("타이틀변경");
		b.setContent("컨텐트변경");
		int res = dao.updateBoard(b);
		Assert.assertEquals(1, res);
		System.out.println("------확인------");
		List<Board> list = dao.selectBoardByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
	
	//@Test
	public void test06UpdateReadCount() {
		
		
	}

	
	//@Test
	public void test07DeleteBoard() {
		System.out.println("delete");
		Board b = new Board(9);
		int res = dao.deleteBoard(b);
		Assert.assertEquals(1, res);
		System.out.println("------확인------");
		List<Board> list = dao.selectBoardByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		
	}

}
