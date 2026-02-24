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
                        .build())
                .toList();
    }

    public Flower getFavouriteFlowerForUser(String userName) {
        return userRepository.findByName(userName)
                .map(User::getFlowerId)
                .flatMap(flowerRepository::findById)
                .map(entity -> Flower.builder().name(entity.getFlowerName()).build())
                .orElse(Flower.builder().name("").build());
    }


    public boolean saveFavouriteFlowerFor(String userName, String flowerName) {
        FlowerEntity flower = flowerRepository.findByFlowerName(flowerName)
                .orElseThrow(() -> new RuntimeException("Flower not found"));
        User user = userRepository.findByName(userName)
                .orElse(User.builder().name(userName).build());

        user.setFlowerId(flower.getId());
        userRepository.save(user);
        return true;
    }
}
