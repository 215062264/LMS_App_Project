package ac.za.service.serviceInterface.people;

import ac.za.domain.people.Lecture;
import ac.za.service.IService;

import java.util.List;
import java.util.Set;

public interface LectureService extends IService<Lecture, Integer> {
    public Lecture findById(Integer id);
    List<Lecture> getAll();
    Lecture save(Lecture lecture);
}
