package ac.za.repository.impl.schoolSubjectsRepositoryTest;

import ac.za.domain.schoolSubjects.CivilEngineering;
import ac.za.factory.schoolSubjectsFactory.CivilEngineeringFactory;
import ac.za.repository.repoInterface.schoolSubjects.CivilEngineeringRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.CivilEngineeringRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CivilEngineeringRepositoryImplTest {

    private CivilEngineeringRepository repository;
    private CivilEngineering civilEngineering;

    private CivilEngineering getSavedCourse() {
        Set<CivilEngineering> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = CivilEngineeringRepositoryImpl.getRepository();
        this.civilEngineering = CivilEngineeringFactory.getCivilEngineering("CIV",85.5);
    }

    @Test
    public void a_create() {
        CivilEngineering created = this.repository.create(this.civilEngineering);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.civilEngineering);
    }

    @Test
    public void b_read() {
        CivilEngineering savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getSubjectCode());
        CivilEngineering read = this.repository.read(savedCourse.getSubjectCode());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        CivilEngineering savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getSubjectCode());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "Business Studies BUS";
        CivilEngineering updated = new CivilEngineering.Builder().copy(getSavedCourse()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
        getAll();
    }

    @Test
    public void getAll() {
        Set<CivilEngineering> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }

}
