package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.guns.modular.system.Bo.LineStyle;
import cn.stylefeng.guns.modular.system.Bo.LinksData;
import cn.stylefeng.guns.modular.system.Bo.VisualData;
import cn.stylefeng.guns.modular.system.model.Nodes;
import cn.stylefeng.guns.modular.system.service.INodesService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Visual;
import cn.stylefeng.guns.modular.system.service.IVisualService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2020-03-27 15:37:24
 */
@Controller
@RequestMapping("/visual")
public class VisualController extends BaseController {
    private String PREFIX = "/system/visual/";

    @Autowired
    private INodesService nodesService;

    @Autowired
    private IVisualService visualService;
    @RequestMapping("supConfVisual")
    @ResponseBody
    public List<List<Double>> supConfVisual(){
        List<Visual> visualsRes=visualService.selectList(null);
        List<List<Double>> data = new LinkedList<>();
        for (Visual visualIn:visualsRes){
            List<Double> inerData=new LinkedList<>();
            inerData.add(Double.parseDouble(visualIn.getSup()));
            inerData.add(Double.parseDouble(visualIn.getConf()));
            data.add(inerData);
        }
        return data;
    }
    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "visual.html";
    }


    /**
     * 跳转到添加
     */
    @RequestMapping("/visual_add")
    public String visualAdd() {
        return PREFIX + "visual_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/visual_update/{visualId}")
    public String visualUpdate(@PathVariable Integer visualId, Model model) {
        Visual visual = visualService.selectById(visualId);
        model.addAttribute("item",visual);
        LogObjectHolder.me().set(visual);
        return PREFIX + "visual_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return visualService.selectList(null);
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Visual visual) {
        visualService.insert(visual);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer visualId) {
        visualService.deleteById(visualId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Visual visual) {
        visualService.updateById(visual);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{visualId}")
    @ResponseBody
    public Object detail(@PathVariable("visualId") Integer visualId) {
        return visualService.selectById(visualId);
    }
}
