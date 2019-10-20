package ac.za.service.impl.schoolSubjectsServiceTest;

import ac.za.domain.schoolSubjects.BusinessStudies;
import ac.za.factory.schoolSubjectsFactory.BusinessStudiesFactory;
import ac.za.service.impl.schoolSubjectsServiceImpl.BusinessStudiesServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BusinessStudiesServiceImplTest {

    private BusinessStudiesServiceImpl service;
    private BusinessStudies businessStudies;

    private BusinessStudies getSaved(){
        Set<BusinessStudies> savedBS = this.service.getAll();
        return savedBS.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (BusinessStudiesServiceImpl) BusinessStudiesServiceImpl.getService();
        this.businessStudies = BusinessStudiesFactory.getBusinessStudies("BUS",85.5);
    }

    @Test
    public void a_create() {
        BusinessStudies created = this.service.create(this.businessStudies);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.businessStudies);
    }

    @Test
    public void c_update() {
        String newCourseName = "Business Studies BUS";
        BusinessStudies updated = new BusinessStudies.Builder().copy(getSaved()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
    }

    @Test
    public void e_delete() {
        BusinessStudies saved = getSaved();
        this.service.delete(saved.getSubjectCode());
        d_getAll();
    }

    @Test
    public void b_read() {
        BusinessStudies saved = getSaved();
        BusinessStudies read = this.service.read(saved.getSubjectCode());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<BusinessStudies> businessStudies = this.service.getAll();
        System.out.println("In getall, all = " + businessStudies);
    }

}
