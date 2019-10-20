package ac.za.repository.impl.schoolSubjectsRepositoryTest;

import ac.za.domain.schoolSubjects.InformationTech;
import ac.za.factory.schoolSubjectsFactory.InformationTechFactory;
import ac.za.repository.repoInterface.schoolSubjects.InformationTechRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.InformationTechRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InformationTechRepositoryImplTest {

    private InformationTechRepository repository;
    private InformationTech informationTech;

    private InformationTech getSavedCourse() {
        Set<InformationTech> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = InformationTechRepositoryImpl.getRepository();
        this.informationTech = InformationTechFactory.getInfoTech("ICT",100.0);
    }

    @Test
    public void a_create() {
        InformationTech created = this.repository.create(this.informationTech);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.informationTech);
    }

    @Test
    public void b_read() {
        InformationTech savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getSubjectCode());
        InformationTech read = this.repository.read(savedCourse.getSubjectCode());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        InformationTech savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getSubjectCode());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "Information & Communication Technology ICT";
        InformationTech updated = new InformationTech.Builder().copy(getSavedCourse()).subjectCode(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectCode());
        getAll();
    }

    @Test
    public void getAll() {
        Set<InformationTech> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }

}
