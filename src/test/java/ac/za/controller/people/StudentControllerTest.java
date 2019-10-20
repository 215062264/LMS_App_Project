package ac.za.controller.people;

import ac.za.LearnerManagementSystem;
import ac.za.domain.people.Student;
import ac.za.factory.peopleFactory.StudentFactory;
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

@ContextConfiguration(classes = LearnerManagementSystem.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class StudentControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/api/student";

    @Test
    public void testGetAllStudents() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        TestCase.assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    public void testGetStudentById() {
        Student student = restTemplate.getForObject(baseURL + "/read/1", Student.class);
        System.out.println(student.getStudentFirstName());
        TestCase.assertNotNull(student);
    }

    @Test
    public void testCreateStudent() {
        Student student = StudentFactory.getStudent(1,"John"," Doh",29);
        System.out.println(student);
        TestCase.assertNotNull(student);

        ResponseEntity<Student> postResponse = restTemplate.withBasicAuth("user","password")
                .postForEntity(baseURL + "/create/", student, Student.class);

        TestCase.assertNotNull(postResponse);
        TestCase.assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void testUpdateStudent() {
        Integer id = 1;
        Student student = restTemplate.getForObject(baseURL + "/read/" + id, Student.class);
        student = StudentFactory.getStudent(id,"Tony","Stark",33);

        ResponseEntity<Student> postResponse = restTemplate.withBasicAuth("user","password")
                .postForEntity(baseURL + "/create/", student, Student.class);

        restTemplate.put(baseURL + "/update/", student);

        Student updatedStudent = restTemplate.getForObject(baseURL + "/read/" + id, Student.class);
        TestCase.assertNotNull(updatedStudent);
        System.out.println(updatedStudent);

    }

    @Test
    public void testDeleteStudent() {
        Integer id = 1;
        Student student = restTemplate.getForObject(baseURL + "/student/" + id, Student.class);
        TestCase.assertNotNull(student);
        restTemplate.delete(baseURL + "/student/" + id);
        try {
            student = restTemplate.getForObject(baseURL + "/student/" + id, Student.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
