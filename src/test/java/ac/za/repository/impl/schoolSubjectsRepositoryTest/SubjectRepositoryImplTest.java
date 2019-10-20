package ac.za.repository.impl.schoolSubjectsRepositoryTest;

import ac.za.domain.schoolSubjects.Subject;
import ac.za.factory.schoolSubjectsFactory.SubjectFactory;
import ac.za.repository.repoInterface.schoolSubjects.SubjectRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.SubjectRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubjectRepositoryImplTest {

    private SubjectRepository repository;
    private Subject subject;

    private Subject getSavedCourse() {
        Set<Subject> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SubjectRepositoryImpl.getRepository();
        this.subject = SubjectFactory.getSubjectID("LearnerManagementSystem Dev");
    }

    @Test
    public void a_create() {
        Subject created = this.repository.create(this.subject);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.subject);
    }

    @Test
    public void b_read() {
        Subject savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getSubjectId());
        Subject read = this.repository.read(savedCourse.getSubjectId());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Subject savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getSubjectId());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "Applications Development 3";
        Subject updated = new Subject.Builder().copy(getSavedCourse()).subjectName(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getSubjectName());
        getAll();
    }

    @Test
    public void getAll() {
        Set<Subject> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }

}
