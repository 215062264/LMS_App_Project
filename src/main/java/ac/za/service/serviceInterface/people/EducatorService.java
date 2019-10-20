package ac.za.service.serviceInterface.people;

import ac.za.domain.people.Educator;
import ac.za.service.IService;
import java.util.List;

public interface EducatorService extends IService<Educator,Integer> {
    public Educator findById(Integer id);
    List<Educator> getAll();
    Educator save(Educator educator);
}
