package ac.za.service.serviceInterface.academicResults;

import ac.za.domain.academicResults.Exam;
import ac.za.domain.academicResults.Quiz;
import ac.za.service.IService;

import java.util.List;
import java.util.Set;

public interface QuizService extends IService<Quiz,Integer> {
    public Quiz findById(Integer id);
    List<Quiz> getAll();
    Quiz save(Quiz quiz);
}
