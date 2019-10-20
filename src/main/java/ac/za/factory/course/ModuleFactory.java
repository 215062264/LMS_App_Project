package ac.za.factory.course;

import ac.za.domain.course.Module;

public class ModuleFactory {
    public static Module getModule(Integer moduleId,String moduleName, String description){
        return new Module.Builder()
                .moduleId(moduleId)
                .moduleName(moduleName)
                .description(description)
                .build();
    }
}
