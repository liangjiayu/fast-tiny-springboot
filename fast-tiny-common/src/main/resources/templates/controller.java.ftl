package ${package.Controller};

import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.fast.tiny.common.api.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;


/**
 * @author ${author}
 * @since ${date}
 */

@Controller
@RequestMapping("/api/${table.entityPath}")
@Tag(name = "${table.controllerName}")
public class ${table.controllerName} {
    @Autowired
    ${table.serviceName} baseService;

    @GetMapping("/pageList")
    @ResponseBody
    @Operation(summary = "获取列表")
    public CommonResult<IPage<${entity}>> get${entity}ByPage() {
        IPage<${entity}> records = this.baseService.getListByPage();
        return CommonResult.success(records);
    }


    @PostMapping("/create")
    @ResponseBody
    @Operation(summary = "创建数据")
    public CommonResult<Integer> create${entity}(@RequestBody ${entity}SaveRequest xxxxxx) {
        Integer result = this.baseService.create${entity}();
        return CommonResult.success(result);
    }

    @PostMapping("/update")
    @ResponseBody
    @Operation(summary = "更新数据")
    public CommonResult<Boolean> update${entity}(@RequestBody ${entity}SaveRequest xxxxxx) {
        Boolean result = this.baseService.update${entity}();
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed("数据不存在");
    }

    @PostMapping("/delete")
    @ResponseBody
    @Operation(summary = "删除数据")
    public CommonResult<Boolean> delete${entity}(@Parameter() Integer id) {
        Boolean result = this.baseService.delete${entity}(id);
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed("数据不存在");
    }

}
