package linkedin;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Base64;

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
	    
	    String image = generateEncodedPngImage(linkedInProfile.getPictureUrl());
		   
//	    <img src='" + encoding +"' alt=\"\" height=\"230\" width=\"390\">.

	    out.println("<br><br>");
	    out.println("<img src='"+image+"' alt=\"\" height=\"80\" width=\"80\" >");
	    out.println("<br><br>");

	    
	    out.println("<br>");
	    out.println("Fist Name : " + linkedInProfile.getFirstName() + "<br>");
	    out.println("Last Name : " + linkedInProfile.getLastName() + "<br>");
	    out.println("Head Line : " + linkedInProfile.getHeadline() + "<br>");
	    out.println("Email	   : " + linkedInProfile.getEmail() + "<br>");
	    out.println("Position  : " + linkedInProfile.getPosition() + "<br>");

//	    out.println("<br>");
//	    out.println("PictureUrl  : " + linkedInProfile.getPictureUrl() + "<br>");
//	    out.println("ID        : " + linkedInProfile.getId() + "<br>");

	    out.println("</body>");
	    out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private String generateEncodedPngImage(String pictureUrl) throws IOException {
		System.out.println(pictureUrl);
		
		URL url = new URL(pictureUrl);
		InputStream in = new BufferedInputStream(url.openStream());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int n = 0;
		while (-1!=(n=in.read(buf)))
		{
		   out.write(buf, 0, n);
		}
		out.close();
		in.close();
		
		byte[] imageBytes = out.toByteArray();

		Base64.Encoder encoder = Base64.getEncoder();

		String encoding = "data:image/png;base64," + encoder.encodeToString(imageBytes);
		return encoding;
	}
}
