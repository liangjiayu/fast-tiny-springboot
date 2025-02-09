package ${package.Controller};

import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.fast.tiny.common.api.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;


/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */

@Controller
@RequestMapping("/${table.entityPath}")
public class ${table.controllerName} {
    @Autowired
    ${table.serviceName} baseService;

    @GetMapping("/list")
    @ResponseBody
    @Operation(summary = "获取列表")
    public CommonResult<IPage<${entity}>> list() {
        IPage<${entity}> records = this.baseService.getPage();
        return CommonResult.success(records);
    }


    @PostMapping("/create")
    @ResponseBody
    @Operation(summary = "创建数据")
    public CommonResult<Integer> create() {
        int result = this.baseService.create();
        return CommonResult.success(result);
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    @Operation(summary = "更新数据")
    public CommonResult<Boolean> update(@PathVariable("id") int id) {
        boolean result = this.baseService.update(id);
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed("数据不存在");
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    @Operation(summary = "删除数据")
    public CommonResult<Boolean> delete(@PathVariable int id) {
        boolean result = this.baseService.delete(id);
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed("数据不存在");
    }

}
