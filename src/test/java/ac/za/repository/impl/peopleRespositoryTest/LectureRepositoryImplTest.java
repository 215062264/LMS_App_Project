package ac.za.repository.impl.peopleRespositoryTest;

import ac.za.LearnerManagementSystem;
import ac.za.domain.people.Lecture;
import ac.za.repository.repoInterface.people.LectureRepository;
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
public class LectureRepositoryImplTest {

    @Autowired
    private LectureRepository repository;
    private Lecture lecture;

    private Lecture getSavedCourse() {
        List<Lecture> savedCourses = this.repository.findAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        lecture =repository.save(new Lecture("Moriarty",5));
    }

    @Test
    public void a_create() {
        Lecture created = this.repository.save(this.lecture);
        System.out.println("In create, created = " + created);
        Assert.assertSame(created, this.lecture);
    }

    @Test
    public void b_read() {
        Lecture savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getLecturerId());
        Lecture read = this.repository.findById(savedCourse.getLecturerId()).orElse(null);
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Lecture savedCourse = getSavedCourse();
        this.repository.deleteById(savedCourse.getLecturerId());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "John";
        int newage = 2;
        Lecture updated = new Lecture.Builder().copy(getSavedCourse()).professor(newCourseName)
                .hours(newage)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.save(updated);
        Assert.assertSame(newCourseName, updated.getProfessor());
    }

    @Test
    public void getAll() {
        List<Lecture> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }
}
