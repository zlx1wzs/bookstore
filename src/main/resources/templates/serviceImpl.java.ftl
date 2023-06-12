package ${package.ServiceImpl};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${package.Mapper}.${table.mapperName};
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* <p>
    * ${table.comment!} 服务层实现类
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Service
public class ${table.serviceImplName} extends ServiceImpl<${table.mapperName},${entity}> implements ${table.serviceName} {


@Override
public Boolean add(${entity} ${table.entityPath}) {
${table.entityPath}.setCreateTime(DateTool.getCurrTime());

this.save(${table.entityPath});
return true;
}

@Override
public Boolean update(${entity} ${table.entityPath}) {
this.updateById(${table.entityPath});
return true;
}

@Override
public void deleteByIds(String ids) {
List
<String> listIds = new ArrayList<>();
    String[] aryIds = ids.split(",");
    for(String id: aryIds){
    listIds.add(id);
    }
    this.removeByIds(listIds);
    }

    @Override
    public void updateUsefulByIds(String ids, Integer useful) {
    //ids 若干个id 用逗号隔开
    String[] aryIds = ids.split(",");
    for(String id: aryIds){

    //修改的value
    ${entity} ${table.entityPath} = new ${entity}();


    //修改的条件
    UpdateWrapper<${entity}> updateWrapper = new UpdateWrapper<>();
    updateWrapper.eq("id",id);

    //执行
    this.update(${table.entityPath},updateWrapper);
    }
    }

    @Override
    public List<${entity}> list(String id ) {
    return this.list(id);
    }

    @Override
    public Page<${entity}> page(Integer pageNum,Integer pageSize) {
    Page<${entity}> page = new Page(pageNum,pageSize);
    return this.page(page);
    }
    }
