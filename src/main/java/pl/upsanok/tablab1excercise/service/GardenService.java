package pl.upsanok.tablab1excercise.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.upsanok.tablab1excercise.models.dto.Flower;
import pl.upsanok.tablab1excercise.repositories.GardenRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class GardenService {

    private GardenRepository gardenRepository;

    public List<Flower> getGardenOrUser(String userName) {
        return gardenRepository.findAll().stream()
                .filter(garden -> garden.getUser().getName().equals(userName))
                .map(garden -> Flower.builder()
                        .id(garden.getFlower().getId())
                        .name(garden.getFlower().getFlowerName())
                        .build())
                .collect(java.util.stream.Collectors.toList());
    }



}
