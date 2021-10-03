package lt.Payroll.repository;

import lt.Payroll.model.ContractLine;
import lt.Payroll.model.EmployeeScheduleEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDate;

@Repository
public interface EmployeeScheduleEntryRepository extends JpaRepository<EmployeeScheduleEntry, Long> {

    @Query(nativeQuery = true, value = "SELECT duration FROM" +
            "(SELECT " +
            "employee_schedule_entry.contract_id AS contract_id, " +
            "employee_schedule_entry.activity_code_id AS activity_code_id, " +
            "cast(employee_schedule_entry.start_date_time as date) AS day_date, " +
            "sum((time_to_sec(timediff(employee_schedule_entry.end_date_time,employee_schedule_entry.start_date_time)) / 3600)) AS duration " +
            "FROM employee_schedule_entry " +
            "GROUP BY employee_schedule_entry.contract_id, day_date, employee_schedule_entry.activity_code_id " +
            "ORDER BY employee_schedule_entry.contract_id, day_date, employee_schedule_entry.activity_code_id) " +
            "WHERE contract_id = :id and day_date = :date")
    float getDurationOnDateByContractID(LocalDate date, Long id);
}
