package com.task.loanscheduler.web;

import com.task.loanscheduler.domain.Loan;
import com.task.loanscheduler.domain.LoanType;
import com.task.loanscheduler.domain.Schedule;
import com.task.loanscheduler.repository.LoanSearchCond;
import com.task.loanscheduler.repository.LoanUpdateDto;
import com.task.loanscheduler.repository.ScheduleUpdateDto;
import com.task.loanscheduler.service.CalculateService;
import com.task.loanscheduler.service.LoanService;
import com.task.loanscheduler.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoanScheduleController {

    private final LoanService loanService;
    private final ScheduleService scheduleService;
    private final CalculateService calculateService;

    @RequestMapping(value="/loans", method=RequestMethod.GET)
    public String loans(@ModelAttribute("loanSearch") LoanSearchCond loanSearch, Model model) throws Exception {
        List<Loan> loans = loanService.findLoans(loanSearch);
        model.addAttribute("loans", loans);

        return "loans";
    }

    @RequestMapping(value="/loans/add", method=RequestMethod.GET)
    public String addForm(@ModelAttribute("loan") Loan loan, Model model) throws Exception {
        LoanType[] loanTypes = loanTypes();
        model.addAttribute("loanTypes", loanTypes);

        return "addForm";
    }

    @RequestMapping(value="/loans/edit/{loanId}", method=RequestMethod.GET)
    public String editForm(@PathVariable Long loanId, Model model) throws Exception {
        Loan loan = loanService.findById(loanId).get();
        model.addAttribute("loan", loan);

        return "editForm";
    }

    @RequestMapping(value="/loans/{loanId}", method=RequestMethod.GET)
    public String loan(@PathVariable long loanId, Model model) throws Exception {
        Loan loan = loanService.findById(loanId).get();
        List <Schedule> schedules = scheduleService.findSchedules(loanId);

        model.addAttribute("loan", loan);
        model.addAttribute("schedules", schedules);

        return "loan";
    }

    @RequestMapping(value="/loans/add", method=RequestMethod.POST)
    public String addLoan(@ModelAttribute Loan loan, RedirectAttributes redirectAttributes) throws Exception {
        LoanType loanType = null;
        List <Schedule> scheduleList = null;
        Loan savedLoan = new Loan();

        loanType = loan.getLoanType();

        if(loanType != null && "P".equals(loanType.toString())){
            savedLoan = loanService.save(loan);
            scheduleList = calculateService.calculateLoanP(savedLoan);
        }else if(loanType != null && "PI".equals(loanType.toString())){
            savedLoan = loanService.save(loan);
            scheduleList = calculateService.calculateLoanPI(savedLoan);
        }else{
            return "redirect:/loans";
        }

        for(Schedule schedule : scheduleList) {
            Schedule savedSchedule = scheduleService.save(schedule);
        }

        redirectAttributes.addAttribute("loanId", savedLoan.getId());
        redirectAttributes.addAttribute("status", true);
        
        return "redirect:/loans/{loanId}";
    }

    @RequestMapping(value="/loans/edit/{loanId}", method=RequestMethod.PUT)
    public String edit(@PathVariable Long loanId, @ModelAttribute LoanUpdateDto updateParam) throws Exception {
        LoanType loanType = updateParam.getLoanType();
        List <Schedule> scheduleList = null;
        Loan updatedLoan = new Loan();

        if("P".equals(loanType.toString())){
            loanService.update(loanId, updateParam);
            updatedLoan = loanService.findById(loanId).get();
            scheduleList = calculateService.calculateLoanP(updatedLoan);
        }else if("PI".equals(loanType.toString())){
            loanService.update(loanId, updateParam);
            updatedLoan = loanService.findById(loanId).get();
            scheduleList = calculateService.calculateLoanPI(updatedLoan);
        }else{
            return "redirect:/loans";
        }

        scheduleService.deleteByLoanId(loanId);

        for(Schedule schedule : scheduleList) {
            Schedule savedSchedule = scheduleService.save(schedule);
        }

        return "redirect:/loans/{loanId}";
    }

    @ModelAttribute("loanTypes")
    public LoanType[] loanTypes() {
        return LoanType.values();
    }
}
