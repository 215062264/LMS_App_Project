package ac.za.service.impl.schoolSubjectsServiceImpl;

import ac.za.domain.schoolSubjects.History;
import ac.za.repository.repoInterface.schoolSubjects.HistoryRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.HistoryRepositoryImpl;
import ac.za.service.serviceInterface.schoolSubjects.HistoryService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class HistoryServiceImpl implements HistoryService {

    private static HistoryServiceImpl service = null;
    private HistoryRepository repository;

    private HistoryServiceImpl(){
        this.repository = HistoryRepositoryImpl.getRepository();
    }

    public static HistoryService getService(){
        if (service == null) service = new HistoryServiceImpl();
        return service;
    }


    @Override
    public History create(History course) {
        return this.repository.create(course);
    }

    @Override
    public History update(History course) { return this.repository.update(course); }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public History read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<History> getAllHis() {
        Set<History> histories = getAll();

        return null;
    }

    @Override
    public Set<History> getAll() {
        return this.repository.getAll();
    }
}
