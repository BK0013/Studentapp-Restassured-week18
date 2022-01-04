package com.studentapp.model.studentinfo;

import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {
        Response response =  given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getSingleStudentInfo(){
        Response response =  given()
                .pathParam("id",11)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

       /* Response response =  given()
                .when()
                .get("/3");
        response.then().statusCode(200);
        response.prettyPrint();*/

    }

    @Test
    public void searchStudentWithParameter() {
        HashMap<String, Object> qParams = new HashMap<>();
        qParams.put("programme","Mechanical Engineering");
        qParams.put("limit",2);

        Response response =  given()
                //  .queryParam("programme","Financial Analysis")
                //.queryParam("limit",2)
                .queryParams(qParams)
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();


    }

    {

    }


}
