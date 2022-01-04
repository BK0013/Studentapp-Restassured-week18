package com.studentapp.model.studentinfo;

import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentDeleteTest extends TestBase {

    @Test
    public void deleteSingleStudentsInfo() {
        Response response =  given()
                .pathParam("id",3)
                .when()
                .delete("/{id}");
        response.then().statusCode(204);
        response.prettyPrint();
    }

}
