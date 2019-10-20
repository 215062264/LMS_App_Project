package ac.za.service.impl.peopleServiceTest;

import ac.za.domain.people.Educator;
import ac.za.repository.repoInterface.people.EducatorRepository;
import ac.za.service.impl.peopleServiceImpl.EducatorServiceImpl;
import ac.za.service.serviceInterface.people.EducatorService;
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
public class EducatorServiceImplTest {


    private EducatorService service;
    @Mock
    private EducatorRepository repository;
    private Educator educator;


    @Before
    public void setUp() throws Exception {
        service = new EducatorServiceImpl(repository);
        educator = new Educator(1,"Professor","Moriarty",55);
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(educator));
    }

    @Test
    public void a_create() {
        Mockito.when(repository.save(educator)).thenReturn(educator);
        Educator educator = service.create(this.educator);
        System.out.println(educator);
    }

    @Test
    public void c_update() {
        String newFirstName = "John";
        String newlname = "Doe";
        int newage = 102;
        Educator newEducator = new Educator.Builder()
                .copy(service.findById(1))
                .educatorFirstName(newFirstName)
                .educatorLastName(newlname)
                .age(newage)
                .build();
        Mockito.when(repository.save(newEducator)).thenReturn(newEducator);
        Educator updated = this.service.update(newEducator);
        Assert.assertEquals(newFirstName, updated.getEducatorFirstName());
    }

    @Test
    public void e_delete() {
        Educator saved = service.findById(1);
        this.service.delete(saved.getEducatorId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Educator saved = service.findById(1);
        Educator read = this.service.read(saved.getEducatorId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        List<Educator> students = this.service.getAll();
        System.out.println("In getall, all = " + students);
    }
}