package scrapping.coinmarketcap;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;

public class HtmlunitTestOncoinmarketcap {

	final static Logger logger = Logger.getLogger(HtmlunitTestOncoinmarketcap.class);

	public static void main(String[] args) {

		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		
		try {
			String searchUrl = "https://coinmarketcap.com/";

//			WebRequest secondLoginPage = new WebRequest(new URL(searchUrl));
//	        secondLoginPage.setAdditionalHeader("Cookie", " currencies='USD'");
//	        HtmlPage loginPage2 = webClient.getPage(secondLoginPage);
	        
//			Set<Cookie> cookies = client.getCookies(new URL(searchUrl));
//			System.out.println(Arrays.toString(cookies.toArray()));
			
			HtmlPage page = client.getPage(searchUrl);

			HtmlElement bitcoin = page.getFirstByXPath(".//tbody/tr[@id='id-bitcoin']");
			HtmlElement litecoin = page.getFirstByXPath(".//tbody/tr[@id='id-litecoin']");

			List<HtmlElement> items = Arrays.asList(bitcoin, litecoin);
			logger.debug(Arrays.toString(items.toArray()));

			if (items.isEmpty()) {
				logger.info("No items found !");
			} else {
				for (HtmlElement htmlItem : items) {
					
					// CURRENCY NAME
					HtmlElement name = ((HtmlElement) htmlItem
							.getFirstByXPath(".//td[@class='no-wrap currency-name']"));
					logger.debug("Currency Name: " + name.asText());
					
					// CURRENCY PRICE
					HtmlAnchor itemAnchor = ((HtmlAnchor) htmlItem
							.getFirstByXPath(".//td[@class='no-wrap text-right']/a"));
					logger.debug("Anchor: " + itemAnchor.asText());
					
					String itemPrice = itemAnchor == null ? "0.0" : itemAnchor.asText();

					Item item = new Item();
					item.setTitle(name.asText());
					item.setPrice(new BigDecimal(itemPrice.replace("$", "")));
					
					 ObjectMapper mapper = new ObjectMapper();
					 String jsonString = mapper.writeValueAsString(item) ;
					 logger.info(jsonString);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
