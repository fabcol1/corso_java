package linkedin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FBHome
 */
@WebServlet("/LinkedinHome")
public class LinkedinHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LinkedinHome() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
		if (code == null || code.equals("")) {
			throw new RuntimeException(
					"ERROR: Didn't get code parameter in callback.");
		}
		
		String state=(String)request.getParameter("state");

		PostTest objPost=new PostTest();
		LinkedInProfile linkedInProfile = null;
		try {
			linkedInProfile=objPost.sendPost(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    out.println("<html>");
	    out.println("<body>");
	    out.println("<br> IO SO CHI SEI... LUCA...<br>");
	    out.println("Fist Name : " + linkedInProfile.getFirstName() + "<br>");
	    out.println("Last Name : " + linkedInProfile.getLastName() + "<br>");
	    out.println("Head Line : " + linkedInProfile.getHeadline() + "<br>");
	    out.println("Email	   : " + linkedInProfile.getEmail() + "<br>");
	    out.println("ID        : " + linkedInProfile.getId() + "<br>");

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
