package ac.za.service.impl.schoolSubjectsServiceTest;

import ac.za.domain.schoolSubjects.CivilEngineering;
import ac.za.factory.schoolSubjectsFactory.CivilEngineeringFactory;
import ac.za.service.impl.schoolSubjectsServiceImpl.CivilEngineeringServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CivilEngineeringServiceImplTest {

    private CivilEngineeringServiceImpl service;
    private CivilEngineering civilEngineering;

    private CivilEngineering getSaved(){
        Set<CivilEngineering> savedCivilEng = this.service.getAll();
        return savedCivilEng.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (CivilEngineeringServiceImpl) CivilEngineeringServiceImpl.getService();
        this.civilEngineering = CivilEngineeringFactory.getCivilEngineering("CIV",85.5);
    }

    @Test
    public void a_create() {
        CivilEngineering created = this.service.create(this.civilEngineering);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.civilEngineering);
    }

    @Test
    public void c_update() {
        String newCourseName = "Civil Engineering CIV";
        CivilEngineering updated = new CivilEngineering.Builder().copy(getSaved()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
    }

    @Test
    public void e_delete() {
        CivilEngineering saved = getSaved();
        this.service.delete(saved.getSubjectCode());
        d_getAll();
    }

    @Test
    public void b_read() {
        CivilEngineering saved = getSaved();
        CivilEngineering read = this.service.read(saved.getSubjectCode());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<CivilEngineering> civilEngineerings = this.service.getAll();
        System.out.println("In getall, all = " + civilEngineerings);
    }

}
