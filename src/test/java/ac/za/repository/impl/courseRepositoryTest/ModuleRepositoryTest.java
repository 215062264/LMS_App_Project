package ac.za.repository.impl.courseRepositoryTest;

import ac.za.LearnerManagementSystem;
import ac.za.domain.course.Module;
import ac.za.repository.repoInterface.course.ModuleRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = LearnerManagementSystem.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModuleRepositoryTest {

    @Autowired
    private ModuleRepository repository;
    private Module module;

    private Module getSavedCourse() {
        List<Module> savedCourses = this.repository.findAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        module = repository.save(new Module(1,"Test Course","DIP ICT"));
    }

    @Test
    public void a_create() {
        Module created = this.repository.save(this.module);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.module);
    }

    @Test
    public void b_read() {
        Module savedCourse = getSavedCourse();
        System.out.println("In read, moduleId = "+ savedCourse.getModuleId());
        Module read = this.repository.findById(savedCourse.getModuleId()).orElse(null);
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Module savedCourse = getSavedCourse();
        this.repository.deleteById(savedCourse.getModuleId());
        getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Module Name";
        Module course = new Module.Builder().copy(getSavedCourse()).moduleName(newname).build();
        System.out.println("In update, about_to_updated = " + course);
        Module updated = this.repository.save(course);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getModuleName());
        getAll();
    }

    @Test
    public void getAll() {
        List<Module> all = this.repository.findAll();
        System.out.println("In getAll, all = " + all);

    }


}
