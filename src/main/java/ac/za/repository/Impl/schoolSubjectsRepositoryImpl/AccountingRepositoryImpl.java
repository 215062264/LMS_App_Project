package ac.za.repository.Impl.schoolSubjectsRepositoryImpl;

import ac.za.domain.schoolSubjects.Accounting;
import ac.za.repository.repoInterface.schoolSubjects.AccountingRepository;
import java.util.HashSet;
import java.util.Set;

public class AccountingRepositoryImpl implements AccountingRepository {

    private static AccountingRepositoryImpl repository = null;
    private Set<Accounting> accountings;

    private AccountingRepositoryImpl() {
        this.accountings = new HashSet<>();
    }

    private Accounting findAccounting(String subjectCode) {
        return this.accountings.stream()
                .filter(accountings -> accountings.getSubjectCode().trim().equals(subjectCode))
                .findAny()
                .orElse(null);
    }

    public static AccountingRepository getRepository(){
        if(repository == null) repository = new AccountingRepositoryImpl();
        return repository;
    }

    public Accounting create(Accounting accountings){
        this.accountings.add(accountings);
        return accountings;
    }

    public Accounting read(String subjectCode){
        Accounting accountings = findAccounting(subjectCode);
        return accountings;
    }

    public Accounting update(Accounting accountings) {
        Accounting toDelete = findAccounting(accountings.getSubjectCode());
        if(toDelete != null) {
            this.accountings.remove(toDelete);
            return create(accountings);
        }
        return null;
    }

    public void delete(String subjectCode) {
        Accounting accountings = findAccounting(subjectCode);
        if (accountings != null) this.accountings.remove(accountings);

    }

    public Set<Accounting> getAll(){
        return this.accountings;
    }


}
