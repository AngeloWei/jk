package cn.zw.jk.web;

import cn.zw.jk.entity.Factory;
import cn.zw.jk.service.FactoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FactoryController {
    @Resource
    private FactoryService factoryService;

    /*
     访问Factory列表
     */
    @RequestMapping(value = "/basicinfo/factory/list.action",method = RequestMethod.GET)
    public String FactoryList(Model model){
        List<Factory> factoryList = factoryService.find(null);
        model.addAttribute("dataList",factoryList);

        return "basicinfo/factory/jFactoryList.jsp";
    }

    /*
    更新Factory信息
     */
    @RequestMapping(value = "/basicinfo/factory/update.action",method = RequestMethod.POST)
    public String updateFactoryInfo(int id,Factory factory){
            factory.setFactoryID(id);
            factoryService.update(factory);
        return "redirect:/basicinfo/factory/list.action";
    }
    /*
    跳到更新页面
     */
    @RequestMapping(value = "/basicinfo/factory/toupdate.action",method = RequestMethod.POST)
    public  String toUpdateFactoryInfo(String id,Model model){
        Factory factory = factoryService.get(id);
        model.addAttribute("obj",factory);
        return "/basicinfo/factory/jFactoryUpdate.jsp" ;
    }
    /*
    跳转到新增页面
     */
    @RequestMapping(value = "/basicinfo/factory/tocreate.action",method = RequestMethod.POST)
    public String toInsertFactory(){
        return "/basicinfo/factory/jFactoryCreate.jsp" ;
    }
    /*
    insert factory
     */
    @RequestMapping("/basicinfo/factory/insert.action")
    public  String InsertFactory(Factory factory){
        factoryService.insert(factory);
        return "redirect:/basicinfo/factory/list.action" ;
    }

    /*
    删除单个工厂
     */
    @RequestMapping("/basicinfo/factory/deleteById.action")
    public String deleteById(String id){
        factoryService.deleteById(id);
        return "redirect:/basicinfo/factory/list.action";
    }
    /*
    删除多个工厂
     */
    @RequestMapping("/basicinfo/factory/delete.action")
    public String deleteFactory(@RequestParam("id") String[] ids){
        factoryService.delete(ids);
        return "redirect:/basicinfo/factory/list.action";
    }
    /*
    启用工厂
     */
    @RequestMapping("/basicinfo/factory/start.action")
    public String startFacotory(@RequestParam("id") String[] ids){
        Map map = new HashMap();
        map.put("state",1);
        map.put("ids",ids);
        factoryService.updateState(map);
        return "redirect:/basicinfo/factory/list.action";
    }
    @RequestMapping("/basicinfo/factory/stop.action")
    public String stopFacotory(@RequestParam("id") String[] ids){
        Map map = new HashMap();
        map.put("state",0);
        map.put("ids",ids);
        factoryService.updateState(map);
        return "redirect:/basicinfo/factory/list.action";
    }
}
