package http;

import java.io.InputStream;
import java.util.Map;

public class MyHttpRequest {
	
	private String method="GET";
	private String url = "URL";
	public MyHttpRequest(InputStream in){}
	
	public String getUrl() {
		return this.url;
	}
	public String getMethod(){
		return "";
	}
	public Map<String, String> getParameters() {
		return null;
	}
	
	//...
}
