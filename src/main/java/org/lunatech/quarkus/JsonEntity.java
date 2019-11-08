package org.lunatech.quarkus;

public class JsonEntity {
    public int code;
    public String error;
    public Object result;
    
    public JsonEntity(int code, String error) {
        this.code = code;
        this.error = error;
    }

    public JsonEntity(Object result) {
        this.result = result;
    }

    public static JsonEntity error(int code, String error) {
        return new JsonEntity(code, error);
    }

    public static JsonEntity result(Object result) {
        return new JsonEntity(result);
    }
}