package api.subscribe.model;

public class GetTransactionRequest {

    private String id;

    private Integer block_num_hint;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBlock_num_hint() {
        return block_num_hint;
    }

    public void setBlock_num_hint(Integer block_num_hint) {
        this.block_num_hint = block_num_hint;
    }

    public String toJSONString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{ \"id\":\"" + id + "\"");
        if(block_num_hint != null) {
            sb.append(",\"block_num_hint\":"+block_num_hint+"");
        }
        sb.append("}");
        return sb.toString();
    }
}
