package com.toy.api

import com.toy.dto.CreateStudentDto
import com.toy.dto.Result
import com.toy.dto.StudentVo
import com.toy.exception.BizException.ArgumentNullException
import com.toy.exception.DbException.InvalidPrimaryKeyException
import com.toy.service.StudentService
import org.springframework.web.bind.annotation.*

/**
 * @author Zhang_Xiang
 * @since 2021/4/9 13:50:59
 */
@RestController
@RequestMapping("student")
class StudentController(private val studentService: StudentService) {
    /**
     * 创建学生
     * 添加一条学生记录到数据库中
     *
     * @param createStudentDto 创建学生传输模型
     */
    @PostMapping("create")
    fun create(@RequestBody createStudentDto: CreateStudentDto?): Result<String> = try {
        studentService.create(createStudentDto)
        Result.success("创建成功")
    } catch (e: ArgumentNullException) {
        e.printStackTrace()
        Result.failure(e.message)
    }


    /**
     * 检索学生信息
     *
     * @param id 学生唯一标识
     * @return 学生信息
     */
    @GetMapping("retrieve")
    fun retrieve(id: Int?): Result<StudentVo> = try {
        val studentVo = studentService.retrieve(id)
        Result.success(studentVo)
    } catch (e: InvalidPrimaryKeyException) {
        e.printStackTrace()
        Result.failure(e.message)
    }
}