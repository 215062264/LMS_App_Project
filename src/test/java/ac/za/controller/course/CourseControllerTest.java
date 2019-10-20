package ac.za.controller.course;

import ac.za.LearnerManagementSystem;
import ac.za.domain.course.Course;
import ac.za.factory.course.CourseFactory;
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
public class CourseControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/api/admin/course";


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
        Course course = restTemplate.getForObject(baseURL + "/read/1", Course.class);
        System.out.println(course.getCourseId());
        assertNotNull(course);
    }

    @Test
    public void testCreateEducator() {
        Course educator = CourseFactory.getCourse(1,"ADP","Application Development Practice 3");
        System.out.println(educator);
        TestCase.assertNotNull(educator);

        ResponseEntity<Course> postResponse = restTemplate.withBasicAuth("user","password")
                .postForEntity(baseURL + "/create/", educator, Course.class);

        TestCase.assertNotNull(postResponse);
        TestCase.assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void testUpdateEducator() {
        Integer id = 1;
        Course course = restTemplate.getForObject(baseURL + "/read/" + id, Course.class);
        course = CourseFactory.getCourse(1,"ADP3","App Dev Practice 3");

        ResponseEntity<Course> postResponse = restTemplate.withBasicAuth("user","password")
                .postForEntity(baseURL + "/create/", course, Course.class);

        restTemplate.put(baseURL + "/update/", course);

        Course updatedEducator = restTemplate.getForObject(baseURL + "/read/" + id, Course.class);
        TestCase.assertNotNull(updatedEducator);
        System.out.println(updatedEducator);
    }

    @Test
    public void testDeleteEducator() {
        Integer id = 1;
        Course course = restTemplate.getForObject(baseURL + "/course/" + id, Course.class);
        TestCase.assertNotNull(course);
        restTemplate.delete(baseURL + "/course/" + id);
        try {
            course = restTemplate.getForObject(baseURL + "/course/" + id, Course.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

}
