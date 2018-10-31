package com.eidiko;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PutJmsMessage
 */
public class PutJmsMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     */
    public PutJmsMessageServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String queueName = request.getParameter("queueName");
		String qcfName = request.getParameter("qCFName");
		String message = request.getParameter("message");
		
		SendMessage sendMessage = new SendMessage();
		StringBuffer result = new StringBuffer();
		try {
			sendMessage.sendMessage(queueName, qcfName, message);
			result.append("Message is successfully delivered");
		} catch (Exception e) {
			result.append("Message failed to delivered");
			result.append("<br>");
			result.append(e.getMessage());
			
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = 
			  getServletContext().getRequestDispatcher("/sendMessage.jsp?result="+result.toString());
			dispatcher.forward(request, response);

		
	}

}
