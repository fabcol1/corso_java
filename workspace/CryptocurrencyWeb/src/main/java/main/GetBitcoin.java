package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.db.BitcoinDBManager;
import org.proxima.rest.bean.JSONResponseMessage;
import com.google.gson.Gson;

/**
 * Servlet implementation class GetBitcoin
 */
@WebServlet("/GetBitcoin")
public class GetBitcoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBitcoin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		if(json!=null && !json.isEmpty()) {
			Gson gson = new Gson();
			JSONResponseMessage w = gson.fromJson(json, JSONResponseMessage.class);
			if(w.getMessage().equals("first")) {
				response.getWriter().append(BitcoinDBManager.listToJSON(BitcoinDBManager.getLastDay()));
			}
		} else {
			response.getWriter().append(BitcoinDBManager.listToJSON(BitcoinDBManager.selectLast()));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
