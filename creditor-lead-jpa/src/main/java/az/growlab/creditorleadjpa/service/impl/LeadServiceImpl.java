package az.growlab.creditorleadjpa.service.impl;

import az.growlab.creditorleadjpa.dto.LeadRequest;
import az.growlab.creditorleadjpa.entity.User;
import az.growlab.creditorleadjpa.enums.ActionStatus;
import az.growlab.creditorleadjpa.enums.LeadResponseStatus;
import az.growlab.creditorleadjpa.exception.CustomNotFoundException;
import az.growlab.creditorleadjpa.repository.UserRepository;
import az.growlab.creditorleadjpa.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeadServiceImpl implements LeadService {
    private final UserRepository userRepository;
    @Override
    public void changeIdentityStatus(LeadRequest leadRequest, ActionStatus actionStatus) {
        if(leadRequest.getRejectReason().equals(LeadResponseStatus.NEED_TO_IMPROVE)||
        leadRequest.getRejectReason().equals(LeadResponseStatus.DECLINE)){
            throw new UnsupportedOperationException(leadRequest.getLeadResponseStatus().toString());
        }
        User user = userRepository.findById(leadRequest.getUserId())
                .orElseThrow(() -> new CustomNotFoundException("User not found"));
        user.setActionStatus(actionStatus);
        userRepository.save(user);
    }
}
