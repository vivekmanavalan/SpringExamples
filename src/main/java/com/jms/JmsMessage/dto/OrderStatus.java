package com.jms.JmsMessage.dto;

public class OrderStatus {

    public String orderId;

    public String name;

    public String status;  //completed, failed

    public OrderStatus() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "orderId='" + orderId + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public OrderStatus(String orderId, String name, String status) {
        this.orderId = orderId;
        this.name = name;
        this.status = status;
    }
}
