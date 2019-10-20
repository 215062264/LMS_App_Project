package ac.za.service.impl.schoolSubjectsServiceTest;

import ac.za.domain.schoolSubjects.InformationTech;
import ac.za.factory.schoolSubjectsFactory.InformationTechFactory;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.InformationTechRepositoryImpl;
import ac.za.service.impl.schoolSubjectsServiceImpl.InformationTechServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InformationTechServiceImplTest {

    private InformationTechServiceImpl service;
    private InformationTech informationTech;

    private InformationTech getSaved(){
        Set<InformationTech> savedIT = this.service.getAll();
        return savedIT.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (InformationTechServiceImpl) InformationTechServiceImpl.getService();
        this.informationTech = InformationTechFactory.getInfoTech("ICT",100.0);
    }

    @Test
    public void a_create() {
        InformationTech created = this.service.create(this.informationTech);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.informationTech);
    }

    @Test
    public void c_update() {
        String newCourseName = "Information Tech ICT";
        InformationTech updated = new InformationTech.Builder().copy(getSaved()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
    }

    @Test
    public void e_delete() {
        InformationTech saved = getSaved();
        this.service.delete(saved.getSubjectCode());
        d_getAll();
    }

    @Test
    public void b_read() {
        InformationTech saved = getSaved();
        InformationTech read = this.service.read(saved.getSubjectCode());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<InformationTech> informationTeches = this.service.getAll();
        System.out.println("In getall, all = " + informationTeches);
    }
}
