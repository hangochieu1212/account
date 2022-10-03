package com.example.demo.constant;

public enum AccountErrorCode {
    MISSING_USERNAME_FIELD(0, "Username là bắt buộc."),
    EMAIL_INVALID(0, "Địa chỉ email không hợp lệ."),
    EMAIL_EXISTED(0, "Địa chỉ email đã được sử dụng."),
    USER_NOT_EXIST(0, "Người dùng không tồn tại."),
    SUCCESS(1, "Success!"),
    MISSING_EMAIL_FIELD(0, "Địa chỉ email là bắt buộc."),
    FAIL(0, "Fail!"),
    MISSING_PASSWORD_FIELD(0, "Mật khẩu là bắt buộc."),
    INTERNAL_ERROR(0, "Có lỗi xảy ra, hãy thử lại sau!"),
    USERNAME_INVALID(0, "Tài khoản không hợp lệ."),
    USERNAME_EXIST(0, "Username đã tồn tại."),
    EMAIL_EXIST(0, "Email đã tồn tại."),
    PASSWORD_INVALID(0, "Mật khẩu không hợp lệ, phải chứa ít nhất 8 ký tự trong đó có ít nhất 1 chữ in thường, 1 chữ in hoa, 1 số và 1 ký tự đặc biệt"),
    NEW_PASSWORD_INVALID(0, "Mật khẩu mới không hợp lệ, phải chứa ít nhất 8 ký tự trong đó có ít nhất 1 chữ in thường, 1 chữ in hoa, 1 số và 1 ký tự đặc biệt");
    private final int code;
    private String message;
    AccountErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
