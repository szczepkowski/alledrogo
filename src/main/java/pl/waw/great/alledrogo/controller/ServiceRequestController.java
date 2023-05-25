package pl.waw.great.alledrogo.controller;

import org.springframework.web.bind.annotation.*;
import pl.waw.great.alledrogo.controller.dto.OfferView;
import pl.waw.great.alledrogo.controller.dto.ServiceRequestRequest;
import pl.waw.great.alledrogo.controller.dto.ServiceRequestView;
import pl.waw.great.alledrogo.service.ServiceRequestService;

@RestController
@RequestMapping("/serviceRequest")
public class ServiceRequestController {

    private final ServiceRequestService service;

    public ServiceRequestController(ServiceRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ServiceRequestView create(ServiceRequestRequest request){
        return this.service.create(request);
    }

    @PostMapping("/{serviceRequestId}/{offerId}")
    public void selectWinner(@PathVariable String serviceRequestId, @PathVariable String offerId){
        this.service.selectWinner(serviceRequestId,offerId);
    }

    @PostMapping("/{serviceRequestId}")
    public void addOffer(@PathVariable String serviceRequestId, @RequestBody OfferView offerView){
        this.service.createOffer(serviceRequestId,offerView);
    }

}
