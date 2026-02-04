package com.winter.app.memo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class MemoController
 */
@WebServlet("/memo/*")
public class MemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemoService memoService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemoController() {
        super();
        // TODO Auto-generated constructor stub
        this.memoService = new MemoService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<MemoDTO> ar = memoService.findAll();;
			
			for(MemoDTO memoDTO: ar) {
				System.out.println("Title : "+memoDTO.getTitle());
				System.out.println("Contents : "+memoDTO.getContents());
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
