package pl.waw.great.alledrogo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.waw.great.alledrogo.controller.dto.OfferView;
import pl.waw.great.alledrogo.controller.dto.ServiceRequestRequest;
import pl.waw.great.alledrogo.controller.dto.ServiceRequestView;
import pl.waw.great.alledrogo.domain.Offer;
import pl.waw.great.alledrogo.domain.ServiceRequest;
import pl.waw.great.alledrogo.domain.User;
import pl.waw.great.alledrogo.repository.ServiceRequestRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ServiceRequestService {

    private final ServiceRequestRepository serviceRequestRepository;

    public ServiceRequestService(ServiceRequestRepository serviceRequestRepository) {
        this.serviceRequestRepository = serviceRequestRepository;
    }

    public ServiceRequestView create(ServiceRequestRequest request) {
        ServiceRequest serviceRequest = serviceRequestRepository.save(ServiceRequest.builder()
                .id(UUID.randomUUID().toString())
                .title(request.getTitle())
                .userId(User.DEFAULT_USER_ID)
                .description(request.getDescription())
                .created(LocalDateTime.now())
                .price(request.getPrice())
                .offers(Arrays.asList())
                .build());

        log.info("created service request {}", serviceRequest);
        return ServiceRequestView.builder()
                .id(serviceRequest.getId())
                .userId(serviceRequest.getUserId())
                .title(serviceRequest.getTitle())
                .description(serviceRequest.getDescription())
                .price(serviceRequest.getPrice())
                .build();
    }

    public OfferView createOffer(String serviceRequestId, OfferView offerView) {
        ServiceRequest serviceRequest = this.serviceRequestRepository.
                findById(serviceRequestId)
                .orElseThrow(() -> new IllegalArgumentException("Service Request not exist with id" + serviceRequestId));

        Offer offer = Offer.builder()
                .id(UUID.randomUUID().toString())
                .title(offerView.getTitle())
                .description(offerView.getDescription())
                .site(offerView.getSite())
                .price(offerView.getPrice())
                .created(LocalDateTime.now())
                .build();

        serviceRequest.addOffer(offer);
        log.info("Offer has been added :" + offer);
        this.serviceRequestRepository.save(serviceRequest);
        return offerView;
    }

    public void selectWinner(String serviceRequestId, String offerId) {
        String id = User.DEFAULT_USER_ID;
        List<ServiceRequest> serviceRequests = this.serviceRequestRepository.findByUserId(id);

        ServiceRequest serviceRequest = serviceRequests.stream()
                .filter(serviceReq -> serviceRequestId.equals(serviceReq.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Service Request not exist with id" + serviceRequestId));

        Offer winnerOffer = serviceRequest.getOffers().stream()
                .filter(offer -> offerId.equals(offer.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Offer not exist with id" + offerId));

        serviceRequest.setWinnerOffer(winnerOffer);
        serviceRequestRepository.save(serviceRequest);

        log.info("Winner offer was selected for " + serviceRequest);
    }

}