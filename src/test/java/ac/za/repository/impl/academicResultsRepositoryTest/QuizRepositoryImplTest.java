package ac.za.repository.impl.academicResultsRepositoryTest;

import ac.za.LearnerManagementSystem;
import ac.za.domain.academicResults.Quiz;
import ac.za.factory.academicsResultsFactory.QuizFactory;
import ac.za.repository.repoInterface.academicResults.QuizRepository;
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
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = LearnerManagementSystem.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QuizRepositoryImplTest {

    @Autowired
    private QuizRepository repository;
    private Quiz quiz;

    private Quiz getSavedCourse() {
        List<Quiz> savedCourses = this.repository.findAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.quiz = repository.save(new Quiz("7 July 2019",100.0));
    }

    @Test
    public void a_create() {
        Quiz created = this.repository.save(this.quiz);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.quiz);
    }

    @Test
    public void b_read() {
        Quiz savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getStudentNum());
        Quiz read = this.repository.findById(savedCourse.getStudentNum()).orElse(null);
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Quiz savedCourse = getSavedCourse();
        this.repository.deleteById(savedCourse.getStudentNum());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "1 July 2019";
        Integer newlname = 215062264;
        double newage = 100.0;
        Quiz updated = new Quiz.Builder()
                .copy(getSavedCourse())
                .dueDate(newCourseName)
                .studentNum(newlname)
                .mark(newage)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.save(updated);
        Assert.assertSame(newCourseName, updated.getDueDate());
    }

    @Test
    public void getAll() {
        List<Quiz> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);
    }
}
