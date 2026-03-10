package pl.upsanok.tablab1excercise.models;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class GardenId implements Serializable {

    private Integer user;

    private Integer flower;

}
