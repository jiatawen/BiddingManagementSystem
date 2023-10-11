function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

$(document).ready(function () {
    start();
})

function start() {
    $.get("../user/getAll",
        function (data) { writeUsers(data) },
        "JSON");

    var id = getUrlParam("contractId");
    if (id != null) {
        getContract(id);
    }
}

function getContract(id) {
    $.ajax({
        url: "../contract/getById",
        type: "POST",
        async: false,
        data: { "id": id },
        success: function (data) { writeContract(data) },
        error: function () { alert("数据库连接失败") }
    })
}

function writeUsers(data) {
    var users = eval(data);
    if (users != null) {
        let AHtml = "";
        let BHtml = "";
        for (let i = 0; i < users.length; i++) {

            if (users[i]["uType"] == "A") {
                AHtml += "<option value=\"" + users[i]["peopleId"] + "\">" + users[i]["legalName"] + "</option>";
            } else if (users[i]["uType"] == "B") {
                BHtml += "<option value=\"" + users[i]["peopleId"] + "\">" + users[i]["legalName"] + "</option>";
            }
        }
        $("#partyAId").html(AHtml);
        $("#partyBId").html(BHtml);
    }
}

function writeContract(data) {
    var contract = eval(data);
    $("#contractId").val(contract["contractId"]);
    setTimeout(function () {
        $("#partyAId").find("option[value='" + contract["partyAId"] + "']").prop('selected', 'selected')
        $("#partyBId").find("option[value='" + contract["partyBId"] + "']").prop('selected', 'selected')
    })
    $("#createDate").val(contract["createDate"].substring(0,10))
    $("#modifyDate").val(contract["modifyDate"].substring(0,10))
    $("#endDate").val(contract["endDate"].substring(0,10))
    $("#uAMoney").val(contract["uAMoney"])
    $("#contractUid").val(contract["contractUid"])
    $("#title").val(contract["title"])
    $("#name").val(contract["name"])
    $("#place").val(contract["place"])
    $("#scale").val(contract["scale"])
    $("#clause").val(contract["clause"])
    $("#breach").val(contract["breach"])
    $("#supplement").val(contract["supplement"])
    $("#uBPower").val(contract["uBPower"])
    $("#uBObligation").val(contract["uBObligation"])
}

$("#sub").click(function(){subMess()})

function subMess(){
    let errm = "修改失败"
    let link = "../contract/modify";
    if(getUrlParam("contractId") == null){
        link = "../contract/insert"
        errm = "插入失败"
    }
    $.ajax({
        url:u=link,
        async:false,
        type:"POST",
        data:$("#frm").serialize(),
        success:function(data){
            window.location.href=document.referrer;
        },
        error:function(){
            alert(errm)
        }
    })
}