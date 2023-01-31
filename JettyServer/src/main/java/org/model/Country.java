package org.model;


import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    private String name;
    private String capital;
    private Double population; // В млн. человек
}
