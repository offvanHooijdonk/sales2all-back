package com.sales2all.back.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Yahor_Fralou on 8/1/2016.
 */

@Entity
@Table(name = "SALE")
public class SaleBean extends BaseBean {
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "DISCOUNT", nullable = false)
    private int discount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
