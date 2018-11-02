package com.jk.service;

import com.jk.mapper.GoodsMapper;
import com.jk.model.FruitsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsServiceApi{
    @Autowired
    private GoodsMapper goodsmapper;

    @Override
    public List<FruitsInfo> queryGoodsList(FruitsInfo fruitsInfo, Integer start, Integer pageSize) {
        return goodsmapper.queryGoodsList(fruitsInfo,(start-1)*pageSize,pageSize);
    }

    @Override
    public long queryGoodsCount(FruitsInfo fruitsInfo) {
        return goodsmapper.queryGoodsCount(fruitsInfo);
    }

    @Override
    public List<FruitsInfo> queryGoodsThroughList(FruitsInfo fruitsInfo, Integer start, Integer pageSize) {
        return goodsmapper.queryGoodsThroughList(fruitsInfo,(start-1)*pageSize,pageSize);    }

    @Override
    public long queryGoodsThroughCount(FruitsInfo fruitsInfo) {
        return goodsmapper.queryGoodsThroughCount(fruitsInfo);
    }

    @Override
    public List<FruitsInfo> queryGoodsRejectedList(FruitsInfo fruitsInfo, Integer start, Integer pageSize) {
        return goodsmapper.queryGoodsRejectedList(fruitsInfo,(start-1)*pageSize,pageSize);
    }

    @Override
    public long queryGoodsRejectedCount(FruitsInfo fruitsInfo) {
        return goodsmapper.queryGoodsRejectedCount(fruitsInfo);
    }

    @Override
    public void approved(String id) {
        goodsmapper.approved(id);
    }



    @Override
    public FruitsInfo queryAllPetById(String id) {
        return goodsmapper.queryAllPetById(id);
    }

    @Override
    public void auditing(FruitsInfo fruitsInfo) {
        goodsmapper.auditing(fruitsInfo);
    }
}
