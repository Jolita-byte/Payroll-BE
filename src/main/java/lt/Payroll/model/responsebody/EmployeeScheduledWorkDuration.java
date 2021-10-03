package lt.Payroll.model.responsebody;

import lombok.Data;
import lt.Payroll.model.Contract;

import java.time.LocalDate;

@Data
public class EmployeeScheduledWorkDuration {
    private Contract contract;
    private LocalDate date;
    private float duration;
}
