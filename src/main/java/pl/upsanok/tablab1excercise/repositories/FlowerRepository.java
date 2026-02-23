package pl.upsanok.tablab1excercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.upsanok.tablab1excercise.models.FlowerEntity;

public interface FlowerRepository extends JpaRepository<FlowerEntity, Integer> {
}
