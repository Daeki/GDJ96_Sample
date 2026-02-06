package com.winter.app.board.qna;

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
@WebServlet("/qna/*")
public class QnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private QnaService qnaService;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaController() {
        super();
        // TODO Auto-generated constructor stub
       this.qnaService = new QnaService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("cat", "QnA");
		request.setAttribute("sub", "1");
		
		String url = request.getRequestURI(); // /notice/list,
		
		url = url.substring(url.lastIndexOf("/"));
		
		String path="";
		try{
			switch(url) {
			case "/list":
				path="/WEB-INF/views/board/list.jsp";
				List<BoardDTO> ar = qnaService.getList();
				request.setAttribute("list", ar);
				break;
			case "/update":
				BoardDTO qnaDto = new QnaDTO();
				qnaDto.setBoard_id(Long.parseLong(request.getParameter("board_id")));
				
				qnaDto = qnaService.getDetail(qnaDto);
				
				request.setAttribute("dto", qnaDto);
				
				path="/WEB-INF/views/board/write.jsp";
				
				break;
				
			case "/write":
				path="/WEB-INF/views/board/write.jsp";
				break;
			case  "/detail":
				
				BoardDTO boardDTO = new QnaDTO();
				boardDTO.setBoard_id(Long.parseLong(request.getParameter("board_id")));
				boardDTO = qnaService.getDetail(boardDTO);
				
				if(boardDTO != null) {
					request.setAttribute("dto", boardDTO);
					path="/WEB-INF/views/board/detail.jsp";
				}else {
					request.setAttribute("result", "글이 없어요");
					request.setAttribute("path", "./list");
					path="/WEB-INF/views/common/result.jsp";
				}
				
				break;
			case "/reply":
				BoardDTO b = new QnaDTO();
				b.setBoard_id(Long.parseLong(request.getParameter("board_id")));
				request.setAttribute("dto", b);
				path="/WEB-INF/views/board/write.jsp";
				
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
		request.setAttribute("cat", "QnA");
		request.setAttribute("sub", "1");
		
		String url = request.getRequestURI(); // /notice/list,
		
		url = url.substring(url.lastIndexOf("/"));
		String path="";
		QnaDTO qnaDTO = new QnaDTO();
		try {
			if(url.equals("/write")) {
				qnaDTO.setBoard_title(request.getParameter("board_title"));
				qnaDTO.setBoard_writer(request.getParameter("board_writer"));
				qnaDTO.setBoard_contents(request.getParameter("board_contents"));
				int result = qnaService.insert(qnaDTO);
				path="./list";
			}else if(url.equals("/update")) {
				qnaDTO.setBoard_title(request.getParameter("board_title"));
				qnaDTO.setBoard_id(Long.parseLong(request.getParameter("board_id")));
				qnaDTO.setBoard_contents(request.getParameter("board_contents"));
				int result = qnaService.update(qnaDTO);
				path="./detail?board_id="+qnaDTO.getBoard_id();
			}else if(url.equals("/delete")) {
				qnaDTO.setBoard_id(Long.parseLong(request.getParameter("board_id")));
				int result = qnaService.delete(qnaDTO);
				path="./list";
			}else if(url.equals("/reply")) {
				qnaDTO.setBoard_id(Long.parseLong(request.getParameter("board_id")));
				qnaDTO.setBoard_title(request.getParameter("board_title"));
				qnaDTO.setBoard_writer(request.getParameter("board_writer"));
				qnaDTO.setBoard_contents(request.getParameter("board_contents"));
				int result = qnaService.reply(qnaDTO);
				path="./list";
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		response.sendRedirect(path);
		
	}

}
