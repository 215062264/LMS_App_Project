package ac.za.repository.impl.peopleRespositoryTest;

import ac.za.LearnerManagementSystem;
import ac.za.domain.people.Tutorial;
import ac.za.factory.peopleFactory.TutorialFactory;
import ac.za.repository.repoInterface.people.TutorialRepository;
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
public class TutorialRepositoryImplTest {

    @Autowired
    private TutorialRepository repository;
    private Tutorial tutorial;

    private Tutorial getSavedCourse() {
        List<Tutorial> savedCourses = this.repository.findAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        tutorial = repository.save(new Tutorial("Kyle","Josias"));
    }

    @Test
    public void a_create() {
        Tutorial created = this.repository.save(this.tutorial);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.tutorial);
    }

    @Test
    public void b_read() {
        Tutorial savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getTutorId());
        Tutorial read = this.repository.findById(savedCourse.getTutorId()).orElse(null);
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Tutorial savedCourse = getSavedCourse();
        this.repository.deleteById(savedCourse.getTutorId());
        getAll();
    }

    @Test
    public void c_update() {
        String newfname = "John";
        String newlname = "Doe";
        Tutorial course = new Tutorial.Builder().copy(getSavedCourse()).tutorFirstName(newfname)
                .tutorLastName(newlname)
                .build();
        System.out.println("In update, about_to_updated = " + course);
        Tutorial updated = this.repository.save(course);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newfname, updated.getTutorFirstName());
        getAll();
    }

    @Test
    public void getAll() {
        List<Tutorial> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);
    }

}
