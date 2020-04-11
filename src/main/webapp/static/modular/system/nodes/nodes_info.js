/**
 * 初始化详情对话框
 */
var NodesInfoDlg = {
    nodesInfoData : {}
};

/**
 * 清除数据
 */
NodesInfoDlg.clearData = function() {
    this.nodesInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
NodesInfoDlg.set = function(key, val) {
    this.nodesInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
NodesInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
NodesInfoDlg.close = function() {
    parent.layer.close(window.parent.Nodes.layerIndex);
}

/**
 * 收集数据
 */
NodesInfoDlg.collectData = function() {
    this
    .set('id')
    .set('projectid')
    .set('projectname')
    .set('projectcount')
    .set('catycray');
}

/**
 * 提交添加
 */
NodesInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/nodes/add", function(data){
        Feng.success("添加成功!");
        window.parent.Nodes.table.refresh();
        NodesInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.nodesInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
NodesInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/nodes/update", function(data){
        Feng.success("修改成功!");
        window.parent.Nodes.table.refresh();
        NodesInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.nodesInfoData);
    ajax.start();
}

$(function() {

});
