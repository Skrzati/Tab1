package pl.upsanok.tablab1excercise.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="flower_table")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class FlowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flower_id")
    private int id;
    @Column(name = "flower_name")
    private String flowerName;
}
