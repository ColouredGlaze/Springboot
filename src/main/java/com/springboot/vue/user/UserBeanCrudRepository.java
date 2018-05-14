package com.springboot.vue.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserBeanCrudRepository extends CrudRepository<UserBean, Long>{
    UserBean findByName(String name);
    UserBean findByRanking(Integer ranking);
    List<UserBean> findByNameLike(String name);
    List<UserBean> findByAgeGreaterThan(Integer age);
    List<UserBean> findBySexAndAgeGreaterThan(String name, Integer age);
    List<UserBean> findByNameLikeAndAgeGreaterThan(String name, Integer age);
    List<UserBean> findByNameLikeAndSexAndAgeGreaterThan(String name, String sex, Integer age);
}
