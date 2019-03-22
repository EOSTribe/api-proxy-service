package api.proxy.model;

public class AbiBinToJsonRequest implements JsonRequest {

    private String code;
    private String action;
    private String binargs;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getBinArgs() {
        return binargs;
    }

    public void setBinArgs(String args) {
        this.binargs = binargs;
    }

    public String toJSONString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{\"code\":\""+code+"\"");
        sb.append(",\"action\":\""+action+"\"");
        sb.append(",\"binargs\":\""+binargs+"\"");
        sb.append("}");
        return sb.toString();
    }
}
