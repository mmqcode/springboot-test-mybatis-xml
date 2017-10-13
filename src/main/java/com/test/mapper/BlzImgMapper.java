package com.test.mapper;

import com.test.entity.BlzImgEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/9/1.
 */
public interface BlzImgMapper {

    List<BlzImgEntity> getAll();

    BlzImgEntity getOne(String id);

    void insert(BlzImgEntity user);

    void update(BlzImgEntity user);

    void delete(String id);

}
