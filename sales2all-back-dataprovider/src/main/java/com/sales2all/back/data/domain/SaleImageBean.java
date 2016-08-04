package com.sales2all.back.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by off on 03.08.2016.
 */

@Entity
@Table(name = "SALE_IMAGE")
public class SaleImageBean extends BaseBean {
    @Column(name = "FILE_NAME", nullable = false)
    private String fileName;
    @Column(name = "main")
    private boolean main = false;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "sale_id", nullable = false)
    private SaleBean sale;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public SaleBean getSale() {
        return sale;
    }

    public void setSale(SaleBean sale) {
        this.sale = sale;
    }
}
