package com.keytory.keyboard.common.exception;

public class KeytoryException extends RuntimeException {

    private final ErrorCode errorCode;

    /**
     * 주어진 오류 코드를 사용하여 {@code KeytoryException}을 생성합니다.
     *
     * @param errorCode 예외와 연관된 오류 코드
     */
    protected KeytoryException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    /**
     * 주어진 오류 코드와 원인으로 {@code KeytoryException}을 생성합니다.
     *
     * @param errorCode 예외와 연관된 오류 코드
     * @param cause 예외의 원인
     */
    protected KeytoryException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.errorCode = errorCode;
    }

    /**
     * 주어진 오류 코드와 메시지로 {@code KeytoryException}을 생성합니다.
     *
     * @param errorCode 예외와 연관된 오류 코드
     * @param message 예외 메시지
     */
    protected KeytoryException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * 예외와 연관된 오류 코드를 반환합니다.
     *
     * @return 오류 코드
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
