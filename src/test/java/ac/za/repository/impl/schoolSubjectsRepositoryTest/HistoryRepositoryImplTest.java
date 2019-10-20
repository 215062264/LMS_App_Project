package ac.za.repository.impl.schoolSubjectsRepositoryTest;

import ac.za.domain.schoolSubjects.History;
import ac.za.factory.schoolSubjectsFactory.HistoryFactory;
import ac.za.repository.repoInterface.schoolSubjects.HistoryRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.HistoryRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HistoryRepositoryImplTest {

    private HistoryRepository repository;
    private History history;

    private History getSavedCourse() {
        Set<History> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = HistoryRepositoryImpl.getRepository();
        this.history = HistoryFactory.getHistory("HIST",89.5);
    }

    @Test
    public void a_create() {
        History created = this.repository.create(this.history);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.history);
    }

    @Test
    public void b_read() {
        History savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getSubjectCode());
        History read = this.repository.read(savedCourse.getSubjectCode());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        History savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getSubjectCode());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "History HIST";
        History updated = new History.Builder().copy(getSavedCourse()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
        getAll();
    }

    @Test
    public void getAll() {
        Set<History> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }

}
