package ac.za.service.impl.academicResultsServiceTest;

import ac.za.domain.academicResults.Results;
import ac.za.repository.repoInterface.academicResults.ResultRepository;
import ac.za.service.impl.academicResultsServiceImpl.ResultsServiceImpl;
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
public class ResultsServiceImplTest {

    private ResultsServiceImpl service;
    private Results results;
    @Mock
    private ResultRepository repository;

    @Before
    public void setUp() throws Exception {
        service = new ResultsServiceImpl(repository);
        results = new Results(1,100.0);
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(results));
    }

    @Test
    public void a_create() {
        Mockito.when(repository.save(results)).thenReturn(results);
        Results created = this.service.create(this.results);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertEquals(created, this.results);
    }

    @Test
    public void c_update() {
        Integer newStdNum = 2;
        double newMark = 100.0;
        Results updated = new Results.Builder()
                .copy(service.findById(1))
                .studentNum(newStdNum)
                .mark(newMark)
                .build();
        Mockito.when(repository.save(updated)).thenReturn(updated);
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newStdNum, updated.getStudentNum());
    }

    @Test
    public void e_delete() {
        Results saved = service.findById(1);
        this.service.delete(saved.getStudentNum());
        d_getAll();
    }

    @Test
    public void b_read() {
        Results saved = service.findById(1);
        Results read = this.service.read(saved.getStudentNum());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        List<Results> results = this.service.getAll();
        System.out.println("In getall, all = " + results);
    }
}
