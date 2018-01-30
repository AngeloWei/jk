package cn.zw.jk.dto;

public class BaseResult {
    private int code;
    private String message;

    public BaseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public BaseResult(){
        this.code=0;
        this.message = "success";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
