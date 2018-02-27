package servlet;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.db.UserDBManager;
import org.entities.User;

import com.commons.PropertiesManager;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/RegistrationLinkedin")
public class RegistrationLinkedin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationLinkedin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		String fname = request.getParameter("fname");
	    String lname = request.getParameter("lname");
	    String email = request.getParameter("email");
	    String pwd = request.getParameter("pass");
	    String pwdr = request.getParameter("passrep");
	    String dateOfBirth = request.getParameter("dateOfBirth");
	    
	    String pictureURL = request.getParameter("pictureURL");
	    
	    HttpSession session = request.getSession();
	    session.setAttribute("email", email);
	    
	    User user = new User();
	    
	    user.setFirstname(fname);
	    user.setLastname(lname);
	    user.setEmail(email);
	    user.setPassword(pwd);
	    
	    
	    if(dateOfBirth.isEmpty()) {
	    	dateOfBirth = null;
	    }
	    
	    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = null;
		try {
			date = format.parse(dateOfBirth);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    user.setDateOfBirth(date);
	    user.setRegdate(new Date());
	    user.setRole(10);
	     
	    
	    
	    String destination = "";
	    
	    
	    try {
//			int validate  = UserDBManager.insertUser(user);
	    	UserDBManager.insertUser(user);
			
//			if (validate == 1) {
//				destination = ("/outputJSP/registrationJSP/registrationok.jsp");
//				destination = ("/uploadimage.jsp");
//			}
				
	    	// CARICO L'IMMAGINE LINKEDI DA URL
	    	System.err.println(pictureURL);
	    	String fileName = generateImage(pictureURL, fname + "_" + lname);
		    UserDBManager.updateImgPath(email, fileName);

	    	
			destination = ("/outputJSP/registrationJSP/registrationok.jsp");

	    	
//			RequestDispatcher rDispatcher  = getServletContext().getRequestDispatcher(destination);
//			rDispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			destination  =("/outputJSP/registrationJSP/registrationko.jsp");
		}
		RequestDispatcher rDispatcher  = getServletContext().getRequestDispatcher(destination);
		rDispatcher.forward(request, response);
	}
	
	private String generateImage(String pictureUrl, String name) throws IOException {
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
		
		String filePath = PropertiesManager.getPropertyAsString("upload.image.path");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String fileName = name + LocalDateTime.now().format(formatter) + ".png";
		
		try (FileOutputStream fos = new FileOutputStream(filePath + File.separator + fileName)) {
			fos.write(imageBytes);
			fos.close();
		}
		
		return fileName;
	}
}
