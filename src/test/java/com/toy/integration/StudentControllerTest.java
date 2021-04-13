package com.toy.integration;

import com.toy.ToyTestApplication;
import com.toy.dto.CreateStudentDto;
import com.toy.dto.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;

import javax.sql.DataSource;

/**
 * @author Zhang_Xiang
 * @since 2021/4/10 16:25:42
 */
@Import(ToyTestConfiguration.class)
@SpringBootTest(classes = ToyTestApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    DataSource datasource;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateStudent_ShouldPass() {
        CreateStudentDto createStudentDto = new CreateStudentDto("小明", "住址测试");
        ResponseEntity<Result> responseEntity = restTemplate.postForEntity("http://localhost:" + port + "/student/create", createStudentDto, Result.class);
        Assertions.assertNotNull(responseEntity.getBody());
        Assertions.assertTrue(responseEntity.getBody().getSucceeded());
    }

    @Test
    public void testRetrieveStudent_ShouldPass() {
        ResponseEntity<Result> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/student/retrieve?id=1", Result.class);
        Assertions.assertNotNull(responseEntity.getBody());
        Assertions.assertTrue(responseEntity.getBody().getSucceeded());
    }
}