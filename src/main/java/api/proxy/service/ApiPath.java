package api.proxy.service;

public interface ApiPath {

    String HISTORY_FIND_ACTIONS = "/v1/history/find_actions";
    String HISTORY_GET_ACTIONS = "/v1/history/get_actions";
    String HISTORY_GET_TRANSACTION = "/v1/history/get_transaction";
    String HISTORY_GET_KEY_ACCOUNTS = "/v1/history/get_key_accounts";
    String HISTORY_GET_CONTROLLED_ACCOUNTS = "/v1/history/get_controlled_accounts";

    String CHAIN_GET_INFO = "/v1/chain/get_info";
    String CHAIN_GET_BLOCK = "/v1/chain/get_block";

}
