package pl.upsanok.tablab1excercise.models;

import jakarta.persistence.*;
import lombok.*;
import pl.upsanok.tablab1excercise.models.dto.Flower;

@Entity
@Table(name = "user_table")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "user_name")
    private String name;

//    @Column(name = "flower_id")
//    private Integer flowerId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flower_id" )
    private FlowerEntity flowerEntity;
}