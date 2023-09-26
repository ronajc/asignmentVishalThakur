package Tests;

import Util.readProperty;
import io.restassured.*;
import io.restassured.response.Response;
import org.testng.annotations.*;
import pojos.UsersPojo.Users;
import static io.restassured.RestAssured.given;
import java.util.*;

public class Base {
    readProperty prop = new readProperty();
    List<Integer> fanCode_users_list = new ArrayList<>();
    final static int long_low = 5;
    final static int long_high = 100;
    final static int lat_low = -40;
    final static int lat_high = 5;

    @BeforeSuite
    public void preRequisite() {
        RestAssured.baseURI = prop.baseUrl();

        Response r = given().when().get("/users");
        Users[] all_users = r.getBody().as(Users[].class);

        for(Users user: all_users){
            int latitude = user.address.geo.lat.intValue();
            int longitude = user.address.geo.lng.intValue();
            if(latitude >= lat_low && latitude <=lat_high && longitude >= long_low && longitude <= long_high){
                fanCode_users_list.add(user.id);
            }
        }
        System.out.println("List of all users who are part of FanCode --> "+fanCode_users_list);
    }

    @AfterSuite
    public void teardown() {
        System.out.println("Test Finished .....");
    }

}
