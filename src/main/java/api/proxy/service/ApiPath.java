package api.proxy.service;

public interface ApiPath {

    String HISTORY_FIND_ACTIONS = "/v1/history/find_actions";
    String HISTORY_GET_ACTIONS = "/v1/history/get_actions";
    String HISTORY_GET_TRANSACTION = "/v1/history/get_transaction";
    String HISTORY_GET_KEY_ACCOUNTS = "/v1/history/get_key_accounts";
    String HISTORY_GET_CONTROLLED_ACCOUNTS = "/v1/history/get_controlled_accounts";

    String CHAIN_GET_INFO = "/v1/chain/get_info";
    String CHAIN_GET_BLOCK = "/v1/chain/get_block";
    String CHAIN_GET_BLOCK_HEADER_STATE = "/v1/chain/get_block_header_state";
    String CHAIN_GET_ACCOUNT = "/v1/chain/get_account";
    String CHAIN_GET_ABI = "/v1/chain/get_abi";
    String CHAIN_GET_RAW_ABI = "/v1/chain/get_raw_abi";
    String CHAIN_GET_RAW_CODE_AND_ABI = "/v1/chain/get_raw_code_and_abi";
    String CHAIN_GET_CODE = "/v1/chain/get_code";
    String CHAIN_GET_TABLE_ROWS = "/v1/chain/get_table_rows";
    String CHAIN_GET_TABLE_BY_SCOPE = "/v1/chain/get_table_by_scope";


}
