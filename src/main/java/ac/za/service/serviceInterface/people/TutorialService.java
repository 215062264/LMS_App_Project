package ac.za.service.serviceInterface.people;

import ac.za.domain.people.Tutorial;
import ac.za.service.IService;

import java.util.List;
import java.util.Set;

public interface TutorialService extends IService<Tutorial, Integer> {
    public Tutorial findById(Integer id);
    List<Tutorial> getAll();
    Tutorial save(Tutorial tutorial);
}
