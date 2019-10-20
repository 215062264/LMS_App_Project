package ac.za.service.impl.schoolSubjectsServiceTest;

import ac.za.domain.schoolSubjects.Registration;
import ac.za.factory.schoolSubjectsFactory.RegistrationFactory;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.RegistrationRepositoryImpl;
import ac.za.service.impl.schoolSubjectsServiceImpl.RegistrationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegistrationServiceImplTest {

    private RegistrationServiceImpl service;
    private Registration registration;

    private Registration getSaved(){
        Set<Registration> savedReg = this.service.getAll();
        return savedReg.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (RegistrationServiceImpl) RegistrationServiceImpl.getService();
        this.registration = RegistrationFactory.getRegistration("DIPICT3","123456");
    }

    @Test
    public void a_create() {
        Registration created = this.service.create(this.registration);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.registration);
    }

    @Test
    public void c_update() {
        String newCourseName = "777777";
        Registration updated = new Registration.Builder().copy(getSaved()).regNum(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newCourseName, updated.getRegNum());
    }

    @Test
    public void e_delete() {
        Registration saved = getSaved();
        this.service.delete(saved.getRegNum());
        d_getAll();
    }

    @Test
    public void b_read() {
        Registration saved = getSaved();
        Registration read = this.service.read(saved.getRegNum());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Registration> registrations = this.service.getAll();
        System.out.println("In getall, all = " + registrations);
    }
}
