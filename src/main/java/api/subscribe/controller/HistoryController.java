package api.subscribe.controller;


import api.subscribe.model.GetActionsRequest;
import api.subscribe.model.GetKeyAccountsRequest;
import api.subscribe.model.GetTransactionRequest;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.apache.http.entity.StringEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/v1/history")
public class HistoryController {


    private static Logger LOGGER = LoggerFactory.getLogger(HistoryController.class);

    private String HISTORY_API;
    private String TOKEN;


    private final String AGENT_NAME = "API Proxy Service";


    @Autowired
    public void setProperties(Properties properties) {
        HISTORY_API = properties.getHistoryApi();
        TOKEN = properties.getToken();
    }

    @RequestMapping(value = "/find_actions", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> findActions(@RequestBody GetActionsRequest request) throws Exception {
        try {
            String response = callAPI("/v1/history/find_actions", request.toJSONString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("{\"error\":\""+ex.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/get_actions", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getActions(@RequestBody GetActionsRequest request) throws Exception {
        try {
            String response = callAPI("/v1/history/get_actions", request.toJSONString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("{\"error\":\""+ex.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/get_transaction", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getTransaction(@RequestBody GetTransactionRequest request) throws Exception {
        try {
            String response = callAPI("/v1/history/get_transaction", request.toJSONString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("{\"error\":\""+ex.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/get_key_accounts", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getKeyAccounts(@RequestBody GetKeyAccountsRequest request) throws Exception {
        try {
            String response = callAPI("/v1/history/get_key_accounts", request.toJSONString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("{\"error\":\""+ex.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String callAPI(String apiPath, String requestJSON) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        StringEntity se = new StringEntity(requestJSON);
        se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        HttpPost post = new HttpPost(HISTORY_API + apiPath);
        post.setEntity(se);
        post.addHeader("User-Agent", AGENT_NAME);
        post.addHeader("Authorization", TOKEN);
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
            LOGGER.error("Error calling "+apiPath+" - got response code: "+responseCode);
            throw new Exception("Remote call to "+apiPath+" returned "+responseCode+" code");
        }
    }

}
