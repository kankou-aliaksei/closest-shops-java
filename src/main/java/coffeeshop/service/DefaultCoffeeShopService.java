package coffeeshop.service;

import coffeeshop.dto.ClosestShopInput;
import coffeeshop.dto.ClosestCoffeeShopDto;
import coffeeshop.repository.CoffeeShopRepository;

import java.util.List;

public class DefaultCoffeeShopService implements CoffeeShopService {
    private final CoffeeShopRepository coffeeShopRepository;

    public DefaultCoffeeShopService(CoffeeShopRepository coffeeShopRepository) {
        this.coffeeShopRepository = coffeeShopRepository;
    }

    @Override
    public List<ClosestCoffeeShopDto> getClosestShops(ClosestShopInput input) {
        return coffeeShopRepository.getClosestShops(input);
    }
}
