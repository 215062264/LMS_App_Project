package ac.za.controller.people;

import ac.za.domain.people.Student;
import ac.za.service.serviceInterface.people.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    @Qualifier("studentService")
    private StudentService service;


    @PostMapping("/create")
    @ResponseBody
    public Student create(@RequestBody Student student) {return service.create(student); }

    @PutMapping("/update")
    @ResponseBody
    public Student update(@RequestBody Student student) {
        return service.update(student);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Student read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Student> getAll() {
        return service.getAll();
    }
}
