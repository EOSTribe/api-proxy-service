package api.proxy.model;

public class GetTableByScopeRequest implements JsonRequest {

    private String code;
    private String table;
    private String lower_bound;
    private String upper_bound;
    private Integer limit;
    private Boolean reverse;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }


    public String toJSONString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{\"code\":\""+code+"\"");
        sb.append(",\"table\":\""+table+"\"");
        if(lower_bound != null) {
            sb.append(",\"lower_bound\":\""+lower_bound+"\"");
        }
        if(upper_bound != null) {
            sb.append(",\"upper_bound\":\""+upper_bound+"\"");
        }
        if(limit != null) {
            sb.append(",\"limit\":"+limit);
        }
        if(reverse != null) {
            sb.append(",\"reverse\":"+reverse);
        }
        sb.append("}");
        return sb.toString();
    }
}
