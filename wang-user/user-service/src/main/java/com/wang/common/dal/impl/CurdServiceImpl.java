package com.wang.common.dal.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.common.dal.CurdService;
import com.wang.common.utils.ConvertUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author wang
 * @version 1.0.0
 * @description TODO
 * @date 2022/12/24 06:44
 */
public abstract class CurdServiceImpl<M extends BaseMapper<T>, T, D, Q> extends ServiceImpl<M, T>
        implements CurdService<T, D, Q>{

    @Resource
    protected M baseDao;

    /**
     * 获取DTO class对象
     * 注意：这里从接口定义中获取第二个泛型的对象
     */
    protected Class<D> currentDtoClass() {
        return (Class<D>) ReflectionKit.getSuperClassGenericType(getClass(), 2);
    }

    /**
     * 抽象方法，需要子类实现自定义的查询条件对象内容组装
     * @param queryParam 查询对象
     * @return
     */
    public abstract QueryWrapper<T> getWrapper(Q queryParam);

    @Override
    public List<D> list(Q queryParam) {
        if (queryParam == null){
            return Collections.emptyList();
        }
        QueryWrapper<T> wrapper = getWrapper(queryParam);
        List<T> entityList = baseMapper.selectList(wrapper);
        return ConvertUtil.sourceToTarget(entityList, currentDtoClass());
    }

    @Override
    public T selectById(Serializable id) {
        return null;
    }

    @Override
    public D get(Long id) {
        return null;
    }

    @Override
    public D findOne(Q queryParam) {
        if (queryParam == null){
            return null;
        }
        QueryWrapper<T> wrapper = getWrapper(queryParam);
        T entity = baseMapper.selectOne(wrapper);
        return ConvertUtil.sourceToTarget(entity, currentDtoClass());
    }

    @Override
    public void saveDto(D dto) {
        T entity = ConvertUtil.sourceToTarget(dto, currentModelClass());
        this.save(entity);
        BeanUtils.copyProperties(entity, dto);
    }

    @Override
    public void save(List<D> dtos) {

    }

    @Override
    public void update(D dto) {

    }

    @Override
    public void update(List<D> dtos) {

    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public boolean deleteById(Serializable id) {
        return false;
    }
}
