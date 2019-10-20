package ac.za.service.impl.academicResultsServiceTest;

import ac.za.domain.academicResults.Assignments;
import ac.za.repository.repoInterface.academicResults.AssignmentsRepository;
import ac.za.service.impl.academicResultsServiceImpl.AssignmentsServiceImpl;
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
public class AssignmentsServiceImplTest {

    private AssignmentsServiceImpl service;
    private Assignments assignments;
    @Mock
    private AssignmentsRepository repository;

    @Before
    public void setUp() throws Exception {
        service =  new AssignmentsServiceImpl(repository);
        assignments = new Assignments(1,"1 June 2019","215062264",100.0);
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(assignments));
    }

    @Test
    public void a_create() {
        Mockito.when(repository.save(assignments)).thenReturn(assignments);
        Assignments created = this.service.create(this.assignments);
        System.out.println("In read, created=" + created);
        Assert.assertEquals(created, this.assignments);
    }

    @Test
    public void b_read() {
        Assignments savedAssignment = service.findById(1);
        System.out.println("In read, StudentNum = "+ savedAssignment.getAssId());
        Assignments read = this.service.read(savedAssignment.getAssId());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(savedAssignment, read);
    }

    @Test
    public void c_update() {
        String newDate = "09 September 2019";
        String newNum = "215062264";
        double newMark = 100.0;
        Assignments updated = new Assignments.Builder()
                .copy(service.findById(1))
                .dueDate(newDate)
                .studentNum(newNum)
                .mark(newMark)
                .build();
        Mockito.when(repository.save(updated)).thenReturn(updated);
        Assignments assignments = this.service.update(updated);
        System.out.println("In update, updated = " + updated);
        Assert.assertEquals(newDate, updated.getDueDate());
    }

    @Test
    public void e_delete() {
        Assignments saved = service.findById(1);
        this.service.delete(saved.getAssId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        List<Assignments> assignments = this.service.getAll();
        System.out.println("In getall, all = " + assignments);
    }
}
