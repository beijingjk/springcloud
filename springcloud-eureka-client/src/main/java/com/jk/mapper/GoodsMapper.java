package com.jk.mapper;

import com.jk.model.FruitsInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    List<FruitsInfo> queryGoodsList(FruitsInfo fruitsInfo, @Param("start") int i,@Param("pageSize") Integer pageSize);

    long queryGoodsCount(FruitsInfo fruitsInfo);

    List<FruitsInfo> queryGoodsThroughList(FruitsInfo fruitsInfo, @Param("start") int i,@Param("pageSize") Integer pageSize);

    long queryGoodsThroughCount(FruitsInfo fruitsInfo);

    List<FruitsInfo> queryGoodsRejectedList(FruitsInfo fruitsInfo, @Param("start") int i,@Param("pageSize") Integer pageSize);

    long queryGoodsRejectedCount(FruitsInfo fruitsInfo);

    void approved(String id);

 

    FruitsInfo queryAllPetById(String id);

    void auditing(FruitsInfo fruitsInfo);
}
