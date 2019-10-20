package ac.za.service.impl.schoolSubjectsServiceTest;

import ac.za.domain.schoolSubjects.Physics;
import ac.za.factory.schoolSubjectsFactory.PhysicsFactory;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.PhysicsRepositoryImpl;
import ac.za.service.impl.schoolSubjectsServiceImpl.PhysicsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PhysicsServiceImplTest {

    private PhysicsServiceImpl service;
    private Physics physics;

    private Physics getSaved(){
        Set<Physics> savedPhysics = this.service.getAll();
        return savedPhysics.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (PhysicsServiceImpl) PhysicsServiceImpl.getService();
        this.physics = PhysicsFactory.getPhysics("PHY",87.5);
    }

    @Test
    public void a_create() {
        Physics created = this.service.create(this.physics);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.physics);
    }

    @Test
    public void c_update() {
        String newCourseName = "Physics PHY";
        Physics updated = new Physics.Builder().copy(getSaved()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
    }

    @Test
    public void e_delete() {
        Physics saved = getSaved();
        this.service.delete(saved.getSubjectCode());
        d_getAll();
    }

    @Test
    public void b_read() {
        Physics saved = getSaved();
        Physics read = this.service.read(saved.getSubjectCode());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Physics> physics = this.service.getAll();
        System.out.println("In getall, all = " + physics);
    }
}
