package ac.za.controller.people;

import ac.za.LearnerManagementSystem;
import ac.za.domain.people.Lecture;
import ac.za.factory.peopleFactory.LectureFactory;
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
public class LectureControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/api/admin/lecture";

    @Test
    public void testGetAllLecture() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetLectureById() {
        Lecture lecture = restTemplate.getForObject(baseURL + "/read/1", Lecture.class);
        System.out.println(lecture.getLecturerId());
        assertNotNull(lecture);
    }

    @Test
    public void testCreateLecture() {
        Lecture lecture = LectureFactory.getLecture(1,"Morgan",3);
        System.out.println(lecture);
        TestCase.assertNotNull(lecture);

        ResponseEntity<Lecture> postResponse = restTemplate.withBasicAuth("user","password")
                .postForEntity(baseURL + "/create/", lecture, Lecture.class);

        TestCase.assertNotNull(postResponse);
        TestCase.assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void testUpdateStudent() {
        Integer id = 1;
        Lecture lecture = restTemplate.getForObject(baseURL + "/read/" + id, Lecture.class);
        lecture = LectureFactory.getLecture(1,"Morgan",3);

        ResponseEntity<Lecture> postResponse = restTemplate.withBasicAuth("user","password")
                .postForEntity(baseURL + "/create/", lecture, Lecture.class);

        restTemplate.put(baseURL + "/update/", lecture);

        Lecture updatedLecture = restTemplate.getForObject(baseURL + "/read/" + id, Lecture.class);
        TestCase.assertNotNull(updatedLecture);
        System.out.println(updatedLecture);
    }

    @Test
    public void testDeleteEmployee() {
        Integer id = 1;
        Lecture lecture = restTemplate.getForObject(baseURL + "/lecture/" + id, Lecture.class);
        TestCase.assertNotNull(lecture);
        restTemplate.delete(baseURL + "/educator/" + id);
        try {
            lecture = restTemplate.getForObject(baseURL + "/lecture/" + id, Lecture.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
