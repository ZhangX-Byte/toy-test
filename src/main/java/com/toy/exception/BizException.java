package com.toy.exception;

/**
 * @author Zhang_Xiang
 * @since 2021/4/9 11:53:18
 */
public class BizException {

    public BizException() {
    }

    /**
     * 参数为空异常
     */
    public static class ArgumentNullException extends Exception {
        public ArgumentNullException(String detailedMessage) {
            super(detailedMessage);
        }
    }
}
