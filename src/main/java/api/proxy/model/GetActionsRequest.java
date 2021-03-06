package api.proxy.model;

public class GetActionsRequest implements JsonRequest {

    private String account_name;

    private Integer pos;

    private Integer offset;

    private String last;

    private String from_date;

    private String to_date;

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public String toJSONString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{ \"account_name\":\"" + account_name + "\"");
        if(pos != null) {
            sb.append(", \"pos\":"+pos);
        }
        if(offset != null) {
            sb.append(", \"offset\":"+offset);
        }
        if(last != null && last.length() > 0) {
            sb.append(",\"last\":\""+last+"\"");
        } else if(from_date != null && from_date.length() > 0) {
            sb.append(",\"from_date\":\""+from_date+"\"");
            if(to_date != null && to_date.length() > 0) {
                sb.append(",\"to_date\":\""+to_date+"\"");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
