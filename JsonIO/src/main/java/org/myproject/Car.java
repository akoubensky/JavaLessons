package org.myproject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @JsonProperty("car-color")
    private String color;
    private String type;
    @JsonIgnore
    private String win;
}
