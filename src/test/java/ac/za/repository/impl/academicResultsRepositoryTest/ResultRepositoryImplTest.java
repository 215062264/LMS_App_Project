package ac.za.repository.impl.academicResultsRepositoryTest;

import ac.za.LearnerManagementSystem;
import ac.za.domain.academicResults.Results;
import ac.za.repository.repoInterface.academicResults.ResultRepository;
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
public class ResultRepositoryImplTest {

    @Autowired
    private ResultRepository repository;
    private Results results;

    private Results getSavedCourse() {
        List<Results> savedCourses = this.repository.findAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.results = repository.save(new Results(215062264,100.0));
    }

    @Test
    public void a_create() {
        Results created = this.repository.save(this.results);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.results);
    }

    @Test
    public void b_read() {
        Results savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getStudentNum());
        Results read = this.repository.findById(savedCourse.getStudentNum()).orElse(null);
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Results savedCourse = getSavedCourse();
        this.repository.deleteById(savedCourse.getStudentNum());
        getAll();
    }

    @Test
    public void c_update() {
        Integer newlname = 215;
        double newage = 100.0;
        Results updated = new Results.Builder().copy(getSavedCourse()).studentNum(newlname)
                .mark(newage)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.save(updated);
        Assert.assertSame(newlname, updated.getStudentNum());
    }

    @Test
    public void getAll() {
        List<Results> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);
    }
}
