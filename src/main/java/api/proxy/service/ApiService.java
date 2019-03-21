package api.proxy.service;

import api.proxy.controller.HistoryController;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ApiService {

    private static Logger LOGGER = LoggerFactory.getLogger(HistoryController.class);

    private static final String AGENT_NAME = "API Proxy Service";

    public static String call(String apiUrl, String token, String requestJSON) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        StringEntity se = new StringEntity(requestJSON);
        se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        HttpPost post = new HttpPost(apiUrl);
        post.setEntity(se);
        post.addHeader("User-Agent", AGENT_NAME);
        post.addHeader("Authorization", token);
        CloseableHttpResponse httpResponse = httpclient.execute(post);
        int responseCode = httpResponse.getStatusLine().getStatusCode();
        if (responseCode == 200) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    httpResponse.getEntity().getContent()));

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();
            httpclient.close();

            return response.toString();
        } else {
            LOGGER.error("Error calling "+apiUrl+" - got response code: "+responseCode);
            throw new Exception("Remote call to "+apiUrl+" returned "+responseCode+" code");
        }
    }

}
