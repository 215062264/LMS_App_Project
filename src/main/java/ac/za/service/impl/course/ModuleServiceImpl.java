package ac.za.service.impl.course;

import ac.za.domain.course.Module;
import ac.za.repository.repoInterface.course.ModuleRepository;
import ac.za.service.serviceInterface.course.ModuleService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {

    private ModuleRepository repository;

    public ModuleServiceImpl(ModuleRepository repository){this.repository = repository;}

    @Override
    public Module save(Module module) {
        return repository.save(module);
    }

    @Override
    public Module findById(Integer id) {
        Optional<Module> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }


    @Override
    public Module create(Module module) {
        module  = this.repository.save(module);
        return module;
    }

    @Override
    public Module read(Integer s) { return this.repository.findById(s).orElse(null);}

    @Override
    public Module update(Module module) {
        return this.repository.save(module);
    }

    @Override
    public void delete(Integer s) { this.repository.deleteById(s); }

    @Override
    public List<Module> getAll() { return this.repository.findAll(); }
}
