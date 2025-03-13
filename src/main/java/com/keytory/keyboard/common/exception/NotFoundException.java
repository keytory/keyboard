package com.keytory.keyboard.common.exception;

public class NotFoundException extends KeytoryException {
    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
