package coffeeshop.service;

import coffeeshop.dto.ClosestShopInput;
import coffeeshop.dto.ClosestCoffeeShopDto;

import java.util.List;

public interface CoffeeShopService {
    List<ClosestCoffeeShopDto> getClosestShops(ClosestShopInput input);
}
