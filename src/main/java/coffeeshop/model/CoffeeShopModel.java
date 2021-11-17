package coffeeshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CoffeeShopModel {
    private final int id;
    private final String name;
    private final double latitude;
    private final double longitude;
}
