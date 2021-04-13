package com.toy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 学生视图模型
 *
 * @author Zhang_Xiang
 * @since 2021/4/9 13:41:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentVo {
    /**
     * 学生唯一标识
     */
    private Integer id;

    /**
     * 学生名称
     */
    private String name;

    /**
     * 学生地址
     */
    private String address;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
