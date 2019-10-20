package ac.za.service.impl.peopleServiceTest;

import ac.za.domain.people.Tutorial;
import ac.za.repository.repoInterface.people.TutorialRepository;
import ac.za.service.impl.peopleServiceImpl.TutorialServiceImpl;
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
public class TutorialServiceImplTest {

    private TutorialServiceImpl service;
    private Tutorial tutorial;
    @Mock
    TutorialRepository repository;

    @Before
    public void setUp() throws Exception {
        service = new TutorialServiceImpl(repository);
        tutorial = new Tutorial(7,"Kyle","Josias");
        Mockito.when(repository.findById(7)).thenReturn(Optional.of(tutorial));
    }

    @Test
    public void a_create() {
        Mockito.when(repository.save(tutorial)).thenReturn(tutorial);
        Tutorial student = service.create(this.tutorial);
        System.out.println(student);
    }

    @Test
    public void c_update() {
        String newFirstName = "John";
        String newlname = "Doe";
        Tutorial updated = new Tutorial.Builder()
                .copy(service.findById(7))
                .tutorFirstName(newFirstName)
                .tutorLastName(newlname)
                .build();
        Mockito.when(repository.save(updated)).thenReturn(updated);
        Tutorial tutorial = this.service.update(updated);
        Assert.assertEquals(newFirstName, tutorial.getTutorFirstName());
    }

    @Test
    public void e_delete() {
        Tutorial saved = service.findById(7);
        this.service.delete(saved.getTutorId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Tutorial saved = service.findById(7);
        Tutorial read = this.service.read(saved.getTutorId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        List<Tutorial> tutorials = this.service.getAll();
        System.out.println("In getall, all = " + tutorials);
    }
}
