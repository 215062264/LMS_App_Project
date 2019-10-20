package ac.za.service.impl.schoolSubjectsServiceImpl;

import ac.za.domain.schoolSubjects.InformationTech;
import ac.za.repository.repoInterface.schoolSubjects.InformationTechRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.InformationTechRepositoryImpl;
import ac.za.service.serviceInterface.schoolSubjects.InformationTechService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class InformationTechServiceImpl implements InformationTechService {

    private static InformationTechServiceImpl service = null;
    private InformationTechRepository repository;

    private InformationTechServiceImpl(){
        this.repository = InformationTechRepositoryImpl.getRepository();
    }

    public static InformationTechService getService(){
        if (service == null) service = new InformationTechServiceImpl();
        return service;
    }


    @Override
    public InformationTech create(InformationTech course) {
        return this.repository.create(course);
    }

    @Override
    public InformationTech update(InformationTech course) { return this.repository.update(course); }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public InformationTech read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<InformationTech> getAllIt() {
        Set<InformationTech> informationTechSet = getAll();

        return null;
    }

    @Override
    public Set<InformationTech> getAll() {
        return this.repository.getAll();
    }
}
