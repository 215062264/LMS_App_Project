package ac.za.repository.Impl.schoolSubjectsRepositoryImpl;

import ac.za.domain.schoolSubjects.BusinessStudies;
import ac.za.repository.repoInterface.schoolSubjects.BusinessStudiesRepository;
import java.util.HashSet;
import java.util.Set;

public class BusinessStudiesRepositoryImpl implements BusinessStudiesRepository {

    private static BusinessStudiesRepositoryImpl repository = null;
    private Set<BusinessStudies> businessStudies;

    private BusinessStudiesRepositoryImpl() {
        this.businessStudies = new HashSet<>();
    }

    private BusinessStudies findBusiness(String subjectCode) {
        return this.businessStudies.stream()
                .filter(businessStudies -> businessStudies.getSubjectCode().trim().equals(subjectCode))
                .findAny()
                .orElse(null);
    }


    public static BusinessStudiesRepository getRepository(){
        if(repository == null) repository = new BusinessStudiesRepositoryImpl();
        return repository;
    }

    public BusinessStudies create(BusinessStudies businessStudies){
        this.businessStudies.add(businessStudies);
        return businessStudies;
    }

    public BusinessStudies read(String subjectCode){
        BusinessStudies businessStudies = findBusiness(subjectCode);
        return businessStudies;
    }

    public BusinessStudies update(BusinessStudies businessStudies) {
        BusinessStudies toDelete = findBusiness(businessStudies.getSubjectCode());
        if(toDelete != null) {
            this.businessStudies.remove(toDelete);
            return create(businessStudies);
        }
        return null;
    }

    public void delete(String subjectCode) {
        BusinessStudies businessStudies = findBusiness(subjectCode);
        if (businessStudies != null) this.businessStudies.remove(businessStudies);
    }

    public Set<BusinessStudies> getAll(){
        return this.businessStudies;
    }


}
