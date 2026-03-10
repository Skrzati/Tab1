package pl.upsanok.tablab1excercise.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.upsanok.tablab1excercise.models.FlowerEntity;
import pl.upsanok.tablab1excercise.models.User;
import pl.upsanok.tablab1excercise.models.dto.Flower;
import pl.upsanok.tablab1excercise.repositories.FlowerRepository;
import pl.upsanok.tablab1excercise.repositories.GardenRepository;
import pl.upsanok.tablab1excercise.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GardenService {

    private GardenRepository gardenRepository;
    private UserRepository userRepository;
    private FlowerRepository flowerRepository;

    public List<Flower> getGardenOrUser(String userName) {
        return gardenRepository.findAll().stream()
                .filter(garden -> garden.getUser().getName().equals(userName))
                .map(garden -> Flower.builder()
                        .id(garden.getFlower().getId())
                        .name(garden.getFlower().getFlowerName())
                        .build())
                .collect(java.util.stream.Collectors.toList());
    }
    @Transactional
    public boolean saveFlowerInGardenForUser(String userName, String flowerName) {
        FlowerEntity flowerEntity = flowerRepository.findAll().stream()
                .filter(f -> f.getFlowerName().equals(flowerName))
                .findFirst()
                .orElse(null);

        if (flowerEntity == null) {
            return false;
        }


        User userEntity = userRepository.findAll().stream()
                .filter(u -> u.getName().equals(userName))
                .findFirst()
                .orElseGet(() -> User.builder()
                        .name(userName)
                        .flowerInGarden(new ArrayList<>())
                        .build());

        List<FlowerEntity> flowersInGarden = userEntity.getFlowerInGarden() != null
                ? userEntity.getFlowerInGarden()
                : new ArrayList<>();

        flowersInGarden.add(flowerEntity);
        userEntity.setFlowerInGarden(flowersInGarden);

        userRepository.save(userEntity);
        return true;
    }


}
