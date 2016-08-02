package com.sales2all.back.data.dao.impl;

import com.sales2all.back.data.dao.IBaseDao;
import com.sales2all.back.data.domain.BaseBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yahor_Fralou on 8/2/2016.
 */

@Repository
public class BaseDaoImpl<T extends BaseBean> implements IBaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public List<T> listAll(Class cls) {
        return getSession().createCriteria(cls).list();
    }

    @Override
    public T getById(Class<T> cls, String id) {
        return (T) getSession().get(cls, id);
    }

    @Override
    public void save(T obj) {
        getSession().merge(obj);
    }

    @Override
    public void save(List<T> list) {
        for (T bean : list) {
            save(bean);
        }
    }

    @Override
    public void delete(T object) {
        getSession().delete(object);
    }

    @Override
    public void delete(List<T> list) {
        for (T bean : list) {
            delete(bean);
        }
    }

}
