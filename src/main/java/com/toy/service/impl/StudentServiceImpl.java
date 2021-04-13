package com.toy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.dozermapper.core.Mapper;
import com.toy.domain.Student;
import com.toy.dto.CreateStudentDto;
import com.toy.dto.StudentVo;
import com.toy.exception.BizException;
import com.toy.exception.DbException;
import com.toy.repository.StudentRepository;
import com.toy.service.StudentService;
import org.springframework.stereotype.Service;

import static com.toy.util.PredicateSets.integerLessZeroPredicate;
import static com.toy.util.PredicateSets.stringNotEmptyPredicate;

/**
 * @author Zhang_Xiang
 * @since 2021/4/9 11:41:02
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentRepository, Student> implements StudentService {

    private final Mapper mapper;

    public StudentServiceImpl(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void create(CreateStudentDto dto) throws BizException.ArgumentNullException {
        if (stringNotEmptyPredicate.test(dto.getName())) {
            throw new BizException.ArgumentNullException("学生名称不能为空，不能创建学生");
        }
        if (stringNotEmptyPredicate.test(dto.getAddress())) {
            throw new BizException.ArgumentNullException("学生住址不能为空，不能创建学生");
        }

        Student student = mapper.map(dto, Student.class);
        save(student);
    }

    @Override
    public StudentVo retrieve(Integer id) throws DbException.InvalidPrimaryKeyException {
        if (integerLessZeroPredicate.test(id)) {
            throw new DbException.InvalidPrimaryKeyException("无效的主键，主键不能为空");
        }

        Student student = getById(id);
        return mapper.map(student, StudentVo.class);
    }

}
