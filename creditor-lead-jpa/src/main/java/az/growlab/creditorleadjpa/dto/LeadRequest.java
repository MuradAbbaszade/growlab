package az.growlab.creditorleadjpa.dto;

import az.growlab.creditorleadjpa.enums.ActionStatus;
import az.growlab.creditorleadjpa.enums.LeadResponseStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.swing.*;

@Getter
@NoArgsConstructor
public class LeadRequest {
    private Long userId;
    private LeadResponseStatus leadResponseStatus;
    private String rejectReason;
}
