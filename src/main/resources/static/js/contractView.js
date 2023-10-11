function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

$(document).ready(function () { start(); })

function start() {
    $.ajax({
        url: "../contract/getById",
        data: { "id": getUrlParam("contractId") },
        type: "POST",
        success: function (data) { writeContract(data) },
        error: function () { alert("获取合同失败") }
    })
}

function writeContract(data) {
    contract = eval(data);
    var aName;
    var bName;
    $.ajax({
        url: "../user/getById",
        type: "POST",
        data: { "id": contract["partyAId"] },
        async: false,
        success: function (udata) { aName = eval(udata)["legalName"] }
    })
    $.ajax({
        url: "../user/getById",
        type: "POST",
        data: { "id": contract["partyBId"] },
        async: false,
        success: function (udata) { bName = eval(udata)["legalName"] }
    })

    let innerHtml = "<div id=\"printdivaa\"><h3 class=\"uid\">GF" + contract["contractUid"] + "</h3>" +
        "<h3 class=\"title1\">" + contract["title"] + "</h3>" +
        "<h3 class=\"title2\">工程建设项目招标代理协议书</h3><br><br>" +
        "<p>委托人:<span class=\"underline\" style=\"color:black\">&#12288;&#12288;" + aName + "</span></p>" +
        "<p>受托人:<span class=\"underline\" style=\"color:black\">&#12288;&#12288;" + bName + "</span></p>" +
        "<p>依照《中华人民共和国合同法》、《中华人民共和国招标投标法》及国家的有关法律、行政法规，遵循平等、自愿、公平和诚实信用的原则，双方就"+
        "<span class=\"underline\" style=\"color:black\">&#12288;&#12288;" + contract["name"] + "</span>" +
        "招标代理事项协商一致，订立本合同。</p>" +
        "<p>一、工程概况</p>"+
        "<p>工程名称:<span class=\"underline\" style=\"color:black\">&#12288;&#12288;" + contract["name"] + "</span></p>" +
        "<p>地&#12288;&#12288;点:<span class=\"underline\" style=\"color:black\">&#12288;&#12288;" + contract["place"] + "</span></p>" +
        "<p>规&#12288;&#12288;模:<span class=\"underline\" style=\"color:black\">&#12288;&#12288;" + contract["scale"] + "</span></p>" +
        "<p>总投资额:<span class=\"underline\" style=\"color:black\">&#12288;&#12288;" + contract["uAMoney"] + "</span></p>" +
        "<p>二、委托人委托受托人为"+
        "<span class=\"underline\" style=\"color:black\">&#12288;&#12288;"+contract["name"] +"</span>"+
        "工程建设项目的招标代理机构，承担本工程的"+
        "招标代理工作</p>"+
        "<p>三、合同价款</p>"+
        "<p>代理报酬为人民币<span class=\"underline\" style=\"color:black\">&#12288;&#12288;" + contract["uAMoney"] + "</span>元</p>"+
        "<p>四、合同订立</p>"+
        "<p class=\"time\">合同定理时间:<span  class=\"underline\" style=\"color:black\">&#12288;&#12288;" +
         contract["createDate"].substring(0,4) + 
         "</span>年<span  class=\"underline\" style=\"color:black\">&#12288;&#12288;"+
         contract["createDate"].substring(5,7)+
         "</span>月<span  class=\"underline\" style=\"color:black\">&#12288;&#12288;"+
         contract["createDate"].substring(8,10)+"</span>日</p>"+
         "<p>五、合同生效</p>"+
         "<p>本合同双方约定<span  class=\"underline\" style=\"color:black\">&#12288;&#12288;" +
         contract["modifyDate"].substring(0,4) + "年" + 
         contract["modifyDate"].substring(5,7) + "月" + 
         contract["modifyDate"].substring(8,10) + "日" + 
          "</span>后生效</p><br><br>" +
          "<div><img src=\"../img/content.png\" alt=\"\" style=\"width:70%;margin-left:15%;\"></div>"+
          "<p>六、词语定义和适用法律<br>" +
          "1. 词语定义<br>" +
          "<br>" +
          "下列词语除本合同专用条款另有约定外，应具有本条款所赋予的定义<br>" +
          "<br>" +
          "l.1  招标代理合同：委托人将工程建设项目招标工作委托给具有相应招标代理资质的受托人，实施招标活动签订的委托合同，<br>" +
          "<br>" +
          "l.2  通用条款：是根据有关法律、行政法规和工程建设项目招标代理的需要所订立，通用于各类工程建设项目招标代理的条款。<br>" +
          "<br>" +
          "1.3 专用条款：是委托人与受托人根据有关法律、行政法规规定，结合具体工程建设项目招标代理的实际，经协商达成一致意见的条款，是对通用条款的具体化、补充或修改。<br>" +
          "<br>" +
          "l.4 委托人：指在合同中约定的，具有建设项目招标委托主体资格的当事人，以及取得该当事人资格的合法继承人。<br>" +
          "<br>" +
          "1.5 受托人：指在合同中约定的，被委托人接受的具有建设项目招标代理主体资格的当事人，以及取得该当事人资格的合法继承人。<br>" +
          "<br>" +
          "1.6 招标代理项目负责人：指受托人在专用条款中指定的负责合同履行的代表。<br>" +
          "<br>" +
          "1.7 工程建设项目：指由委托人和受托人在合同中约定的委托代理招标的工程。<br>" +
          "<br>" +
          "1.8 招标代理业务：委托人委托受托人代理实施工程建设项目招标的工作内容。<br>" +
          "<br>" +
          "1.9 附加服务：指委托人和受托人在本合同通用条款 4.1 款和专用条款 4.1 款中双方约定工作范围之外的附加工作。<br>" +
          "<br>" +
          "1.10    代理报酬：委托人和受托人在合同中约定的，受托人按照约定应收取的代理报酬总额。<br>" +
          "<br>" +
          "1.11 图纸：指由委托人提供的满足招标需要的所有图纸、计算书、配套说明以及相关的技术资料。<br>" +
          "<br>" +
          "1.12 书面形式：指具有公章、法定代表人或授权代理人签字的合同书、信件和数据电文（包括电报、电传、传真）等可以有形地表现所载内容的形式。<br>" +
          "<br>" +
          "1.13    违约责任：指合同一方不履行合同义务或履行合同义务不符合约定所应承担的责任。<br>" +
          "<br>" +
          "1.14 索赔：指在合同履行过程中，对于并非自己的过错，而是应由对方承担责任的情况造成的实际损失，向对方提出经济补偿或其他的要求。<br>" +
          "<br>" +
          "1.15 不可抗力：指双方无法控制和不可预见的事件，但不包括双方的违约或疏忽。这些事件包括但不限于战争、严重火灾、洪水、台风、地震，或其他双方一致认为属于不可抗力的事件。<br>" +
          "<br>" +
          "1.16  小时或天：本合同中规定按小时计算时间的，从事件有效开始时计算（不扣除休息时间）；规定按天计算时间的，开始当天不计入，从次日开始计算。时限的最后一天是休息日或者其他法定节假日的，以节假日次日为时限的最后一天。时限的最后一天的截止时间为当日 24 时。<br>" +
          "<br>" +
          "2. 合同文件及解释顺序<br>" +
          "<br>" +
          "2.1 合同文件应能互相解释，互为说明。除本合同专用条款另有约定外，组成本合同的文件及优先解释顺序如下：<br>" +
          "<br>" +
          "（ 1）本合同履行过程中双方以书面形式签署的补充和修正文件；<br>" +
          "<br>" +
          "（ 2）本合同协议书：<br>" +
          "<br>" +
          "（ 3）本合同专用条款；<br>" +
          "<br>" +
          "（ 4）本合同通用条款。<br>" +
          "<br>" +
          "2.2 当合同文件内容出现含糊不清或不相一致时，应在不影响招标代理业务正常进行的情况下，由委托人和受托人协商解决。双方协商不成时，按本合同通用条款第 12 条关于争议的约定处理。<br>" +
          "<br>" +
          "3. 语言文字和适用法律<br>" +
          "<br>" +
          "3.1 语言文字<br>" +
          "<br>" +
          "除本合同专用条款中另有约定，本合同文件使用汉语语言文字书写、解释和说明。如本合同专用条款约定使用两种以上（含两种）语言文字时，汉语应为解释和说明本合同的标准语言文字。<br>" +
          "<br>" +
          "3.2 适用法律和行政法规<br>" +
          "<br>" +
          "本合同文件适用有关法律和行政法规。需要明示的法律和行政法规，双方可在本合同专用条款中约定。</p>"+
          "<p>七、条款</p>"+
          "<p>" + contract["clause"] + "</p>"+
          "<p>八、补充条款</p>"+
          "<p>" + contract["supplement"] + "</p>" +
          "<p>九、违约</p>"+
          "<p>" + contract["breach"] + "</p>" +
          "<p>十、收代理人的权力与义务</p>"+
          "<p>（1）权力</p>"+
          "<p>" + contract["uBPower"] + "</p>" +
          "<p>（2）义务</p>"+
          "<p>" + contract["uBObligation"] + "</p></div>"
    $("#allBody").html(innerHtml);
}

function dayin() {
    var userAgent = navigator.userAgent.toLowerCase(); //取得浏览器的userAgent字符串
    if (userAgent.indexOf("trident") > -1) {
        alert("请使用google或者360浏览器打印");
        return false;
    } else if (userAgent.indexOf('msie') > -1) {
        var onlyChoseAlert = simpleAlert({
            "content": "请使用Google或者360浏览器打印",
            "buttons": {
                "确定": function () {
                    onlyChoseAlert.close();
                }
            }
        })
        alert("请使用google或者360浏览器打印");
        return false;
    } else {//其它浏览器使用lodop
        var oldstr = document.body.innerHTML;
        var headstr = "<html><head><title></title></head><body>";
        var footstr = "</body>";
        //执行隐藏打印区域不需要打印的内容
        // document.getElementById("otherpho").style.display = "none";
        //此处id换为你自己的id
        var printData = document.getElementById("printdivaa").innerHTML; //获得 div 里的所有 html 数据
        document.body.innerHTML = headstr + printData + footstr;
        window.print();
        //打印结束后，放开隐藏内容
        // document.getElementById("otherpho").style.display = "block";
        document.body.innerHTML = oldstr;
        
    }
    location.reload();
}
