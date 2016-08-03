package com.sales2all.back.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
}
