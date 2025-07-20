package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author ${author}
 * @since ${date}
 */
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {
    IPage<${entity}> getListByPage();

    Integer create${entity}();

    Boolean update${entity}();

    Boolean delete${entity}(Integer id);
}
