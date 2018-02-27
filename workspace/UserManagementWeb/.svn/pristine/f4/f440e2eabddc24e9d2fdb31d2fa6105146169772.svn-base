package servlet;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.db.UserDBManager;

import com.commons.PropertiesManager;

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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
		filePath = PropertiesManager.getPropertyAsString("upload.image.path");

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

			List<FileItem> fileItems = up.parseRequest(request);

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			
			for(FileItem fi : fileItems) {
				if (!fi.isFormField()) {

					String fileName = fi.getName();
//					JAVA BASE
//					String[] fileEdEstensione = fileName.split(".");
					
//					API COMMONS
					String base = FilenameUtils.getBaseName(fileName);
					String ext = "." + FilenameUtils.getExtension(fileName);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

					String genName = base + LocalDateTime.now().format(formatter)  + ext;
					boolean nomeGiaEsistente;
					
					do {
						String[] file_list = new File(filePath).list();
						nomeGiaEsistente = false;
						
						for(String s : file_list) {
							if(s.equals(fileName)) {
								nomeGiaEsistente = true;
								genName = base + LocalDateTime.now().format(formatter) + ext;
							}
						}
					} while(nomeGiaEsistente);
					
					fileName = genName;
					
					file = new File(filePath + File.separator + fileName);
					fi.write(file);
					
					out.print("Upload immagine eseguita con successo" + "<a href='index.jsp'>Esegui login</a>");
					
					int image = filePath.indexOf("images");
					String img = filePath.substring(image);
							
					// AGGIORNIAMO IL DB... CON IL PATH IMG
				    HttpSession session = request.getSession();
				    String email = (String) session.getAttribute("email");
				    UserDBManager.updateImgPath(email, fileName);
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