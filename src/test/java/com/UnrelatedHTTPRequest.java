package com;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.junit.Test;

public class UnrelatedHTTPRequest {	
	public static void main(String[] args){
	
		String url = "http://www.google.com/search";
		String charset = "UTF-8"; // Or in Java 7 and later, use the constant:
									// java.nio.charset.StandardCharsets.UTF_8.name()
		String param1 = "pretty";
		String param2 = "girls";
		String query = null;
		URLConnection connection = null;
		InputStream response = null;
		int readData = -1;
		
		try {
			query = String.format("%s+%s",
					URLEncoder.encode(param1, charset),
					URLEncoder.encode(param2, charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		try {
			connection = new URL(url + "?q=" + query).openConnection();
			connection.addRequestProperty("User-Agent", 
			        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		connection.setRequestProperty("Accept-Charset", charset);
		try {
			response = connection.getInputStream();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
		try {
			response = new URL(url).openStream();
		} catch (MalformedURLException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(response);
		do {
			try {
				readData=bufferedInputStream.read();
				char readDataChar = (char) readData;
				System.out.print(readDataChar);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		} while (readData!=-1);
		
		try {
			bufferedInputStream.close();
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
