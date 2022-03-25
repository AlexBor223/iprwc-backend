package com.backend.backendiprwc.model;

import com.sun.xml.txw2.annotation.XmlCDATA;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Product implements Serializable {
    @Id
//    @SequenceGenerator(
//            name = "product_sequence",
//            sequenceName = "product_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "product_sequence"
//    )
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private String brand;
    @Column
    private String price;
    @Column
    private Integer stock;
    @Column
    private String seller;
    @Column
    private Integer EAN;
    @Column
    private String category;
    @Column
    private String description;
    @Column
    private String imgPath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product() {
    }

    public Product(String name, String brand, String price, Integer stock, String seller, Integer EAN, String category, String description, String imgPath) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
        this.seller = seller;
        this.EAN = EAN;
        this.category = category;
        this.description = description;
        this.imgPath = imgPath;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getEAN() {
        return EAN;
    }

    public void setEAN(Integer EAN) {
        this.EAN = EAN;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(brand, product.brand) && Objects.equals(price, product.price) && Objects.equals(stock, product.stock) && Objects.equals(seller, product.seller) && Objects.equals(EAN, product.EAN) && Objects.equals(category, product.category) && Objects.equals(description, product.description) && Objects.equals(imgPath, product.imgPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brand, price, stock, seller, EAN, category, description, imgPath);
    }
}

