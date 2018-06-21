package ru.tsystems.javaschool.model;

import java.io.Serializable;
import java.util.List;

public class InfoDto implements Serializable {

    private Integer allDrivers;

    private Integer driversOnOrder;

    private Integer freeDrivers;

    private Integer allTrucks;

    private Integer trucksOnOrder;

    private Integer availableTrucks;

    private Integer brokenTrucks;

    private List<OrderDto> lastTen;

    public InfoDto() {
    }

    public InfoDto(Integer allDrivers, Integer driversOnOrder, Integer freeDrivers, Integer allTrucks,
                   Integer trucksOnOrder, Integer availableTrucks, Integer brokenTrucks, List<OrderDto> lastTen) {
        this.allDrivers = allDrivers;
        this.driversOnOrder = driversOnOrder;
        this.freeDrivers = freeDrivers;
        this.allTrucks = allTrucks;
        this.trucksOnOrder = trucksOnOrder;
        this.availableTrucks = availableTrucks;
        this.brokenTrucks = brokenTrucks;
        this.lastTen = lastTen;
    }

    public Integer getAllDrivers() {
        return allDrivers;
    }

    public void setAllDrivers(Integer allDrivers) {
        this.allDrivers = allDrivers;
    }

    public Integer getDriversOnOrder() {
        return driversOnOrder;
    }

    public void setDriversOnOrder(Integer driversOnOrder) {
        this.driversOnOrder = driversOnOrder;
    }

    public Integer getFreeDrivers() {
        return freeDrivers;
    }

    public void setFreeDrivers(Integer freeDrivers) {
        this.freeDrivers = freeDrivers;
    }

    public Integer getAllTrucks() {
        return allTrucks;
    }

    public void setAllTrucks(Integer allTrucks) {
        this.allTrucks = allTrucks;
    }

    public Integer getTrucksOnOrder() {
        return trucksOnOrder;
    }

    public void setTrucksOnOrder(Integer trucksOnOrder) {
        this.trucksOnOrder = trucksOnOrder;
    }

    public Integer getAvailableTrucks() {
        return availableTrucks;
    }

    public void setAvailableTrucks(Integer availableTrucks) {
        this.availableTrucks = availableTrucks;
    }

    public Integer getBrokenTrucks() {
        return brokenTrucks;
    }

    public void setBrokenTrucks(Integer brokenTrucks) {
        this.brokenTrucks = brokenTrucks;
    }

    public List<OrderDto> getLastTenOrders() {
        return lastTen;
    }

    public void setLastTenOrders(List<OrderDto> lastTenOrders) {
        this.lastTen = lastTenOrders;
    }

    @Override
    public String toString() {
        return "InfoDto{" +
                "allDrivers=" + allDrivers +
                ", driversOnOrder=" + driversOnOrder +
                ", freeDrivers=" + freeDrivers +
                ", allTrucks=" + allTrucks +
                ", trucksOnOrder=" + trucksOnOrder +
                ", availableTrucks=" + availableTrucks +
                ", brokenTrucks=" + brokenTrucks +
                ", lastTenOrders=" + lastTen +
                '}';
    }
}
