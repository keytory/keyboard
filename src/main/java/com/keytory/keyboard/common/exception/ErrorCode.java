package com.keytory.keyboard.common.exception;

public enum ErrorCode {

    INVALID_REQUEST_ARGUMENT("잘못된 요청입니다.");

    private final String message;

    /**
     * 주어진 메시지를 사용하여 새로운 {@code ErrorCode}를 생성합니다.
     *
     * @param message 오류 메시지
     */
    ErrorCode(String message) {
        this.message = message;
    }

    /**
     * 오류 메시지를 반환합니다.
     *
     * @return 오류 메시지
     */
    public String getMessage() {
        return message;
    }
}
