package com.sales2all.back.data.service;

import com.sales2all.back.data.domain.SaleImageBean;

/**
 * Created by Yahor_Fralou on 8/4/2016.
 */
public interface ISaleImageService extends IBaseService<SaleImageBean> {
    String getImagePath(String fileName);
}
