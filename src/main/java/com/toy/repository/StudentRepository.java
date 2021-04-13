package com.toy.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.toy.domain.Student;
import org.springframework.stereotype.Repository;

/**
 * @author Zhang_Xiang
 * @since 2021/4/9 11:41:35
 */
@Repository
public interface StudentRepository extends BaseMapper<Student> {
}
