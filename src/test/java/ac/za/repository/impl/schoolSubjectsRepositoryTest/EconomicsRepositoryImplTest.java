package ac.za.repository.impl.schoolSubjectsRepositoryTest;

import ac.za.domain.schoolSubjects.Economics;
import ac.za.factory.schoolSubjectsFactory.EconomicsFactory;
import ac.za.repository.repoInterface.schoolSubjects.EconomicsRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.EconomicsRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EconomicsRepositoryImplTest {

    private EconomicsRepository repository;
    private Economics economics;

    private Economics getSavedCourse() {
        Set<Economics> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = EconomicsRepositoryImpl.getRepository();
        this.economics = EconomicsFactory.getEconomics("ECO",97.5);
    }

    @Test
    public void a_create() {
        Economics created = this.repository.create(this.economics);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.economics);
    }

    @Test
    public void b_read() {
        Economics savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getSubjectCode());
        Economics read = this.repository.read(savedCourse.getSubjectCode());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Economics savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getSubjectCode());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "Economics ECO";
        Economics updated = new Economics.Builder().copy(getSavedCourse()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
        getAll();
    }

    @Test
    public void getAll() {
        Set<Economics> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
