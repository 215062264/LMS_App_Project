package ac.za.repository.Impl.schoolSubjectsRepositoryImpl;

import ac.za.domain.schoolSubjects.InformationTech;
import ac.za.repository.repoInterface.schoolSubjects.InformationTechRepository;
import java.util.HashSet;
import java.util.Set;

public class InformationTechRepositoryImpl implements InformationTechRepository {

    private static InformationTechRepositoryImpl repository = null;
    private Set<InformationTech> informationTeches;

    private InformationTechRepositoryImpl() {
        this.informationTeches = new HashSet<>();
    }

    private InformationTech findHis(String subjectCode) {
        return this.informationTeches.stream()
                .filter(informationTech -> informationTech.getSubjectCode().trim().equals(subjectCode))
                .findAny()
                .orElse(null);
    }

    public static InformationTechRepositoryImpl getRepository(){
        if(repository == null) repository = new InformationTechRepositoryImpl();
        return repository;
    }

    public InformationTech create(InformationTech informationTeches){
        this.informationTeches.add(informationTeches);
        return informationTeches;
    }

    public InformationTech read(String subjectCode){
        InformationTech history = findHis(subjectCode);
        return history;
    }

    public InformationTech update(InformationTech informationTech) {
        InformationTech toDelete = findHis(informationTech.getSubjectCode());
        if(toDelete != null) {
            this.informationTeches.remove(toDelete);
            return create(informationTech);
        }
        return null;
    }

    public void delete(String subjectCode) {
        InformationTech informationTech = findHis(subjectCode);
        if (informationTeches != null) this.informationTeches.remove(informationTech);
    }

    public Set<InformationTech> getAll(){
        return this.informationTeches;
    }


}
