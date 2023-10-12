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
    check();
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
            let mess = "";
            if (users[i]["peopleId"] == 1 || users[i]["peopleId"] == 2) {
                mess = "<span style=\"color:red;\">(本单位)</span>";
            }
            if (users[i]["uType"] == "A") {
                AHtml += "<option value=\"" + users[i]["peopleId"] + "\">" + users[i]["legalName"] + mess + "</option>";
            } else if (users[i]["uType"] == "B") {
                BHtml += "<option value=\"" + users[i]["peopleId"] + "\">" + users[i]["legalName"] + mess + "</option>";
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
    $("#createDate").val(contract["createDate"].substring(0, 10))
    $("#modifyDate").val(contract["modifyDate"].substring(0, 10))
    $("#endDate").val(contract["endDate"].substring(0, 10))
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

$("#sub").click(function () { subMess() })

function subMess() {
    let errm = "修改失败"
    let link = "../contract/modify";
    if (getUrlParam("contractId") == null) {
        link = "../contract/insert"
        errm = "插入失败"
    }
    $.ajax({
        url: u = link,
        async: false,
        type: "POST",
        data: $("#frm").serialize(),
        success: function (data) {
            window.location.href = document.referrer;
        },
        error: function () {
            alert(errm)
        }
    })
}

var flag = true;

$("input,textarea").blur(function () {
    check()
})

function check() {
    let flag = true;
    {
        if ($("#createDate").val() == "") {
            flag = false;
            $("#createDate").css("border", "2px solid red")
        } else {
            $("#createDate").css("border", "1px solid #4987c0")
        }
    }
    {
        if ($("#modifyDate").val() == "") {
            flag = false;
            $("#modifyDate").css("border", "2px solid red")
        } else {
            $("#modifyDate").css("border", "1px solid #4987c0")
        }
    }
    {
        if ($("#title").val() == "") {
            flag = false;
            $("#title").css("border", "2px solid red")
        } else {
            $("#title").css("border", "1px solid #4987c0")
        }
    }
    {
        if ($("#endDate").val() == "") {
            flag = false;
            $("#endDate").css("border", "2px solid red")
        } else {
            $("#endDate").css("border", "1px solid #4987c0")
        }
    }
    {
        let arg = /^[0-9]+.?[0-9]*$/i
        if (!arg.test($("#uAMoney").val())) {
            flag = false;
            $("#uAMoney").css("border", "2px solid red")
        } else {
            $("#uAMoney").css("border", "1px solid #4987c0")
        }
    }
    {
        let arg = /^\d{12}$/i
        if (getUrlParam("contractId") == null) {
            $.ajax({
                url: "../contract/findUid",
                type: "POST",
                data: { "uid": $("#contractUid").val() },
                success: function (data) {
                    if (data == true) {
                        flag = false
                        $("#contractUid").css("border", "2px solid red")
                    } else {
                        if (!arg.test($("#contractUid").val())) {
                            flag = false;
                            $("#contractUid").css("border", "2px solid red")
                        } else {
                            $("#contractUid").css("border", "1px solid #4987c0")
                        }
                    }
                }
            })
        } else {
            $("#contractUid,#partyAId,#partyBId,#createDate").attr("disabled", "true");
            $("#contractUid,#partyAId,#partyBId,#createDate").attr("disabled", true);
            $("#contractUid,#partyAId,#partyBId,#createDate").attr("disabled", "disabled");
        }
    }
    {
        if ($("#name").val() == "") {
            flag = false;
            $("#name").css("border", "2px solid red")
        } else {
            $("#name").css("border", "1px solid #4987c0")
        }
    }
    {
        if ($("#place").val() == "") {
            flag = false;
            $("#place").css("border", "2px solid red")
        } else {
            $("#place").css("border", "1px solid #4987c0")
        }
    }
    {
        if ($("#scale").val() == "") {
            flag = false;
            $("#scale").css("border", "2px solid red")
        } else {
            $("#scale").css("border", "1px solid #4987c0")
        }
    }
    {
        if ($("#clause").val() == "") {
            flag = false;
            $("#clause").css("border", "2px solid red")
        } else {
            $("#clause").css("border", "1px solid #4987c0")
        }
    }
    {
        if ($("#breach").val() == "") {
            flag = false;
            $("#breach").css("border", "2px solid red")
        } else {
            $("#breach").css("border", "1px solid #4987c0")
        }
    }
    {
        if ($("#supplement").val() == "") {
            flag = false;
            $("#supplement").css("border", "2px solid red")
        } else {
            $("#supplement").css("border", "1px solid #4987c0")
        }
    }
    {
        if ($("#uBPower").val() == "") {
            flag = false;
            $("#uBPower").css("border", "2px solid red")
        } else {
            $("#uBPower").css("border", "1px solid #4987c0")
        }
    }
    {
        if ($("#uBObligation").val() == "") {
            flag = false;
            $("#uBObligation").css("border", "2px solid red")
        } else {
            $("#uBObligation").css("border", "1px solid #4987c0")
        }
    }
    cSub(flag);
}

function cSub(flag) {
    if (flag == false) {
        $("#sub").attr("disabled", "true");
        $("#sub").attr("disabled", true);
        $("#sub").attr("disabled", "disabled");
        $("#sub").css("background", "linear-gradient(to bottom, #8b8b8b, #8b8b8b, #8b8b8b, #8b8b8b, #8b8b8b)")
    } else {
        $("#sub").removeAttr("disabled");
        $("#sub").attr("disabled", false);
        $("#sub").css("background", "linear-gradient(to bottom, #85c0ec, #6aa7d6, #508dc6, #306fb4, #17559e)")
    }
}