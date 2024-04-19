package com.heima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String status;
    private Integer code;
    private String message;
    private Object data;

    public static Result success(Object data){
        return new Result("success",200,"Request successful",data);
    }
    public static Result success(String s , Object data){
        return new Result("success",200,s,data);
    }

    public static Result error(String s){
        return new Result("未知錯誤",404,s,"");
    }

    public static Result errorMissingParameter(String paramName){
        return new Result("error",400,"缺少參數: " + paramName,"");
    }

    public static Result errorParameterTooShort(String paramName, int i){
        return new Result("error",400,"參數: " + paramName + " 過短！需大於: " + i + " 個字符","");
    }

    public static Result errorParameterTooLong(String paramName, int i){
        return new Result("error",400,"參數: " + paramName + " 過長！需少於: " + i + " 個字符","");
    }

    public static Result errorWrongFormat(String paramName){
        return new Result("error",400,"參數: " + paramName + " 格式錯誤！" ,"");
    }

}
