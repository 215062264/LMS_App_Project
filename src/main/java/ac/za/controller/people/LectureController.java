package ac.za.controller.people;

import ac.za.domain.people.Lecture;
import ac.za.service.serviceInterface.people.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin/lecture")
public class LectureController {
    @Autowired
    @Qualifier("lectureService")
    private LectureService service;

    @PostMapping("/create")
    @ResponseBody
    public Lecture create(@RequestBody Lecture student) {
        return service.create(student);
    }

    @PutMapping("/update")
    @ResponseBody
    public Lecture update(@RequestBody Lecture student) {
        return service.update(student);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Lecture read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Lecture> getAll() {
        return service.getAll();
    }
}
