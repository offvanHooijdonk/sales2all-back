package com.sales2all.back.data.service.impl;

import com.sales2all.back.data.dao.IBaseDao;
import com.sales2all.back.data.domain.SaleBean;
import com.sales2all.back.data.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yahor_Fralou on 8/2/2016.
 */

@Service
public class SaleServiceImpl implements ISaleService {

    @Autowired
    @Qualifier(value = "baseDaoImpl")
    private IBaseDao<SaleBean> dao;

    @Override
    @Transactional
    public List<SaleBean> listAll() {
        return dao.listAll(SaleBean.class);
    }

    @Override
    @Transactional
    public SaleBean getById(Long id) {
        return dao.getById(SaleBean.class, id);
    }

    @Override
    @Transactional
    public void save(SaleBean bean) {
        dao.save(bean);
    }

    @Override
    @Transactional
    public void save(List<SaleBean> list) {
        dao.save(list);
    }

    @Override
    @Transactional
    public void delete(SaleBean bean) {
        dao.delete(bean);
    }

    @Override
    @Transactional
    public void delete(List<SaleBean> list) {
        dao.delete(list);
    }
}
