package linkedin;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

public class PostTest {
	
	// HTTP POST request
	public LinkedInProfile sendPost(String code ) throws Exception {

		String url = "https://www.linkedin.com/oauth/v2/accessToken";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Host", "www.linkedin.com");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		String urlParameters = "grant_type=authorization_code&code="+code+"&redirect_uri="+LinkedinConnection.REDIRECT_URI+"&client_id="+LinkedinConnection.LI_APP_ID+"&client_secret="+LinkedinConnection.LI_APP_SECRET+"";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		
		JSONObject jsonObj = new JSONObject(response.toString());
		String access_token = jsonObj.getString("access_token");
		System.out.println(access_token);
		 
		LinkedInProfile obj_LinkedInProfile=new LinkedInProfile();
		obj_LinkedInProfile=sendGet(access_token);
		
		return obj_LinkedInProfile;

	}
	
	private static LinkedInProfile sendGet(String access_token) throws Exception {
		
		LinkedInProfile obj_LinkedInProfile=new LinkedInProfile();
//		GET /people/~/email-address
//		String url = "https://api.linkedin.com/v1/people/~/picture-url?format=json";
//		String picture = doGet(url, access_token).toString();
//		
//		url = "https://api.linkedin.com/v1/people/~/email-address?format=json";
//		String email = doGet(url, access_token).toString();
//		
//		url = "https://api.linkedin.com/v1/people/~?format=json";

		String url = "https://api.linkedin.com/v1/people/~"
				+ ":(id,location,email-address,first-name,last-name,formatted-name,picture-url,headline)"
				+ "?format=json";
		
		StringBuffer response = doGet(url, access_token);
		
		JSONObject jsonObj = new JSONObject(response.toString());
		 
		obj_LinkedInProfile.setFirstName(jsonObj.getString("firstName"));
		obj_LinkedInProfile.setLastName(jsonObj.getString("lastName"));
		obj_LinkedInProfile.setHeadline(jsonObj.getString("headline"));
		obj_LinkedInProfile.setEmail(jsonObj.getString("emailAddress"));
		
		obj_LinkedInProfile.setPictureUrl(jsonObj.getString("pictureUrl"));

		JSONObject positionJsonObj = jsonObj.getJSONObject("location");

		obj_LinkedInProfile.setPosition(positionJsonObj.getString("name"));

		obj_LinkedInProfile.setId(jsonObj.getString("id"));
		
		System.out.println(access_token);
		

		return obj_LinkedInProfile;
	}
	
	private static StringBuffer doGet(String url, String access_token) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		con.setRequestProperty("Host", "api.linkedin.com");
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Authorization", "Bearer "+	access_token);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		
		return response;
	}
}
