package web_study_12.controller.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_study_12.controller.Command;
import web_study_12.dto.Board;
import web_study_12.service.BoardService;

public class BoardCheckPassModel implements Command {
	private BoardService service = new BoardService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("Get");
			return "boardCheckPass.jsp";
		}else {
			//post
			int num = Integer.parseInt(request.getParameter("num"));
			String pass = request.getParameter("pass");
			
			Board b = service.selectByNum(num);
			if(b.getPass().equals(pass)) {
				response.getWriter().print("2");
			}else {
				response.getWriter().print("1");
				request.setAttribute("message", "비밀번호가 틀렸습니다.");
			}
			return null;
	}

	}
}
