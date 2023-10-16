package az.growlab.creditor_lead.controller;
import az.growlab.creditor_lead.enums.ActionStatus;
import az.growlab.creditor_lead.enums.LeadResponseStatus;
import az.growlab.creditor_lead.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/lead/")
public class LeadController {

    private final LeadService leadService;

    @PostMapping("/identity-status/{id}")
    public String approveIdentityStatus(@PathVariable Long id, @RequestParam("response-status") LeadResponseStatus leadResponseStatus,
                                  @RequestParam(value = "reject-reason",required = false) String rejectReason){

        return leadService.changeActionStatus(id,leadResponseStatus,rejectReason, ActionStatus.IDENTITY_CHECK_APPROVED);
    }
    @PostMapping("/initial-status/{id}")
    public String approveInitialStatus(@PathVariable Long id, @RequestParam("response-status") LeadResponseStatus leadResponseStatus,
                          @RequestParam(value = "reject-reason",required = false) String rejectReason){

        return leadService.changeActionStatus(id,leadResponseStatus,rejectReason, ActionStatus.INITIAL_CHECK_APPROVED);
    }

}
