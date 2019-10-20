package ac.za.service.impl.schoolSubjectsServiceTest;

import ac.za.domain.schoolSubjects.LifeOrientation;
import ac.za.factory.schoolSubjectsFactory.LifeOrientationFactory;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.LifeOrientationRepositoryImpl;
import ac.za.service.impl.schoolSubjectsServiceImpl.LifeOrientationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LifeOrientationServiceImplTest {

    private LifeOrientationServiceImpl service;
    private LifeOrientation lifeOrientation;

    private LifeOrientation getSaved(){
        Set<LifeOrientation> savedLO = this.service.getAll();
        return savedLO.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (LifeOrientationServiceImpl) LifeOrientationServiceImpl.getService();
        this.lifeOrientation = LifeOrientationFactory.getLifeOrientation("LO",100.0);
    }

    @Test
    public void a_create() {
        LifeOrientation created = this.service.create(this.lifeOrientation);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.lifeOrientation);
    }

    @Test
    public void c_update() {
        String newCourseName = "Life Orientation LO";
        LifeOrientation updated = new LifeOrientation.Builder().copy(getSaved()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
    }

    @Test
    public void e_delete() {
        LifeOrientation saved = getSaved();
        this.service.delete(saved.getSubjectCode());
        d_getAll();
    }

    @Test
    public void b_read() {
        LifeOrientation saved = getSaved();
        LifeOrientation read = this.service.read(saved.getSubjectCode());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<LifeOrientation> lifeOrientations = this.service.getAll();
        System.out.println("In getall, all = " + lifeOrientations);
    }
}
