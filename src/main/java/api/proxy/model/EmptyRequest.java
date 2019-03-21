package api.proxy.model;

public class EmptyRequest implements JsonRequest {

    public String toJSONString() {
        return "";
    }

}
