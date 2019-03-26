
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import sun.applet.Main;
import org.json.CDL;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.*;
import org.apache.commons.io.FileUtils;
import org.json.JSONWriter;

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
        String method = "Method=findAll";
        String url = "https://deltamedia.api.hasoffers.com/Apiv3/json?api_key=c5cdd08dc2cb01e8bfff8179fc6781ae2b76b65a9137a186b75905af31b9ff2c&Target=Affiliate_Offer&" + method;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        //System.out.println("\nSending 'GET' request to URL : " + url);
        //System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONObject output = new JSONObject(response.toString());
        JSONObject ja = output.getJSONObject("response");
        JSONObject jo = ja.getJSONObject("data");
        
        
        JSONObject five = jo.getJSONObject("5");
        
        JSONObject ofr = five.getJSONObject("Offer");
        
        System.out.println(ofr.length());
        
        //String xArr [][] = null;
        //String[] xArr = new String[100];
        String elephant = ofr.toString(); 
        String[] animals = elephant.split(",");  
        
            Map<String,String> testFive = new HashMap<String,String>();
                       
            

            for (int i=0; i<animals.length; i++){
                String lin = animals[i].toString()+ "#"; 
                String[] insects = lin.split("#");
                for (int b=0; b<insects.length;b++){
                    String bog = insects[b];
                    System.out.print(bog.replace("\""," ") + "\n");
                    
                }

                  //System.out.println(lin);
//                String keyo = lin.substring(0,lin.indexOf(":"));
//                System.out.println(keyo);
//                String valo = lin.substring(lin.indexOf("\":\""), lin.indexOf("@"));
//                System.out.println(valo);
//                testFive.put(keyo,valo);
//                
                
                
                
                        //System.out.println(lin);
                        //System.out.println(animals[i].replace("\"", "") +"\n");
            }
                             //System.out.println(testFive);

       

    }
}



   
        //for(int i = 0; i < ofr.length(); i++){
            //String ts = ofr.getJSONObject(i.toString()).toString();
            //xArr = ArrayHelper.push(ofr.getJSONObject(i).toString());
            //xArr.push("hello",ofr.getJSONObject(i));
        //}


        //List<String> elephantList = Arrays.asList(elephant.split(","));
        //ArrayList<String> elephantList2 = (ArrayList<String>)Arrays.asList(elephant.split(","));


//response.toString() is json string
        //
        //          
        // JsonReader jsonReader = Json.createReader(...);
        // JsonArray array = jsonReader.readArray();
        // jsonReader.close();
        //                                       
        //JSONArray docs = output.getJSONArray();
//        String address = docs.getJSONObject(0).getString("request");
//        File file = new File("fromJson.csv");
//        String csv = CDL.toString(docs);
//        FileUtils.write(file, csv);






