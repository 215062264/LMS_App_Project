package ac.za.service.serviceInterface.academicResults;

import ac.za.domain.academicResults.Exam;
import ac.za.service.IService;

import java.util.List;
import java.util.Set;

public interface ExamService extends IService<Exam, Integer> {
    public Exam findById(Integer id);
    List<Exam> getAll();
    Exam save(Exam exam);
}
