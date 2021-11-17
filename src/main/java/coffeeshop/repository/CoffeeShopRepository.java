package coffeeshop.repository;

import coffeeshop.dto.ClosestShopInput;
import coffeeshop.dto.ClosestCoffeeShopDto;

import java.util.List;

public interface CoffeeShopRepository {
    List<ClosestCoffeeShopDto> getClosestShops(ClosestShopInput input);
}
