package ac.za.service.serviceInterface.academicResults;

import ac.za.domain.academicResults.Results;
import ac.za.service.IService;

import java.util.List;
import java.util.Set;

public interface ResultsService extends IService<Results,Integer> {
    public Results findById(Integer id);
    List<Results> getAll();
    Results save(Results results);
}
