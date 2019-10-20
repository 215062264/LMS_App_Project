package ac.za.controller.course;

import ac.za.LearnerManagementSystem;
import ac.za.domain.course.Course;
import ac.za.domain.course.Module;
import ac.za.factory.course.ModuleFactory;
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
public class ModuleControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/api/admin/module";


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
        Module module = restTemplate.getForObject(baseURL + "/read/1", Module.class);
        System.out.println(module.getModuleId());
        assertNotNull(module);
    }

    @Test
    public void testCreateEducator() {
        Module module = ModuleFactory.getModule(1,"ADP","Application Development Practice 3");
        System.out.println(module);
        TestCase.assertNotNull(module);

        ResponseEntity<Course> postResponse = restTemplate.withBasicAuth("user","password")
                .postForEntity(baseURL + "/create/", module, Course.class);

        TestCase.assertNotNull(postResponse);
        TestCase.assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void testUpdateEducator() {
        Integer id = 1;
        Module module = restTemplate.getForObject(baseURL + "/read/" + id, Module.class);
        module =ModuleFactory.getModule(1,"ADP3","App Dev Practice 3");

        ResponseEntity<Module> postResponse = restTemplate.withBasicAuth("user","password")
                .postForEntity(baseURL + "/create/", module, Module.class);

        restTemplate.put(baseURL + "/update/", module);

        Module updatedEducator = restTemplate.getForObject(baseURL + "/read/" + id, Module.class);
        TestCase.assertNotNull(updatedEducator);
        System.out.println(updatedEducator);
    }

    @Test
    public void testDeleteEducator() {
        Integer id = 1;
        Module module = restTemplate.getForObject(baseURL + "/module/" + id, Module.class);
        TestCase.assertNotNull(module);
        restTemplate.delete(baseURL + "/module/" + id);
        try {
            module = restTemplate.getForObject(baseURL + "/module/" + id, Module.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

}
