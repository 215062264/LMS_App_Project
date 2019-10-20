package ac.za.service.impl.peopleServiceImpl;

import ac.za.domain.people.Student;
import ac.za.repository.repoInterface.people.StudentRepository;
import ac.za.service.serviceInterface.people.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service("studentService")
public class StudentServiceImpl implements StudentService {


    private StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository){
        this.repository = repository;
    }

    @Override
    public Student save(Student student) { return repository.save(student); }

    @Override
    public Student findById(Integer id) {
        Optional<Student> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public Student create(Student student) {
        student  = this.repository.save(student);
        return student;
    }

    @Override
    public Student read(Integer s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Student update(Student student) {
        return repository.save(student);
    }

    @Override
    public void delete(Integer s) { repository.deleteById(s); }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }



}
