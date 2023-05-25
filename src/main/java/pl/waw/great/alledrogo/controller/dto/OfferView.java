package pl.waw.great.alledrogo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
public class OfferView {

    private String title;
    private String description;
    private String site;

    private BigDecimal price;
}
