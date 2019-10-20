package ac.za.security;

import ac.za.LearnerManagementSystem;
import ac.za.domain.people.Educator;
import ac.za.factory.peopleFactory.EducatorFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@ContextConfiguration(classes = LearnerManagementSystem.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class SecurityTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/api/admin/educator";

    @Before
    public void addDummyData(){

        Educator educator = EducatorFactory.getEducator("Kyle","Josias",7,26);

        ResponseEntity<Educator> postResponse = restTemplate.postForEntity(baseURL + "/create", educator, Educator.class);

    }

    @Test
    public void whenCorrectCredentialsWillBe200() throws Exception {

        ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "admin").getForEntity(baseURL + "/read/all", String.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void whenIncorrectCredentialsWillBe401() throws Exception {

        ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "admins").getForEntity(baseURL + "/read/all", String.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());

    }

}
