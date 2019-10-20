package ac.za.repository.impl.schoolSubjectsRepositoryTest;


import ac.za.domain.schoolSubjects.Physics;
import ac.za.factory.schoolSubjectsFactory.PhysicsFactory;
import ac.za.repository.repoInterface.schoolSubjects.PhysicsRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.PhysicsRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PhysicsRepositoryImplTest {

    private PhysicsRepository repository;
    private Physics physics;

    private Physics getSavedCourse() {
        Set<Physics> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = PhysicsRepositoryImpl.getRepository();
        this.physics = PhysicsFactory.getPhysics("PHY",86.5);
    }

    @Test
    public void a_create() {
        Physics created = this.repository.create(this.physics);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.physics);
    }

    @Test
    public void b_read() {
        Physics savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getSubjectCode());
        Physics read = this.repository.read(savedCourse.getSubjectCode());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Physics savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getSubjectCode());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "Physics PHY";
        Physics updated = new Physics.Builder().copy(getSavedCourse()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
        getAll();
    }

    @Test
    public void getAll() {
        Set<Physics> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }

}
