package ac.za.service.impl.schoolSubjectsServiceImpl;


import ac.za.domain.schoolSubjects.CivilEngineering;
import ac.za.repository.repoInterface.schoolSubjects.CivilEngineeringRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.CivilEngineeringRepositoryImpl;
import ac.za.service.serviceInterface.schoolSubjects.CivilEngineeringService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class CivilEngineeringServiceImpl implements CivilEngineeringService {

    private static CivilEngineeringServiceImpl service = null;
    private CivilEngineeringRepository repository;

    private CivilEngineeringServiceImpl(){
        this.repository = CivilEngineeringRepositoryImpl.getRepository();
    }

    public static CivilEngineeringService getService(){
        if (service == null) service = new CivilEngineeringServiceImpl();
        return service;
    }


    @Override
    public CivilEngineering create(CivilEngineering course) {
        return this.repository.create(course);
    }

    @Override
    public CivilEngineering update(CivilEngineering course) {
        return this.repository.update(course);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public CivilEngineering read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<CivilEngineering> getAllCivil() {
        Set<CivilEngineering> civilEngineerings = getAll();

        return null;
    }

    @Override
    public Set<CivilEngineering> getAll() {
        return this.repository.getAll();
    }
}
