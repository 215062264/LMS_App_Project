package ac.za.service.impl.peopleServiceTest;

import ac.za.domain.people.Lecture;
import ac.za.repository.repoInterface.people.LectureRepository;
import ac.za.service.impl.peopleServiceImpl.LectureServiceImpl;
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
public class LectureServiceImplTest {

    private LectureServiceImpl service;
    private Lecture lecture;
    @Mock
    LectureRepository repository;

    @Before
    public void setUp() throws Exception {
        service = new LectureServiceImpl(repository);
        lecture = new Lecture(1,"Jack",2);
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(lecture));
    }

    @Test
    public void a_create() {
        Mockito.when(repository.save(lecture)).thenReturn(lecture);
        Lecture lecture = service.create(this.lecture);
        System.out.println(lecture);
    }

    @Test
    public void c_update() {
        String newProfessor = "Tony Stark";
        int newHours = 4;
        Lecture updated = new Lecture.Builder()
                .copy(service.findById(1))
                .professor(newProfessor)
                .hours(newHours)
                .build();
        Mockito.when(repository.save(updated)).thenReturn(updated);
        Lecture updateLecture = this.service.update(updated);
        Assert.assertEquals(newProfessor, updateLecture.getProfessor());
    }

    @Test
    public void e_delete() {
        Lecture saved = service.findById(1);
        this.service.delete(saved.getLecturerId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Lecture saved = service.findById(1);
        Lecture read = this.service.read(saved.getLecturerId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        List<Lecture> lectures = this.service.getAll();
        System.out.println("In getall, all = " + lectures);
    }
}
