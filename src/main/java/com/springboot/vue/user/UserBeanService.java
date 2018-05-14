package com.springboot.vue.user;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserBeanService {

    @Resource
    private UserBeanCrudRepository userBeanCrudRepository;

    public Iterable<UserBean> searchAllUser() {
        return userBeanCrudRepository.findAll();
    }

    public UserBean addOneUser(UserBean newUserBean) {
        return userBeanCrudRepository.save(newUserBean);
    }

    public boolean deleteUser(Long id) {
        UserBean userBean = userBeanCrudRepository.findOne(id);
        if (userBean == null) {
            return false;
        }
        try {
            userBeanCrudRepository.delete(userBean);
            return true;
        } catch (Exception e) {
            System.err.println("删除用户失败：" + e.getMessage());
            return false;
        }
    }

    public UserBean preciseSearchByName(String name) {
        return userBeanCrudRepository.findByName(name);
    }

    public List<UserBean> fuzzySearchByName(String name) {
        return userBeanCrudRepository.findByNameLike("%" + name + "%");
    }

    public List<UserBean> conditionsSearch(String name, String sex, Integer age) {
        if (name.isEmpty() && sex.isEmpty()) {
            //名字和性别为空，只根据年龄查询
            return userBeanCrudRepository.findByAgeGreaterThan(age);
        } else {
            if (name.isEmpty()) {
                //名字为空，根据性别和年龄查询
                return userBeanCrudRepository.findBySexAndAgeGreaterThan(sex, age);
            } else if (sex.isEmpty()) {
                //性别为空，根据名字和年龄查询
                return userBeanCrudRepository.findByNameLikeAndAgeGreaterThan("%" + name + "%", age);
            } else {
                //性别和姓名均不为空，根据性别、姓名和年龄查询
                return userBeanCrudRepository.findByNameLikeAndSexAndAgeGreaterThan("%" + name + "%", sex, age);
            }
        }
    }

    public UserBean updateUser(UserBean userBean) {
        return  userBeanCrudRepository.save(userBean);
    }
}
