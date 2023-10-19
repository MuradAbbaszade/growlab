package az.growlab.creditorleadjpa.controller;

import az.growlab.creditorleadjpa.dto.LoanRequest;
import az.growlab.creditorleadjpa.dto.PassportInformationRequest;
import az.growlab.creditorleadjpa.dto.PersonalInformationRequest;
import az.growlab.creditorleadjpa.service.CreditorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/creditor")
public class CreditorController {
    private final CreditorService creditorService;
    @PostMapping("/check-identity")
    public void checkIdentity(@RequestBody PassportInformationRequest passportInformationRequest){
        creditorService.identityApprove(passportInformationRequest);
    }
    @PostMapping("/initial-approve")
    public void initialApprove(@RequestBody PersonalInformationRequest personalInformationRequest){
        creditorService.initialApprove(personalInformationRequest);
    }
    @PostMapping("/final-approve")
    public void finalApprove(@RequestBody LoanRequest loanRequest){
        creditorService.finalApprove(loanRequest);
    }

}
