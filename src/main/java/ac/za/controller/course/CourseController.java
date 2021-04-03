package ac.za.controller.course;

import ac.za.domain.course.Course;
import ac.za.service.serviceInterface.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin/course")
public class CourseController {

    @Autowired
    @Qualifier("courseService")
    private CourseService service;

    @PostMapping("/create")
    @ResponseBody
    public Course create(@RequestBody Course course) {
        return service.create(course);
    }

    @PutMapping("/update")
    @ResponseBody
    public Course update(@RequestBody Course course) {
        return service.update(course);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Course read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Course> getAll() {
        return service.getAll();
    }

}
