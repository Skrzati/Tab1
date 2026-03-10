package pl.upsanok.tablab1excercise.models;

import jakarta.persistence.*;
import lombok.*;
import pl.upsanok.tablab1excercise.models.dto.Flower;

@Entity
@Table(name = "garden_table")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@IdClass(GardenId.class)
public class Garden {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flower_id")
    private FlowerEntity flower;

}
