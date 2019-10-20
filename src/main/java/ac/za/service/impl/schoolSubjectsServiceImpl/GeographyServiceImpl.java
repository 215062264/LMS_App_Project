package ac.za.service.impl.schoolSubjectsServiceImpl;

import ac.za.domain.schoolSubjects.Geography;
import ac.za.repository.repoInterface.schoolSubjects.GeographyRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.GeographyRepositoryImpl;
import ac.za.service.serviceInterface.schoolSubjects.GeographyService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class GeographyServiceImpl implements GeographyService {

    private static GeographyServiceImpl service = null;
    private GeographyRepository repository;

    private GeographyServiceImpl(){
        this.repository = GeographyRepositoryImpl.getRepository();
    }

    public static GeographyService getService(){
        if (service == null) service = new GeographyServiceImpl();
        return service;
    }


    @Override
    public Geography create(Geography course) {
        return this.repository.create(course);
    }

    @Override
    public Geography update(Geography course) { return this.repository.update(course); }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Geography read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Geography> getAllGeo() {
        Set<Geography> geographies = getAll();

        return null;
    }

    @Override
    public Set<Geography> getAll() {
        return this.repository.getAll();
    }
}
