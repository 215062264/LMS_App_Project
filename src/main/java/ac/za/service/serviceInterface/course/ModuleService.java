package ac.za.service.serviceInterface.course;

import ac.za.domain.course.Module;
import ac.za.service.IService;
import java.util.List;

public interface ModuleService extends IService<Module, Integer> {
    public Module findById(Integer id);
    List<Module> getAll();
    Module save(Module module);
}
