package pl.upsanok.tablab1excercise.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.upsanok.tablab1excercise.models.FlowerEntity;
import pl.upsanok.tablab1excercise.models.Garden;
import pl.upsanok.tablab1excercise.models.User;
import pl.upsanok.tablab1excercise.models.dto.Flower;
import pl.upsanok.tablab1excercise.repositories.FlowerRepository;
import pl.upsanok.tablab1excercise.repositories.GardenRepository;
import pl.upsanok.tablab1excercise.repositories.UserRepository;

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
        User user = userRepository.findAll().stream()
                .filter(u -> u.getName().equals(userName))
                .findFirst()
                .orElseGet(() -> userRepository.save(User.builder().name(userName).build()));

        FlowerEntity flower = flowerRepository.findAll().stream()
                .filter(f -> f.getFlowerName().equals(flowerName))
                .findFirst()
                .orElse(null);

        if (flower == null) {
            return false;
        }

        Garden garden = Garden.builder()
                .user(user)
                .flower(flower)
                .build();

        gardenRepository.save(garden);
        return true;
    }


}
