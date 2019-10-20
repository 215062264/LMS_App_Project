package ac.za.repository.Impl.schoolSubjectsRepositoryImpl;

import ac.za.domain.schoolSubjects.LifeOrientation;
import ac.za.repository.repoInterface.schoolSubjects.LifeOrientationRepository;
import java.util.HashSet;
import java.util.Set;

public class LifeOrientationRepositoryImpl implements LifeOrientationRepository {

    private static LifeOrientationRepositoryImpl repository = null;
    private Set<LifeOrientation> lifeOrientations;

    private LifeOrientationRepositoryImpl() {
        this.lifeOrientations = new HashSet<>();
    }

    private LifeOrientation findLO(String subjectCode) {
        return this.lifeOrientations.stream()
                .filter(lifeOrientation -> lifeOrientation.getSubjectCode().trim().equals(subjectCode))
                .findAny()
                .orElse(null);
    }

    public static LifeOrientationRepository getRepository(){
        if(repository == null) repository = new LifeOrientationRepositoryImpl();
        return repository;
    }

    public LifeOrientation create(LifeOrientation lifeOrientations){
        this.lifeOrientations.add(lifeOrientations);
        return lifeOrientations;
    }

    public LifeOrientation read(String subjectCode){
        LifeOrientation history = findLO(subjectCode);
        return history;
    }

    public LifeOrientation update(LifeOrientation lifeOrientation) {
        LifeOrientation toDelete = findLO(lifeOrientation.getSubjectCode());
        if(toDelete != null) {
            this.lifeOrientations.remove(toDelete);
            return create(lifeOrientation);
        }
        return null;
    }

    public void delete(String subjectCode) {
        LifeOrientation lifeOrientation = findLO(subjectCode);
        if (lifeOrientations != null) this.lifeOrientations.remove(lifeOrientation);
    }

    public Set<LifeOrientation> getAll(){
        return this.lifeOrientations;
    }


}
