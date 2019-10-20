package ac.za.controller.people;

import ac.za.LearnerManagementSystem;
import ac.za.domain.people.Tutorial;
import ac.za.factory.peopleFactory.TutorialFactory;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = LearnerManagementSystem.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class TutorialControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/api/tutorial";

    @Test
    public void testGetAllStudents() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    public void testGetStudentById() {
        Tutorial tutorial = restTemplate.getForObject(baseURL + "/tutorial/1", Tutorial.class);
        System.out.println(tutorial.getTutorFirstName());
        assertNotNull(tutorial);
    }

    @Test
    public void testCreateStudent() {
        Tutorial tutorial = TutorialFactory.getTutorial(1,"Kyle","Josias");
        System.out.println(tutorial);
        TestCase.assertNotNull(tutorial);

        ResponseEntity<Tutorial> postResponse = restTemplate.withBasicAuth("user","password")
                .postForEntity(baseURL + "/create/", tutorial, Tutorial.class);

        TestCase.assertNotNull(postResponse);
        TestCase.assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void testUpdateStudent() {
        Integer id = 1;
        Tutorial tutorial = restTemplate.getForObject(baseURL + "/read/" + id, Tutorial.class);
        tutorial = TutorialFactory.getTutorial(1,"Kyle","Josias");

        ResponseEntity<Tutorial> postResponse = restTemplate.withBasicAuth("user","password")
                .postForEntity(baseURL + "/create/", tutorial, Tutorial.class);

        restTemplate.put(baseURL + "/update/", tutorial);

        Tutorial updatedTutorial = restTemplate.getForObject(baseURL + "/read/" + id, Tutorial.class);
        TestCase.assertNotNull(updatedTutorial);
        System.out.println(updatedTutorial);
    }

    @Test
    public void testDeleteEmployee() {
        Integer id = 1;
        Tutorial tutorial = restTemplate.getForObject(baseURL + "/tutorial/" + id, Tutorial.class);
        TestCase.assertNotNull(tutorial);
        restTemplate.delete(baseURL + "/tutorial/" + id);
        try {
            tutorial = restTemplate.getForObject(baseURL + "/tutorial/" + id, Tutorial.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
