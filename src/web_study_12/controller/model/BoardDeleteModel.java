package web_study_12.controller.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_study_12.controller.Command;
import web_study_12.dto.Board;
import web_study_12.service.BoardService;

public class BoardDeleteModel implements Command {
	private BoardService service = new BoardService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		Board b = service.selectByNum(num);
		System.out.println(b);
		int res = service.deleteBoard(b);
		response.getWriter().print(res);
		response.sendRedirect("boardList.do");
		return null;
	}

}
