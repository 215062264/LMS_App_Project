package ac.za.controller.people;

import ac.za.LearnerManagementSystem;
import ac.za.domain.people.Educator;
import ac.za.factory.peopleFactory.EducatorFactory;
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
public class EducatorControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/api/admin/educator";


    @Test
    public void testGetAllEducator() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    public void testGetEducatorById() {
        Educator educator = restTemplate.getForObject(baseURL + "/read/1", Educator.class);
        System.out.println(educator.getEducatorId());
        assertNotNull(educator);
    }

    @Test
    public void testCreateEducator() {
        Educator educator = EducatorFactory.getEducator("Kyle","Josias",1,26);
        System.out.println(educator);
        TestCase.assertNotNull(educator);

        ResponseEntity<Educator> postResponse = restTemplate.withBasicAuth("user","password")
                .postForEntity(baseURL + "/create/", educator, Educator.class);

        TestCase.assertNotNull(postResponse);
        TestCase.assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void testUpdateEducator() {
        Integer id = 1;
        Educator educator = restTemplate.getForObject(baseURL + "/read/" + id, Educator.class);
        educator = EducatorFactory.getEducator("Tony","Stark",id,33);

        ResponseEntity<Educator> postResponse = restTemplate.withBasicAuth("user","password")
                .postForEntity(baseURL + "/create/", educator, Educator.class);

        restTemplate.put(baseURL + "/update/", educator);

        Educator updatedEducator = restTemplate.getForObject(baseURL + "/read/" + id, Educator.class);
        TestCase.assertNotNull(updatedEducator);
        System.out.println(updatedEducator);
    }

    @Test
    public void testDeleteEducator() {
        String id = "1";
        Educator educator = restTemplate.getForObject(baseURL + "/educator/" + id, Educator.class);
        TestCase.assertNotNull(educator);
        restTemplate.delete(baseURL + "/educator/" + id);
        try {
            educator = restTemplate.getForObject(baseURL + "/educator/" + id, Educator.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
