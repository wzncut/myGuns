/**
 * 管理初始化
 */
var Nodes = {
    id: "NodesTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Nodes.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'projectid', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'projectname', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'projectcount', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'catycray', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Nodes.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Nodes.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
Nodes.openAddNodes = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/nodes/nodes_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
Nodes.openNodesDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/nodes/nodes_update/' + Nodes.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
Nodes.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/nodes/delete", function (data) {
            Feng.success("删除成功!");
            Nodes.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("nodesId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询列表
 */
Nodes.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Nodes.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Nodes.initColumn();
    var table = new BSTable(Nodes.id, "/nodes/list", defaultColunms);
    table.setPaginationType("client");
    Nodes.table = table.init();
});
