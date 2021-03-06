// // This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)
package application;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class Main2
{
    public static void main(String[] args)
    {
        HttpClient httpClient = new DefaultHttpClient();
        String URL = askForURL();
        

        try
        {
        	String link = "http://api.smmry.com/&SM_API_KEY=A34CD89F91&SM_LENGTH=3&SM_WITH_BREAK&SM_URL=";
        	link = link + URL;
            URIBuilder uriBuilder = new URIBuilder(link);

            URI uri = uriBuilder.build();
            HttpPost request = new HttpPost(uri);

            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null)
            {
            	String line;
            	BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));
                while((line = br.readLine()) != null){
                	System.out.println(line);
                }
                br.close();
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static String askForURL(){
    	System.out.println("Paste URL here: ");
    	Scanner reader = new Scanner(System.in);
    	String s = reader.next();
    	reader.close();
    	return s;
    	
    }
}