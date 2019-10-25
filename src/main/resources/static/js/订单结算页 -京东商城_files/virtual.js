Class('trade.virtual', {
    init: function (options) {
        var _this = this;
        _this.options = options;
        _this._init();
    },
    _init: function () {
        var _this = this;
        _this._interactiveInit();
        _this._switchInit();
        _this._sweepError();
    },
    _interactiveInit: function () {
        var _this = this;
        _this._initGiftCardSwitch();

    },
    _sweepError: function(){
        $(".ui-switchable-item").click(function () {
            $("#no-pwd-error").hide();
            $("#pwd-error").hide();
        });
        $(".giftcard-tab-item").click(function () {
            $("#no-pwd-error").hide();
            $("#pwd-error").hide();
        });
        $(".accesskey-tab-item").click(function () {
            $("#no-pwd-error").hide();
            $("#pwd-error").hide();
        });
        $(".coupon-tab-item").click(function () {
            $("#no-pwd-error").hide();
            $("#pwd-error").hide();
        });


    },
    _initGiftCardSwitch: function () {
        seajs.use('jdf/1.0.0/ui/switchable/1.0.0/switchable', function (switchable, dialog) {
            $(".giftcard-cont").switchable({
                navItem: 'giftcard-tab-item',
                navSelectedClass: 'curr',
                contentClass: 'giftcard-tab-panel-main',
                mainClass: 'giftcard-tab-panel',
                event: 'click',
                delay: 0
            });

            $(".accesskey-cont").switchable({
                navItem: 'accesskey-tab-item',
                navSelectedClass: 'curr',
                contentClass: 'accesskey-tab-panel-main',
                mainClass: 'accesskey-tab-panel',
                event: 'click',
                delay: 0
            });
        });
    },
    _initGiftCardFn: function () {

        $('#gift_card').find('ul li:first').bind('click', function (e) {
            window.localStorage.setItem('ECard_hasMore', true);
            window.virtualGiftCard.queryECard(1, 1);
            //TODO
            window.virtualGiftCard._scrollEventBind(1)
        });
        $('#gift_card').find('ul li:eq(1)').bind('click', function (e) {
            window.localStorage.setItem('ECard_hasMore', true);
            window.virtualGiftCard.queryECard(-1, 1);
            window.virtualGiftCard._scrollEventBind(0)
        });
        $('#gift_card').find('ul li:last').bind('click', function (e) {
            window.virtualGiftCard._switchCardBind(0);
        });

        //
        $('#consignment_card').find('ul li:first').bind('click', function (e) {
            window.localStorage.setItem('ECard_hasMore', true);
            window.virtualGiftCard.queryECard(2, 1);
            window.virtualGiftCard._scrollEventBind(2)
        });
        $('#consignment_card').find('ul li:eq(1)').bind('click', function (e) {
            window.localStorage.setItem('ECard_hasMore', true);
            window.virtualGiftCard.queryECard(-2, 1);
            window.virtualGiftCard._scrollEventBind(-2)
        });
        $('#consignment_card').find('ul li:last').bind('click', function (e) {
            window.virtualGiftCard._switchCardBind(5);
        });
    },

    _switchInit: function () {
        var _this = this;
        $('#giftitem').click(function (e) {
            //TODO _this.options.availableGiftNum
            window.virtualGiftCard._initECardList(_this, this, e, 1, _this.options.availableGiftNum,_this.options.totalGiftNum);
        });
        $('#consignmentitem').click(function (e) {
            window.virtualGiftCard._initECardList(_this, this, e, 2, _this.options.availableConsignmentGiftNum,_this.options.totalConsignmentGiftNum);
        });
        _this._initGiftCardFn();

    },
    checkPassword: function (key, success) {
        var url = '/virtual/v1/' + key;
        $.request({
            url: url,
            method: 'GET',
            success: success,
            async: false
        })
    },
    _buildVirtual: function (orderPrice) {
        $('#couponUseNum').val(orderPrice.couponNum + orderPrice.freightCouponNum);
        $('#freeFreightCouponUseNum').val(orderPrice.freightCouponNum);
        $('#couponTotalDiscount').val(orderPrice.couponDiscount);
        $('#hiddenFreeFreight_coupon').val(orderPrice.freightCouponDiscount.toFixed(2));
        $('#red-packet-price').data('price', orderPrice.redPacketDiscount);
        $('#giftCardPricehidden').val(orderPrice.giftCardDiscount);
        $('#giftCardPriceNum').val(orderPrice.giftCardNum);
        $('#consignmentCardDiscounthidden').val(orderPrice.consignmentCardDiscount);
        $('#consignmentCardNum').val(orderPrice.consignmentCardNum);
        $('#jdBeanexChange').val(orderPrice.jdBeanDiscount);
        $('#useBalanceShowDiscount').val(orderPrice.balanceDiscount);
    },

    //TODO
    _flushOrderPrice: function (orderPrice) {
        var _this = this;
        if(orderPrice.presaleRealDingjin !=null && orderPrice.presaleRealDingjin !=""){
        	$("#presaleRealDingjinOld").text("￥"+orderPrice.presaleRealDingjin.toFixed(2));
        }
        if(orderPrice.presaleDingJinFactPrice !=null && orderPrice.presaleDingJinFactPrice !="" && Number(orderPrice.presaleDingJinFactPrice)>0){
        	$("#presaleRealDingjin").text("￥"+Number(orderPrice.presaleDingJinFactPrice).toFixed(2));
        }
        _this._buildVirtual(orderPrice);
        if (orderPrice.redPacketDiscount != null) {
            $('#red-packet-price').find('em').html("-￥" + orderPrice.redPacketDiscount.toFixed(2));
        }
        // 修改礼品卡结算信息
        if (orderPrice.giftCardDiscount != null) {
            $("#giftCardPriceId").text("-￥" + orderPrice.giftCardDiscount.toFixed(2));
            orderPrice.giftCardDiscount == 0 ? $("#showGiftCardPrice").hide() : $("#showGiftCardPrice").show()
        } else {
            $("#showGiftCardPrice").hide();
        }
        //领货码
        if (orderPrice.consignmentCardDiscount != null) {
            $("#gconsignmentCardId").text("-￥" + orderPrice.consignmentCardDiscount.toFixed(2));
            orderPrice.consignmentCardDiscount == 0 ? $("#consignmentCardPrice").hide() : $("#consignmentCardPrice").show();
        } else {
            $("#consignmentCardPrice").hide();
        }
        // 修改余额
        if (orderPrice.balanceDiscount != null) {
            $("#usedBalanceId").text("-￥" + orderPrice.balanceDiscount.toFixed(2));
            orderPrice.balanceDiscount == 0 ? $("#showUsedOrderBalance").hide() : $("#showUsedOrderBalance").show();
        } else {
            $("#showUsedOrderBalance").hide();
        }
        // 修改京豆
        if (orderPrice.jdBeanDiscount != null) {
            $("#usedJdBeanId").text("-￥" + orderPrice.jdBeanDiscount.toFixed(2));
            orderPrice.jdBeanDiscount == 0 ? $("#showUsedJdBean").hide() : $("#showUsedJdBean").show();
        } else {
            $("#showUsedJdBean").hide();
        }

        if (orderPrice.factPrice || orderPrice.factPrice === 0) {
            modifyNeedPay(orderPrice.factPrice.toFixed(2));
        }
        refushVertualused();
    },

    setAvailableNumbers: function (data) {
        var _this = this;
            _this.options.availableGiftNum = data.availableGiftNum;
            _this.options.availableConsignmentGiftNum = data.availableConsignmentGiftNum;
            _this.options.totalGiftNum = data.totalGiftNum;
            _this.options.totalConsignmentGiftNum = data.totalConsignmentGiftNum;
    },

    _noFundsPassword: function () {
        var showMessage = '<div class="tip-box icon-box"><span class="warn-icon m-icon"></span><div class="item-fore">'
        var safetyCenter=$("#safetyCenter").val();
        showMessage += '<h3>支付密码未开启</h3>'
        showMessage += '<div>为保障您的账户资金安全，请先开启支付密码</div>'
        showMessage += '</div><div class="op-btns ac"><a href="javascript:void(0);" onclick="$.closeDialog(); window.open(\''+safetyCenter+'\')" class="btn-9">前往开启</a></div></div>';
        $('body').dialog({

            title: '提示',
            width: 380,
            height: 100,
            type: 'html',
            autoIframe: false,
            source: showMessage
        });
    },
    showErrorDlg: function(title, subtitle , text){
        var html = template('J_common-tips-error-dialog', {"title":title,"subtitle":subtitle ,"context":text});
        $("body").dialog({
            title: null,
            width: 420,
            type: "html",
            extendMainClass: "common-tips-dialog",
            source: html,
            onReady: function() {
                $(".comon-tips-btn").click(function() {
                    $.closeDialog()
                })
            }
        })
    },
});