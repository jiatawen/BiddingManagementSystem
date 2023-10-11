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
                success: function (data) { writeAll(data) },
                error: function () { alert("没有找到该用户！") }
            }

        )
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
        success:function(flag){
            if(flag == true){
                window.location.href=document.referrer;
            }else{
                alert(errm)
            }
        },
        error:function(){alert(errm)}
    })
})