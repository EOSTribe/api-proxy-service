package api.proxy.controller;

import api.proxy.model.*;
import api.proxy.service.ApiPath;
import api.proxy.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/v1/chain")
public class ChainController {

    private String API_SERVER;
    private String TOKEN;


    @Autowired
    public void setProperties(Properties properties) {
        API_SERVER = properties.getApiServer();
        TOKEN = properties.getToken();
    }

    @RequestMapping(value = "/get_info", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getInfo() {
        return processRequest(ApiPath.CHAIN_GET_INFO, new EmptyRequest());
    }

    @RequestMapping(value = "/get_block", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getBlock(@RequestBody GetBlockRequest request) {
        return processRequest(ApiPath.CHAIN_GET_BLOCK, request);
    }

    private ResponseEntity<Object> processRequest(String apiPath, JsonRequest request) {
        try {
            String response = ApiService.call(API_SERVER + apiPath, TOKEN, request.toJSONString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("{\"error\":\""+ex.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
