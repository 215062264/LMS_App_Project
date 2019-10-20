package ac.za.service.impl.schoolSubjectsServiceTest;

import ac.za.domain.schoolSubjects.Accounting;
import ac.za.factory.schoolSubjectsFactory.AccountingFactory;
import ac.za.service.impl.schoolSubjectsServiceImpl.AccountingServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountingServiceImplTest {

    private AccountingServiceImpl service;
    private Accounting accounting;

    private Accounting getSaved(){
        Set<Accounting> savedAccounts = this.service.getAll();
        return savedAccounts.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (AccountingServiceImpl) AccountingServiceImpl.getService();
        this.accounting = AccountingFactory.getAccounting("ACT",70);
    }

    @Test
    public void a_create() {
        Accounting created = this.service.create(this.accounting);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.accounting);
    }

    @Test
    public void c_update() {
        String newCourseName = "Accounting ACT";
        Accounting updated = new Accounting.Builder().copy(getSaved()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
    }

    @Test
    public void e_delete() {
        Accounting saved = getSaved();
        this.service.delete(saved.getSubjectCode());
        d_getAll();
    }

    @Test
    public void b_read() {
        Accounting saved = getSaved();
        Accounting read = this.service.read(saved.getSubjectCode());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Accounting> accountings = this.service.getAll();
        System.out.println("In getall, all = " + accountings);
    }
}
