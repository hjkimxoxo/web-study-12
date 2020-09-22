package web_study_12.controller.model;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web_study_12.controller.Command;
import web_study_12.dto.Board;
import web_study_12.service.BoardService;

public class BoardUpdateModel implements Command {
	private BoardService service = new BoardService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if (request.getMethod().equalsIgnoreCase("GET")) {	
			int num = Integer.parseInt(request.getParameter("num"));
			Board b = service.selectByNum(num);
			service.updateReadCount(num);
			
			request.setAttribute("board", b);
			
			return "boardUpdate.jsp";
		}else {
//			request.setCharacterEncoding("UTF-8");
//			
//			Board b = new Board();
//			b.setNum(Integer.parseInt(request.getParameter("num")));
//			b.setName(request.getParameter("name"));
//			b.setPass(request.getParameter("pass"));
//			b.setEmail(request.getParameter("email"));
//			b.setTitle(request.getParameter("title"));
//			b.setContent(request.getParameter("content"));
//			
			
			//System.out.println("오나");
			Gson gson = new Gson();
			
			Board b = gson.fromJson(new InputStreamReader(request.getInputStream(),"UTF-8"), Board.class);
			
			int res = service.updateBoard(b);
			System.out.println(res);
			response.getWriter().print(res);
			
			return null;
		}
		
		
		
	}

}
