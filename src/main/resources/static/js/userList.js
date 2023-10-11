$(document).ready(function () { begin() })
function begin() {
    $.get("../user/getAll",
        function (data) { writeAll(data) },
        "JSON")
}

function writeAll(data) {
    let usersHtml = "<table class=\"providerTable\" cellpadding=\"0\" cellspacing=\"0\">\n" +
        "                <tr class=\"firstTr\">\n" +
        "                    <th width=\"10%\">人员类型</th>\n" +
        "                    <th width=\"20%\">法人名称</th>\n" +
        "                    <th width=\"10%\">代理人名称</th>\n" +
        "                    <th width=\"10%\">地址</th>\n" +
        "                    <th width=\"10%\">邮编</th>\n" +
        "                    <th width=\"10%\">电话</th>\n" +
        "                    <th width=\"10%\">银行账户</th>\n" +
        "                    <th width=\"10%\">开户行</th>\n" +
        "                    <th width=\"20%\">操作</th>\n" +
        "                </tr>\n";
    if (data != null) {
        let yonghu = eval(data);
        for (let i = 0; i < yonghu.length; i++) {
            let type = "甲方";
            if (yonghu[i]["uType"] == 'B') {
                type = "乙方";
            }
            usersHtml += "                <tr>\n" +
                "                    <td>" + type + "</td>\n" +
                "                    <td>" + yonghu[i]["legalName"] + "</td>\n" +
                "                    <td>" + yonghu[i]["agentName"] + "</td>\n" +
                "                    <td>" + yonghu[i]["place"] + "</td>\n" +
                "                    <td>" + yonghu[i]["zipcode"] + "</td>\n" +
                "                    <td>" + yonghu[i]["phone"] + "</td>\n" +
                "                    <td>" + yonghu[i]["bankId"] + "</td>\n" +
                "                    <td>" + yonghu[i]["bankPlace"] + "</td>\n" +
                "                    <td>\n" +
                "                        <a href=\"./userModify.html?peopleId=" + yonghu[i]["peopleId"] + "\"><img src=\"../img/xiugai.png\" alt=\"修改\" title=\"修改\"/></a>\n" +
                "                        <a href=\"javascript:delUser(\'" + yonghu[i]["peopleId"] + "\')\" class=\"removeUser\"><img src=\"../img/schu.png\" alt=\"删除\" title=\"删除\"/></a>\n" +
                "                    </td>\n" +
                "                </tr>\n"
        }
    }
    else { usersHtml += "<tr><td colspan=8>没有用户</td></tr>" }
    usersHtml += "</table>"
    $("#allBody").html(usersHtml);
}
function delUser(uid) {
    $.ajax(
        {
            type:"POST",
            url:"../user/del",
            data:{'id':uid},
            success:function(msg){
                if(msg){
                    alert("删除成功")
                }else{
                    alert("删除失败")
                }
                location.reload();
            },
            error:function(emsg){
                alert("删除失败，请确保合同中没有该用户");

            }
        }
    )
}
$("#searchButton").click(search)
function search(){
    var legalName = $("#searchByName").val();
    $.ajax({
        type:"POST",
        url:"../user/searchName",
        data:{'legalName':legalName},
        success:function (data){writeAll(data)}
    })
}