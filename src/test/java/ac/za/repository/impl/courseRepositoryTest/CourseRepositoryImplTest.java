package ac.za.repository.impl.courseRepositoryTest;

import ac.za.LearnerManagementSystem;
import ac.za.domain.course.Course;
import ac.za.repository.repoInterface.course.CourseRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = LearnerManagementSystem.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseRepositoryImplTest {

    @Autowired
    private CourseRepository repository;
    private Course course;

    private Course getSavedCourse() {
        List<Course> savedCourses = this.repository.findAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        course = repository.save(new Course(1,"Test Course","DIP ICT"));
    }

    @Test
    public void a_create() {
        Course created = this.repository.save(this.course);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.course);
    }

    @Test
    public void b_read() {
        Course savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getCourseId());
        Course read = this.repository.findById(savedCourse.getCourseId()).orElse(null);
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Course savedCourse = getSavedCourse();
        this.repository.deleteById(savedCourse.getCourseId());
        getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Course Name";
        Course course = new Course.Builder().copy(getSavedCourse()).courseName(newname).build();
        System.out.println("In update, about_to_updated = " + course);
        Course updated = this.repository.save(course);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getCourseName());
        getAll();
    }

    @Test
    public void getAll() {
        List<Course> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}
