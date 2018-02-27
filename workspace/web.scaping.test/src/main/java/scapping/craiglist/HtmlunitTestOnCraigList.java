package scapping.craiglist;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlunitTestOnCraigList {

	private static HtmlPage pageAsXML() {
		String searchQuery = "Iphone 6s";

		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		try {
			String searchUrl = "https://sfbay.craigslist.org/search/sss?query="
					+ URLEncoder.encode(searchQuery, "UTF-8");
			HtmlPage page = client.getPage(searchUrl);
//			System.out.println(page.asXml());
			return page;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void parsePageByClass() {
		HtmlPage page = pageAsXML();
		List<HtmlElement> items = page.getByXPath("//p[@class='result-info']");
		if (items.isEmpty()) {
			System.out.println("No items found !");
		} else {
			for (HtmlElement htmlItem : items) {
				HtmlAnchor itemAnchor = ((HtmlAnchor) htmlItem.getFirstByXPath(".//a"));

				String itemName = itemAnchor.asText();
				String itemUrl = itemAnchor.getHrefAttribute();
				HtmlElement spanPrice = ((HtmlElement) htmlItem.getFirstByXPath(".//span[@class='result-price']"));
				// It is possible that an item doesn't have any price
				String itemPrice = spanPrice == null ? "no price" : spanPrice.asText();

				System.out.println(String.format("Name : %s Url : %s Price : %s", itemName, itemUrl, itemPrice));
			}
		}
	}

	private static void parsePageByClassWithJackson() throws JsonProcessingException {
		HtmlPage page = pageAsXML();
		List<HtmlElement> items = page.getByXPath("//p[@class='result-info']");  
		if(items.isEmpty()){  
		  System.out.println("No items found !");
		}else{
			for(HtmlElement htmlItem : items){  
				  HtmlAnchor itemAnchor = ((HtmlAnchor) htmlItem.getFirstByXPath(".//a"));
				  HtmlElement spanPrice = ((HtmlElement) htmlItem.getFirstByXPath(".//span[@class='result-price']")) ;

				  // It is possible that an item doesn't have any price, we set the price to 0.0 in this case
				  String itemPrice = spanPrice == null ? "0.0" : spanPrice.asText() ;

				  Item item = new Item();
				  item.setTitle(itemAnchor.asText());
				  item.setUrl(itemAnchor.getHrefAttribute());
				  item.setPrice(new BigDecimal(itemPrice.replace("$", "")));
				  
				  ObjectMapper mapper = new ObjectMapper();
				  String jsonString = mapper.writeValueAsString(item) ;
				  System.out.println(jsonString);
			}
		}
	}

	public static void main(String[] args) throws JsonProcessingException {
		parsePageByClassWithJackson();
	}

}
