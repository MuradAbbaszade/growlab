package az.growlab.creditor_lead.controller;

import az.growlab.creditor_lead.dto.PassportInformationRequest;
import az.growlab.creditor_lead.service.CreditorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/creditor/")
@RequiredArgsConstructor
public class CreditorController {

    private final CreditorService creditorService;
    @PostMapping("/check-identity")
    public void checkIdentity(@RequestBody PassportInformationRequest passportInformationRequest){
        creditorService.savePassportInformation(passportInformationRequest);
    }
}
