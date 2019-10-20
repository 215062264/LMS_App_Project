package ac.za.service.impl.academicResultsServiceTest;

import ac.za.domain.academicResults.Exam;
import ac.za.repository.repoInterface.academicResults.ExamRepository;
import ac.za.service.impl.academicResultsServiceImpl.ExamServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExamServiceImplTest {

    private ExamServiceImpl service;
    private Exam exam;
    @Mock
    private ExamRepository repository;

    @Before
    public void setUp() throws Exception {
        service = new ExamServiceImpl(repository);
        exam = new Exam(1,"215062264",100.0);
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(exam));
    }

    @Test
    public void a_create() {
        Mockito.when(repository.save(exam)).thenReturn(exam);
        Exam created = this.service.create(this.exam);
        System.out.println("In read, created=" + created);
        Assert.assertEquals(created, this.exam);
    }

    @Test
    public void b_read() {
        Exam saved = service.findById(1);
        System.out.println("In read, examNum = "+ saved.getExamNum());
        Exam read = this.service.read(saved.getExamNum());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        Integer newExamNum = 1;
        String newStudentNum = "215062264";
        double newMark = 100.0;
        Exam updated = new Exam.Builder()
                .copy(service.findById(1))
                .examNum(newExamNum)
                .studentNum(newStudentNum)
                .mark(newMark)
                .build();
        Mockito.when(repository.save(updated)).thenReturn(updated);
        System.out.println("In update, updated = " + updated);
        Assert.assertEquals(newExamNum, updated.getExamNum());
    }

    @Test
    public void e_delete() {
        Exam saved = service.findById(1);
        this.service.delete(saved.getExamNum());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<Exam> exams = this.service.getAll();
        System.out.println("In getall, all = " + exams);
    }
}
