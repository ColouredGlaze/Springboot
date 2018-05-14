package com.springboot.jpa;

import org.springframework.data.repository.CrudRepository;

/**
 * 在CrudRepository自带常用的增、删、改、查方法
 * 这样一个Dao就Finish咯
 * Created by MingT on 2017/7/12.
 */
public interface JHBeanRepository extends CrudRepository<JHBean, Long> {
/*
 * 在Spring Data的核心接口里面Repository是最基本的接口了, spring提供了很多实现了该接口的基本接口,
 * 如:CrudRepository，PagingAndSortingRepository，SimpleJpaRepository，QueryDslJpaRepository等大量查询接口
 */
}

