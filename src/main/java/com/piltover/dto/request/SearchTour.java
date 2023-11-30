package com.piltover.dto.request;

import lombok.Data;
import java.util.Date;

@Data
public class SearchTour {
    private Date startDate;
    private String tourName;
    private String startAddress;
    private Double minPrice;
    private Double maxPrice;
}
