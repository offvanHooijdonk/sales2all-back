package com.sales2all.back.data.domain;

import javax.persistence.*;

/**
 * Created by Yahor_Fralou on 8/2/2016.
 */
@MappedSuperclass
public class BaseBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals( Object obj) {
        return obj != null && obj instanceof BaseBean && this.getId().equals(((BaseBean) obj).getId());
    }
}
