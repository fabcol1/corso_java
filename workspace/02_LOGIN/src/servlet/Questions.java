package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Question;

/**
 * Servlet implementation class Questions
 */
@WebServlet("/questionario")
public class Questions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Questions() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnection con = new DBConnection();

		Question q = null;
		try {
			q = con.generateQuestion();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Quest</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<p>");
	    out.println(q.domanda);
	    out.println("</p>");
	    
	    out.println("<form action=\"check\">");
	    for(int i = 0; i < q.risposte.length; i++) {
	    	out.println("<input type=\"checkbox\" name=\"checkbox\" value="+i+" />"+q.risposte[i]+"</br></br>");
	    }
	    out.println("<input type=\"submit\" value=\"Esegui\"/></br></br>");
	    out.println("<input type=\"hidden\" name=\"id\" value=\""+q.id+"\"/></br></br>");
	    out.println("</form>");
	    out.println("</body>");
	    out.println("</html>");
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
