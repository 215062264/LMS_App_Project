package ac.za.repository.impl.schoolSubjectsRepositoryTest;

import ac.za.domain.schoolSubjects.BusinessStudies;
import ac.za.factory.schoolSubjectsFactory.BusinessStudiesFactory;
import ac.za.repository.repoInterface.schoolSubjects.BusinessStudiesRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.BusinessStudiesRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BusinessStudiesRepositoryImplTest {

    private BusinessStudiesRepository repository;
    private BusinessStudies businessStudies;

    private BusinessStudies getSavedCourse() {
        Set<BusinessStudies> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = BusinessStudiesRepositoryImpl.getRepository();
        this.businessStudies = BusinessStudiesFactory.getBusinessStudies("BUS",85.5);
    }

    @Test
    public void a_create() {
        BusinessStudies created = this.repository.create(this.businessStudies);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.businessStudies);
    }

    @Test
    public void b_read() {
        BusinessStudies savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getSubjectCode());
        BusinessStudies read = this.repository.read(savedCourse.getSubjectCode());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        BusinessStudies savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getSubjectCode());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "Business Studies BUS";
        BusinessStudies updated = new BusinessStudies.Builder().copy(getSavedCourse()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
        getAll();
    }

    @Test
    public void getAll() {
        Set<BusinessStudies> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }

}
