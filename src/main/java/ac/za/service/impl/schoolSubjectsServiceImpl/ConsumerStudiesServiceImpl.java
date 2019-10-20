package ac.za.service.impl.schoolSubjectsServiceImpl;

import ac.za.domain.schoolSubjects.ConsumerStudies;
import ac.za.repository.repoInterface.schoolSubjects.ConsumerStudiesRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.ConsumerStudiesRepositoryImpl;
import ac.za.service.serviceInterface.schoolSubjects.ConsumerStudiesService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class ConsumerStudiesServiceImpl implements ConsumerStudiesService {

    private static ConsumerStudiesServiceImpl service = null;
    private ConsumerStudiesRepository repository;

    private ConsumerStudiesServiceImpl(){
        this.repository = ConsumerStudiesRepositoryImpl.getRepository();
    }

    public static ConsumerStudiesService getService(){
        if (service == null) service = new ConsumerStudiesServiceImpl();
        return service;
    }


    @Override
    public ConsumerStudies create(ConsumerStudies course) {
        return this.repository.create(course);
    }

    @Override
    public ConsumerStudies update(ConsumerStudies course) {
        return this.repository.update(course);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public ConsumerStudies read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<ConsumerStudies> getAllCivil() {
        Set<ConsumerStudies> consumerStudies = getAll();

        return null;
    }

    @Override
    public Set<ConsumerStudies> getAll() {
        return this.repository.getAll();
    }
}
