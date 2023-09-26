package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojos.TodoPojo.TodoResponse;

import static io.restassured.RestAssured.given;

public class Todo extends Base{
    static int count = 0;
    static TodoResponse[] todo_tasks;

    @BeforeTest(description = "Get todo API return successful API response")
    public TodoResponse[] get_todo(){
        RestAssured.baseURI = prop.baseUrl();

        Response r = given().when().get("/todos");
        todo_tasks = r.getBody().as(TodoResponse[].class);

        Assert.assertTrue(r.statusCode() == HttpStatus.SC_OK, "Get todo threw status code -> "+r.statusCode());
        return todo_tasks;
    }

    @Test(description = "Todo tasks should not be empty")
    public void check_for_empty_todo(){
        Assert.assertTrue(todo_tasks.length != 0, "There are no todo tasks available");
    }

    @Test(description = "FanCode users should be present in the users list")
    public void check_for_empty_fc_users(){
        Assert.assertTrue(fanCode_users_list.size() != 0, "There are no FanCode users in the list");
    }

    @Test(dependsOnMethods = {"check_for_empty_fc_users"}, description = "All the users of City `FanCode` should have more than half of their todos task completed")
    public void check_all_fc_users_percentage_to_be_above_50(){
        for(TodoResponse to : todo_tasks){
            if(fanCode_users_list.contains(to.userId)){
                count++;
            }
        }
        Assert.assertTrue(count*100/fanCode_users_list.size() > 50, "FanCode users have not completed their tasks");
    }
}
