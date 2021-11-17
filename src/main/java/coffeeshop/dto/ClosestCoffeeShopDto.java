package coffeeshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ClosestCoffeeShopDto {
    private final int id;
    private final String name;
    private final double latitude;
    private final double longitude;
    private final double distance;
}
