public class graphQLrequestBuilder {
    protected org.json.JSONObject json;
    public graphQLrequestBuilder(){
        json = new org.json.JSONObject();

    }
    public void setQuery(String query){
        json.put("query",query);
    }
    public void setVariables(String variables){
        json.put("variables",variables);
    }
    public void setOperationName(String operationName){
        json.put("operationName",operationName);
    }
    public String getJSONString() {return json.toString();}

}

