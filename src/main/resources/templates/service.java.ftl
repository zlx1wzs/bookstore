package ${package.Service};

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package.Entity}.${entity};

import java.util.List;

/**
* <p>
    * ${table.comment!} 服务类接口
    * </p>
*
* @author ${author}
* @since ${date}
*/
public interface ${table.serviceName} extends IService<${entity}> {


Boolean add(${entity} ${table.entityPath});
Boolean update(${entity} ${table.entityPath});
void deleteByIds(String ids);
void updateUsefulByIds(String ids, Integer useful);
List<${entity}> list(String id);
Page<${entity}> page(Integer pageNum,Integer pageSize);
}