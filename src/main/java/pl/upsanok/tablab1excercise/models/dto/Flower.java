package pl.upsanok.tablab1excercise.models.dto;

import lombok.Builder;

@Builder
public record Flower(
    Integer id,
    String name
) {
}
