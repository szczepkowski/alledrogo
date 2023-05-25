package pl.waw.great.alledrogo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
public class ServiceRequestView {

    private String id;

    private String userId;

    private String title;

    private String description;

    private BigDecimal price;
}
