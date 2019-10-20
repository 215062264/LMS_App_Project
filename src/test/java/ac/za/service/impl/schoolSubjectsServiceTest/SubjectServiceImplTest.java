package ac.za.service.impl.schoolSubjectsServiceTest;

import ac.za.domain.schoolSubjects.Subject;
import ac.za.factory.schoolSubjectsFactory.SubjectFactory;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.SubjectRepositoryImpl;
import ac.za.service.impl.schoolSubjectsServiceImpl.SubjectServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubjectServiceImplTest {

    private SubjectServiceImpl service;
    private Subject subject;

    private Subject getSaved()
    {   Set<Subject> savedSubjects = this.service.getAll();
        return savedSubjects.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (SubjectServiceImpl) SubjectServiceImpl.getService();
        this.subject = SubjectFactory.getSubjectID("ADP3");
    }

    @Test
    public void a_create() {
        Subject created = this.service.create(this.subject);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.subject);
    }

    @Test
    public void c_update() {
        String newCourseName = "Applications Development 3";
        Subject updated = new Subject.Builder().copy(getSaved()).subjectName(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectName());
    }

    @Test
    public void e_delete() {
        Subject saved = getSaved();
        this.service.delete(saved.getSubjectId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Subject saved = getSaved();
        Subject read = this.service.read(saved.getSubjectId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Subject> registrations = this.service.getAll();
        System.out.println("In getall, all = " + registrations);
    }
}
