package ac.za.repository.Impl.schoolSubjectsRepositoryImpl;

import ac.za.domain.schoolSubjects.TechnicalDrawings;
import ac.za.repository.repoInterface.schoolSubjects.TechnicalDrawingsRepository;
import java.util.HashSet;
import java.util.Set;

public class TechnicalDrawingsRepositoryImpl implements TechnicalDrawingsRepository {

    private static TechnicalDrawingsRepositoryImpl repository = null;
    private Set<TechnicalDrawings> technicalDrawings;

    private TechnicalDrawingsRepositoryImpl() {
        this.technicalDrawings = new HashSet<>();
    }

    private TechnicalDrawings findP(String subjectCode) {
        return this.technicalDrawings.stream()
                .filter(technicalDrawings -> technicalDrawings.getSubjectCode().trim().equals(subjectCode))
                .findAny()
                .orElse(null);
    }

    public static TechnicalDrawingsRepository getRepository(){
        if(repository == null) repository = new TechnicalDrawingsRepositoryImpl();
        return repository;
    }

    public TechnicalDrawings create(TechnicalDrawings technicalDrawings){
        this.technicalDrawings.add(technicalDrawings);
        return technicalDrawings;
    }

    public TechnicalDrawings read(String subjectCode){
        TechnicalDrawings technicalDrawings = findP(subjectCode);
        return technicalDrawings;
    }

    public TechnicalDrawings update(TechnicalDrawings technicalDrawings) {
        TechnicalDrawings toDelete = findP(technicalDrawings.getSubjectCode());
        if(toDelete != null) {
            this.technicalDrawings.remove(toDelete);
            return create(technicalDrawings);
        }
        return null;
    }

    public void delete(String subjectCode) {
        TechnicalDrawings technicalDrawings = findP(subjectCode);
        if (technicalDrawings != null) this.technicalDrawings.remove(technicalDrawings);
    }

    public Set<TechnicalDrawings> getAll(){
        return this.technicalDrawings;
    }


}
