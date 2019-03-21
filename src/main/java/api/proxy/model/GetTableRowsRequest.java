package api.proxy.model;

public class GetTableRowsRequest implements JsonRequest {

    private String code;
    private String table;
    private String index_position;
    private String key_type;
    private String encode_type;

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

    public String getIndex_position() {
        return index_position;
    }

    public void setIndex_position(String index_position) {
        this.index_position = index_position;
    }

    public String getKey_type() {
        return key_type;
    }

    public void setKey_type(String key_type) {
        this.key_type = key_type;
    }

    public String getEncode_type() {
        return encode_type;
    }

    public void setEncode_type(String encode_type) {
        this.encode_type = encode_type;
    }

    public String toJSONString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{\"code\":\""+code+"\"");
        sb.append(",\"table\":\""+table+"\"");
        if(index_position != null) {
            sb.append(",\"index_position\":\""+index_position+"\"");
        }
        if(key_type != null) {
            sb.append(",\"key_type\":\""+key_type+"\"");
        }
        if(encode_type != null) {
            sb.append(",\"encode_type\":\""+encode_type+"\"");
        }
        sb.append("}");
        return sb.toString();
    }
}
