package api.proxy.model;

public class AbiJsonToBinRequest implements JsonRequest {

    private String code;
    private String action;
    private String args;

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

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String toJSONString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{\"code\":\""+code+"\"");
        sb.append(",\"action\":\""+action+"\"");
        sb.append(",\"args\":\""+args+"\"");
        sb.append("}");
        return sb.toString();
    }
}
