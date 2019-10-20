package ac.za.service.impl.schoolSubjectsServiceTest;

import ac.za.domain.schoolSubjects.Science;
import ac.za.factory.schoolSubjectsFactory.ScienceFactory;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.ScienceRepositoryImpl;
import ac.za.service.impl.schoolSubjectsServiceImpl.ScienceServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScienceServiceImplTest {

    private ScienceServiceImpl service;
    private Science science;

    private Science getSaved(){
        Set<Science> savedScience = this.service.getAll();
        return savedScience.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (ScienceServiceImpl) ScienceServiceImpl.getService();
        this.science = ScienceFactory.getScience("SCI",92.6);
    }

    @Test
    public void a_create() {
        Science created = this.service.create(this.science);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.science);
    }

    @Test
    public void c_update() {
        String newCourseName = "Science SCI";
        Science updated = new Science.Builder().copy(getSaved()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
    }

    @Test
    public void e_delete() {
        Science saved = getSaved();
        this.service.delete(saved.getSubjectCode());
        d_getAll();
    }

    @Test
    public void b_read() {
        Science saved = getSaved();
        Science read = this.service.read(saved.getSubjectCode());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Science> sciences = this.service.getAll();
        System.out.println("In getall, all = " + sciences);
    }
}
