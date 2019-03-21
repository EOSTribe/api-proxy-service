package api.proxy.controller;


import api.proxy.model.*;
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
@RequestMapping("/v1/history")
public class HistoryController {


    private String HISTORY_API;
    private String TOKEN;


    @Autowired
    public void setProperties(Properties properties) {
        HISTORY_API = properties.getHistoryApi();
        TOKEN = properties.getToken();
    }

    @RequestMapping(value = "/find_actions", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> findActions(@RequestBody GetActionsRequest request) throws Exception {
        return processRequest("/v1/history/find_actions", request);
    }

    @RequestMapping(value = "/get_actions", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getActions(@RequestBody GetActionsRequest request) throws Exception {
        return processRequest("/v1/history/get_actions", request);
    }

    @RequestMapping(value = "/get_transaction", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getTransaction(@RequestBody GetTransactionRequest request) {
        return processRequest("/v1/history/get_transaction", request);
    }

    @RequestMapping(value = "/get_key_accounts", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getKeyAccounts(@RequestBody GetKeyAccountsRequest request) {
        return processRequest("/v1/history/get_key_accounts", request);
    }

    @RequestMapping(value = "/get_controlled_accounts", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getControlledAccounts(@RequestBody GetControlledAccountsRequest request) {
        return processRequest("/v1/history/get_controlled_accounts", request);
    }

    private ResponseEntity<Object> processRequest(String apiPath, JsonRequest request) {
        try {
            String response = ApiService.call(HISTORY_API+apiPath, TOKEN, request.toJSONString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("{\"error\":\""+ex.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
