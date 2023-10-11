$(document).ready(function () { begin() })
function begin() {
    $.get("../contract/getAll",
        function (data) { writeAll(data) },
        "JSON")
}



function writeAll(data) {
    let contractsHtml = "<table class=\"providerTable\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "                <tr class=\"firstTr\">\n" +
        "                    <th width=\"10%\">合同编号</th>\n" +
        "                    <th width=\"10%\">合同标题</th>\n" +
        "                    <th width=\"15%\">甲方</th>\n" +
        "                    <th width=\"15%\">乙方</th>\n" +
        "                    <th width=\"10%\">金额</th>\n" +
        "                    <th width=\"10%\">项目名称</th>\n" +
        "                    <th width=\"10%\">签订日期</th>\n" +
        "                    <th width=\"10%\">截至日期</th>\n" +
        "                    <th width=\"20%\">操作</th>\n" +
        "                </tr>\n";
    if (data != null) {
        let contracts = eval(data);
        for (let i = 0; i < contracts.length; i++) {
            var aName;
            var bName;
            $.ajax({
                url: "../user/getById",
                type: "POST",
                data: { "id": contracts[i]["partyAId"] },
                async: false,
                success: function (udata) { aName = eval(udata)["legalName"] }
            })
            $.ajax({
                url: "../user/getById",
                type: "POST",
                data: { "id": contracts[i]["partyBId"] },
                async: false,
                success: function (udata) { bName = eval(udata)["legalName"] }
            })
            contractsHtml += "                <tr>\n" +
                "                    <td>" + contracts[i]["contractUid"] + "</td>\n" +
                "                    <td>" + contracts[i]["title"] + "</td>\n" +
                "                    <td>" + aName + "</td>\n" +
                "                    <td>" + bName + "</td>\n" +
                "                    <td>" + contracts[i]["uAMoney"] + "</td>\n" +
                "                    <td>" + contracts[i]["name"] + "</td>\n" +
                "                    <td>" + contracts[i]["createDate"].substring(0, 10) + "</td>\n" +
                "                    <td>" + contracts[i]["endDate"].substring(0, 10) + "</td>\n" +
                "                    <td>\n" +
                "                        <a href=\"./contractView.html?contractId=" + contracts[i]["contractId"] + "\"><img src=\"../img/read.png\" alt=\"修改\" title=\"修改\"/></a>\n" +
                "                        <a href=\"./contractModify.html?contractId=" + contracts[i]["contractId"] + "\"><img src=\"../img/xiugai.png\" alt=\"修改\" title=\"修改\"/></a>\n" +
                "                        <a href=\"javascript:delContract(\'" + contracts[i]["contractId"] + "\')\" class=\"removeUser\"><img src=\"../img/schu.png\" alt=\"删除\" title=\"删除\"/></a>\n" +
                "                    </td>\n" +
                "                </tr>\n"
        }
    }
    else { contractsHtml += "<tr><td colspan=8>没有合同</td></tr>" }
    contractsHtml += "</table>"
    $("#allBody").html(contractsHtml);
}
function delUser(uid) {
    $.ajax(
        {
            type: "POST",
            url: "../user/del",
            data: { 'id': uid },
            success: function (msg) {
                if (msg) {
                } else {
                    alert("删除失败")
                }
                location.reload();
            },
            error: function (emsg) {
                alert("删除失败，请确保合同中没有该用户");

            }
        }
    )
}
$("#searchButton").click(search)
function search() {
    var legalName = $("#searchByName").val();
    $.ajax({
        type: "POST",
        url: "../user/searchName",
        data: { 'legalName': legalName },
        success: function (data) { writeAll(data) }
    })
}

function delContract(id) {
    $.ajax({
        url: "../contract/del",
        data: { "id": id },
        type: "POST",
        success: function (data) {
            if (!data) {
                alert("删除失败")
                
            }
            location.reload();
        },
        error: function () { alert("删除失败") }
    })
}

$("#searchButton").click(search)
function search(){
    var title = $("#searchByName").val();
    $.ajax({
        type:"POST",
        url:"../contract/searchName",
        data:{'title':title},
        success:function (data){writeAll(data)}
    })
}