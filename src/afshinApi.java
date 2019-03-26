import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import sun.applet.Main;
import org.json.CDL;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class afshinApi {
    
    private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		afshinApi http = new afshinApi();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();
		
		//System.out.println("\nTesting 2 - Send Http POST request");
		//http.sendPost();

	}

	// HTTP GET request
	private void sendGet() throws Exception {

                String method = "Method=getAccountManager";
                method = "Method=findAll";
                
		String url = "https://deltamedia.api.hasoffers.com/Apiv3/json?Target=Affiliate_Affiliate&" + method + "&api_key=c5cdd08dc2cb01e8bfff8179fc6781ae2b76b65a9137a186b75905af31b9ff2c";
		
                //String url="https://deltamedia.api.hasoffers.com/Apiv3/json?api_key=c5cdd08dc2cb01e8bfff8179fc6781ae2b76b65a9137a186b75905af31b9ff2c&Target=Affiliate_Offer&Method=findAll";
                
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

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

                
                JSONObject output;
        try {
            output = new JSONObject(response.toString());

            JSONArray docs = output.getJSONArray("Target");

            File file=new File("/fromJson.csv");
            String csv = CDL.toString(docs);
            FileUtils.writeStringToFile(file, csv);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
                
		//print result
		System.out.println(response.toString());

	}
    
}
