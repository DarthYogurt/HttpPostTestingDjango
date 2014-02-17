import java.io.File;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


public class Main {
	//static String url = "http://dev.darthyogurt.com:8000/upload/";
	static String url = "http://127.0.0.1:8000/upload/";
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		multipartPost();

	}

	// For sending files using MultipartEntity
		@SuppressWarnings("deprecation")
		public static void multipartPost() throws ClientProtocolException, IOException {
			//File image = new File("e:/coding_workspace/HTTPPostTester/test.jpg");
			File json = new File("e:/coding_workspace/HTTPPostTester/test.json");
			
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(url);
			post.setHeader("enctype", "multipart/form-data");

			MultipartEntityBuilder multipartEntity = MultipartEntityBuilder.create();
			multipartEntity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			//multipartEntity.addPart("image12", new FileBody(image));
			multipartEntity.addPart("data", new FileBody(json));
			post.setEntity(multipartEntity.build());
			
			HttpResponse response = client.execute(post);
			String responseBody = EntityUtils.toString(response.getEntity());
			System.out.println(responseBody);
		}
}
