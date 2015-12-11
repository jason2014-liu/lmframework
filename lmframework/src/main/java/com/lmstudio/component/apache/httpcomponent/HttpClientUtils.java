/**
* TODO
* @Project: component
* @Title: HttpClientUtils.java
* @Package com.lmstudio.component.apache.httpcomponent
* @author Administrator
* @Date 2015年8月26日 下午3:24:58
* @Copyright
* @Version 
*/
package com.lmstudio.component.apache.httpcomponent;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * TODO
 * 
 * @ClassName: HttpClientUtils
 * @author Administrator
 */
public class HttpClientUtils {

	public static String SEND_URL = "211.151.85.133:8080/sendsms.asp";

	/**
	 * 参数
	 */
	public static String PARA_USERNAME = "username";
	public static String PARA_PASSWORD = "password";
	public static String PARA_PASSWORDMD5 = "passwordMd5";
	public static String PARA_MOBILE = "mobile";
	public static String PARA_MESSAGE = "message";
	public static String PARA_EXT = "Ext";
	
	public static String TEST_MESSAGE = "【四川省12331投诉举报中心】你的投诉举报案件已受理123";

	/**
	 * TODO
	 * 
	 * @Title: main
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
//			URI send_uri = new URIBuilder().setScheme("http").setHost(SEND_URL).setParameter(PARA_USERNAME, "SYJJ")
//					.setParameter(PARA_PASSWORD, "888888").setParameter(PARA_MOBILE, "18608022632").setParameter(PARA_MESSAGE, java.net.URLEncoder.encode(TEST_MESSAGE,"gbk")).build();
			
			String strUrl = "http://211.151.85.133:8080/sendsms.asp?username=SYJJ&password=888888&mobile=18608022632&message="+java.net.URLEncoder.encode(TEST_MESSAGE,"gbk");
			
			HttpGet httpget = new HttpGet(strUrl);
			
			System.out.println("send_url:"+httpget.getURI());
			
			//Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				@Override
				public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
					// TODO Auto-generated method stub
					int status = response.getStatusLine().getStatusCode();
					if(status == HttpStatus.SC_OK ){
						HttpEntity entity = response.getEntity();
						
						return EntityUtils.toString(entity);
						
					}else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
					
				}
				
			};
			
			String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println("responseBody:"+responseBody);
			
			
			
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		}catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			httpclient.close();
		}
	}

}
