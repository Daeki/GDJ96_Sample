package com.winter.app.board.notice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.winter.app.board.BoardDTO;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/notice/*")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NoticeService noticeService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        // TODO Auto-generated constructor stub
        this.noticeService = new NoticeService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURI(); // /notice/list,
		
		url = url.substring(url.lastIndexOf("/"));
		
		String path="";
		try{
			switch(url) {
			case "/list":
				path="/WEB-INF/views/board/list.jsp";
				List<BoardDTO> ar = noticeService.getList();
				request.setAttribute("list", ar);
				break;
			case "/update":
				BoardDTO noticeDTO = new NoticeDTO();
				noticeDTO.setBoard_id(Long.parseLong(request.getParameter("board_id")));
				
				noticeDTO = noticeService.getDetail(noticeDTO);
				
				request.setAttribute("dto", noticeDTO);
				
				path="/WEB-INF/views/board/write.jsp";
				
				break;
				
			case "/write":
				path="/WEB-INF/views/board/write.jsp";
				break;
			case  "/detail":
				
				BoardDTO boardDTO = new NoticeDTO();
				boardDTO.setBoard_id(Long.parseLong(request.getParameter("board_id")));
				boardDTO = noticeService.getDetail(boardDTO);
				
				if(boardDTO != null) {
					request.setAttribute("dto", boardDTO);
					path="/WEB-INF/views/board/detail.jsp";
				}else {
					request.setAttribute("result", "글이 없어요");
					request.setAttribute("path", "./list");
					path="/WEB-INF/views/common/result.jsp";
				}
				
				break;
			default:
				
				
			
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI(); // /notice/list,
		
		url = url.substring(url.lastIndexOf("/"));
		String path="";
		NoticeDTO noticeDTO = new NoticeDTO();
		try {
			if(url.equals("/write")) {
				noticeDTO.setBoard_title(request.getParameter("board_title"));
				noticeDTO.setBoard_writer(request.getParameter("board_writer"));
				noticeDTO.setBoard_contents(request.getParameter("board_contents"));
				int result = noticeService.insert(noticeDTO);
				path="./list";
			}else if(url.equals("/update")) {
				noticeDTO.setBoard_title(request.getParameter("board_title"));
				noticeDTO.setBoard_id(Long.parseLong(request.getParameter("board_id")));
				noticeDTO.setBoard_contents(request.getParameter("board_contents"));
				int result = noticeService.update(noticeDTO);
				path="./detail?board_id="+noticeDTO.getBoard_id();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		response.sendRedirect(path);
		
	}

}
