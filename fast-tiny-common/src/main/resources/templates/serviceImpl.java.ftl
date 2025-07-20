package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author ${author}
 * @since ${date}
 */
@Service
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Autowired
    ${table.mapperName} baseMapper;

    @Override
    public IPage<${entity}> getListByPage() {
        Page<${entity}> page = new Page<>(1, 10);
        LambdaQueryWrapper<${entity}> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        return this.baseMapper.selectPage(page, lambdaQueryWrapper);
    }

    @Override
    public Integer create${entity}() {
        ${entity} record = new ${entity}();
        record.setId(null);
        this.baseMapper.insert(record);

        return record.getId();
    }

    @Override
    public Boolean update${entity}() {
        ${entity} record  = new ${entity}();

        return this.baseMapper.updateById(record) > 0;
    }

    @Override
    public Boolean delete${entity}(Integer id) {
        return this.baseMapper.deleteById(id) > 0;
    }

}


