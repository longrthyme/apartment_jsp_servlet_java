package vn.edu.hcmuaf.fit.web.dao.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Apartment implements Serializable {


    private int id;
    private String name;
    private String describe;
    private double price;
    private double area;
    private int bedroom;
    private int bathroom;
    private int toilet;
    private String interior;
    private String legal;
    // private Date postedDate;
    private LocalDateTime postedDate;

    private String url;
    private int viewCount;
    private String nameAddress;

    public Apartment(int id, String name, String describe, double price, double area, int bedroom, int bathroom, int toilet, String interior, String legal, LocalDateTime postedDate, String url, int viewCount, String nameAddress) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.area = area;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.toilet = toilet;
        this.interior = interior;
        this.legal = legal;
        this.postedDate = postedDate;
        this.url = url;
        this.viewCount = viewCount;
        this.nameAddress = nameAddress;
    }

    public Apartment(){

    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", price=" + price +
                ", area=" + area +
                ", bedroom=" + bedroom +
                ", bathroom=" + bathroom +
                ", toilet=" + toilet +
                ", interior='" + interior + '\'' +
                ", legal='" + legal + '\'' +
                ", postedDate=" + postedDate +
                ", url='" + url + '\'' +
                ", viewCount=" + viewCount +
                ", nameAddress='" + nameAddress + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public int getToilet() {
        return toilet;
    }

    public void setToilet(int toilet) {
        this.toilet = toilet;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getLegal() {
        return legal;
    }

    public void setLegal(String legal) {
        this.legal = legal;
    }

    public LocalDateTime getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDateTime postedDate) {
        this.postedDate = postedDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getNameAddress() {
        return nameAddress;
    }

    public void setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
    }
}
