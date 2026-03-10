package pl.upsanok.tablab1excercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.upsanok.tablab1excercise.models.Garden;
import pl.upsanok.tablab1excercise.models.GardenId;

import java.util.List;

@Repository
public interface GardenRepository extends JpaRepository<Garden, GardenId> {

    @Query("SELECT g FROM Garden g JOIN FETCH g.user u JOIN FETCH g.flower f WHERE u.name = :userName")
    List<Garden> findByUserName(@Param("userName") String userName);
}
