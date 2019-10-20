package ac.za.service.serviceInterface.course;

import ac.za.domain.course.Course;
import ac.za.service.IService;
import java.util.List;

public interface CourseService extends IService<Course, Integer> {
    public Course findById(Integer id);
    List<Course> getAll();
    Course save(Course course);
}
