package lt.Payroll.service.Tier2;

import lt.Payroll.model.Contract;
import lt.Payroll.model.requestbody.ScheduleRequest;
import lt.Payroll.model.responsebody.EmployeeScheduledWorkDuration;
import lt.Payroll.service.Tier1.ContractService;
import lt.Payroll.service.Tier1.EmployeeScheduleEntryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleViewService {
    private ContractService contractService;
    private EmployeeScheduleEntryService employeeScheduleEntryService;

    public ScheduleViewService(ContractService contractService, EmployeeScheduleEntryService employeeScheduleEntryService) {
        this.contractService = contractService;
        this.employeeScheduleEntryService = employeeScheduleEntryService;
    }

    public List<EmployeeScheduledWorkDuration> getAllEmployeeScheduleDurationByDayPerPeriod(LocalDate fromDate, LocalDate toDate) {
        List<EmployeeScheduledWorkDuration> employeeScheduledWorkDurations = new ArrayList<>();
        List<Contract> contracts = contractService.getAllValidContractsPerPeriod(fromDate, toDate);
        for (Contract contract : contracts) {
            for (LocalDate date = fromDate; (date.isBefore(toDate) || date.isEqual(toDate)); date = date.plusDays(1)) {
                //float duration = employeeScheduleEntryService.getDurationOnDateByContractID(date, contract.getId());
                float duration = 0.0f;
                EmployeeScheduledWorkDuration employeeScheduledWorkDuration = new EmployeeScheduledWorkDuration();
                employeeScheduledWorkDuration.setContract(contract);
                employeeScheduledWorkDuration.setDate(date);
                employeeScheduledWorkDuration.setDuration(duration);
                employeeScheduledWorkDurations.add(employeeScheduledWorkDuration);
            }
        }
        return employeeScheduledWorkDurations;
    }

}
