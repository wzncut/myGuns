/**
 * 管理初始化
 */
var Visual = {
    id: "VisualTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Visual.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'sources', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'target', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'sup', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'conf', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'catycray', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Visual.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Visual.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
Visual.openAddVisual = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/visual/visual_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
Visual.openVisualDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/visual/visual_update/' + Visual.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
Visual.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/visual/delete", function (data) {
            Feng.success("删除成功!");
            Visual.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("visualId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询列表
 */
Visual.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Visual.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Visual.initColumn();
    var table = new BSTable(Visual.id, "/visual/list", defaultColunms);
    table.setPaginationType("client");
    Visual.table = table.init();
});
