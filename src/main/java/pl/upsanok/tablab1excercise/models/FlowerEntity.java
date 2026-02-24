package pl.upsanok.tablab1excercise.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="flower_table")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flower_id")
    private Integer id;
    @Column(name = "flower_name")
    private String flowerName;
}
