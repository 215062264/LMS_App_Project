package ac.za.service.impl.courseServiceTest;

import ac.za.domain.course.Module;
import ac.za.repository.repoInterface.course.ModuleRepository;
import ac.za.service.impl.course.ModuleServiceImpl;
import ac.za.service.serviceInterface.course.ModuleService;
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
public class ModuleServiceImplTest {

    private ModuleService service;
    @Mock
    private ModuleRepository repository;
    private Module module;


    @Before
    public void setUp() throws Exception {
        service = new ModuleServiceImpl(repository);
        module = new Module(1,"ICT","Information Technology Course");
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(module));
    }

    @Test
    public void a_create() {
        Mockito.when(repository.save(module)).thenReturn(module);
        Module educator = service.create(this.module);
        System.out.println(educator);
    }

    @Test
    public void c_update() {
        String newName = "IT";
        String newdesc = "Info Tech";
        Integer newId = 1;
        Module newCourse = new Module.Builder()
                .copy(service.findById(1))
                .moduleName(newName)
                .description(newdesc)
                .build();
        Mockito.when(repository.save(newCourse)).thenReturn(newCourse);
        Module updated = this.service.update(newCourse);
        Assert.assertEquals(newName, updated.getModuleName());
    }

    @Test
    public void e_delete() {
        Module saved = service.findById(1);
        this.service.delete(saved.getModuleId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Module saved = service.findById(1);
        Module read = this.service.read(saved.getModuleId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        List<Module> courses = this.service.getAll();
        System.out.println("In getall, all = " + courses);
    }

}
