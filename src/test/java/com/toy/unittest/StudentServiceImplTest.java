package com.toy.unittest;

import com.github.dozermapper.core.Mapper;
import com.toy.domain.Student;
import com.toy.dto.CreateStudentDto;
import com.toy.dto.StudentVo;
import com.toy.exception.BizException;
import com.toy.exception.DbException;
import com.toy.repository.StudentRepository;
import com.toy.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Zhang_Xiang
 * @since 2021/4/10 10:38:24
 */
class StudentServiceImplTest {

    @Spy
    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private Mapper mapper;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateStudent_NullName_ShouldThrowException() {
        CreateStudentDto createStudentDto = new CreateStudentDto("", "一些测试地址");
        String msg = Assertions.assertThrows(BizException.ArgumentNullException.class, () -> studentService.create(createStudentDto)).getMessage();
        String expected = "学生名称不能为空，不能创建学生";
        Assertions.assertEquals(expected, msg);
    }

    @Test
    public void testCreateStudent_NullAddress_ShouldThrowException() {
        CreateStudentDto createStudentDto = new CreateStudentDto("小明", "");
        String msg = Assertions.assertThrows(BizException.ArgumentNullException.class, () -> studentService.create(createStudentDto)).getMessage();
        String expected = "学生住址不能为空，不能创建学生";
        Assertions.assertEquals(expected, msg);
    }

    @Test
    public void testCreateStudent_ShouldPass() throws BizException.ArgumentNullException {
        CreateStudentDto createStudentDto = new CreateStudentDto("小明", "住址测试");

        when(studentService.getBaseMapper()).thenReturn(studentRepository);
        when(studentRepository.insert(any(Student.class))).thenReturn(1);
        Student student = new Student();
        when(mapper.map(createStudentDto, Student.class)).thenReturn(student);
        studentService.create(createStudentDto);
    }

    @Test
    public void testRetrieve_NullId_ShouldThrowException() {
        String msg = Assertions.assertThrows(DbException.InvalidPrimaryKeyException.class, () -> studentService.retrieve(null)).getMessage();
        String expected = "无效的主键，主键不能为空";
        Assertions.assertEquals(expected, msg);
    }

    @Test
    public void testRetrieve_ShouldPass() throws DbException.InvalidPrimaryKeyException {
        when(studentService.getBaseMapper()).thenReturn(studentRepository);

        Integer studentId = 1;
        String studentName = "小明";
        String studentAddress = "学生地址";
        LocalDateTime createTime = LocalDateTime.now();
        LocalDateTime updateTime = LocalDateTime.now();
        Student student = new Student(studentId, studentName, studentAddress, createTime, updateTime);
        when(studentRepository.selectById(studentId)).thenReturn(student);
        StudentVo studentVo = new StudentVo(studentId, studentName, studentAddress, createTime, updateTime);
        when(mapper.map(student, StudentVo.class)).thenReturn(studentVo);

        StudentVo studentVoReturn = studentService.retrieve(studentId);

        Assertions.assertEquals(studentId, studentVoReturn.getId());
        Assertions.assertEquals(studentName, studentVoReturn.getName());
        Assertions.assertEquals(studentAddress, studentVoReturn.getAddress());
        Assertions.assertEquals(createTime, studentVoReturn.getCreateTime());
        Assertions.assertEquals(updateTime, studentVoReturn.getUpdateTime());
    }
}