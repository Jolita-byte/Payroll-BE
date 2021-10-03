package lt.Payroll.repository;

import lt.Payroll.model.EmployeeTimesheetEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface EmployeeTimesheetEntryRepository extends JpaRepository<EmployeeTimesheetEntry, Long> {

}
