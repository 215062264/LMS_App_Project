package ac.za.service.impl.schoolSubjectsServiceImpl;

import ac.za.domain.schoolSubjects.TechnicalDrawings;
import ac.za.repository.repoInterface.schoolSubjects.TechnicalDrawingsRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.TechnicalDrawingsRepositoryImpl;
import ac.za.service.serviceInterface.schoolSubjects.TechnicalDrawingsService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class TechnicalDrawingsServiceImpl implements TechnicalDrawingsService {

    private static TechnicalDrawingsServiceImpl service = null;
    private TechnicalDrawingsRepository repository;

    private TechnicalDrawingsServiceImpl(){
        this.repository = TechnicalDrawingsRepositoryImpl.getRepository();
    }

    public static TechnicalDrawingsService getService(){
        if (service == null) service = new TechnicalDrawingsServiceImpl();
        return service;
    }


    @Override
    public TechnicalDrawings create(TechnicalDrawings course) {
        return this.repository.create(course);
    }

    @Override
    public TechnicalDrawings update(TechnicalDrawings course) { return this.repository.update(course); }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public TechnicalDrawings read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<TechnicalDrawings> getAllP() {
        Set<TechnicalDrawings> technicalDrawings = getAll();

        return null;
    }

    @Override
    public Set<TechnicalDrawings> getAll() {
        return this.repository.getAll();
    }
}
