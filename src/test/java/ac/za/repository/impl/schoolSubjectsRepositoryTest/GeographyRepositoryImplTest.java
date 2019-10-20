package ac.za.repository.impl.schoolSubjectsRepositoryTest;

import ac.za.domain.schoolSubjects.Geography;
import ac.za.factory.schoolSubjectsFactory.GeographyFactory;
import ac.za.repository.repoInterface.schoolSubjects.GeographyRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.GeographyRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GeographyRepositoryImplTest {

    private GeographyRepository repository;
    private Geography geography;

    private Geography getSavedCourse() {
        Set<Geography> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = GeographyRepositoryImpl.getRepository();
        this.geography = GeographyFactory.getGeography("GEO",88.5);
    }

    @Test
    public void a_create() {
        Geography created = this.repository.create(this.geography);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.geography);
    }

    @Test
    public void b_read() {
        Geography savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getSubjectCode());
        Geography read = this.repository.read(savedCourse.getSubjectCode());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Geography savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getSubjectCode());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "Geography GEO";
        Geography updated = new Geography.Builder().copy(getSavedCourse()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
        getAll();
    }

    @Test
    public void getAll() {
        Set<Geography> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }

}
