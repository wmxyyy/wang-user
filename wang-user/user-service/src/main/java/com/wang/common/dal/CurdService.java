package com.wang.common.dal;

import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.List;

/**
 * @author wang
 * @version 1.0.0
 * @description 扩展MybatisPlus的IService接口
 * @date 2022/12/24 06:00
 */
public interface CurdService<T, D, Q> extends IService<T> {

    /**
     * 列表查询
     * @param queryParam
     */
    List<D> list(Q queryParam);

    /**
     * 根据ID查询
     * @param id
     */
    T selectById(Serializable id);

    /**
     * 根据id查询
     * @param id id
     */
    D get(Long id);

    /**
     * 单表查询
     * @param queryParam
     */
    D findOne(Q queryParam);

    /**
     * 单个保存，会更新入参的id字段
     * @param dto
     */
    void saveDto(D dto);

    /**
     * 多个保存，会更新入参的id字段
     * @param dtos
     */
    void save(List<D> dtos);

    /**
     * 单个更新
     * @param dto
     */
    void update(D dto);

    /**
     * 多个更新
     * @param dtos
     */
    void update(List<D> dtos);

    /**
     * 批量id删除
     * @param ids
     */
    void delete(Long[] ids);

    /**
     * 根据id删除
     * @param id 主键id
     */
    boolean deleteById(Serializable id);

}
