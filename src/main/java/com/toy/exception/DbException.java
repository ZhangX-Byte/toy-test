package com.toy.exception;

/**
 * 数据库操作异常
 *
 * @author Zhang_Xiang
 * @since 2021/4/9 13:43:52
 */
public class DbException {

    public DbException() {
    }

    /**
     * 无效的主键异常
     */
    public static class InvalidPrimaryKeyException extends Exception {
        public InvalidPrimaryKeyException(String detailedMessage) {
            super(detailedMessage);
        }
    }
}
