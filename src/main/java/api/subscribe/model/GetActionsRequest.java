package api.subscribe.model;

public class GetActionsRequest {

    private String data;

    private String last;

    private String from_date;

    private String to_date;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
        if(data != null && data.length() > 0) {
            sb.append("{ \"data\":\"" + data + "\"");
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
