package pl.upsanok.tablab1excercise.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.upsanok.tablab1excercise.models.Garden;
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

    private FlowerRepository flowerRepository;
    private UserRepository userRepository;
    private GardenRepository gardenRepository;

    public List<Flower> getGardenOrUser(String userName) {
        userRepository.findAll().forEach(user -> {
            if (user.getName().equals(userName)) {
                List<Garden> allFlowers =  gardenRepository.findAll();
                for (User user : allUsers) {
                    if (user.getName().equals(userName)) {
                        return Flower.builder().name(user.getFlowerEntity().getFlowerName()).build();
                    }
                }
            }
        });
        return new ArrayList<>();
    }

}
