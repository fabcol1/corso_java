package servlet;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileSystemUtils;
import org.db.UserDBManager;

import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 100 * 1024;
	private int maxMemSize = 4 * 1024;
	private File file;

	@Override
	public void init() {
		// Get the file location where it would be stored.
		filePath = getServletContext().getInitParameter("file-path");
		String location = getServletContext().getRealPath(getServletName());
		// String absolutePath =
		// getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		String deletelocation = location.substring(0, location.indexOf("."));
		String addlocation = getServletContext().getContextPath().substring(1) + "\\images";
		String correctLocation = deletelocation + addlocation;
		System.out.println(correctLocation);
		filePath = correctLocation;
		File theDir = new File(filePath);

		// if the directory does not exist, create it
		if (!theDir.exists()) {
			System.out.println("creating directory: " + theDir.getName());
			boolean result = false;

			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
			}
			if (result) {
				System.out.println("DIR created");
			}
		}

		// System.out.println(location);
		// System.out.println(absolutePath);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		// Check that we have a file upload request
		isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();

		if (!isMultipart) {
			out.println("No Upload This Time");
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);

		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("c:\\temp"));

		// Create a new file upload handler
		ServletFileUpload up = new ServletFileUpload(factory);

		up.setSizeMax(maxFileSize);

		try {

			List fileItems = up.parseRequest(request);

			Iterator element = fileItems.iterator();

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			while (element.hasNext()) {
				FileItem fi = (FileItem) element.next();
				if (!fi.isFormField()) {

					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();

					if (fileName.lastIndexOf("\\") >= 0) {
						file = new File(filePath + "\\" + fileName.substring(fileName.lastIndexOf("\\")));
					} else {
						file = new File(filePath + "\\" + fileName.substring(fileName.lastIndexOf("\\") + 1));
					}

					fi.write(file);
					out.println("Uploaded Filename: " + fileName + "<br>" + filePath);
				
					
					int image = filePath.indexOf("images");
					String img = filePath.substring(image);

					String finalString= img + "/" + fileName;
							
					// AGGIORNIAMO IL DB... CON IL PATH IMG
				    HttpSession session = request.getSession();
				    String email = (String) session.getAttribute("email");
				    UserDBManager.updateImgPath(email, finalString);
				    session.invalidate();
				}
			}
			out.println("</body>");
			out.println("</html>");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}

}