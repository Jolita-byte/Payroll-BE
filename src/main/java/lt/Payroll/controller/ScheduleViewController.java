package lt.Payroll.controller;

import lt.Payroll.model.requestbody.ScheduleRequest;
import lt.Payroll.model.responsebody.EmployeeScheduledWorkDuration;
import lt.Payroll.service.Tier2.ScheduleViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/schedule/view")
public class ScheduleViewController {
    private ScheduleViewService scheduleViewService;

    public ScheduleViewController(ScheduleViewService scheduleViewService) {
        this.scheduleViewService = scheduleViewService;
    }

    @GetMapping(value = "/byDay")
    public List<EmployeeScheduledWorkDuration> getAllEmployeeScheduleDurationByDayPerPeriod(@RequestParam ("From Date")
                                                                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
                                                                                            @RequestParam ("To Date")
                                                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate toDate){
        return scheduleViewService.getAllEmployeeScheduleDurationByDayPerPeriod(fromDate, toDate);
    }
}
