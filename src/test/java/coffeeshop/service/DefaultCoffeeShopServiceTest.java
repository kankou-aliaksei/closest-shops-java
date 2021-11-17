package coffeeshop.service;

import coffeeshop.dto.ClosestShopInput;
import coffeeshop.model.CoffeeShopModel;
import coffeeshop.repository.InMemoryCoffeeShopRepository;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DefaultCoffeeShopServiceTest {
    @Test public void shouldFindDreamlandAsClosestShop() {
        List<CoffeeShopModel> testShops = List.of(
                new CoffeeShopModel(1, "Gippo", 53.879672763944406, 27.46678999184836),
                new CoffeeShopModel(2, "Outleto Mall", 53.87947038053962, 27.51760176036633),
                new CoffeeShopModel(3, "Dreamland", 53.93569525751962, 27.52103498796889)
        );

        var repository = new InMemoryCoffeeShopRepository(testShops);
        var service = new DefaultCoffeeShopService(repository);

        var input = new ClosestShopInput(53.919118810526605, 27.53888777150223);

        var shops = service.getClosestShops(input);

        assertEquals(3, shops.get(0).getId());
        assertEquals(testShops.get(2).getName(), shops.get(0).getName());
    }

    @Test public void shouldFindGippoAsClosestShop() {
        List<CoffeeShopModel> testShops = List.of(
                new CoffeeShopModel(1, "Gippo", 53.879672763944406, 27.46678999184836),
                new CoffeeShopModel(2, "Outleto Mall", 53.87947038053962, 27.51760176036633),
                new CoffeeShopModel(3, "Dreamland", 53.93569525751962, 27.52103498796889)
        );

        var repository = new InMemoryCoffeeShopRepository(testShops);
        var service = new DefaultCoffeeShopService(repository);

        var input = new ClosestShopInput(53.85034014462827, 27.4712052781082);

        var shops = service.getClosestShops(input);

        assertEquals(1, shops.get(0).getId());
        assertEquals(testShops.get(0).getName(), shops.get(0).getName());
    }

    @Test public void shouldFindAllClosestShops() {
        List<CoffeeShopModel> testShops = List.of(
                new CoffeeShopModel(1, "Gippo", 53.879672763944406, 27.46678999184836),
                new CoffeeShopModel(2, "Outleto Mall", 53.87947038053962, 27.51760176036633),
                new CoffeeShopModel(3, "Dreamland", 53.93569525751962, 27.52103498796889)
        );

        var repository = new InMemoryCoffeeShopRepository(testShops);
        var service = new DefaultCoffeeShopService(repository);

        var input = new ClosestShopInput(53.85034014462827, 27.4712052781082);

        var shops = service.getClosestShops(input);

        assertEquals(3, shops.size());
    }

    @Test public void shouldFindTwoClosestShops() {
        List<CoffeeShopModel> testShops = List.of(
                new CoffeeShopModel(1, "Gippo", 53.879672763944406, 27.46678999184836),
                new CoffeeShopModel(2, "Outleto Mall", 53.87947038053962, 27.51760176036633),
                new CoffeeShopModel(3, "Dreamland", 53.93569525751962, 27.52103498796889)
        );

        var repository = new InMemoryCoffeeShopRepository(testShops);
        var service = new DefaultCoffeeShopService(repository);

        var input = new ClosestShopInput(53.85034014462827, 27.4712052781082, 2);

        var shops = service.getClosestShops(input);

        assertEquals(2, shops.size());
    }

    @Test public void shouldFindTwoClosestShopsAccordingToDistanceLimit() {
        List<CoffeeShopModel> testShops = List.of(
                new CoffeeShopModel(1, "Gippo", 53.879672763944406, 27.46678999184836),
                new CoffeeShopModel(2, "Outleto Mall", 53.87947038053962, 27.51760176036633),
                new CoffeeShopModel(3, "Dreamland", 53.93569525751962, 27.52103498796889)
        );

        var repository = new InMemoryCoffeeShopRepository(testShops);
        var service = new DefaultCoffeeShopService(repository);

        var input = new ClosestShopInput(53.85034014462827, 27.4712052781082, 7000.0);

        var shops = service.getClosestShops(input);

        assertEquals(2, shops.size());
    }
}
