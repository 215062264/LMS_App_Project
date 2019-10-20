package ac.za.domain.course;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer moduleId;
    private String moduleName;
    private String description;

    public Module() {
    }

    public Module(String moduleName, String description) {
        this(null,moduleName,description);
    }

    public Module(Integer moduleId, String moduleName, String description) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.description = description;
    }

    private Module(Builder builder){
        this.moduleId = builder.moduleId;
        this.moduleName = builder.moduleName;
        this.description = builder.description;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getDescription() {
        return description;
    }


    public static class Builder{
        private Integer moduleId;
        private String moduleName;
        private String description;

        public Builder moduleId(Integer moduleId){
            this.moduleId = moduleId;
            return this;
        }

        public Builder moduleName(String moduleName){
            this.moduleName = moduleName;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder copy(Module module){
            this.moduleId = module.moduleId;
            this.moduleName = module.moduleName;
            this.description = module.description;
            return this;
        }

        public Module build(){return new Module(this);}

    }


    @Override
    public String toString() {
        return "Module{" +
                "moduleId=" + moduleId +
                ", moduleName='" + moduleName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
