package ac.za.repository.impl.peopleRespositoryTest;

import ac.za.LearnerManagementSystem;
import ac.za.domain.people.Student;
import ac.za.repository.repoInterface.people.StudentRepository;
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
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository repository;
    private Student student;

    private Student getSavedCourse() {
        List<Student> savedCourses = this.repository.findAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        student = repository.save(new Student("Trevor","Belmont",26));
    }

    @Test
    public void a_create() {
        Student created = this.repository.save(this.student);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.student);
    }

    @Test
    public void b_read() {
        Student savedCourse = getSavedCourse();
        System.out.println("In read, studentId = "+ savedCourse.getStudentId());
        Student read = this.repository.findById(savedCourse.getStudentId()).orElse(null);
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Student savedCourse = getSavedCourse();
        this.repository.deleteById(savedCourse.getStudentId());
        getAll();
    }

    @Test
    public void c_update() {
        String newFirstName = "John";
        String newLastName = "Doe";
        int newAge = 27;
        Student updated = new Student.Builder().copy(getSavedCourse()).studentFirstName(newFirstName)
                .studentLastName(newLastName)
                .age(newAge)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.save(updated);
        Assert.assertSame(newFirstName, updated.getStudentFirstName());
    }

    @Test
    public void getAll() {
        List<Student> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);
    }

}
