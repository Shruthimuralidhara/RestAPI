package com.restAPI.RestClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;



public class RestClient {
	
	
	//GET Method :: Retrieve the information using GET method without headers
	//Description :: executes the get method
	//Parameter :: url <String>
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse closeablehttpResponse =  httpClient.execute(httpget);
		
		return closeablehttpResponse;
	}
	
	//POST Method :: Creates new entity
	//Description :: executes post method
	public CloseableHttpResponse post(String url,String entityString, HashMap<String,String> headerMap) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//Post request
		HttpPost httppost = new HttpPost(url);
		//Define Payload
		httppost.setEntity(new StringEntity(entityString));
		
		//Headers 
		for(Entry<String, String> entry : headerMap.entrySet())
		{
			httppost.addHeader(entry.getKey(), entry.getValue());
			
		}
		
		CloseableHttpResponse closeablehttpResponse = httpClient.execute(httppost);
		return closeablehttpResponse;
	}

}
