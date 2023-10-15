package az.growlab.creditor_lead.controller;

import az.growlab.creditor_lead.enums.ActionStatus;
import az.growlab.creditor_lead.enums.LeadResponseStatus;
import az.growlab.creditor_lead.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/lead/")
public class LeadController {

    private final LeadService leadService;

    @PostMapping("/identity-status/{id}")
    public ResponseEntity approve(@PathVariable Long id, @RequestParam("response-status") LeadResponseStatus leadResponseStatus,
                                  @RequestParam(value = "reject-reason",required = false) String rejectReason){
        if(leadResponseStatus.equals(LeadResponseStatus.APPROVE)){
            leadService.changeActionStatusById(id, ActionStatus.IDENTITY_CHECK_APPROVED);
            return ResponseEntity.ok(ActionStatus.IDENTITY_CHECK_APPROVED+" "+id);
        }
        if(rejectReason==null){
            return ResponseEntity.badRequest().body("Reject reason is required for NEED_TO_IMPROVE and DECLINE status.");
        }
        return ResponseEntity.ok(id+"Rejected.Reason: "+rejectReason);
    }

}
