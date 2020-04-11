/**
 * 初始化详情对话框
 */
var VisualInfoDlg = {
    visualInfoData : {}
};

/**
 * 清除数据
 */
VisualInfoDlg.clearData = function() {
    this.visualInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
VisualInfoDlg.set = function(key, val) {
    this.visualInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
VisualInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
VisualInfoDlg.close = function() {
    parent.layer.close(window.parent.Visual.layerIndex);
}

/**
 * 收集数据
 */
VisualInfoDlg.collectData = function() {
    this
    .set('id')
    .set('sources')
    .set('target')
    .set('sup')
    .set('conf')
    .set('catycray');
}

/**
 * 提交添加
 */
VisualInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/visual/add", function(data){
        Feng.success("添加成功!");
        window.parent.Visual.table.refresh();
        VisualInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.visualInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
VisualInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/visual/update", function(data){
        Feng.success("修改成功!");
        window.parent.Visual.table.refresh();
        VisualInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.visualInfoData);
    ajax.start();
}

$(function() {

});
