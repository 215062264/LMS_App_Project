package ac.za.service.impl.peopleServiceTest;

import ac.za.domain.people.Student;
import ac.za.repository.repoInterface.people.StudentRepository;
import ac.za.service.impl.peopleServiceImpl.StudentServiceImpl;
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
public class StudentServiceImplTest {

    private StudentServiceImpl service;
    private Student student;
    @Mock
    StudentRepository repository;

    @Before
    public void setUp() throws Exception {
        service = new StudentServiceImpl(repository);
        student = new Student(1,"Kyle","Josias",25);
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(student));
    }

    @Test
    public void a_create() {
        Mockito.when(repository.save(student)).thenReturn(student);
        Student student = service.create(this.student);
        System.out.println(student);
    }

    @Test
    public void c_update() {
        String newCourseName = "John";
        String newlname = "Doe";
        int newage = 26;
        Student updated = new Student.Builder()
                .copy(service.findById(1))
                .studentFirstName(newCourseName)
                .studentLastName(newlname)
                .age(newage)
                .build();
        Mockito.when(repository.save(updated)).thenReturn(updated);
        Student student = this.service.update(updated);
        Assert.assertEquals(newCourseName, student.getStudentFirstName());
    }

    @Test
    public void e_delete() {
        Student saved = service.findById(1);
        this.service.delete(saved.getStudentId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Student saved = service.findById(1);
        Student read = this.service.read(saved.getStudentId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        List<Student> students = this.service.getAll();
        System.out.println("In getall, all = " + students);
    }
}
