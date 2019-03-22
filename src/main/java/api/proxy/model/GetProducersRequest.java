package api.proxy.model;

public class GetProducersRequest implements JsonRequest {

    private String limit;
    private String lower_bound;
    private Boolean json;

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getLower_bound() {
        return lower_bound;
    }

    public void setLower_bound(String lower_bound) {
        this.lower_bound = lower_bound;
    }

    public Boolean getJson() {
        return json;
    }

    public void setJson(Boolean json) {
        this.json = json;
    }

    public String toJSONString() {
        StringBuffer sb = new StringBuffer();
        if(limit == null) limit = "50";
        sb.append("{\"limit\":\""+limit+"\"");
        if(lower_bound != null) sb.append(",\"lower_bound\":\""+lower_bound+"\"");
        if(json) sb.append(",\"json\":true");
        sb.append("}");
        return sb.toString();
    }
}
