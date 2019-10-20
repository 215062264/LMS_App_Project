package ac.za.service.impl.schoolSubjectsServiceImpl;

import ac.za.domain.schoolSubjects.BusinessStudies;
import ac.za.repository.repoInterface.schoolSubjects.BusinessStudiesRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.BusinessStudiesRepositoryImpl;
import ac.za.service.serviceInterface.schoolSubjects.BusinessStudiesService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class BusinessStudiesServiceImpl implements BusinessStudiesService {

    private static BusinessStudiesServiceImpl service = null;
    private BusinessStudiesRepository repository;

    private BusinessStudiesServiceImpl(){
        this.repository = BusinessStudiesRepositoryImpl.getRepository();
    }

    public static BusinessStudiesService getService(){
        if (service == null) service = new BusinessStudiesServiceImpl();
        return service;
    }


    @Override
    public BusinessStudies create(BusinessStudies course) {
        return this.repository.create(course);
    }

    @Override
    public BusinessStudies update(BusinessStudies course) {
        return this.repository.update(course);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public BusinessStudies read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<BusinessStudies> getAllBusiness() {
        Set<BusinessStudies> businessStudies = getAll();

        return null;
    }

    @Override
    public Set<BusinessStudies> getAll() {
        return this.repository.getAll();
    }
}
