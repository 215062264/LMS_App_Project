package ac.za.service.impl.schoolSubjectsServiceTest;

import ac.za.domain.schoolSubjects.Economics;
import ac.za.factory.schoolSubjectsFactory.EconomicsFactory;
import ac.za.service.impl.schoolSubjectsServiceImpl.EconomicsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EconomicsServiceImplTest {

    private EconomicsServiceImpl service;
    private Economics economics;

    private Economics getSaved()
    {   Set<Economics> savedEco = this.service.getAll();
        return savedEco.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (EconomicsServiceImpl) EconomicsServiceImpl.getService();
        this.economics = EconomicsFactory.getEconomics("ECO",95.5);
    }

    @Test
    public void a_create() {
        Economics created = this.service.create(this.economics);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.economics);
    }

    @Test
    public void c_update() {
        String newCourseName = "Economics ECO";
        Economics updated = new Economics.Builder().copy(getSaved()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
    }

    @Test
    public void e_delete() {
        Economics saved = getSaved();
        this.service.delete(saved.getSubjectCode());
        d_getAll();
    }

    @Test
    public void b_read() {
        Economics saved = getSaved();
        Economics read = this.service.read(saved.getSubjectCode());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Economics> economics = this.service.getAll();
        System.out.println("In getall, all = " + economics);
    }

}
