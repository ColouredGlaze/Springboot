package com.springboot.crud;

import org.springframework.data.repository.Repository;

/**
 * Created by MingT on 2017/7/17.
 */
public interface CRUDBeanRepository extends Repository<CRUDBean,Long> {
    CRUDBean findByName(String name);
}
