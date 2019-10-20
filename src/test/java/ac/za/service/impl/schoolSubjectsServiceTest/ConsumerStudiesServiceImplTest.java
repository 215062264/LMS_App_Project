package ac.za.service.impl.schoolSubjectsServiceTest;

import ac.za.domain.schoolSubjects.ConsumerStudies;
import ac.za.factory.schoolSubjectsFactory.ConsumerStudiesFactory;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.ConsumerStudiesRepositoryImpl;
import ac.za.service.impl.schoolSubjectsServiceImpl.ConsumerStudiesServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConsumerStudiesServiceImplTest {

    private ConsumerStudiesServiceImpl service;
    private ConsumerStudies consumerStudies;

    private ConsumerStudies getSaved(){
        Set<ConsumerStudies> savedCS = this.service.getAll();
        return savedCS.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (ConsumerStudiesServiceImpl) ConsumerStudiesServiceImpl.getService();
        this.consumerStudies = ConsumerStudiesFactory.getConsumerStudies("CON",75.5);
    }

    @Test
    public void a_create() {
        ConsumerStudies created = this.service.create(this.consumerStudies);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.consumerStudies);
    }

    @Test
    public void c_update() {
        String newCourseName = "Consumer Studies CON";
        ConsumerStudies updated = new ConsumerStudies.Builder().copy(getSaved()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
    }

    @Test
    public void e_delete() {
        ConsumerStudies saved = getSaved();
        this.service.delete(saved.getSubjectCode());
        d_getAll();
    }

    @Test
    public void b_read() {
        ConsumerStudies saved = getSaved();
        ConsumerStudies read = this.service.read(saved.getSubjectCode());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<ConsumerStudies> consumerStudies = this.service.getAll();
        System.out.println("In getall, all = " + consumerStudies);
    }

}
