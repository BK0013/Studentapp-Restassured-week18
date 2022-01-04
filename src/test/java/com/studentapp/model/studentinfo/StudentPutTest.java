package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPutTest extends TestBase {

    @Test
    public void putStudentDetails() {
        List<String> courseList = new ArrayList<>();
        courseList.add("Cucumber");
        courseList.add("Postman");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("RG");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("bkg13@yahoo.com");
        studentPojo.setProgramme("Automation");
        studentPojo.setCourses(courseList);

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 99)
                .body(studentPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();


    }
}