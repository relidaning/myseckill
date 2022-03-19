package xyz.lidaning.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult {
    private int code;
    private String message;
    private Object data;

    public static JsonResult success(){
        return new JsonResult(200, "success", null);
    }
    public static JsonResult success(Object data){
        return new JsonResult(200, "success", data);
    }
    public static JsonResult success(String message, Object data){
        return new JsonResult(200, message, data);
    }
    public static JsonResult success(int code, String message, Object data){
        return new JsonResult(code, message, data);
    }

    public static JsonResult error(){
        return new JsonResult(500, "error", null);
    }
    public static JsonResult error(Object data){
        return new JsonResult(500, "error", data);
    }
    public static JsonResult error(String message, Object data){
        return new JsonResult(500, message, data);
    }
    public static JsonResult error(int code, String message, Object data){
        return new JsonResult(code, message, data);
    }
}
