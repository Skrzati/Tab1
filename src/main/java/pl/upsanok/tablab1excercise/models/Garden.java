package pl.upsanok.tablab1excercise.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "garden_table")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Garden {

    @EmbeddedId
    private GardenIdEmbedded gardenIdEmbedded;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("flower")
    @JoinColumn(name = "flower_id")
    private FlowerEntity flower;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("user")
    @JoinColumn(name = "user_id")
    private User user;

}
