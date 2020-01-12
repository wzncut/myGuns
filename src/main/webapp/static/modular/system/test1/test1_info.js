/**
 * 初始化test1详情对话框
 */
var Test1InfoDlg = {
    test1InfoData : {}
};

/**
 * 清除数据
 */
Test1InfoDlg.clearData = function() {
    this.test1InfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Test1InfoDlg.set = function(key, val) {
    this.test1InfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Test1InfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Test1InfoDlg.close = function() {
    parent.layer.close(window.parent.Test1.layerIndex);
}

/**
 * 收集数据
 */
Test1InfoDlg.collectData = function() {
    this
    .set('aaa')
    .set('bbb');
}

/**
 * 提交添加
 */
Test1InfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/test1/add", function(data){
        Feng.success("添加成功!");
        window.parent.Test1.table.refresh();
        Test1InfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.test1InfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Test1InfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/test1/update", function(data){
        Feng.success("修改成功!");
        window.parent.Test1.table.refresh();
        Test1InfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.test1InfoData);
    ajax.start();
}

$(function() {

});
