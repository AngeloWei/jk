package cn.zw.jk.web;

import cn.zw.jk.dto.BaseResult;
import cn.zw.jk.entity.Export;
import cn.zw.jk.service.ExportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller

@RequestMapping("/export")
public class ExportController {
    @Resource
    private ExportService exportService;
    @RequestMapping(value = "/insert",consumes = "Application/json;charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult insert(@RequestBody Export export) {
        exportService.insert(export);
        return new BaseResult();
    }
    @RequestMapping(value="/update",consumes = "Application/json;charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult update(@RequestBody Export export) {
        exportService.update(export);
        return new BaseResult();
    }
    @RequestMapping(value = "/changeState",method = RequestMethod.GET)
    @ResponseBody
    public BaseResult changeState(String exportId, short state) {
        exportService.updateState(exportId,state);
        return new BaseResult();
    }

}
