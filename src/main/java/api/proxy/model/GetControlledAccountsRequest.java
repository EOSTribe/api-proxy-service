package api.proxy.model;

public class GetControlledAccountsRequest implements JsonRequest {

    private String controlling_account;

    public String getControlling_account() {
        return controlling_account;
    }

    public void setControlling_account(String controlling_account) {
        this.controlling_account = controlling_account;
    }

    public String toJSONString() {
        return "{\"controlling_account\":\""+controlling_account+"\"}";
    }
}
