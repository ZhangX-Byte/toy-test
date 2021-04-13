package com.toy.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

/**
 * 学生
 *
 * @author Zhang_Xiang
 * @since 2021/4/9 10:58:06
 */
@Data
@AllArgsConstructor
public class Student {

    public Student() {
        this.createTime = LocalDateTime.now();
    }

    /**
     * 学生唯一标识
     */
    @TableId(type = AUTO)
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
