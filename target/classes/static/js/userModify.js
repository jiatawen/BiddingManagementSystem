function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
$(document).ready(function start() {

    var peopleId = getUrlParam("peopleId");

    if (peopleId != null && peopleId != "") {
        $.ajax(
            {
                type: "POST",
                url: "../user/getById",
                data: { "id": peopleId },
                success: function (data) { writeAll(data); },
                error: function () { alert("没有找到该用户！") }
            }

        )
    } else {
        check();
    }
})

function writeAll(data) {
    if (data != null) {
        let people = eval(data);
        $("#uType").each(function () {
            let flag = 0;
            if (people["uType"] == "B") {
                flag = 1;
            }
            $(this).find("option").eq(flag).prop("selected", true)
        })
        $("#peopleId").val(people["peopleId"])
        $("#legalName").val(people["legalName"])
        $("#agentName").val(people["agentName"])
        $("#phone").val(people["phone"])
        $("#place").val(people["place"])
        $("#zipcode").val(people["zipcode"])
        $("#bankId").val(people["bankId"])
        $("#bankPlace").val(people["bankPlace"])
    }
}

$("#sub").click(function () {
    let link = "../user/insert"
    let errm = "插入失败"
    if (getUrlParam("peopleId") != null) {
        link = "../user/modify"
        errm = "修改失败"
    }
    $.ajax({
        url: link,
        type: "POST",
        data: $("#frm").serialize(),
        success: function (flag) {
            if (flag == true) {
                window.location.href = document.referrer;
            } else {
                alert(errm)
            }
        },
        error: function () { alert(errm) }
    })
})
$(":text").blur(function () { check() })

function check() {
    let flag = true
    {
        if ($("#legalName").val() == null || $("#legalName").val() == "") {
            flag = false;
            $("#legalName").css("border", "2px solid red")
        } else {
            $("#legalName").css("border", "1px solid #4987c0")
        }
    }
    {
        if ($("#agentName").val() == null || $("#agentName").val() == "") {
            flag = false;
            $("#agentName").css("border", "2px solid red")
        } else {
            $("#agentName").css("border", "1px solid #4987c0")
        }
    }
    {
        if ($("#place").val() == null || $("#place").val() == "") {
            flag = false;
            $("#place").css("border", "2px solid red")
        } else {
            $("#place").css("border", "1px solid #4987c0")
        }
    }
    {
        let rgc = /^\d{11}$/i;
        if (!rgc.test($("#phone").val())) {
            flag = false;
            $("#phone").css("border", "2px solid red")
        } else {
            $("#phone").css("border", "1px solid #4987c0")
        }
    }
    {
        let rgc = /^\d{6}$/i
        if (!rgc.test($("#zipcode").val())) {
            flag = false;
            $("#zipcode").css("border", "2px solid red")
        } else {
            $("#zipcode").css("border", "1px solid #4987c0")
        }
    }
    {
        let rgc = /^\d{19}$/i
        if (!rgc.test($("#bankId").val())) {
            flag = false;
            $("#bankId").css("border", "2px solid red")
        } else {
            $("#bankId").css("border", "1px solid #4987c0")
        }
    }
    {
        if ($("#bankPlace").val() == null || $("#bankPlace").val() == "") {
            flag = false;
            $("#bankPlace").css("border", "2px solid red")
        } else {
            $("#bankPlace").css("border", "1px solid #4987c0")
        }
    }
    cSub(flag)
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