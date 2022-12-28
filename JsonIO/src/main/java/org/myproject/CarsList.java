package org.myproject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CarsList {
    private List<Car> cars;
    @JsonProperty("park-number")
    private Integer parkNumber;
    @JsonProperty("park-owner")
    private String parkOwner;
}
