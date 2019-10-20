package ac.za.repository.impl.schoolSubjectsRepositoryTest;

import ac.za.domain.schoolSubjects.English;
import ac.za.factory.schoolSubjectsFactory.EnglishFactory;
import ac.za.repository.repoInterface.schoolSubjects.EnglishRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.EnglishRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EnglishRepositoryImplTest {

    private EnglishRepository repository;
    private English english;

    private English getSavedCourse() {
        Set<English> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = EnglishRepositoryImpl.getRepository();
        this.english = EnglishFactory.getEnglish("ENG",98.5);
    }

    @Test
    public void a_create() {
        English created = this.repository.create(this.english);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.english);
    }

    @Test
    public void b_read() {
        English savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getSubjectCode());
        English read = this.repository.read(savedCourse.getSubjectCode());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        English savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getSubjectCode());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "English ENG";
        English updated = new English.Builder().copy(getSavedCourse()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
        getAll();
    }

    @Test
    public void getAll() {
        Set<English> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }

}
