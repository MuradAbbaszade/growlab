package az.growlab.creditorleadjpa.controller;

import az.growlab.creditorleadjpa.dto.LeadRequest;
import az.growlab.creditorleadjpa.dto.LoanRequest;
import az.growlab.creditorleadjpa.dto.PassportInformationRequest;
import az.growlab.creditorleadjpa.dto.PersonalInformationRequest;
import az.growlab.creditorleadjpa.enums.ActionStatus;
import az.growlab.creditorleadjpa.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/lead")
@RestController
public class LeadController {
    private final LeadService leadService;

    @PostMapping("/identity-status")
    public void checkIdentity(@RequestBody LeadRequest leadRequest){
        leadService.changeIdentityStatus(leadRequest, ActionStatus.IDENTITY_CHECK_APPROVED);
    }
    @PostMapping("/initial-status")
    public void initialApprove(@RequestBody LeadRequest leadRequest){
        leadService.changeIdentityStatus(leadRequest, ActionStatus.INITIAL_CHECK_APPROVED);
    }
    @PostMapping("/final-status")
    public void finalApprove(@RequestBody LeadRequest leadRequest){
        leadService.changeIdentityStatus(leadRequest, ActionStatus.FINAL_CHECK_APPROVED);
    }

}
