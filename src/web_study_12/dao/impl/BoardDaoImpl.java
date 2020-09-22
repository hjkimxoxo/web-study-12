package web_study_12.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web_study_12.dao.BoardDao;
import web_study_12.ds.JdbcUtil;
import web_study_12.dto.Board;

public class BoardDaoImpl implements BoardDao {
	private static final BoardDaoImpl instance = new BoardDaoImpl();
	private Connection con;

	public BoardDaoImpl() {
	};

	public static BoardDaoImpl getInstance() {
		return instance;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	private Board getBoard(ResultSet rs) throws SQLException {
		Board board = new Board();
		board.setNum(rs.getInt("NUM"));
		board.setPass(rs.getString("PASS"));
		board.setName(rs.getString("NAME"));
		board.setEmail(rs.getString("EMAIL"));
		board.setTitle(rs.getString("TITLE"));
		board.setContent(rs.getString("CONTENT"));
		board.setReadCount(rs.getInt("READCOUNT"));
		board.setWriteDate(rs.getTimestamp("WRITEDATE"));
		return board;
	}

	@Override
	public List<Board> selectBoardByAll() {
		String sql = "SELECT NUM, PASS, NAME, EMAIL, TITLE, CONTENT, READCOUNT, WRITEDATE FROM BOARD ORDER BY NUM ASC";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Board> list = new ArrayList<>();
				do {
					list.add(getBoard(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	@Override
	public int insertBoard(Board board) {
		String sql = "INSERT INTO BOARD(PASS, NAME, EMAIL, TITLE, CONTENT) VALUES (?, ?, ?, ?, ?)";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, board.getPass());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getTitle());
			pstmt.setString(5, board.getContent());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
	}

	@Override
	public void updateReadCount(int num) {
		String sql = "update board set readcount=readcount+1 where num = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomSQLException(e);

		}

	}

	@Override
	public Board selectBoardByNum(int num) {
		String sql = "SELECT NUM, PASS, NAME, EMAIL, TITLE, CONTENT, READCOUNT, WRITEDATE " + "FROM BOARD "
				+ "WHERE NUM = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, num);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getBoard(rs);
				}
			}
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	@Override
	public int updateBoard(Board board) {
		String sql = "UPDATE BOARD SET PASS = ?, NAME = ? , EMAIL = ?, TITLE = ?, CONTENT = ? WHERE NUM = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, board.getPass());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getTitle());
			pstmt.setString(5, board.getContent());
			pstmt.setInt(6, board.getNum());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
	}

	@Override
	public int deleteBoard(Board board) {
		String sql = "DELETE FROM BOARD WHERE NUM = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setInt(1, board.getNum());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
	}

	@Override
	public Board checkPassword(String pass, String num) {
		String sql = "select * from board where pass = ? and num = ?";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			pstmt.setString(1, pass);
			pstmt.setString(2, num);
			if (rs.next()) {
				getBoard(rs);
			}
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

}
