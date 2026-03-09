package pl.upsanok.tablab1excercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.upsanok.tablab1excercise.models.FlowerEntity;

import java.util.Optional;

@Repository
public interface FlowerRepository extends JpaRepository<FlowerEntity, Integer> {
    Optional<FlowerEntity> findByFlowerName(String flowerName);
}