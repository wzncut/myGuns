package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Test1;
import cn.stylefeng.guns.modular.system.service.ITest1Service;

/**
 * test1控制器
 *
 * @author fengshuonan
 * @Date 2020-01-12 16:38:55
 */
@Controller
@RequestMapping("/test1")
public class Test1Controller extends BaseController {

    private String PREFIX = "/system/test1/";

    @Autowired
    private ITest1Service test1Service;

    /**
     * 跳转到test1首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "test1.html";
    }

    /**
     * 跳转到添加test1
     */
    @RequestMapping("/test1_add")
    public String test1Add() {
        return PREFIX + "test1_add.html";
    }

    /**
     * 跳转到修改test1
     */
    @RequestMapping("/test1_update/{test1Id}")
    public String test1Update(@PathVariable Integer test1Id, Model model) {
        Test1 test1 = test1Service.selectById(test1Id);
        model.addAttribute("item",test1);
        LogObjectHolder.me().set(test1);
        return PREFIX + "test1_edit.html";
    }

    /**
     * 获取test1列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return test1Service.selectList(null);
    }

    /**
     * 新增test1
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Test1 test1) {
        test1Service.insert(test1);
        return SUCCESS_TIP;
    }

    /**
     * 删除test1
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer test1Id) {
        test1Service.deleteById(test1Id);
        return SUCCESS_TIP;
    }

    /**
     * 修改test1
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Test1 test1) {
        test1Service.updateById(test1);
        return SUCCESS_TIP;
    }

    /**
     * test1详情
     */
    @RequestMapping(value = "/detail/{test1Id}")
    @ResponseBody
    public Object detail(@PathVariable("test1Id") Integer test1Id) {
        return test1Service.selectById(test1Id);
    }
}
