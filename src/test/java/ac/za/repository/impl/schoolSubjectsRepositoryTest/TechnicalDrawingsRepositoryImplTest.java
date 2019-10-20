package ac.za.repository.impl.schoolSubjectsRepositoryTest;

import ac.za.domain.schoolSubjects.TechnicalDrawings;
import ac.za.factory.schoolSubjectsFactory.TechnicalDrawingsFactory;
import ac.za.repository.repoInterface.schoolSubjects.TechnicalDrawingsRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.TechnicalDrawingsRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TechnicalDrawingsRepositoryImplTest {

    private TechnicalDrawingsRepository repository;
    private TechnicalDrawings technicalDrawings;

    private TechnicalDrawings getSavedCourse() {
        Set<TechnicalDrawings> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TechnicalDrawingsRepositoryImpl.getRepository();
        this.technicalDrawings = TechnicalDrawingsFactory.getTechnicalDrawings("TDR",89.7);
    }

    @Test
    public void a_create() {
        TechnicalDrawings created = this.repository.create(this.technicalDrawings);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.technicalDrawings);
    }

    @Test
    public void b_read() {
        TechnicalDrawings savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getSubjectCode());
        TechnicalDrawings read = this.repository.read(savedCourse.getSubjectCode());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        TechnicalDrawings savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getSubjectCode());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "Technical Drawings TDR";
        TechnicalDrawings updated = new TechnicalDrawings.Builder().copy(getSavedCourse()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
        getAll();
    }

    @Test
    public void getAll() {
        Set<TechnicalDrawings> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }

}
