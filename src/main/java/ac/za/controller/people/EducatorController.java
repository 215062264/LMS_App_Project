package ac.za.controller.people;

import ac.za.domain.people.Educator;
import ac.za.service.serviceInterface.people.EducatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/educator")
public class EducatorController {
    @Autowired
    @Qualifier("educatorService")
    private EducatorService service;

    @PostMapping("/create")
    @ResponseBody
    public Educator create(@RequestBody  Educator educator) {
        return service.create(educator);
    }

    @PostMapping("/update")
    @ResponseBody
    public Educator update(@RequestBody Educator educator) {
        return service.update(educator);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Educator read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Educator> getAll() {
        return (List<Educator>) service.getAll();
    }
}
