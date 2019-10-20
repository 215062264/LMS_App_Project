package ac.za.service.impl.schoolSubjectsServiceTest;

import ac.za.domain.schoolSubjects.History;
import ac.za.factory.schoolSubjectsFactory.HistoryFactory;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.HistoryRepositoryImpl;
import ac.za.service.impl.schoolSubjectsServiceImpl.HistoryServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HistoryServiceImplTest {

    private HistoryServiceImpl service;
    private History history;

    private History getSaved(){
        Set<History> savedHistory = this.service.getAll();
        return savedHistory.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (HistoryServiceImpl) HistoryServiceImpl.getService();
        this.history = HistoryFactory.getHistory("HIST",88.5);
    }

    @Test
    public void a_create() {
        History created = this.service.create(this.history);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.history);
    }

    @Test
    public void c_update() {
        String newCourseName = "History HIST";
        History updated = new History.Builder().copy(getSaved()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
    }

    @Test
    public void e_delete() {
        History saved = getSaved();
        this.service.delete(saved.getSubjectCode());
        d_getAll();
    }

    @Test
    public void b_read() {
        History saved = getSaved();
        History read = this.service.read(saved.getSubjectCode());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<History> histories = this.service.getAll();
        System.out.println("In getall, all = " + histories);
    }
}
