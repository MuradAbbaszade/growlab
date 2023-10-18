package az.growlab.creditor_lead.controller;

import az.growlab.creditor_lead.dto.*;
import az.growlab.creditor_lead.exception.custom.CustomNotFoundException;
import az.growlab.creditor_lead.service.CreditorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/creditor/")
@RequiredArgsConstructor
public class CreditorController {

    private final CreditorService creditorService;

    @PostMapping("/check-identity")
    public void checkIdentity(@RequestBody PassportInformationRequest passportInformationRequest) {
        creditorService.savePassportInformation(passportInformationRequest);
    }

    @PostMapping("/initial-approve")
    public void initialApprove(@RequestParam("user-id") Long userId, @RequestBody PersonalInformationRequest personalInformationRequest) throws CustomNotFoundException {
        creditorService.saveContactAndAddressInformation(userId, personalInformationRequest);
    }

    @PostMapping("/final-approve")
    public void finalApprove(@RequestBody LoanRequest loanRequest) throws CustomNotFoundException {
        creditorService.saveLoan(loanRequest);
    }
}
