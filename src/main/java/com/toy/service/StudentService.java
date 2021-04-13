package com.toy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.toy.domain.Student;
import com.toy.dto.CreateStudentDto;
import com.toy.dto.StudentVo;
import com.toy.exception.BizException;
import com.toy.exception.DbException;

/**
 * @author Zhang_Xiang
 * @since 2021/4/9 11:34:29
 */
public interface StudentService extends IService<Student> {

    /**
     * 创建学生
     * <p>
     * 验证学生名称不能为空
     * 验证学生地址不能为空
     *
     * @param dto 创建学生传输模型
     * @throws BizException.ArgumentNullException 无效的参数，学生姓名和学生住址不能为空
     */
    void create(CreateStudentDto dto) throws BizException.ArgumentNullException;

    /**
     * 检索学生信息
     *
     * @param id 学生信息 ID
     * @return 学生信息
     * @throws DbException.InvalidPrimaryKeyException 无效的主键异常
     */
    StudentVo retrieve(Integer id) throws DbException.InvalidPrimaryKeyException;
}
