package com.heima.pojo;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Result {
    private String status;
    private Integer code;
    private String message;
    private Object data;

    /**
     * 偷懶不寫訊息的成功響應
     */
    @ApiResponse(description = "成功")
    public static Result success(Object data) {
        log.info("成功響應:\ndata: {}",data.toString());
        return new Result("success", 200, "Request successful", data);
    }


    /**
     * 重載success: 可以書寫msg
     */
    public static Result success(String msg, Object data) {
        log.info("成功響應:\nmsg:\n{}",msg);
        return new Result("success", 200, msg, data);
    }

    /**
     * 與目前狀態衝突
     */
    public static Result fail(String msg,Object data) {
        log.info("失敗響應:\nmsg:\n{}",msg);
        return new Result("fail", 409, msg, data);
    }

    public static Result error(String msg) {
        log.info("錯誤響應:\nmsg:\n{}",msg);
        return new Result("未知錯誤", 404, msg, "");
    }

    public static Result errorMissingParameter(String paramName) {
        return new Result("error", 400, "缺少參數: " + paramName, "");
    }

    public static Result errorParameterTooShort(String paramName, int i) {
        return new Result("error", 400, "參數: " + paramName + " 過短！需大於: " + i + " 個字符", "");
    }

    public static Result errorParameterTooLong(String paramName, int i) {
        return new Result("error", 400, "參數: " + paramName + " 過長！需少於: " + i + " 個字符", "");
    }

    public static Result errorWrongFormat(String paramName) {
        return new Result("error", 400, "參數: " + paramName + " 格式錯誤！", "");
    }

}
