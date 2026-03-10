package pl.upsanok.tablab1excercise.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.upsanok.tablab1excercise.models.FlowerEntity;
import pl.upsanok.tablab1excercise.models.User;
import pl.upsanok.tablab1excercise.models.dto.Flower;
import pl.upsanok.tablab1excercise.repositories.FlowerRepository;
import pl.upsanok.tablab1excercise.repositories.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FlowersService {

    private final FlowerRepository flowerRepository;
    private final UserRepository userRepository;


    public List<Flower> getAllFlowers() {
        return flowerRepository.findAll().stream()
                .map(entity -> Flower.builder()
                        .name(entity.getFlowerName())
                        .id(entity.getId())
                        .build())
                .toList();
    }

    public Flower getFavouriteFlowerForUser(String userName) {
        return userRepository.findAll().stream()
                .filter(user -> user.getName().equals(userName))
                .findFirst()
                .map(user -> {
                    if (user.getFlowerEntity() == null) {
                        return Flower.builder().name("").build();
                    }
                    return Flower.builder().name(user.getFlowerEntity().getFlowerName()).build();
                })
                .orElse(Flower.builder().name("").build());
    }

    public boolean saveFavouriteFlowerFor(String userName, String flowerName) {
        FlowerEntity flower = flowerRepository.findAll().stream()
                .filter(f -> f.getFlowerName().equals(flowerName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Flower not found"));

        User user = userRepository.findAll().stream()
                .filter(u -> u.getName().equals(userName))
                .findFirst()
                .orElse(User.builder().name(userName).build());

        user.setFlowerEntity(flower);
        userRepository.save(user);
        return true;

    }
}
