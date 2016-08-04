package com.sales2all.back.data.service;

import com.sales2all.back.data.domain.BaseBean;

import java.util.List;

/**
 * Created by Yahor_Fralou on 8/2/2016.
 */
public interface IBaseService<T extends BaseBean> {
    List<T> listAll();

    T getById(Long id);

    void save(T bean);
    void save(List<T> list);
    void delete(T bean);
    void delete(List<T> list);

}
