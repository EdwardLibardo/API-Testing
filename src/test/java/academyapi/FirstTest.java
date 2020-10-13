package academyapi;

import academyapi.pojos.Issuetype;
import academyapi.pojos.Project;
import academyapi.pojos.Fields;
import academyapi.pojos.PojoMockApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class FirstTest {
    private Response _response;
    private String _lastId;

    @Test
    public void testOne() {
        _response = (Response) RestAssured.get("https://5f8386306b97440016f4e745.mockapi.io/users");
        Assert.assertEquals(_response.getStatusCode(), 200);
        //check if the body is empty
        if (!_response.body().toString().isBlank()) {
            ArrayList<String> list = RestAssured.get("https://5f8386306b97440016f4e745.mockapi.io/users").then().extract().path("id");
            int length = list.size();
            //if the body is not empty, all the user will be deleted
            for (int i = 0; i <= length - 1; i++) {
                _response = RestAssured.delete("https://5f8386306b97440016f4e745.mockapi.io/users/" + list.get(i));
            }
        }
        //checking again the body does not have any user
        RestAssured.given().when().get("https://5f8386306b97440016f4e745.mockapi.io/users")
                .then().statusCode(200).body("$", Matchers.hasSize(0));
    }

    @Test
    public void testTwo() throws Exception {
        PojoMockApi user = new PojoMockApi(2, "Cristiano1", "Ronaldo", 321312, 13123, "retiro",
                "hjkdsfhs@gmail.com", true, "colombia", 31221);
        _response = RestAssured.given().contentType("application/json").body(user).when().post("https://5f8386306b97440016f4e745.mockapi.io/users/");
        Assert.assertEquals(_response.getStatusCode(), 201);
    }

    @Test
    public void creatingAJiraBug() throws ParseException {
        //Project projectString = new Project("API")
        Fields fields = new Fields(new Project("API"), "REST ye merry gentlemen",
                "Creating of an issue using Project keys and issue type names using the REST API", new Issuetype("Bug"));
        File jsonCreatAnIssue = new File("src/test/resources/creatingIssue.json"); //this json file is created to send a post if you want to use the json directly
        System.out.println("{"+fields.toString()+"}");
        String jsonIssue = "{"+fields.toString()+"}";
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonIssue);
        _response = RestAssured.given().auth().preemptive().basic("elcorregidorc@correo.udistrital.edu.co", "odLsGl7LeBinegJe4dCu21AD")
                .contentType("application/json").body(json).when().post("https://edwardcorregidor.atlassian.net/rest/api/2/issue/");
        _lastId = _response.then().contentType("application/json").extract().path("id");
        System.out.println(_lastId);
        Assert.assertEquals(_response.getStatusCode(), 201);
    }

    @Test
    public void bugIdIsHigherThanTheLastOne() {
        _response = RestAssured.given().auth().preemptive().basic("elcorregidorc@correo.udistrital.edu.co", "odLsGl7LeBinegJe4dCu21AD")
                .contentType("application/json").when().get("https://edwardcorregidor.atlassian.net/rest/api/2/search?jql=project=ApiTest");
        Assert.assertEquals(_response.getStatusCode(), 200);
        List<Integer> allIds = _response.jsonPath().getList("issues.id");
        for (int i = 0; i <= allIds.size() - 1; i++) {
            System.out.println(allIds.get(i));
        }
        int lastValue = Integer.parseInt(String.valueOf(allIds.get(0)));
        Assert.assertTrue(lastValue > Integer.parseInt(String.valueOf(allIds.get(1))));
    }
}