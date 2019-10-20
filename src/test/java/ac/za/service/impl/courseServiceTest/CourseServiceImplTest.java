package ac.za.service.impl.courseServiceTest;

import ac.za.domain.course.Course;
import ac.za.factory.course.CourseFactory;
import ac.za.repository.repoInterface.course.CourseRepository;
import ac.za.service.impl.course.CourseServiceImpl;
import ac.za.service.serviceInterface.course.CourseService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;


@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseServiceImplTest {

    private CourseService service;
    @Mock
    private CourseRepository repository;
    private Course course;


    @Before
    public void setUp() throws Exception {
        service = new CourseServiceImpl(repository);
        course = new Course(1,"ICT","Information Technology Course");
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(course));
    }

    @Test
    public void a_create() {
        Mockito.when(repository.save(course)).thenReturn(course);
        Course educator = service.create(this.course);
        System.out.println(educator);
    }

    @Test
    public void c_update() {
        String newName = "IT";
        String newdesc = "Info Tech";
        Integer newId = 1;
        Course newCourse = new Course.Builder()
                .copy(service.findById(1))
                .courseName(newName)
                .description(newdesc)
                .build();
        Mockito.when(repository.save(newCourse)).thenReturn(newCourse);
        Course updated = this.service.update(newCourse);
        Assert.assertEquals(newName, updated.getCourseName());
    }

    @Test
    public void e_delete() {
        Course saved = service.findById(1);
        this.service.delete(saved.getCourseId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Course saved = service.findById(1);
        Course read = this.service.read(saved.getCourseId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        List<Course> courses = this.service.getAll();
        System.out.println("In getall, all = " + courses);
    }

}
