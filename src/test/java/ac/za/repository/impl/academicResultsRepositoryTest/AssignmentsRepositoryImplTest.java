package ac.za.repository.impl.academicResultsRepositoryTest;

import ac.za.LearnerManagementSystem;
import ac.za.domain.academicResults.Assignments;
import ac.za.repository.repoInterface.academicResults.AssignmentsRepository;
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
public class AssignmentsRepositoryImplTest {

    @Autowired
    private AssignmentsRepository repository;
    private Assignments assignments;

    private Assignments getSavedCourse() {
        List<Assignments> savedCourses = this.repository.findAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        assignments = repository.save(new Assignments("1 June 2019","215062264",100.0));

    }

    @Test
    public void a_create() {
        Assignments created = this.repository.save(this.assignments);
        System.out.println("In create, created = " + created);
        Assert.assertEquals(created, this.assignments);
    }

    @Test
    public void b_read() {
        Assignments savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getAssId());
        Assignments read = this.repository.findById(savedCourse.getAssId()).orElse(null);
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Assignments savedCourse = getSavedCourse();
        this.repository.deleteById(savedCourse.getAssId());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "2 June 2019";
        String newlname = "215062264";
        double newage = 100.0;
        Assignments updated = new Assignments.Builder()
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
        List<Assignments> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}
