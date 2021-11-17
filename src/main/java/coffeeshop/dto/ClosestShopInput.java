package coffeeshop.dto;

import lombok.Getter;

@Getter
public class ClosestShopInput {
    private final double latitude;
    private final double longitude;
    private Integer limit;
    private Double distance;

    public ClosestShopInput(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public ClosestShopInput(double latitude, double longitude, Integer limit) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.limit = limit;
    }

    public ClosestShopInput(double latitude, double longitude, Double distance) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance = distance;
    }

    public ClosestShopInput(double latitude, double longitude, Integer limit, Double distance) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.limit = limit;
        this.distance = distance;
    }
}
