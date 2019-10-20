package ac.za.repository.impl.schoolSubjectsRepositoryTest;

import ac.za.domain.schoolSubjects.Registration;
import ac.za.factory.schoolSubjectsFactory.RegistrationFactory;
import ac.za.repository.repoInterface.schoolSubjects.RegistrationRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.RegistrationRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegistrationRepositoryImplTest {

    private RegistrationRepository repository;
    private Registration registration;

    private Registration getSavedCourse() {
        Set<Registration> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = RegistrationRepositoryImpl.getRepository();
        this.registration = RegistrationFactory.getRegistration("DIPICT3","123456");
    }

    @Test
    public void a_create() {
        Registration created = this.repository.create(this.registration);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.registration);
    }

    @Test
    public void b_read() {
        Registration savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getRegNum());
        Registration read = this.repository.read(savedCourse.getRegNum());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Registration savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getRegNum());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "777777";
        Registration updated = new Registration.Builder().copy(getSavedCourse()).regNum(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getRegNum());
        getAll();
    }

    @Test
    public void getAll() {
        Set<Registration> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }


}
