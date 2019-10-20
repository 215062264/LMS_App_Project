package ac.za.repository.impl.academicResultsRepositoryTest;

import ac.za.LearnerManagementSystem;
import ac.za.domain.academicResults.Exam;
import ac.za.repository.repoInterface.academicResults.ExamRepository;
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
public class ExamRepositoryImplTest {

    @Autowired
    private ExamRepository repository;
    private Exam exam;

    private Exam getSavedCourse() {
        List<Exam> savedCourses = this.repository.findAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception { this.exam =repository.save(new Exam("215062264",100.0)); }

    @Test
    public void a_create() {
        Exam created = this.repository.save(this.exam);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.exam);
    }

    @Test
    public void b_read() {
        Exam savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getStudentNum());
        Exam read = this.repository.findById(savedCourse.getExamNum()).orElse(null);
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Exam savedCourse = getSavedCourse();
        this.repository.deleteById(savedCourse.getExamNum());
        getAll();
    }

    @Test
    public void c_update() {
        Integer newCourseName = 777;
        String newlname = "215062264";
        double newage = 100.0;
        Exam updated = new Exam.Builder()
                .copy(getSavedCourse())
                .examNum(newCourseName)
                .studentNum(newlname)
                .mark(newage)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.save(updated);
        Assert.assertSame(newCourseName, updated.getExamNum());
    }

    @Test
    public void getAll() {
        List<Exam> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);
    }

}
