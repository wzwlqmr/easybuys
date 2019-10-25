/******* 公共变量**********/
var JING_PWD_TYPE = "jingPwdType";
var DONG_FREIGHT_PWD_TYPE = "dongfreightPwdType";
var LPK_PWD_TYPE = "lpkPwdType";
var dongType = "dongType";
var jingType = "jingType";
var freeFreight = "freeFreightType";
var TYPE_COUPON = 'couponitem';
var position = {bar:null,ui:null,type:null};
/*********** 优惠券部分 ***************/
// 优惠券滚动
var scrollCoupon = null;
// 运费券滚动
var scollFreight = null;
//初始化优惠券
function initCouponScroll(){
//计算高度
$('.coupon-freefreight').parents(".ui-scrollbar-wrap").hide();
var couponlength = $(".coupon-scrollbar .coupon-enable ul .coupon-item").length;
couponlength = couponlength+ $(".coupon-scrollbar .coupon-disable ul .coupon-item").length;
if(couponlength<10){
  return;
}
if(!scrollCoupon) {
  scrollCoupon = $('.coupon-scrollbar').scrollbar({
    width: 11,
    scrollClass: 'ui-scrollbar-item-consignee',
    mainClass: 'ui-scrollbar-main',
    hasHeadTail: false,
    limit: true,
    wrapHeight: 360
  });
  scrollbarPosition();
}
else {
  scrollCoupon.update();
}
$('.coupon-scrollbar').parents(".ui-scrollbar-wrap").show().children().show();
}
 //初始化运费券
function initFreightScroll(){
    //计算高度
    var length = $(".coupon-freefreight .coupon-enable ul li").length;
    length = length+$(".coupon-freefreight .coupon-disable ul li").length;
    if(length<10){
      return;
    }
    $('.coupon-scrollbar').parents(".ui-scrollbar-wrap").hide();
    if(!scollFreight) {
      scollFreight = $('.coupon-freefreight').scrollbar({
        width: 11,
        scrollClass: 'ui-scrollbar-item-consignee',
        mainClass: 'ui-scrollbar-main',
        hasHeadTail: false,
        limit: true,
        wrapHeight: 360
      });
    } else {
      scollFreight.update();
    }
    $('.coupon-freefreight').parents(".ui-scrollbar-wrap").show().children().show();
  }
  //切换初始化滚动条
  function showScrollCoupon(e){
    switch (e){
      case 0:
        initCouponScroll();
        break;
      case 1:
        initFreightScroll();
        break;
    }
    $('#currTab').val(e);
  }window.showScrollCoupon=showScrollCoupon;

//查询优惠券
function query_coupons_vertual(syncSign,mandatory) {
    //预售切换
    if(!mandatory){
        if($("#bestCouponCheck").is(':checked')){
            return;
        }
    }
    var param = addFlowTypeParam();
    var url = OrderAppConfig.DynamicDomain + "/coupon/getCoupons.action";
    jQuery.ajax({
      type : "POST",
      dataType : "text",
      url : url,
      data : param,
      async : !syncSign,
      cache : false,
      success : function(result) {
        if (isUserNotLogin(result)) {
            goToLogin();
          return;
        }
        if (isHasMessage(result)) {
          var message = getMessage(result);
          alert(message);
          return;
        }
        if($(result).find('.coupon-enable .item-selected .c-jing').length>0){
        	checkPaymentPasswordSafe(JING_PWD_TYPE);
        }else{
        	checkPaymentPasswordSafe(DONG_FREIGHT_PWD_TYPE);
        }
         $("#" + OrderAppConfig.Module_Coupon).html(result);
         entityCouponInputEventInit();// 实体券输入框初始化

          // 优惠券降级后不刷新运费券金额
          var couponDownGradeCodeSign = document.getElementById("couponDownGradeCodeSign");
          if(couponDownGradeCodeSign == null){
              refushVertualused();
          }
          //预售尾款用券切换金额展示
          if('2' === $('#virtualdiv').attr('data-forbidtype')){
              flushOrderPriceByCoupon();
          }
         resetFreightCouponTip(); //运费券可用提醒
         isNeedPaymentPassword(); // 是否需要支付密码
      },
      error : function(XMLHttpResponse) {
        //alert("系统繁忙，请稍后再试！");
      }
    });
}window.query_coupons_vertual = query_coupons_vertual;

/**
*  当有可用的运费券时，展示小红点
*/
function resetFreightCouponTip(){
  if($(".coupon-freefreight .coupon-enable ul li").length > 0){
      if($("#freightcoupontit i").length == 0){
          $("#freightcoupontit").append("<i></i>");
      }
  } else {
      $("#freightcoupontit i").remove();
  }
}window.resetFreightCouponTip=resetFreightCouponTip;
$(function(){
    resetFreightCouponTip();
});

function userOrCancelCouponVertual(key,id,a){
  if($("#selected_coupon_"+id).hasClass("item-selected")){
    /**取消使用优惠券**/
    useOrCancelCoupon(OrderAppConfig.DynamicDomain + "/coupon/cancelCoupon.action",id, 0);
  }else{
    useOrCancelCoupon(OrderAppConfig.DynamicDomain + "/coupon/useCoupon.action",key, 1);
  }
}

//获取优惠券信息
function useOrCancelCoupon(url, id, flag) {
  var param = "";
  if (flag == 1) {// 使用券传的是couponKey
    param += "couponParam.couponKey=" + id;
  } else {// 取消券使用的是couponId
    param += "couponParam.couponId=" + id;
  }
  param += "&couponParam.pageNum="+$("#pageNum").val();
  param = addFlowTypeParam(param);
  keepScrollbar(TYPE_COUPON);
  jQuery.ajax({
    type : "POST",
    dataType : "text",
    url : url,
    data : param,
    async : true,
    cache : false,
    success : function(result) {
      if (isUserNotLogin(result)) {
        goToLogin();
        return;
      }
      if (isHasMessage(result)) {
        var message = getMessage(result);
        alert(message);
        if(flag==1){
          if($("#selected_coupon_"+id).hasClass("item-selected")){
              $("#selected_coupon_"+id).removeClass("item-selected");
            }
        }else{
           if ($("#coupon_"+id).parent().parent().hasClass("item-selected")) {
              $("#coupon_"+id).parent().parent().removeClass("item-selected");
          }
        }
        return;
      }
      if(flag==1 && $(result).find('.coupon-enable .item-selected .c-jing').length>0){
    	  checkPaymentPasswordSafe(JING_PWD_TYPE, 0);// 用户安全，检查是否开启支付密码
      }else{
      	checkPaymentPasswordSafe(DONG_FREIGHT_PWD_TYPE, 0);
      }
      //预售逻辑处理
      if($(result).find('.coupon-tab-panel').length >0 && $(result).find('.coupon-tab-panel')[0].getAttribute('forbidCoupon')) {
          $('.step-cont.order-virtual').css('display', 'block');
          $('.step-cont.order-presale').css('display', 'none');
      }else{
          $("#" + OrderAppConfig.Module_Coupon).html(result);
      }
      // 刷新显示：优惠券优惠金额，礼品卡优惠金额，余额优惠金额，实际应付总金额
      
      if($(".coupon-freefreight div[id= selected_coupon_"+id+"]").length>0){
         $("#freightcoupontit").click();
      }

      useCancelEditJdBean(0, null, true);
      isNeedPaymentPassword(); // 是否需要支付密码

      // 检查优惠券是否降级，因为使用券被降级后没有操作缓存，导致没有返回价格信息，所以不刷新价格
      var couponDownGradeCodeSign = document.getElementById("couponDownGradeCodeSign");
      if(couponDownGradeCodeSign != null &&
          // 结算页降级
          (couponDownGradeCodeSign.value == "trade_coupon_1100_USE_COUPON" ||
          couponDownGradeCodeSign.value == "trade_coupon_1101_USE_COUPON"||
          couponDownGradeCodeSign.value == "trade_coupon_user_1100_USE_COUPON" ||
          couponDownGradeCodeSign.value == "trade_coupon_user_1101_USE_COUPON" ||
          //优惠券降级
          couponDownGradeCodeSign.value == "coupon_1000_USE_COUPON" ||
          couponDownGradeCodeSign.value == "coupon_1001_USE_COUPON" ||
          couponDownGradeCodeSign.value == "coupon_1002_USE_COUPON" ||
          couponDownGradeCodeSign.value == "coupon_1003_USE_COUPON" ||
          couponDownGradeCodeSign.value == "coupon_1100_USE_COUPON" ||
          couponDownGradeCodeSign.value == "coupon_1103_USE_COUPON")){
          query_coupons_vertual();
          return;
      }

      flushOrderPriceByCoupon(); // 改变优惠券状态
      checkCouponWaste();// 检查优惠券是否存在浪费情况
      refushCouponPrice();
      refushVertualused();
      entityCouponInputEventInit();// 实体券输入框初始化
    //清空运费明细
      $("#frightDetail").html("");
    // 修改运费
      if ($("#hiddenFreight_coupon").val() != null) {
        if ($("#hiddenFreight_coupon").val() > 0) {
        	$("#frightDetail").html("总计<em class='ml5 ftx-01' >￥" + $("#hiddenFreight_coupon").val() + "</em>");
        }
      }
      var orderPriceJson = jQuery.parseJSON($("#orderPriceJson").html());
      if(orderPriceJson !=null){
    	  flushOrderFreightDetail(orderPriceJson, false);
      }
      resetFreightCouponTip(); //运费券可用提醒
    }
  });
}
//使用优惠券刷新 礼品卡使用金额
function refushCouponPrice(){
  $("#giftCardPricehidden").val($("#hiddenGiftCardDiscount_coupon").val());
  $("#consignmentCardDiscounthidden").val($("#hiddenConsignmentCardDiscount_coupon").val())
}

function getBastCouponList(obj){
  $("#pwd-error").hide();
  var flag = (obj.checked) ? "1" : "0";
  if(flag == 0){
    query_coupons_vertual();
    resetCoupontab();
    $("#isBestCoupon").val("0");
  }else{
    var param = "";
    var url =OrderAppConfig.DynamicDomain + "/coupon/getBestVertualCoupons.action";
    param = addFlowTypeParam(param);
    jQuery.ajax({
      type : "POST",
      dataType : "text",
      url : url,
      data : param,
      async : true,
      cache : false,
      success : function(result) {
        if (isUserNotLogin(result)) {
          goToLogin();
          return;
        }
        if($(result).find("#couponUseNum").val() === '0'
            || $(result).find("#couponUseNum").val() === 0
            || (isHasMessage(result) && getMessage(result) ==="没有最优组合")){
            query_coupons_vertual(true,true);
            resetCoupontab();
            if (obj.checked) {
                obj.checked = false;
            }
            return;
        }
        if($(result).find('.coupon-enable .item-selected .c-jing').length>0){
        	checkPaymentPasswordSafe(JING_PWD_TYPE);
        }else{
        	checkPaymentPasswordSafe(DONG_FREIGHT_PWD_TYPE);
        }
        $("#" + OrderAppConfig.Module_Coupon).html(result);
        // 刷新显示：优惠券优惠金额，礼品卡优惠金额，余额优惠金额，实际应付总金额
        useCancelEditJdBean(0, null, true);
        flushOrderPriceByCoupon(); // 改变优惠券状态
        checkCouponWaste();// 检查优惠券是否存在浪费情况
        isNeedPaymentPassword(); // 是否需要支付密码
        refushCouponPrice();
        refushVertualused();
        refushBastCoupon();
        entityCouponInputEventInit();// 实体券输入框初始化
        $("#isBestCoupon").val("1");
        //-------优惠券前置
      //清空运费明细
        $("#frightDetail").html("");
      // 修改运费
        if ($("#hiddenFreight_coupon").val() != null) {
          if ($("#hiddenFreight_coupon").val() > 0) {
          	$("#frightDetail").html("总计<em class='ml5 ftx-01' >￥" + $("#hiddenFreight_coupon").val() + "</em>");
          }
        }
        var orderPriceJson = jQuery.parseJSON($("#orderPriceJson").html());
        if(orderPriceJson!=null){
        	flushOrderFreightDetail(orderPriceJson, false);
        }
      }
    });
  }
}window.getBastCouponList=getBastCouponList;

/**
 * 使用兑换码兑换优惠券 
 * 
 */
function exchangeVertualCoupons(obj) {
  if ($('#couponKeyPressFirst').val() == "" || $('#couponKeyPressSecond').val() == "" || $('#couponKeyPressThrid').val() == ""
      || $('#couponKeyPressFourth').val() == "") {
    $("#couponKeyPressFirst").parent().find(".error-msg").text("请输入优惠券兑换码！");
    $("#couponKeyPressFirst").parent().find(".error-msg").show();
    return;
  }

  var param = "couponParam.fundsPwdType=Coupon";
  var url = OrderAppConfig.DynamicDomain + "/coupon/checkFundsPwdResult.action";
  param = addFlowTypeParam(param);
  jQuery.ajax({
    type : "POST",
    dataType : "json",
    url : url,
    data : param,
    async : true,
    cache : false,
    success : function(flag) {
      if (isUserNotLogin(flag)) {
        goToLogin();
        return;
      }
      if (flag) {
        var key = $("#couponKeyPressFirst").val() + $("#couponKeyPressSecond").val() + $("#couponKeyPressThrid").val() + $("#couponKeyPressFourth").val();
        $("input[id^='couponKeyPress']").each(function() {
          $(this).val("");
        });
        var param = "couponParam.couponKey=" + key;
        param = addFlowTypeParam(param);
        jQuery.ajax({
          type : "POST",
          dataType : "json",
          url : OrderAppConfig.AsyncDomain + "/coupon/exchangeCoupons.action",
          data : param,
          async : true,
          cache : false,
          success : function(result) {
            if (isUserNotLogin(result)) {
              goToLogin();
              return;
            }
            if (!result.resultFlag) {
              var message = result.message;
             // showMessageError(message);
              $("#couponKeyPressFirst").parent().find(".error-msg").text(message);
              $("#couponKeyPressFirst").parent().find(".error-msg").show();
              if (obj.checked) {
                obj.checked = false;
              }
              return;
            }
            showMessageSucc(result.message);
            query_coupons_vertual();
            showEntityPanel();
          }
        });
      } else {
        showLargeMessage("支付密码未开启", "为保障您的账户资金安全，请先开启支付密码");
        return;
      }
    }
  });
}
window.exchangeVertualCoupons = exchangeVertualCoupons;

/**
刷新最优组合
*/
function refushBastCoupon(){
  if($("#couponUseNum").val()!=undefined){
      var tip = "优惠组合推荐，共抵用<span class='money'>",
      discount= eval(parseFloat($("#hiddenCouponDiscount").val()) + parseFloat($("#hiddenFreeFreight_coupon").val()));
      tip+=parseFloat(discount).toFixed(2);
      tip+="元</span>：";
      var couponNum = $("#couponUseNum").val();
      var freeFreightCouponUseNum = $("#freeFreightCouponUseNum").val();
      freeFreightCouponUseNum = isNaN(freeFreightCouponUseNum) ? 0 : Number(freeFreightCouponUseNum);

      var isFreight= false;
      if($("#hiddenFreeFreight_coupon").val() > 0) {
        couponNum= couponNum-freeFreightCouponUseNum;
        isFreight=true;
      }
      if(couponNum>0)
        tip+="使用优惠券"+couponNum+"张 ";
      if(isFreight){
        tip+="运费券" + freeFreightCouponUseNum + "张";
      }
      $("#bestCoupon").html(tip);
      //隐藏 coupontab
      hideCoupontab();
    }
}
function hideCoupontab(){
  $(".coupon-cont .coupon-tab").hide();
}
function showCoupontab(){
  $(".coupon-cont .coupon-tab").show();
}
function resetCoupontab(){
    $("#bestCouponCheck").attr("checked",false);
    $("#bestCoupon").text("优惠组合推荐");
    showCoupontab();
}
/**
* 刷新价格信息
*/
function refushVertualused(){
  // 运费券
  var totaldiscount= 0.00;
  var couponNum = $("#couponUseNum").val();
  var freeFreightCouponUseNum = $("#freeFreightCouponUseNum").val();
  freeFreightCouponUseNum = isNaN(freeFreightCouponUseNum) ? 0 : Number(freeFreightCouponUseNum);
  var isHasVertualShow =false;
  // 修改优惠券结算信息
  if($("#hiddenCouponDiscount")[0]) {
    // 运费券金额拆分再合并
    var couponDiscount = $("#hiddenCouponDiscount").val();
    if($("#hiddenFreeFreight_coupon").val() > 0) {
      couponNum = couponNum-freeFreightCouponUseNum;
    }
    if(couponDiscount>0){
      var couponShow="使用优惠券<em>"+couponNum+"</em>张，优惠<em>"+parseFloat(couponDiscount).toFixed(2)+"</em>元 ";
      $("#couponTotalDiscount").text(parseFloat(couponDiscount).toFixed(2));
      $("#couponTotalShow").html(couponShow);
      isHasVertualShow=true;
      $("#couponTotalShow").show();
      totaldiscount=eval(parseFloat(totaldiscount)+parseFloat(couponDiscount));
    }else{
      $("#couponTotalShow").css("display", "none");
    }
    $("#couponNum").text(couponNum);
  }else{
    $("#couponTotalShow").css("display", "none");
  }
  //运费券信息
  if($("#hiddenCouponDiscount")[0]) {
    $("#freeFreightPriceId").text("-￥" + $("#hiddenFreeFreight_coupon").val());
    if($("#hiddenFreeFreight_coupon").val()>0){
      var couponShow;
      if(isHasVertualShow){
        couponShow="| 使用运费券<em>" + freeFreightCouponUseNum + "</em>张，抵用运费<em>"+parseFloat($("#hiddenFreeFreight_coupon").val()).toFixed(2)+"</em>元";
      }else{
        isHasVertualShow=true;
        couponShow="使用运费券<em>" + freeFreightCouponUseNum + "</em>张，运费<em>"+parseFloat($("#hiddenFreeFreight_coupon").val()).toFixed(2)+"</em>元";
      }
      totaldiscount=eval(parseFloat(totaldiscount)+parseFloat($("#hiddenFreeFreight_coupon").val()));
      $("#freeFreightShow").html(couponShow);
      $("#freeFreightShow").show();
    }else{
      $("#freeFreightShow").css("display", "none");
    }
  } else {
    $("#freeFreightShow").css("display", "none");
  }
    //红包 兼容 TODO delete
    if($('#red-packet-price').data('price') > 0 && !$('#red-packet-price').is(':hidden')){
        var redPacketPrice =$('#red-packet-price').data('price');
        var redPacketHtml;
        if(isHasVertualShow){
            redPacketHtml = "| 使用红包，抵用<em>"+parseFloat(redPacketPrice).toFixed(2)+"</em>元 ";
        }else{
            isHasVertualShow = true;
            redPacketHtml = "使用红包，抵用<em>"+parseFloat(redPacketPrice).toFixed(2)+"</em>元 ";
        }
        $('#redPacketShow').html(redPacketHtml);
        totaldiscount=eval(parseFloat(totaldiscount)+parseFloat(redPacketPrice));
        $('#redPacketShow').show();
    }else{
        $('#redPacketShow').hide()
    }
    //京豆
    if($("#jdBeanexChange").val()>0){
        $("#jdBeanShow").show();
        var jdbeanHtml;
        if(isHasVertualShow){
            jdbeanHtml="| 使用京豆，抵用<em>"+parseFloat($("#jdBeanexChange").val()).toFixed(2)+"</em>元 ";
        }else{
            isHasVertualShow=true;
            jdbeanHtml="使用京豆，抵用<em>"+parseFloat($("#jdBeanexChange").val()).toFixed(2)+"</em>元 ";
        }
        $("#jdBeanShow").html(jdbeanHtml);
        totaldiscount=eval(parseFloat(totaldiscount)+parseFloat($("#jdBeanexChange").val()));
    }else{
        $("#jdBeanShow").css("display", "none");
    }
  //礼品卡信息
  if($("#giftCardPricehidden").val()>0) {
    var giftCardDiscount = $("#giftCardPricehidden").val();
    if(giftCardDiscount>0){
      var giftcardHtml;
      if(isHasVertualShow){
        giftcardHtml="| 使用礼品卡<em>"+$("#giftCardPriceNum").val()+"</em>张，抵用<em>"+parseFloat(giftCardDiscount).toFixed(2)+"</em>元 ";

      }else{
        isHasVertualShow=true;
        giftcardHtml="使用礼品卡<em>"+$("#giftCardPriceNum").val()+"</em>张，抵用<em>"+parseFloat(giftCardDiscount).toFixed(2)+"</em>元 ";
      }
      $("#giftCardShow").html(giftcardHtml);
      $("#giftCardShow").show();

       totaldiscount=eval(parseFloat(totaldiscount)+parseFloat(giftCardDiscount));
    }else{
      $("#giftCardShow").css("display", "none");
    }
  }else{
    $("#giftCardShow").css("display", "none");
  }

  //领货码信息
    if($("#consignmentCardDiscounthidden").val()>0) {
        var consignmentCardDiscount = $("#consignmentCardDiscounthidden").val();
        if(consignmentCardDiscount>0){
            var consignmentCardHtml
            if(isHasVertualShow){
                consignmentCardHtml = "| 使用领货码<em>"+$("#consignmentCardNum").val()+"</em>张，抵用<em>"+parseFloat(consignmentCardDiscount).toFixed(2)+"</em>元 ";

            }else{
                isHasVertualShow=true;
                consignmentCardHtml = "使用领货码<em>"+$("#consignmentCardNum").val()+"</em>张，抵用<em>"+parseFloat(consignmentCardDiscount).toFixed(2)+"</em>元 ";
            }
            $("#consignmentCardShow").html(consignmentCardHtml);
            $("#consignmentCardShow").show();

            totaldiscount=eval(parseFloat(totaldiscount)+parseFloat(consignmentCardDiscount));
        }else{
            $("#consignmentCardShow").hide();
        }
    }else{
        $("#consignmentCardShow").hide();
    }

  //余额
  if($("#useBalanceShowDiscount").val()>0){
    //$(".balanceDiscount").text(parseFloat($("#useBalanceShowDiscount").val()).toFixed(2));
    var balanceHtml;
    if(isHasVertualShow){
      balanceHtml="| 使用余额，抵用<em>"+parseFloat($("#useBalanceShowDiscount").val()).toFixed(2)+"</em>元 ";
    }else{
      isHasVertualShow=true;
      balanceHtml="使用余额，抵用<em>"+parseFloat($("#useBalanceShowDiscount").val()).toFixed(2)+"</em>元 ";
    }
    $("#selectOrderBalance").attr("checked", true);
    $("#balanceShow").html(balanceHtml);
    $("#balanceShow").show();
    // 修改余额显示
    var leaveBalance=$("#canUsedBalanceId span:first").text().replace("￥","");
    var htmlBalance="&nbsp;使用余额（账户当前余额：<span class='ftx-01'>"+leaveBalance+"</span>元，本次使用：<span class='ftx-01'>"+parseFloat($("#useBalanceShowDiscount").val()).toFixed(2)+"</span>元）";
    $("#canUsedBalanceId").html(htmlBalance);
    // 剩余可用余额
    totaldiscount=eval(parseFloat(totaldiscount)+parseFloat($("#useBalanceShowDiscount").val()));
  }else{
      if(!$('#selectOrderBalance').is(':disabled') && $('#selectOrderBalance').is(':checked')){
          window.virtualBalance.changeBalanceStatus(false);
      }
  }
  //总金额抵扣
  $("#total").text("￥"+parseFloat(totaldiscount).toFixed(2));
};

$("#entityCouponId").click(function(){
    $(".virtual-add-input .succ-msg").show();
    setTimeout(function(){
      $(".virtual-add-input .succ-msg").hide();
    }, 1500);
  });
  /**************** 礼品卡 *******************/
//重新加载礼品卡列表

function reloadGiftCard(){
    if($("#isNewVertual").val() == "true"){
        if( typeof $(".giftcard-main.ui-switchable-panel-selected")[0] !== "undefined"){
            var giftCardType = $(".giftcard-main.ui-switchable-panel-selected")[0].id;
            if(typeof giftCardType !== "undefined" && giftCardType ==="consignment"){
                window.virtualGiftCard.getGiftCardList('consignment');
            }else if(typeof giftCardType !== "undefined"  && giftCardType ==="gift"){
                window.virtualGiftCard.getGiftCardList('gift')
            }else{
                window.virtualGiftCard.getGiftCardList('gift')
            }
        }
        if($("#flowType").val() != "15"){
        	showOrHideJdBean(1);
        }
    }
}window.reloadGiftCard = reloadGiftCard;


/**
* 粘贴礼品卡密码时自动填充
* @param e
*/
function pasteCardPassWord(e, obj){
  try{
      var newData;
      if(window.clipboardData && window.clipboardData.getData("text")){ // for IE
          newData = window.clipboardData.getData("text");
      } else if(e && e.clipboardData && e.clipboardData.getData("text")){
          newData = e.clipboardData.getData("text");
      } else {
          return;
      }

      if(!newData || newData.length == 0){
          return;
      }

      newData = newData.replace(/[^a-zA-Z0-9]/g, '').toUpperCase();
      newData = newData.replace('O', '0');
      if(newData.length == 0){
          return;
      }

      var id = obj.id;
      var $eleList = new Array();
      if(id == "lpkKeyPressFirst"){
          $eleList.push($("#lpkKeyPressFirst"));
          $eleList.push($("#lpkKeyPressSecond"));
          $eleList.push($("#lpkKeyPressThird"));
          $eleList.push($("#lpkKeyPressFourth"));
      } else if(id == "lpkKeyPressSecond"){
          $eleList.push($("#lpkKeyPressSecond"));
          $eleList.push($("#lpkKeyPressThird"));
          $eleList.push($("#lpkKeyPressFourth"));
      } else if(id == "lpkKeyPressThird"){
          $eleList.push($("#lpkKeyPressThird"));
          $eleList.push($("#lpkKeyPressFourth"));
      } else if(id == "lpkKeyPressFourth"){
          $eleList.push($("#lpkKeyPressFourth"));
      }

      e.preventDefault ? e.preventDefault() : (e.returnValue = false);  // for IE

      for(var i = 0; i < $eleList.length; i++){
          $eleList[i].val(newData.slice(0 + i*4, 4 + i*4));
          $eleList[i].keyup();
      }
  } catch (e){
  }
}

seajs.use(['jdf/1.0.0/ui/tips/1.0.0/tips'],function(tips){
function vertualCoupontips(){
  var $el = $("#container");
  virtualTips = $el.tips({
      tipsClass: "coupon-tips",
      trigger: ".c-type-r",
      width: 535,
      type: 'hover',
      sourceTrigger: '#tooltip-box04',
      callback:function(trigger,obj){
        var couponKey = $(trigger).attr("id");
        if(couponKey == undefined)
          return;
        var availableType = $(trigger).parent().parent().hasClass("c-detail-disable")? 1 : 0;
        //availableType == 0 ?:"该券不可用商品列表"
        $('.coupon-tit',obj).html("该券可用商品列表");
        var param = "couponParam.couponKey=" + couponKey+"&couponParam.availableType="+availableType;;
        param = addFlowTypeParam(param);
        var url = OrderAppConfig.AsyncDomain + "/coupon/getSkuInfoByCouponKey.action";
        jQuery.ajax({
          type : "POST",
          dataType : "text",
          url : url,
          data : param,
          async : true,
          cache : false,
          success : function(result) {
            if (isUserNotLogin(result)) {
            goToLogin();
            return;
          }
          if (isHasMessage(result)) {
            var message = getMessage(result);
            alert(message);
            return;
          }
            $("#v-goods",obj).html(result);
          },
          error : function(XMLHttpResponse) {
            alert("系统繁忙，请稍后再试！");
          }
        });
      }

  });
}window.vertualCoupontips=vertualCoupontips;

});


  /*********************vertual change price****************************/
  function changeVertualOrderPrice() {
     // 已优惠的礼品卡金额
/*  if ($("#hiddenGiftCardDiscount-giftCard")[0]) {
    $("#giftCardPriceId").text("-￥" + $("#hiddenGiftCardDiscount-giftcard").val());
    if ($("#hiddenGiftCardDiscount-giftcard").val() > 0) {
      $("#showGiftCardPrice").show();
    } else {
      $("#showGiftCardPrice").hide();
    }
  }
  // 余额
  if ($("#hiddenUsedBalance-giftcard")[0]) {
    $("#usedBalanceId").text("-￥" + $("#hiddenUsedBalance-giftcard").val());
    if ($("#hiddenUsedBalance-giftcard").val() > 0) {
      $("#showUsedOrderBalance").show();
    } else {
      $("#showUsedOrderBalance").hide();
    }
  }
  // 实际应付金额
  if ($("#hiddenPayPrice-giftcard")[0]) {
    modifyNeedPay($("#hiddenPayPrice" + "-" + giftCardType).val());
  }*/
    save_Pay(0);
  }window.changeVertualOrderPrice = changeVertualOrderPrice;

 function changeGiftCardListOrderPrice() {
     // 已优惠的礼品卡金额
  if ($("#hiddenGiftCardDiscount-giftcard").val()) {
    $("#giftCardPriceId").text("-￥" + $("#hiddenGiftCardDiscount-giftcard").val());
    $("#giftCardPricehidden").val($("#hiddenGiftCardDiscount-giftcard").val());
    if($("#hiddenGiftCardDiscount-giftcard").val() > 0) {
      $("#showGiftCardPrice").show();
       $("#giftCardPriceNum").val($("#hiddenGiftCardNum-giftcard").val());
    } else {
      $("#showGiftCardPrice").hide();
      $("#giftCardPriceNum").val(0);
      $("#giftCardPricehidden").val(0);
    }
  }else{
     $("#showGiftCardPrice").hide();
     $("#giftCardPriceNum").val(0);
    $("#giftCardPricehidden").val(0);
  }
  // 余额
  if ($("#hiddenUsedBalance-giftcard")) {
    $("#usedBalanceId").text("-￥" + $("#hiddenUsedBalance-giftcard").val());
    if ($("#hiddenUsedBalance-giftcard").val() > 0) {
      $("#showUsedOrderBalance").show();
      $("#useBalanceShowDiscount").val($("#hiddenUsedBalance-giftcard").val());
    } else {
      $("#showUsedOrderBalance").hide();
      $("#useBalanceShowDiscount").val(0);
    }
  }
  // 实际应付金额
  if ($("#hiddenPayPrice-giftcard")[0] && $("#closeGrade").val() !=1) {
    modifyNeedPay($("#hiddenPayPrice-giftcard").val());
  }

  };
  function changeGiftCardListOrderPriceByType() {
      // 已优惠的礼品卡金额
      if ($("#hiddenGiftCardDiscount-giftcard").val()) {
          $("#gconsignmentCardId").text("-￥" + $("#hiddenGiftCardDiscount-giftcard").val());
          $("#consignmentCardDiscounthidden").val($("#hiddenGiftCardDiscount-giftcard").val());
          if($("#hiddenGiftCardDiscount-giftcard").val() > 0) {
              $("#consignmentCardPrice").show();
              $("#consignmentCardNum").val($("#hiddenGiftCardNum-giftcard").val());
          } else {
              $("#consignmentCardPrice").hide();
              $("#consignmentCardNum").val(0);
              $("#consignmentCardDiscounthidden").val(0);
          }
      }else{
          $("#consignmentCardPrice").hide();
          $("#consignmentCardNum").val(0);
          $("#consignmentCardDiscounthidden").val(0);
      }
      // 余额
      if ($("#hiddenUsedBalance-giftcard")) {
          $("#usedBalanceId").text("-￥" + $("#hiddenUsedBalance-giftcard").val());
          if ($("#hiddenUsedBalance-giftcard").val() > 0) {
              $("#showUsedOrderBalance").show();
              $("#useBalanceShowDiscount").val($("#hiddenUsedBalance-giftcard").val());
          } else {
              $("#showUsedOrderBalance").hide();
              $("#useBalanceShowDiscount").val(0);
          }
      }
      // 实际应付金额
      if ($("#hiddenPayPrice-giftcard")[0] && $("#closeGrade").val() !=1) {
          modifyNeedPay($("#hiddenPayPrice-giftcard").val());
      }

  };



  /************* event ***************/
  // cancel button
  $(".order-virtual").delegate(".item-selected", "mousemove", function(){
    $(".item-selected-cancel", this).removeClass("hide");
  });
  $(".order-virtual").delegate(".item-selected", "mouseleave", function(){
    $(".item-selected-cancel", this).addClass("hide");
  });
  // click

 /******异步处理******/

  function refushHasAvailableVertual(dataResult) {
    if(dataResult.availableCouponNum>0){
     showCouponItem(true);
     //预售默认不展示
     if($('.ml20.ftx-06').length === 0){
         vertualShow();
     }
    }else{
	    if($("#useBestCoupons").val()=="1" && dataResult.availableCouponNum >0 ){
	    	showCouponItem(true);
	    }else{
	    	showCouponItem(false);
	    }
    }
    if(dataResult.redPacketResultVO && dataResult.redPacketResultVO.redPacketTotalUsableBalance > 0){
        showRedPacket(true);
    }else{
        showRedPacket(false);
    }
    if(dataResult.availableGiftNum>0){
      showGiftItem(true);
    }else{
      showGiftItem(false);
    }
    if(dataResult.availableJdBeanNum>=1000){
     showJdbeanItem(true);
    }else{
     showJdbeanItem(false);
    }
    if(dataResult.availableConsignmentGiftNum>0){
      showConsigmentItem(true);
    }else{
        showConsigmentItem(false);
    }
    if (dataResult.balance && dataResult.balance.success){
      if(dataResult.balance.leavyMoney>0){
         showBalanceItem(true);
      }
    }else{
      showBalanceItem(false);
    }

  }window.refushHasAvailableVertual = refushHasAvailableVertual;

  function vertualHidOrShow(){
    if($("#virtualdiv").hasClass("step-toggle-on")){
      vertualhide();
    }else{
      vertualShow();
      var redpacket = 0;
      if($(".order-virtual-tabs ul li").first().attr("id") == "red-packet" || $(".order-virtual-tabs ul li").length>1){
    	  redpacket=1;
      }
      if($("#flowType").val() == "15" && redpacket==1 && window.virtualRedPacket){
    	  window.virtualRedPacket.getStatus();
      }
    }
  }
  //隐藏虚拟资产div
  function vertualhide(){
      $(".order-virtual").css("display", "none");
      $("#virtualdiv").removeClass("step-toggle-on");
      $("#virtualdiv").addClass("step-toggle-off");
  }
  //展开虚拟资产div
  function vertualShow(){
      $(".order-virtual").css("display", "block");
      $("#virtualdiv").removeClass("step-toggle-off");
      $("#virtualdiv").addClass("step-toggle-on");
     initCouponScroll(); //初始化优惠卷
     initFreightScroll(); //初始化运费卷
  }

  function showCouponItem(flag){
    if(flag){
      $("#couponitem").html('<span>优惠券</span><i></i>');
      $("#bestCouponDiv").css("display", "block");
      $("#couponsplit").css("display", "block");
    }else{
      $("#couponitem").html('<span>优惠券</span><i style="display: none"></i>');
      $("#bestCouponDiv").css("display", "none");
      $("#couponsplit").css("display", "none");
    }
  }window.showCouponItem = showCouponItem;

  function showGiftItem(flag){
    if(flag){
      $("#giftitem").html('<span>礼品卡</span><i></i>');
    }else{
      $("#giftitem").html('<span>礼品卡</span><i style="display: none"></i>');
    }
  }window.showGiftItem = showGiftItem;

  function showRedPacket(flag){
      if(flag){
          $("#red-packet").html('<span>红包</span><i></i>');
      }else{
          $("#red-packet").html('<span>红包</span><i style="display: none"></i>');
      }
  }

  function showConsigmentItem(flag){
    if(flag){
        $("#consignmentitem").html('<span>领货码</span><i></i>');
    }else{
        $("#consignmentitem").html('<span>领货码</span><i style="display: none"></i>');
    }
  }
  function showJdbeanItem(flag){
     if(flag){
      $("#jdbeanitem").html('<span>京豆</span><i></i>');
    }else{
      $("#jdbeanitem").html('<span>京豆</span><i style="display: none"></i>');
    }
  }window.showJdbeanItem = showJdbeanItem;

  function showBalanceItem(flag){
    if(flag){
      $("#balanceitem").html('<span>余额</span><i></i>');
    }else{
      $("#balanceitem").html('<span>余额</span><i style="display: none"></i>');
    }
  }window.showJdbeanItem = showJdbeanItem;
function keepScrollbar(type){
  var _this = this;
    if(type === TYPE_COUPON){
       var barPosition = $('.coupon-scrollbar').position();
        _this.position.bar = $(".coupon-tab-panel").css('display') === 'block'?barPosition.top:0;
        _this.position.type =TYPE_COUPON;
    }
    var barUIposition = $('.ui-scrollbar-item-consignee').position();
    _this.position.ui = null === barUIposition?null:barUIposition.top;
}
function scrollbarPosition(){
  var _this = this;
    var type = $('.ui-switchable-item.curr').attr("id");
    if( _this.position.type === type && assertPosition(_this)){
      if(type === TYPE_COUPON){
          $('.coupon-scrollbar').css('top',_this.position.bar);
      }
      $('.ui-scrollbar-item-consignee').css('top',_this.position.ui);
    }
    function assertPosition(obj){
      return null != obj.position.type && null != obj.position.ui && null != obj.position.bar;
    }
}window.scrollbarPosition = scrollbarPosition;