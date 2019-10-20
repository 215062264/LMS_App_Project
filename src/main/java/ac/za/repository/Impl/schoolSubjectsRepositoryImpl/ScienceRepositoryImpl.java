package ac.za.repository.Impl.schoolSubjectsRepositoryImpl;

import ac.za.domain.schoolSubjects.Science;
import ac.za.repository.repoInterface.schoolSubjects.ScienceRepository;
import java.util.HashSet;
import java.util.Set;

public class ScienceRepositoryImpl implements ScienceRepository {

    private static ScienceRepositoryImpl repository = null;
    private Set<Science> sciences;

    private ScienceRepositoryImpl() {
        this.sciences = new HashSet<>();
    }

    private Science findP(String subjectCode) {
        return this.sciences.stream()
                .filter(science -> science.getSubjectCode().trim().equals(subjectCode))
                .findAny()
                .orElse(null);
    }

    public static ScienceRepository getRepository(){
        if(repository == null) repository = new ScienceRepositoryImpl();
        return repository;
    }

    public Science create(Science sciences){
        this.sciences.add(sciences);
        return sciences;
    }

    public Science read(String subjectCode){
        Science science = findP(subjectCode);
        return science;
    }

    public Science update(Science science) {
        Science toDelete = findP(science.getSubjectCode());
        if(toDelete != null) {
            this.sciences.remove(toDelete);
            return create(science);
        }
        return null;
    }

    public void delete(String subjectCode) {
        Science science = findP(subjectCode);
        if (science != null) this.sciences.remove(science);
    }

    public Set<Science> getAll(){
        return this.sciences;
    }


}
