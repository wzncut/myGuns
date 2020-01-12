/**
 * test1管理初始化
 */
var Test1 = {
    id: "Test1Table",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Test1.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'aaa', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'bbb', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Test1.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Test1.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加test1
 */
Test1.openAddTest1 = function () {
    var index = layer.open({
        type: 2,
        title: '添加test1',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/test1/test1_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看test1详情
 */
Test1.openTest1Detail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'test1详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/test1/test1_update/' + Test1.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除test1
 */
Test1.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/test1/delete", function (data) {
            Feng.success("删除成功!");
            Test1.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("test1Id",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询test1列表
 */
Test1.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Test1.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Test1.initColumn();
    var table = new BSTable(Test1.id, "/test1/list", defaultColunms);
    table.setPaginationType("client");
    Test1.table = table.init();
});
