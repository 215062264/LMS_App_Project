package ac.za.repository.impl.schoolSubjectsRepositoryTest;

import ac.za.domain.schoolSubjects.Accounting;
import ac.za.factory.schoolSubjectsFactory.AccountingFactory;
import ac.za.repository.repoInterface.schoolSubjects.AccountingRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.AccountingRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountingRepositoryImplTest {

    private AccountingRepository repository;
    private Accounting accounting;

    private Accounting getSavedCourse() {
        Set<Accounting> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AccountingRepositoryImpl.getRepository();
        this.accounting = AccountingFactory.getAccounting("ACT",70.5);
    }

    @Test
    public void a_create() {
        Accounting created = this.repository.create(this.accounting);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.accounting);
    }

    @Test
    public void b_read() {
        Accounting savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getSubjectCode());
        Accounting read = this.repository.read(savedCourse.getSubjectCode());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Accounting savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getSubjectCode());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "Accounting ACT";
        Accounting updated = new Accounting.Builder().copy(getSavedCourse()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
        getAll();
    }

    @Test
    public void getAll() {
        Set<Accounting> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }

}
