package com.springboot.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MingT on 2017/7/12.
 */
@Service
public class JHBeanService {

    @Autowired
    public void setJhBeanRepository(JHBeanRepository jhBeanRepository) {
        this.jhBeanRepository = jhBeanRepository;
    }

    private JHBeanRepository jhBeanRepository;

    @Transactional
    public void save(JHBean jhBean){
        jhBeanRepository.save(jhBean);
    }
}
