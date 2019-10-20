package ac.za.service.impl.schoolSubjectsServiceTest;

import ac.za.domain.schoolSubjects.English;
import ac.za.factory.schoolSubjectsFactory.EnglishFactory;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.EnglishRepositoryImpl;
import ac.za.service.impl.schoolSubjectsServiceImpl.EnglishServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EnglishServiceImplTest {

    private EnglishServiceImpl service;
    private English english;

    private English getSaved(){
        Set<English> savedEng = this.service.getAll();
        return savedEng.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (EnglishServiceImpl) EnglishServiceImpl.getService();
        this.english = EnglishFactory.getEnglish("ENG",98.5);
    }

    @Test
    public void a_create() {
        English created = this.service.create(this.english);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.english);
    }

    @Test
    public void c_update() {
        String newCourseName = "English ENG";
        English updated = new English.Builder().copy(getSaved()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
    }

    @Test
    public void e_delete() {
        English saved = getSaved();
        this.service.delete(saved.getSubjectCode());
        d_getAll();
    }

    @Test
    public void b_read() {
        English saved = getSaved();
        English read = this.service.read(saved.getSubjectCode());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<English> english = this.service.getAll();
        System.out.println("In getall, all = " + english);
    }
}
