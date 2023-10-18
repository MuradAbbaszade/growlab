package az.growlab.creditor_lead.service;

import az.growlab.creditor_lead.dto.*;
import az.growlab.creditor_lead.exception.custom.CustomNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface CreditorService {
    int savePassportInformation(PassportInformationRequest passportInformationRequest);

    Long saveContactAndAddressInformation(Long userId, PersonalInformationRequest personalInformationRequest) throws CustomNotFoundException;

    Long saveLoan(LoanRequest loanRequest) throws CustomNotFoundException;
}
