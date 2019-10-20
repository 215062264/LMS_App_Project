package ac.za.service.serviceInterface.academicResults;

import ac.za.domain.academicResults.Assignments;
import ac.za.service.IService;

import java.util.List;
import java.util.Set;

public interface AssignmentsService extends IService<Assignments, Integer> {
    public Assignments findById(Integer id);
    List<Assignments> getAll();
    Assignments save(Assignments assignments);
}
