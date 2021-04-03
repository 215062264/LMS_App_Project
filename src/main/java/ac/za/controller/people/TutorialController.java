package ac.za.controller.people;

import ac.za.domain.people.Tutorial;
import ac.za.service.serviceInterface.people.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/tutorial")
public class TutorialController {
    @Autowired
    @Qualifier("tutorialService")
    private TutorialService service;

    @PostMapping("/create")
    @ResponseBody
    public Tutorial create(@RequestBody Tutorial student) {
        return service.create(student);
    }

    @PutMapping("/update")
    @ResponseBody
    public Tutorial update(@RequestBody Tutorial student) {
        return service.update(student);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Tutorial read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Tutorial> getAll() {
        return service.getAll();
    }
}
