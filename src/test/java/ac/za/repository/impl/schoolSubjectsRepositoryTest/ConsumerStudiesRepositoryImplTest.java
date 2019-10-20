package ac.za.repository.impl.schoolSubjectsRepositoryTest;

import ac.za.domain.schoolSubjects.ConsumerStudies;
import ac.za.factory.schoolSubjectsFactory.ConsumerStudiesFactory;
import ac.za.repository.repoInterface.schoolSubjects.ConsumerStudiesRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.ConsumerStudiesRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConsumerStudiesRepositoryImplTest {

    private ConsumerStudiesRepository repository;
    private ConsumerStudies consumerStudies;

    private ConsumerStudies getSavedCourse() {
        Set<ConsumerStudies> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ConsumerStudiesRepositoryImpl.getRepository();
        this.consumerStudies = ConsumerStudiesFactory.getConsumerStudies("CON",95.5);
    }

    @Test
    public void a_create() {
        ConsumerStudies created = this.repository.create(this.consumerStudies);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.consumerStudies);
    }

    @Test
    public void b_read() {
        ConsumerStudies savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getSubjectCode());
        ConsumerStudies read = this.repository.read(savedCourse.getSubjectCode());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        ConsumerStudies savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getSubjectCode());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "Business Studies BUS";
        ConsumerStudies updated = new ConsumerStudies.Builder().copy(getSavedCourse()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
        getAll();
    }

    @Test
    public void getAll() {
        Set<ConsumerStudies> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }

}
