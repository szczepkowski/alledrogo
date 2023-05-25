package pl.waw.great.alledrogo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
@Document("serviceRequest")
@ToString
public class ServiceRequest {

    @Id
    private String id;

    private String userId;

    private String title;

    private String description;

    private BigDecimal price;

    @Singular
    private List<Offer> offers = new ArrayList<>();
    @Setter
    private Offer winnerOffer;

    private LocalDateTime created;

    public boolean addOffer(Offer offer){
        this.offers.add(offer);
        return true;
    }

}
