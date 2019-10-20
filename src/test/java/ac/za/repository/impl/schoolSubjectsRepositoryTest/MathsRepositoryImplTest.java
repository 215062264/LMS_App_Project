package ac.za.repository.impl.schoolSubjectsRepositoryTest;

import ac.za.domain.schoolSubjects.Mathematics;
import ac.za.factory.schoolSubjectsFactory.MathematicsFactory;
import ac.za.repository.repoInterface.schoolSubjects.MathsRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.MathsRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MathsRepositoryImplTest {

    private MathsRepository repository;
    private Mathematics mathematics;

    private Mathematics getSavedCourse() {
        Set<Mathematics> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = MathsRepositoryImpl.getRepository();
        this.mathematics = MathematicsFactory.getMath("MAT",99.0);
    }

    @Test
    public void a_create() {
        Mathematics created = this.repository.create(this.mathematics);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.mathematics);
    }

    @Test
    public void b_read() {
        Mathematics savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getSubjectCode());
        Mathematics read = this.repository.read(savedCourse.getSubjectCode());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Mathematics savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getSubjectCode());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "Mathematics MAT";
        Mathematics updated = new Mathematics.Builder().copy(getSavedCourse()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
        getAll();
    }

    @Test
    public void getAll() {
        Set<Mathematics> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }

}
