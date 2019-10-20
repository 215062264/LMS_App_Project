package ac.za.repository.impl.schoolSubjectsRepositoryTest;

import ac.za.domain.schoolSubjects.LifeOrientation;
import ac.za.factory.schoolSubjectsFactory.LifeOrientationFactory;
import ac.za.repository.repoInterface.schoolSubjects.LifeOrientationRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.LifeOrientationRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LifeOrientationRepositoryImplTest {

    private LifeOrientationRepository repository;
    private LifeOrientation lifeOrientation;

    private LifeOrientation getSavedCourse() {
        Set<LifeOrientation> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = LifeOrientationRepositoryImpl.getRepository();
        this.lifeOrientation = LifeOrientationFactory.getLifeOrientation("LO",100.0);
    }

    @Test
    public void a_create() {
        LifeOrientation created = this.repository.create(this.lifeOrientation);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.lifeOrientation);
    }

    @Test
    public void b_read() {
        LifeOrientation savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getSubjectCode());
        LifeOrientation read = this.repository.read(savedCourse.getSubjectCode());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        LifeOrientation savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getSubjectCode());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "Life Orientation LO";
        LifeOrientation updated = new LifeOrientation.Builder().copy(getSavedCourse()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
        getAll();
    }

    @Test
    public void getAll() {
        Set<LifeOrientation> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }

}
