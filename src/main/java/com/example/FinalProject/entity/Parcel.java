package com.example.FinalProject.entity;

import com.example.FinalProject.Constants;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;

@Component
public class Parcel implements Serializable, Comparable<Parcel> {
    private int id;
    private String fromPoint;
    private String toPoint;
    private String deliveryAddress;
    private String category;
    private int distance;
    private int length;
    private int width;
    private int height;
    private double weight;
    private double price;

    private String status;
    private int userId;
    private Date createDate;
    private Date paymentDate;
    private Date deliveryDate;

    public Parcel() {
    }

    public Parcel(String fromPoint, String toPoint, int length, int width, int height, double weight) {
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public double calculatePrice(int distance, int amount, double weight) {
        double calculatedPrice = 20;
        if (amount > 5000) {
            calculatedPrice = Math.ceil(calculatedPrice + 0.01 * calculatedPrice * amount / 5000);
        }
        if (distance > 300) {
            calculatedPrice = Math.ceil(calculatedPrice + 0.1 * calculatedPrice * distance / 300);
        }
        if (weight > 15) {
            calculatedPrice = Math.ceil(calculatedPrice + 0.01 * calculatedPrice * weight / 15);
        }
        return calculatedPrice;
    }

    public int calculateDistance(String fromPoint, String toPoint) {
        int calculatedDistance = 0;
        int indexFromPoint = 0;
        int indexToPoint = 0;
        for (int i = 0; i < Constants.CITIES.length; i++) {
            if (fromPoint.equals(Constants.CITIES[i])) {
                indexFromPoint = i;
            }
            if (toPoint.equals(Constants.CITIES[i])) {
                indexToPoint = i;
            }
        }
        calculatedDistance = Constants.DISTANCES[indexFromPoint][indexToPoint];
        return calculatedDistance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromPoint() {
        return fromPoint;
    }

    public void setFromPoint(String fromPoint) {
        this.fromPoint = fromPoint;
    }

    public String getToPoint() {
        return toPoint;
    }

    public void setToPoint(String toPoint) {
        this.toPoint = toPoint;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "id=" + id +
                ", fromPoint='" + fromPoint + '\'' +
                ", toPoint='" + toPoint + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", category='" + category + '\'' +
                ", distance=" + distance +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", weight=" + weight +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                ", createDate=" + createDate +
                ", paymentDate=" + paymentDate +
                ", deliveryDate=" + deliveryDate +
                '}';
    }

    @Override
    public int compareTo(Parcel parcel) {
        return 0;
    }
}
