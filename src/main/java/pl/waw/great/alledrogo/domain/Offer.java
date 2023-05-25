package pl.waw.great.alledrogo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class Offer {

    @Id
    private String id;

    private String title;

    private String description;

    private String site;

    private BigDecimal price;

    private LocalDateTime created;

}
