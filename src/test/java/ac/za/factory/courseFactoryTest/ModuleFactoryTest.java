package ac.za.factory.courseFactoryTest;

import ac.za.domain.course.Module;
import ac.za.factory.course.ModuleFactory;
import org.junit.Assert;
import org.junit.Test;

public class ModuleFactoryTest {

    @Test
    public void getModule(){

        String desc = "Diploma in Information & Communication Technology";
        String name = "IT Course";
        Integer id = 1;

        Module course = ModuleFactory.getModule(id,name,desc);
        System.out.println(course);
        Assert.assertNotNull(course.getModuleId()+"\n"+course.getDescription());
    }

}
