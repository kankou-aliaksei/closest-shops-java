package coffeeshop.repository;

import coffeeshop.dto.ClosestShopInput;
import coffeeshop.dto.ClosestCoffeeShopDto;
import coffeeshop.model.CoffeeShopModel;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static coffeeshop.Util.calculateDistance;
import static coffeeshop.constant.Constant.DEFAULT_CLOSEST_SHOPS_LIMIT;

public class InMemoryCoffeeShopRepository implements CoffeeShopRepository {
    private final List<CoffeeShopModel> shops;

    public InMemoryCoffeeShopRepository(List<CoffeeShopModel> shops) {
        this.shops = shops;
    }

    @Override
    public List<ClosestCoffeeShopDto> getClosestShops(ClosestShopInput input) {
        var latitude = input.getLatitude();
        var longitude = input.getLongitude();
        var limit = input.getLimit() != null
                ? input.getLimit(): DEFAULT_CLOSEST_SHOPS_LIMIT;

        return shops
                .stream()
                .map(shop -> {
                    var distance = calculateDistance(
                            latitude,
                            longitude,
                            shop.getLatitude(),
                            shop.getLongitude());

                    return new ClosestCoffeeShopDto(
                            shop.getId(),
                            shop.getName(),
                            shop.getLatitude(),
                            shop.getLongitude(),
                            distance);
                })
                .filter(shop -> input.getDistance() == null || shop.getDistance() <= input.getDistance())
                .sorted(Comparator.comparingDouble(ClosestCoffeeShopDto::getDistance))
                .limit(limit)
                .collect(Collectors.toList());
    }
}
