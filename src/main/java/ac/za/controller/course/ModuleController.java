package ac.za.controller.course;

import ac.za.domain.course.Module;
import ac.za.service.serviceInterface.course.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin/module")
public class ModuleController {
    @Autowired
    @Qualifier("moduleService")
    private ModuleService service;

    @PostMapping("/create")
    @ResponseBody
    public Module create(@RequestBody Module module) {
        return service.create(module);
    }

    @PutMapping("/update")
    @ResponseBody
    public Module update(@RequestBody Module module) {
        return service.update(module);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Module read(@PathVariable Integer id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Module> getAll() {
        return service.getAll();
    }
}
