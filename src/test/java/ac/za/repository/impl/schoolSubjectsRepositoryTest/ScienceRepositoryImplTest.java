package ac.za.repository.impl.schoolSubjectsRepositoryTest;

import ac.za.domain.schoolSubjects.Science;
import ac.za.factory.schoolSubjectsFactory.ScienceFactory;
import ac.za.repository.repoInterface.schoolSubjects.ScienceRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.ScienceRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScienceRepositoryImplTest {

    private ScienceRepository repository;
    private Science science;

    private Science getSavedCourse() {
        Set<Science> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ScienceRepositoryImpl.getRepository();
        this.science = ScienceFactory.getScience("SCI",92.5);
    }

    @Test
    public void a_create() {
        Science created = this.repository.create(this.science);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.science);
    }

    @Test
    public void b_read() {
        Science savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getSubjectCode());
        Science read = this.repository.read(savedCourse.getSubjectCode());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Science savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getSubjectCode());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "Science SCI";
        Science updated = new Science.Builder().copy(getSavedCourse()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
        getAll();
    }

    @Test
    public void getAll() {
        Set<Science> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }

}
