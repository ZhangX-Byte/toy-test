package com.toy.util;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;

/**
 * @author Zhang_Xiang
 * @since 2021/2/4 17:07:52
 */
public class PredicateSets {

    /**
     * 判断 String 类型不为空
     */
    public static Predicate<String> stringNotEmptyPredicate = StringUtils::isEmpty;

    public static Predicate<Integer> integerLessZeroPredicate = temp -> temp == null || temp <= 0;
}
