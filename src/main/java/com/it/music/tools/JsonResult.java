package com.it.music.tools;
/**
 * @author 羡羡
 *
 * 统一返回JSON
 */
public class JsonResult {
    int code;
    String msg;
    Object data;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public JsonResult() {
    }
    public JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public JsonResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

