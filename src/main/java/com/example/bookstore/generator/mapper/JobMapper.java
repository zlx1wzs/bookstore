package com.example.bookstore.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bookstore.generator.entity.Job;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wzs
 * @since 2023-05-24
 */
public interface JobMapper extends BaseMapper<Job> {
    @Select("SELECT a.* FROM job a  WHERE a.now='1'")
    List<Job> now();

    @Select("update  job  set now= replace(now, '1', '0') WHERE job.id=#{id}")
    List<Job> upnow(String id);


}
