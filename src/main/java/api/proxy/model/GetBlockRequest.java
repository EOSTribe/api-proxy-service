package api.proxy.model;

public class GetBlockRequest implements JsonRequest {

    private String block_num_or_id;

    public String getBlock_num_or_id() {
        return block_num_or_id;
    }

    public void setBlock_num_or_id(String block_num_or_id) {
        this.block_num_or_id = block_num_or_id;
    }

    public String toJSONString() {
        return "{ \"block_num_or_id\":\"" + block_num_or_id + "\" }";
    }
}
