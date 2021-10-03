package lt.Payroll.service.Tier1;

import lt.Payroll.model.EmployeeScheduleEntry;
import lt.Payroll.model.requestbody.ScheduleRequest;
import lt.Payroll.model.responsebody.EmployeeScheduledWorkDuration;
import lt.Payroll.repository.EmployeeScheduleEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeScheduleEntryService {
    @Autowired
    private EmployeeScheduleEntryRepository employeeScheduleEntryRepository;

    public List<EmployeeScheduleEntry> getAllEmployeeScheduleEntries() {
        return employeeScheduleEntryRepository.findAll();
    }

    public float getDurationOnDateByContractID(LocalDate date, Long id){
        return employeeScheduleEntryRepository.getDurationOnDateByContractID(date, id);
    }

}
