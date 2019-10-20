package ac.za.repository.impl.peopleRespositoryTest;

import ac.za.LearnerManagementSystem;
import ac.za.domain.people.Educator;
import ac.za.repository.repoInterface.people.EducatorRepository;
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
public class EducatorRepositoryImplTest {

    @Autowired
    private EducatorRepository repository;
    Educator educator;

    private Educator getSavedCourse() {
        List<Educator> savedCourses = this.repository.findAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        educator = repository.save(new Educator("Professor","Moriarty",55));
    }

    @Test
    public void a_create() {
        Educator created = repository.save(educator);
        System.out.println("In create, created = " + created);
        Assert.assertSame(created, educator);
    }

    @Test
    public void b_read() {
        Educator savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getEducatorId());
        Educator read = this.repository.findById(savedCourse.getEducatorId()).orElse(null);
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Educator savedCourse = getSavedCourse();
        this.repository.deleteById(savedCourse.getEducatorId());
        getAll();
    }

    @Test
    public void c_update() {
        String newfname = "John";
        String newlname = "Doe";
        int newage = 26;
        Educator educator = new Educator.Builder()
                .copy(getSavedCourse())
                .educatorFirstName(newfname)
                .educatorLastName(newlname)
                .age(newage)
                .build();
        Educator updated = this.repository.save(educator);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newfname, updated.getEducatorFirstName());

    }

    @Test
    public void getAll() {
        List<Educator> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }

}
