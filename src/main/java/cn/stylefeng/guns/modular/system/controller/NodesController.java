package cn.stylefeng.guns.modular.system.controller;
import com.google.common.collect.Lists;
import cn.stylefeng.guns.modular.system.Bo.LineStyle;
import cn.stylefeng.guns.modular.system.Bo.LinksData;

import cn.stylefeng.guns.modular.system.Bo.NodesData;
import cn.stylefeng.guns.modular.system.Bo.VisualData;
import cn.stylefeng.guns.modular.system.model.Visual;
import cn.stylefeng.guns.modular.system.service.IVisualService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Nodes;
import cn.stylefeng.guns.modular.system.service.INodesService;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2020-03-27 15:37:17
 */
@Controller
@RequestMapping("/nodes")
public class NodesController extends BaseController {

    private String PREFIX = "/system/nodes/";

    @Autowired
    private INodesService nodesService;

    @Autowired
    private IVisualService visualService;

    @RequestMapping("visualData")
    @ResponseBody
    public VisualData visualData(){
        List<Nodes> nodesRes= nodesService.selectList(null);
        List<Visual> visualsRes=visualService.selectList(null);
        List<NodesData> nodesData=new ArrayList<>();
        List<LinksData> linksData=new ArrayList<>();
        for (Nodes nodesIn:nodesRes){
            NodesData nodes = new NodesData();
            nodes.setCategory(nodesIn.getCatycray());
            nodes.setName(nodesIn.getProjectname());
            nodes.setValue(nodesIn.getProjectcount());
            nodes.setSymbolSize(nodesIn.getProjectcount());
            nodesData.add(nodes);
        }
        for (Visual visualIn:visualsRes){
            LinksData links=new LinksData();
            LineStyle lineStyle =new LineStyle();
            lineStyle.setWidth(Integer.parseInt(visualIn.getSup()));
            links.setSource(visualIn.getSources());
            links.setTarget(visualIn.getTarget());
            links.setLineStyle(lineStyle);
            linksData.add(links);
        }

        VisualData res=new VisualData();
        res.setNodes(nodesData);
        res.setLinks(linksData);
        return res;
    }
    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "nodes.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/nodes_add")
    public String nodesAdd() {
        return PREFIX + "nodes_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/nodes_update/{nodesId}")
    public String nodesUpdate(@PathVariable Integer nodesId, Model model) {
        Nodes nodes = nodesService.selectById(nodesId);
        model.addAttribute("item",nodes);
        LogObjectHolder.me().set(nodes);
        return PREFIX + "nodes_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return nodesService.selectList(null);
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Nodes nodes) {
        nodesService.insert(nodes);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer nodesId) {
        nodesService.deleteById(nodesId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Nodes nodes) {
        nodesService.updateById(nodes);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{nodesId}")
    @ResponseBody
    public Object detail(@PathVariable("nodesId") Integer nodesId) {
        return nodesService.selectById(nodesId);
    }
}
