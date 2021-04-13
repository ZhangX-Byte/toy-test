package com.toy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建学生传输模型
 *
 * @author Zhang_Xiang
 * @since 2021/4/9 11:36:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentDto {

    /**
     * 学生名称
     */
    private String name;

    /**
     * 学生地址
     */
    private String address;
}
