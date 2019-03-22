package api.proxy.model;

public class GetCurrencyBalanceRequest implements JsonRequest {

    private String code;
    private String account;
    private String symbol;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String toJSONString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{\"code\":\""+code+"\"");
        sb.append(",\"account\":\""+account+"\"");
        sb.append(",\"symbol\":\""+symbol+"\"");
        sb.append("}");
        return sb.toString();
    }
}
