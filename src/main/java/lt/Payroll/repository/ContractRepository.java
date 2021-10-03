package lt.Payroll.repository;

import lt.Payroll.model.Contract;
import lt.Payroll.model.ContractLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM contract as c ")
    List<Contract> findAllValidPerPeriod(LocalDate fromDate, LocalDate toDate);
    /*WHERE c.employment_date <= :fromDate and*/
}
