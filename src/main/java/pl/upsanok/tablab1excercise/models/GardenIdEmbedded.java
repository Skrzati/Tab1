package pl.upsanok.tablab1excercise.models;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class GardenIdEmbedded implements Serializable {

    private Integer user;
    private Integer flower;

}
