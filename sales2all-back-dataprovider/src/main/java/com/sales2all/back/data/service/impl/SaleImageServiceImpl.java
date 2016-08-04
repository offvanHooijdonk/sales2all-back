package com.sales2all.back.data.service.impl;

import com.sales2all.back.data.dao.IBaseDao;
import com.sales2all.back.data.domain.SaleBean;
import com.sales2all.back.data.domain.SaleImageBean;
import com.sales2all.back.data.service.ISaleImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

/**
 * Created by Yahor_Fralou on 8/4/2016.
 */

@Service
public class SaleImageServiceImpl implements ISaleImageService {
    @Value("${path.images.sale}")
    private String pathSaleImage;

    @Autowired
    @Qualifier(value = "baseDaoImpl")
    private IBaseDao<SaleImageBean> dao;

    @Deprecated
    @Override
    public List<SaleImageBean> listAll() {
        return null;
    }

    @Override
    @Transactional
    public SaleImageBean getById(Long id) {
        return dao.getById(SaleImageBean.class, id);
    }

    @Override
    @Transactional
    public void save(SaleImageBean bean) {
        dao.save(bean);
    }

    @Override
    public void save(List<SaleImageBean> list) {

    }

    @Override
    public void delete(SaleImageBean bean) {

    }

    @Override
    public void delete(List<SaleImageBean> list) {

    }

    @Override
    public String getImagePath(String fileName) {
        String path = pathSaleImage + "/" + fileName;
        File file = new File(path);
        path = file.exists() ? path : null;

        return path;
    }
}
