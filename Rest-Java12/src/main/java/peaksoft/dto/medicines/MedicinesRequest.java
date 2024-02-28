package peaksoft.dto.medicines;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MedicinesRequest {
    private String name;
    private double price ;


}
