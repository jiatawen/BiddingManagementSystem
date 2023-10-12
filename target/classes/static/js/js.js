
//供应商管理页面上点击删除按钮弹出删除框(providerList.html)
    $('.removeProvider').click(function () {
        $('.zhezhao').css('display', 'block');
        $('#removeProv').fadeIn();
    });
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeProv').css('display', 'none');
    });
//订单管理页面上点击删除按钮弹出删除框(billList.html)
$(function () {
    $('.removeBill').click(function () {
        $('.zhezhao').css('display', 'block');
        $('#removeBi').fadeIn();
    });
});
$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeBi').fadeOut();
    });
});


//用户管理页面上点击删除按钮弹出删除框(userList.html)
$(function () {
    $('.removeUser').click(function () {
        $('.zhezhao').css('display', 'block');
        $('#removeUse').fadeIn();
    });
});
$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeUse').fadeOut();
    });
});
//库存管理页面上点击删除按钮弹出删除框(warehouse.html)
$(function () {
    $('.removeStore').click(function () {
        $('.zhezhao').css('display', 'block');
        $('#removeStor').fadeIn();
    });
});
$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeStor').fadeOut();
    });
});
//商品管理页面上点击删除按钮弹出删除框(commodityList.html)
$(function () {
    $('.removeCommodity').click(function () {
        $('.zhezhao').css('display', 'block');
        $('#removeCom').fadeIn();
    });
});

$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeCom').fadeOut();
    });
});
//仓库管理页面上点击删除按钮弹出删除框(inventoryList.html)
$(function () {
    $('.removeInventory').click(function () {
        $('.zhezhao').css('display', 'block');
        $('#removeInven').fadeIn();
    });
});

$(function () {
    $('#no').click(function () {
        $('.zhezhao').css('display', 'none');
        $('#removeInven').fadeOut();
    });
});
