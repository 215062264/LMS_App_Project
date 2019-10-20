package ac.za.repository.Impl.schoolSubjectsRepositoryImpl;

import ac.za.domain.schoolSubjects.History;
import ac.za.repository.repoInterface.schoolSubjects.HistoryRepository;
import java.util.HashSet;
import java.util.Set;

public class HistoryRepositoryImpl implements HistoryRepository {

    private static HistoryRepositoryImpl repository = null;
    private Set<History> histories;

    private HistoryRepositoryImpl() {
        this.histories = new HashSet<>();
    }

    private History findHis(String subjectCode) {
        return this.histories.stream()
                .filter(history -> history.getSubjectCode().trim().equals(subjectCode))
                .findAny()
                .orElse(null);
    }

    public static HistoryRepository getRepository(){
        if(repository == null) repository = new HistoryRepositoryImpl();
        return repository;
    }

    public History create(History histories){
        this.histories.add(histories);
        return histories;
    }

    public History read(String subjectCode){
        History history = findHis(subjectCode);
        return history;
    }

    public History update(History history) {
        History toDelete = findHis(history.getSubjectCode());
        if(toDelete != null) {
            this.histories.remove(toDelete);
            return create(history);
        }
        return null;
    }

    public void delete(String subjectCode) {
        History history = findHis(subjectCode);
        if (histories != null) this.histories.remove(history);
    }

    public Set<History> getAll(){
        return this.histories;
    }


}
