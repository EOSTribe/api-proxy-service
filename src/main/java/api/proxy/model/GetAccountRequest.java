package api.proxy.model;

public class GetAccountRequest implements JsonRequest {

    private String account_name;

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String toJSONString() {
        return "{ \"account_name\":\"" + account_name + "\" }";
    }
}
