package ac.za.service.impl.academicResultsServiceTest;

import ac.za.domain.academicResults.Quiz;
import ac.za.repository.repoInterface.academicResults.QuizRepository;
import ac.za.service.impl.academicResultsServiceImpl.QuizServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import java.util.Optional;


@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QuizServiceImplTest {

    private QuizServiceImpl service;
    private Quiz quiz;
    @Mock
   public QuizRepository repository;

    @Before
    public void setUp() throws Exception {
        service = new QuizServiceImpl(repository);
        quiz = new Quiz(1,"1 June 2019",100.0);
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(quiz));
    }

    @Test
    public void a_create() {
        Mockito.when(repository.save(quiz)).thenReturn(quiz);
        Quiz created = this.service.create(this.quiz);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertEquals(created, this.quiz);
    }

    @Test
    public void b_read() {
        Quiz saved = service.findById(1);
        Quiz read = this.service.read(saved.getStudentNum());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newDueDate = "09 September 2019";
        Integer newStudNum = 1;
        double newMark = 100.0;
        Quiz updated = new Quiz.Builder()
                .copy(service.findById(1))
                .dueDate(newDueDate)
                .studentNum(newStudNum)
                .mark(newMark)
                .build();
        Mockito.when(repository.save(updated)).thenReturn(updated);
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertEquals(newDueDate, updated.getDueDate());
    }

    @Test
    public void e_delete() {
        Quiz saved = service.findById(1);
        this.service.delete(saved.getStudentNum());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<Quiz> quizzes = this.service.getAll();
        System.out.println("In getall, all = " + quizzes);
    }
}
