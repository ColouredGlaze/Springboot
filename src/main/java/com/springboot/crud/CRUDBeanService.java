package com.springboot.crud;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by MingT on 2017/7/17.
 */
@Service
public class CRUDBeanService {
    @Resource
    private CRUDBeanCrudRepository crudBeanCrudRepository;
    @Resource
    private CRUDBeanRepository crudBeanRepository;

    @Transactional
    public Iterable<CRUDBean> checkAll(){
        return crudBeanCrudRepository.findAll();
    }

    @Transactional
    public CRUDBean checkByName(String name){
        System.err.println("checkByNameBegin"+name);
        return crudBeanRepository.findByName(name);
    }

    @Transactional
    public void save(CRUDBean crudBean){
        crudBeanCrudRepository.save(crudBean);
    }
}
