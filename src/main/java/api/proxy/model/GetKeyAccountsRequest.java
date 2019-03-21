package api.proxy.model;

public class GetKeyAccountsRequest implements JsonRequest {

    private String public_key;

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }

    public String toJSONString() {
        return "{\"public_key\":\""+public_key+"\"}";
    }
}
