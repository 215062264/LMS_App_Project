package ac.za.service.serviceInterface.people;

import ac.za.domain.people.Student;
import ac.za.service.IService;

import java.util.List;
import java.util.Set;

public interface StudentService extends IService<Student, Integer> {
    public Student findById(Integer id);
    List<Student> getAll();
    Student save(Student student);
}
