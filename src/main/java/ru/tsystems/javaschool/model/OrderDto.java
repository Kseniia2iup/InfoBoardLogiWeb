package ru.tsystems.javaschool.model;

import java.io.Serializable;

public class OrderDto implements Serializable {

    private Integer id;

    private String orderStatus;

    private String truck;

    private String cargoes;

    private String drivers;

    public OrderDto() {
    }

    public OrderDto(Integer id, String orderStatus, String truck, String cargoes, String drivers) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.truck = truck;
        this.cargoes = cargoes;
        this.drivers = drivers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    public String getCargoes() {
        return cargoes;
    }

    public void setCargoes(String cargoes) {
        this.cargoes = cargoes;
    }

    public String getDrivers() {
        return drivers;
    }

    public void setDrivers(String drivers) {
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"orderStatus\":\"" + orderStatus + '\"' +
                ", \"truck\":\"" + truck + '\"' +
                ", \"cargoes\":\"" + cargoes + '\"' +
                ", \"drivers\":\"" + drivers + '\"' +
                '}';
    }
}
