package az.growlab.creditorleadjpa.service;

import az.growlab.creditorleadjpa.dto.LoanRequest;
import az.growlab.creditorleadjpa.dto.PassportInformationRequest;
import az.growlab.creditorleadjpa.dto.PersonalInformationRequest;
import az.growlab.creditorleadjpa.entity.PassportInformation;
import az.growlab.creditorleadjpa.entity.PersonalInformation;
import org.springframework.stereotype.Service;

@Service
public interface CreditorService {
    void identityApprove(PassportInformationRequest passportInformationRequest);
    void initialApprove(PersonalInformationRequest personalInformationRequest);
    void finalApprove(LoanRequest loanRequest);
}
