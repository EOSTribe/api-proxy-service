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
import com.fasterxml.jackson.databind.JsonNode;


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

    @RequestMapping(value = "/get_block_header_state", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getBlockHeaderState(@RequestBody GetBlockRequest request) {
        return processRequest(ApiPath.CHAIN_GET_BLOCK_HEADER_STATE, request);
    }

    @RequestMapping(value = "/get_account", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getAccount(@RequestBody GetAccountRequest request) {
        return processRequest(ApiPath.CHAIN_GET_ACCOUNT, request);
    }

    @RequestMapping(value = "/get_abi", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getAbi(@RequestBody GetAccountRequest request) {
        return processRequest(ApiPath.CHAIN_GET_ABI, request);
    }

    @RequestMapping(value = "/get_raw_abi", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getRawAbi(@RequestBody GetAccountRequest request) {
        return processRequest(ApiPath.CHAIN_GET_RAW_ABI, request);
    }

    @RequestMapping(value = "/get_raw_code_and_abi", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getRawCodeAndAbi(@RequestBody GetAccountRequest request) {
        return processRequest(ApiPath.CHAIN_GET_RAW_CODE_AND_ABI, request);
    }

    @RequestMapping(value = "/get_code", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getCode(@RequestBody GetAccountRequest request) {
        return processRequest(ApiPath.CHAIN_GET_CODE, request);
    }

    @RequestMapping(value = "/get_table_rows", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getTableRows(@RequestBody GetTableRowsRequest request) {
        return processRequest(ApiPath.CHAIN_GET_TABLE_ROWS, request);
    }

    @RequestMapping(value = "/get_table_by_scope", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getTableByScope(@RequestBody GetTableByScopeRequest request) {
        return processRequest(ApiPath.CHAIN_GET_TABLE_BY_SCOPE, request);
    }

    @RequestMapping(value = "/get_currency_balance", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getCurrencyBalance(@RequestBody GetCurrencyBalanceRequest request) {
        return processRequest(ApiPath.CHAIN_GET_CURRENCY_BALANCE, request);
    }

    @RequestMapping(value = "/abi_json_to_bin", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> abiJsonToBin(@RequestBody AbiJsonToBinRequest request) {
        return processRequest(ApiPath.CHAIN_ABI_JSON_TO_BIN, request);
    }

    @RequestMapping(value = "/abi_bin_to_json", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> abiBenToJson(@RequestBody AbiBinToJsonRequest request) {
        return processRequest(ApiPath.CHAIN_ABI_BIN_TO_JSON, request);
    }

    @RequestMapping(value = "/get_required_keys", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getRequiredKeys(@RequestBody JsonNode request) {
        return processRequest(ApiPath.CHAIN_GET_REQUIRED_KEYS, request);
    }

    @RequestMapping(value = "/get_currency_stats", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getCurrencyStats(@RequestBody GetCurrencyStatsRequest request) {
        return processRequest(ApiPath.CHAIN_GET_CURRENCY_STATS, request);
    }

    @RequestMapping(value = "/get_producers", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getProducers(@RequestBody GetProducersRequest request) {
        return processRequest(ApiPath.CHAIN_GET_PRODUCERS, request);
    }

    @RequestMapping(value = "/push_block", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> pushBlock(@RequestBody JsonNode request) {
        return processRequest(ApiPath.CHAIN_PUSH_BLOCK, request);
    }

    @RequestMapping(value = "/push_transaction", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> pushTransaction(@RequestBody JsonNode request) {
        return processRequest(ApiPath.CHAIN_PUSH_TRANSACTION, request);
    }

    @RequestMapping(value = "/push_transactions", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> pushTransactions(@RequestBody JsonNode request) {
        return processRequest(ApiPath.CHAIN_PUSH_TRANSACTIONS, request);
    }


    private ResponseEntity<Object> processRequest(String apiPath, JsonRequest request) {
        return processRequest(apiPath, request.toJSONString());
    }

    private ResponseEntity<Object> processRequest(String apiPath, JsonNode request) {
        return processRequest(apiPath, request.asText());
    }

    private ResponseEntity<Object> processRequest(String apiPath, String body) {
        try {
            String response = ApiService.call(API_SERVER + apiPath, TOKEN, body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("{\"error\":\""+ex.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
