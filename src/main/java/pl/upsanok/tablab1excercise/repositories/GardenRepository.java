package pl.upsanok.tablab1excercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.upsanok.tablab1excercise.models.Garden;
import pl.upsanok.tablab1excercise.models.GardenId;

@Repository
public interface GardenRepository extends JpaRepository<Garden, GardenId> {
}
