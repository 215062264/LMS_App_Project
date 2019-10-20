package ac.za.service.impl.course;

import ac.za.domain.course.Course;
import ac.za.repository.repoInterface.course.CourseRepository;
import ac.za.service.serviceInterface.course.CourseService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service("courseService")
public class CourseServiceImpl implements CourseService {

    private CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository){this.repository = repository;}

    @Override
    public Course save(Course course) {
        return repository.save(course);
    }

    @Override
    public Course findById(Integer id) {
        Optional<Course> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }


    @Override
    public Course create(Course course) {
        course  = this.repository.save(course);
        return course;
    }

    @Override
    public Course read(Integer s) { return this.repository.findById(s).orElse(null);}

    @Override
    public Course update(Course course) {
        return this.repository.save(course);
    }

    @Override
    public void delete(Integer s) { this.repository.deleteById(s); }

    @Override
    public List<Course> getAll() { return this.repository.findAll(); }
}
