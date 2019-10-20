package ac.za.repository.Impl.schoolSubjectsRepositoryImpl;

import ac.za.domain.schoolSubjects.CivilEngineering;
import ac.za.repository.repoInterface.schoolSubjects.CivilEngineeringRepository;
import java.util.HashSet;
import java.util.Set;

public class CivilEngineeringRepositoryImpl implements CivilEngineeringRepository {

    private static CivilEngineeringRepositoryImpl repository = null;
    private Set<CivilEngineering> civilEngineerings;

    private CivilEngineeringRepositoryImpl() {
        this.civilEngineerings = new HashSet<>();
    }

    private CivilEngineering findCivil(String subjectCode) {
        return this.civilEngineerings.stream()
                .filter(civilEngineering -> civilEngineering.getSubjectCode().trim().equals(subjectCode))
                .findAny()
                .orElse(null);
    }

    public static CivilEngineeringRepository getRepository(){
        if(repository == null) repository = new CivilEngineeringRepositoryImpl();
        return repository;
    }

    public CivilEngineering create(CivilEngineering civilEngineerings){
        this.civilEngineerings.add(civilEngineerings);
        return civilEngineerings;
    }

    public CivilEngineering read(String subjectCode){
        CivilEngineering civilEngineerings = findCivil(subjectCode);
        return civilEngineerings;
    }

    public CivilEngineering update(CivilEngineering civilEngineering) {
        CivilEngineering toDelete = findCivil(civilEngineering.getSubjectCode());
        if(toDelete != null) {
            this.civilEngineerings.remove(toDelete);
            return create(civilEngineering);
        }
        return null;
    }

    public void delete(String subjectCode) {
        CivilEngineering civilEngineering = findCivil(subjectCode);
        if (civilEngineerings != null) this.civilEngineerings.remove(civilEngineering);
    }

    public Set<CivilEngineering> getAll(){
        return this.civilEngineerings;
    }


}
