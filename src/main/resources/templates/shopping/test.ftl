<!DOCTYPE html>
<!-- saved from url=(0055)https://trade.jd.com/shopping/order/getOrderInfo.action -->
<html xmlns="http://www.w3.org/1999/xhtml" class=""><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">

    <title>订单结算页 -京东商城</title>
    <!--结算页面样式-->
    <link rel="stylesheet" href="/js/订单结算页 -京东商城_files/bankList.css" charset="utf-8">
    <link type="text/css" rel="stylesheet"
          href="/js/订单结算页 -京东商城_files/saved_resource" source="widget">
    <link type="text/css" rel="stylesheet"
          href="/js/订单结算页 -京东商城_files/saved_resource(1)">
    <script type="text/javascript" defer="" async="" src="/js/订单结算页 -京东商城_files/uaest.js">

    </script>

    </script>
    <script type="text/javascript" async="" src="/js/订单结算页 -京东商城_files/te.js" id="tak_trv">

    </script>
    <script type="text/javascript" src="/js/订单结算页 -京东商城_files/jquery-1.6.4.js">

    </script><style type="text/css">
        :root div[id^="miaozhen"],
        :root a[href*="wan.jd.com/"],
        :root .gl-i-wrap img[data-url*=".jd.com/dsp/"],
        :root .gl-i-wrap a[href*=".jd.com/dsp/"],
        :root .ab-goods
        { display: none !important; }</style>
    <script type="text/javascript" src="/js/订单结算页 -京东商城_files/saved_resource(2)"></script>
    <script type="text/javascript" src="/js/订单结算页 -京东商城_files/cookieTrack_v4.js"></script>

    <script type="text/javascript" src="/js/订单结算页 -京东商城_files/order.common.js"></script>
    <script type="text/javascript" src="/js/订单结算页 -京东商城_files/jquery.checkout.js"></script>
    <script type="text/javascript" src="/js/订单结算页 -京东商城_files/class.mini.js"></script>
    <style>@font-face{font-family:uc-nexus-iconfont;src:url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_9qmmi8b8jsxxbt9.woff) format('woff'),url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_9qmmi8b8jsxxbt9.ttf) format('truetype')}</style><div id="BIJIA_HAS_BUILT">

    </div>
    <script src="/js/订单结算页 -京东商城_files/z_stat.php" async="" defer="">

    </script>
    <link charset="utf-8" rel="stylesheet" href="/js/订单结算页 -京东商城_files/tips.css">
</head>
<body id="mainframe">
<!--shortcut start-->
<div id="o-header-2013"><div id="header-2013" style="display:none;"></div></div>
<!--shortcut end-->
<!--shortcut end-->


<div class="w w1 header clearfix">

    <div class="stepflex" id="#sflex03">
        <dl class="first done">
            <dt class="s-num">1</dt>
            <dd class="s-text">1.我的购物车<s></s><b></b></dd>
        </dl>
        <dl class="normal doing">
            <dt class="s-num">2</dt>
            <dd class="s-text">2.填写核对订单信息<s></s><b></b></dd>
        </dl>
        <dl class="normal last">
            <dt class="s-num">3</dt>
            <dd class="s-text">3.成功提交订单<s></s><b></b></dd>
        </dl>
    </div>
</div>

<!-- /header -->
<!--/ /widget/header/header.tpl -->


<!-- main -->
<div id="container">
    <div id="content" class="w">
        <!-- <div class="m"> -->
        <div class="orderInfo-tip hide" style="display: none;">
            <span class="wicon"></span>
            <span class="ftx-03"> 温馨提示：订单中存在不支持7天无理由退商品，请确认相关商品信息后提交订单。</span>
            <span class="cls-btn" onclick="closeorderInfotip()">x</span>
        </div>
        <div class="checkout-tit">
            <span class="tit-txt">填写并核对订单信息</span>
        </div>
        <!--<div class="mc">-->
        <div class="checkout-steps">
            <!--  /widget/consignee-step/consignee-step.tpl -->
            <div class="step-tit">
                <h3>收货人信息</h3>
                <div class="tips-new-white hide" id="tariffTip"><b></b><span>目的国/地区如产生关税及其它相关费用，需用户自行承担</span></div>
                <div class="tips-new-white hide" id="hkTip"><b></b><span>收货地址为住宅时，需向配送员支付住宅附加费：20港币/单</span></div>
                <div class="extra-r">
                    <!--<a href="#none" class="ftx-05" onclick="use_NewConsignee()" clstag="pageclick|keycount|trade_201602181|3">新增收货地址</a>-->
                    <input type="hidden" id="del_consignee_type" value="0">
                </div>
            </div>
            <div class="step-cont">
                <div id="consignee-addr" class="consignee-content">
                    <div class="consignee-scrollbar">
                        <div class="ui-scrollbar-main">
                            <div class="consignee-scroll">
                                <div class="consignee-cont" id="consignee1" style="height: 42px;">
                                    <ul id="consignee-list">

                                        <li class="ui-switchable-panel ui-switchable-panel-selected" style="display: list-item;" id="consignee_index_1042400590" selected="selected" c_li_custom_label="consignee_li">
                                            <div class="consignee-item item-selected" longitude="1000.0" gclng="116.2901" latitude="1000.0" gclat="40.145119" consigneeid="1042400590" provinceid="1" cityid="2901" countyid="55561" townid="0" id="consignee_index_div_1042400590" consigneetype="0" clstag="pageclick|keycount|trade_201602181|1" c_div_custom_label="consignee_div">
                                                <span limit="8" title="王志文">王志文</span><b></b>
                                            </div>
                                            <div class="addr-detail">
                                                <!--yanwenqi 全球购添加idcard 不是国际购的要不要显示？ -->
                                                <span class="addr-name" limit="6" title="王志文">王志文</span>
                                                <span class="addr-info" limit="45" title="北京 昌平区 沙河地区  北京市昌平区沙河镇北京科技经营管理学院（新校区西门）">北京 昌平区 沙河地区  北京市昌平区沙河镇北京科技经营管理学院（新校区西门）</span>
                                                <span class="addr-tel">150****4908</span>
                                                <span class="addr-default">默认地址</span>
                                            </div>
                                            <div class="op-btns" consigneeid="1042400590" isoldaddress="false">
                                            </div>
                                        </li>


                                        <!-- 地址升级提示:两种情况 -->
                                        <!-- 地址升级隐藏域信息 -->
                                        <input type="hidden" id="hid_upArea_1042400590" consigneeid="1042400590" isoldaddress="false" ismapping="false" newprovinceid="0" newcityid="0" newcountyid="0" newtownid="0" newprovincename="" newcityname="" newcountyname="" newtownname="" address_type="1" addressname="王志文" name="王志文" email="" mobile="150****4908" phone="" idcard="" address="北京市昌平区沙河镇北京科技经营管理学院（新校区西门）" ceshi1="" style="display: none;">

                                        <!-- -->
                                        <input type="hidden" id="hidden_consignees_size" value="5" style="display: none;">
                                        <li class="ui-switchable-panel ui-switchable-panel-selected" style="display: none;" id="consignee_index_1398207306" c_li_custom_label="consignee_li">
                                            <div class="consignee-item" longitude="116.21961212158203" gclng="116.22092" latitude="40.098182678222656" gclat="40.09644" consigneeid="1398207306" provinceid="1" cityid="2800" countyid="55823" townid="0" id="consignee_index_div_1398207306" clstag="pageclick|keycount|trade_201602181|1" c_div_custom_label="consignee_div">
                                                <span limit="8" title="梦如">梦如</span><b></b>
                                            </div>
                                            <div class="addr-detail">
                                                <!--yanwenqi 全球购添加idcard 不是国际购的要不要显示？ -->
                                                <span class="addr-name" limit="6" title="梦如">梦如</span>
                                                <span class="addr-info" limit="45" title="北京 海淀区 上庄镇  上庄家园小区东区29号楼6单元601室">北京 海淀区 上庄镇  上庄家园小区东区29号楼6单元601室</span>
                                                <span class="addr-tel">159****5647</span>
                                            </div>

                                            <div class="op-btns" consigneeid="1398207306" isoldaddress="false">
                                            </div>
                                        </li>





                                        <!-- 地址升级提示:两种情况 -->
                                        <!-- 地址升级隐藏域信息 -->
                                        <input type="hidden" id="hid_upArea_1398207306" consigneeid="1398207306" isoldaddress="false" ismapping="false" newprovinceid="0" newcityid="0" newcountyid="0" newtownid="0" newprovincename="" newcityname="" newcountyname="" newtownname="" address_type="1" addressname="梦如" name="梦如" email="" mobile="159****5647" phone="" idcard="" address="上庄家园小区东区29号楼6单元601室" ceshi1="" style="display: none;">

                                        <li class="ui-switchable-panel ui-switchable-panel-selected" style="display: none;" id="consignee_index_1035137680" c_li_custom_label="consignee_li">
                                            <div class="consignee-item" longitude="1000.0" gclng="116.282959" latitude="1000.0" gclat="40.03352" consigneeid="1035137680" provinceid="1" cityid="2800" countyid="55818" townid="0" id="consignee_index_div_1035137680" clstag="pageclick|keycount|trade_201602181|1" c_div_custom_label="consignee_div">
                                                <span limit="8" title="齐梦如">齐梦如</span><b></b>
                                            </div>
                                            <div class="addr-detail">
                                                <!--yanwenqi 全球购添加idcard 不是国际购的要不要显示？ -->
                                                <span class="addr-name" limit="6" title="齐梦如">齐梦如</span>
                                                <span class="addr-info" limit="45" title="北京 海淀区 马连洼街道  亿城国际中心418室">北京 海淀区 马连洼街道  亿城国际中心418室</span>
                                                <span class="addr-tel">159****5647</span>
                                            </div>

                                            <div class="op-btns" consigneeid="1035137680" isoldaddress="false">
                                            </div>
                                        </li>





                                        <!-- 地址升级提示:两种情况 -->
                                        <!-- 地址升级隐藏域信息 -->
                                        <input type="hidden" id="hid_upArea_1035137680" consigneeid="1035137680" isoldaddress="false" ismapping="false" newprovinceid="0" newcityid="0" newcountyid="0" newtownid="0" newprovincename="" newcityname="" newcountyname="" newtownname="" address_type="1" addressname="齐梦如" name="齐梦如" email="" mobile="159****5647" phone="" idcard="372**********7022" address="亿城国际中心418室" ceshi1="" style="display: none;">

                                        <li class="ui-switchable-panel ui-switchable-panel-selected" style="display: none;" id="consignee_index_1030004122" c_li_custom_label="consignee_li">
                                            <div class="consignee-item" longitude="1000.0" gclng="115.528427" latitude="1000.0" gclat="34.605881" consigneeid="1030004122" provinceid="13" cityid="1099" countyid="1102" townid="26262" id="consignee_index_div_1030004122" clstag="pageclick|keycount|trade_201602181|1" c_div_custom_label="consignee_div">
                                                <span limit="8" title="王志文">王志文</span><b></b>
                                            </div>
                                            <div class="addr-detail">
                                                <!--yanwenqi 全球购添加idcard 不是国际购的要不要显示？ -->
                                                <span class="addr-name" limit="6" title="王志文">王志文</span>
                                                <span class="addr-info" limit="45" title="山东 菏泽市 曹县 朱洪庙乡 陈李村297号">山东 菏泽市 曹县 朱洪庙乡 陈李村297号</span>
                                                <span class="addr-tel">136****6931</span>
                                            </div>

                                            <div class="op-btns" consigneeid="1030004122" isoldaddress="false">
                                            </div>
                                        </li>





                                        <!-- 地址升级提示:两种情况 -->
                                        <!-- 地址升级隐藏域信息 -->
                                        <input type="hidden" id="hid_upArea_1030004122" consigneeid="1030004122" isoldaddress="false" ismapping="false" newprovinceid="0" newcityid="0" newcountyid="0" newtownid="0" newprovincename="" newcityname="" newcountyname="" newtownname="" address_type="1" addressname="王志文" name="王志文" email="" mobile="136****6931" phone="" idcard="" address="陈李村297号" ceshi1="" style="display: none;">

                                        <li class="ui-switchable-panel ui-switchable-panel-selected" style="display: none;" id="consignee_index_138001941" c_li_custom_label="consignee_li">
                                            <div class="consignee-item" longitude="1000.0" gclng="117.54644" latitude="1000.0" gclat="36.67699" consigneeid="138001941" provinceid="13" cityid="1000" countyid="40493" townid="51331" id="consignee_index_div_138001941" clstag="pageclick|keycount|trade_201602181|1" c_div_custom_label="consignee_div">
                                                <span limit="8" title="王志文">王志文 山东</span><b></b>
                                            </div>
                                            <div class="addr-detail">
                                                <!--yanwenqi 全球购添加idcard 不是国际购的要不要显示？ -->
                                                <span class="addr-name" limit="6" title="王志文">王志文</span>
                                                <span class="addr-info" limit="45" title="山东 济南市 章丘区 城区 齐鲁理工学院-教学楼">山东 济南市 章丘区 城区 齐鲁理工学院-教学楼</span>
                                                <span class="addr-tel">136****6931</span>
                                            </div>

                                            <div class="op-btns" consigneeid="138001941" isoldaddress="false">
                                            </div>
                                        </li>





                                        <!-- 地址升级提示:两种情况 -->
                                        <!-- 地址升级隐藏域信息 -->
                                        <input type="hidden" id="hid_upArea_138001941" consigneeid="138001941" isoldaddress="false" ismapping="false" newprovinceid="0" newcityid="0" newcountyid="0" newtownid="0" newprovincename="" newcityname="" newcountyname="" newtownname="" address_type="1" addressname="" name="王志文" email="" mobile="136****6931" phone="136****6931" idcard="" address="齐鲁理工学院-教学楼" ceshi1="" style="display: none;">

                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="addr-switch switch-on" id="consigneeItemAllClick" onclick="show_ConsigneeAll()" clstag="pageclick|keycount|trade_201602181|2">
                    <span>更多地址</span><b></b>
                </div>
                <div class="addr-switch switch-off hide" id="consigneeItemHideClick" onclick="hide_ConsigneeAll()">
                    <span>收起地址</span><b></b>
                </div>



            </div>
            <!--/ /widget/consignee-step/consignee-step.tpl -->
            <div class="hr"></div>
            <!--/ /widget/shopping-list/shopping-list.tpl -->
            <div id="shipAndSkuInfo">
                <div id="payShipAndSkuInfo">
                    <div class="step-tit">
                        <h3>支付方式</h3>
                    </div>
                    <div type="hide"></div>
                    <input type="hidden" id="totalPriceVender" value="0">
                    <input type="hidden" id="totalNumVender" value="0">
                    <div class="plusProductListVender hide">[]</div>
                    <input type="hidden" id="crossRegionalFeeVender" value="">
                    <div class="crossSkuVender hide"></div>
                    <div class="step-cont">
                        <div class="payment-list" id="">
                            <div class="list-cont">
                                <ul id="payment-list">
                                    <input type="hidden" id="instalmentPlan" value="false">


                                    <li style="cursor: pointer;">
                                        <div class="payment-item online-payment payment-item-disabled" for="pay-method-1" payname="货到付款" payid="1" clstag="pageclick|keycount|trade_201602181|8">
                                            <b></b>
                                            货到付款
                                            <span id="codtips" class="qmark-icon qmark-tip" data-tips="商品属性或所在地区不支持货到付款 &lt;a href=&#39;//help.jd.com/user/issue/103-983.html&#39; target=&#39;_blank &#39;class=&#39;ftx-05&#39;&gt;查看服务及配送范围&lt;/a&gt;"></span>
                                        </div>
                                    </li>

                                    <!-- 是否限制该支付方式 -->
                                    <li style="cursor: pointer;" onclick="
				save_Pay(4,0,1);" clstag="pageclick|keycount|trade_201602181|7">

                                        <div class=" payment-item item-selected online-payment " for="pay-method-4" payname="在线支付" payid="4" onlinepaytype="0"><b></b>
                                            <em class="payment-promo">惠</em>
                                            在线支付                    													                <span id="cod" class="qmark-icon qmark-tip" data-tips="即时到账，支持绝大数银行借记卡及部分银行信用卡 &lt;a href=&#39;//help.jd.com/user/issue/223-562.html&#39; target=&#39;_blank&#39; class=&#39;ftx-05&#39;&gt; 查看银行及限额&lt;/a&gt;"></span>                 																</div>
                                    </li>


                                    <!-- 是否限制该支付方式 -->
                                    <li style="cursor: pointer;" onclick="
				save_Pay(5,0,1);" clstag="pageclick|keycount|trade_201602181|9">

                                        <div class="hide payment-item  online-payment " for="pay-method-5" payname="公司转账" payid="5" onlinepaytype="0"><b></b>
                                            公司转账                    													                                												<span class="qmark-icon qmark-tip" data-tips="通过快钱平台转账 转账后1-3个工作日内到账 &lt;a href=&#39;//help.jd.com/user/issue/list-175.html&#39; target=&#39;_blank&#39; class=&#39;ftx-05&#39;&gt;查看账户信息&lt;/a&gt;"></span> 				</div>
                                    </li>


                                    <li id="payment-less" class="hide">
                                        <div class="payment-item-on" clstag="pageclick|keycount|PaymentLead__2016030411|10">
                                            <span>收起</span><b></b>
                                        </div>
                                    </li>
                                    <li id="payment-more">
                                        <div class="payment-item-off" clstag="pageclick|keycount|PaymentLead__2016030411|9">
                                            <span>更多</span><b></b>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="hr"></div>
                    <!--/ /widget/payment-step/payment-step.tpl -->
                    <div class="step-cont" id="skuPayAndShipment-cont">
                        <!--添加商品清单  zhuqingjie -->
                        <div class="shopping-lists" id="shopping-lists">
                            <!--定义大商品清单LIST-->
                            <div class="hide" id="skuDetailInfo" notonemainsku="false"></div>
                            <div class="shopping-list ABTest">
                                <div class="goods-list">
                                    <!--单品开始-->
                                    <div class="goods-items">     						                                 <div data-service=""></div>
                                        <div class="goods-item goods-item-extra" goods-id="100005014771" sx-type="">

                                            <div class="p-img">
                                                <a target="_blank" href="http://item.jd.com/100005014771.html?dist="><img src="/js/订单结算页 -京东商城_files/e1cc38487b20b624.jpg" alt="" data-zoom-img-src="https://img14.360buyimg.com/N0/jfs/t1/84172/14/12390/309351/5d9d8ea6E109a2cfb/e1cc38487b20b624.jpg"></a>
                                            </div>
                                            <div class="goods-msg">
                                                <div class="goods-msg-gel">
                                                    <div class="p-name">

                                                        <a href="http://item.jd.com/100005014771.html?dist=" target="_blank">
                                                            松下（Panasonic）S1H全画幅微单相机 单电/无反数码相机 (6K视频、双原生ISO、5轴防抖、4:2:2 10bit)
                                                        </a>
                                                    </div>
                                                    <div class="p-price ">
                                                        <!--增加预售金额显示 begin   预售分阶段支付类型（1：一阶梯全款支付；2：一阶梯定金支付(全款或定金可选)；3：三阶梯(仅定金)；4：三阶梯(全款或定金可选)；5：一阶梯仅定金支付） -->


                                                        <strong class="jd-price">
                                                            ￥ 26998.00

                                                            <em class=""></em>
                                                        </strong>
                                                        <!--增加预售金额显示 end-->
                                                        <span class="p-num">
                                                                        x1
                                                            </span>
                                                        <span id="pre-state" class="p-state" skuid="100005014771">有货</span>
                                                        <span class="p-weight">2.850kg</span>

                                                    </div>
                                                </div>
                                            </div>
                                            <!-- 颜色尺码以及车型begin -->
                                            <!-- 颜色尺码以及车型end -->
                                            <div class="p-icon-continer">
                                                <i class="p-icon p-icon-w sevenicon"></i><span class="ftx-07 withouthk seven">支持7天无理由退货（拆封后不支持）
                                                    <!-- 京尊达 begin -->
                                                    <!-- 京尊达 end -->
                </span></div>

                                            <div class="clr"></div>
                                        </div>
                                    </div>
                                    <!--单品结束-->
                                </div><!--goods-list 结束-->
                                <div class="clr"></div>
                            </div>
                            <div id="trade-nostock-recommendation-render" style="display:none"></div>
                            <!--隐藏的无货代下单div-->
                            <!--无货代下单失败提示div-->
                            <!--无货代下单成功提示div-->
                            <div class="clr"></div>
                        </div>
                        <!--shopping-lists 结束-->
                    </div>
                </div>
            </div>
        <div class="trade-foot">
            <div id="plusInfoByFreight" class="hide"></div>
            <div id="plusInfo" class="hide"></div>
            <div class="trade-foot-detail-com">
                <div class="fc-price-info">
                    <span class="price-tit">应付总额：</span>
                    <span class="price-num" id="sumPayPriceId">￥26998.00</span>
                </div>
                <div class="fc-baitiao-info" style="display: none;">
                    <span>白条支付：<em>不分期</em>（不使用优惠）<i class="bt-edit-icon" onclick="javascript:btDetail();" clstag="pageclick|keycount|PaymentLead__2016030411|5"></i></span>
                </div>
                <div class="giftbuy-info">
                    <label class="noShowMoney hide" id="giftBuyHidePriceDiv">
                        <input type="checkbox" id="giftBuyHidePrice" checked="">包装内不显示礼品价格
                    </label>
                </div>
                <div class="fc-consignee-info">
                    <span class="mr20" id="sendAddr">寄送至： 北京 昌平区 沙河地区   北京市昌平区沙河镇北京科技经营管理学院（新校区西门）</span>
                    <span id="sendMobile">收货人：王志文 150****4908</span>
                </div>
            </div>
            <!-- 支付密码 -->
            <div class="pay-pwd mt10 hide" id="paypasswordPanel" style="display: none;">
                <div id="payPassword_container" class="alieditContainer clearfix" data-busy="0">
                    <label for="i_payPassword" class="i-block">支付密码：</label>
                    <div class="i-block">
                        <div class="i-block six-password">
                            <input class="i-text sixDigitPassword" id="txt_paypassword" type="text" onfocus="this.type=&#39;password&#39;" autocomplete="off" required="required" value="" name="payPassword_rsainput" data-role="sixDigitPassword" tabindex="" maxlength="6" minlength="6" aria-required="true" onchange="clearError()">
                            <div tabindex="0" class="sixDigitPassword-box">
                                <i><b></b></i>
                                <i><b></b></i>
                                <i><b></b></i>
                                <i><b></b></i>
                                <i><b></b></i>
                                <i><b></b></i>
                                <span id="cardwrap" data-role="cardwrap"></span>
                            </div>
                        </div>
                        <span class="forgot-password">
	              </span>
                    </div>
                </div>
                <div id="no-pwd-error" class="pay-pwd-error hide">
                    <label class="error-msg" for="">请输入6位数字密码</label>
                </div>
                <div id="pwd-error" class="pay-pwd-error hide" style="margin-right: 16px; display: none;">
                    <label class="error-msg" for=""></label>
                </div>
                <div class="payment-bt-tips hide">
                    <span class="bt-tips-cont">结算金额变动，请重新选择白条分期以及白条优惠</span><i class="bt-tips-close" onclick="closebtErrorTip();">×</i>
                </div>
            </div>
            <!-- 预售 -->
            <!-- 全球售、台湾售、香港售 -->
            <div class="hkmtbuy-con hide" id="overseamtbuy-area">
                <div class="hkmtbuy-chk">
                </div>
            </div>
            <!-- 快递到车 -->
            <div class="hkmtbuy-con hide" id="car_Agreement_tips">
                <div class="hkmtbuy-chk">
                </div>
            </div>

            <!-- 快递到车 -->
            <div class="hkmtbuy-con hide" id="car_Agreement_tips">
                <div class="hkmtbuy-chk">
                </div>
            </div>


            <div id="checkout-floatbar" class="group">
                <div class="ui-ceilinglamp checkout-buttons">
                    <div class="sticky-placeholder hide" style="display: none;">
                    </div>
                    <div class="sticky-wrap">
                        <div class="inner">
                            <button type="submit" class="checkout-submit" id="order-submit" onclick="javascript:submit_Order(null,2);" clstag="pageclick|keycount|trade_201602181|25">
                                提交订单<b></b>
                            </button>
                            <button type="submit" id="enterPriseUserPaymentSubmit" style="display:none;" class="checkout-submit-combine" onclick="javascript:submit_Order(1);" data-tips="若您要下多个订单，可以先提交订单再去订单中心合并支付，效率更高哟~">
                                提交订单暂不支付
                            </button>
                            <span id="checkCodeDiv"></span>

                            <div class="checkout-submit-tip" id="changeAreaAndPrice" style="display: none;">
                                由于价格可能发生变化，请核对后再提交订单
                            </div>
                            <!--div style="display:none" id="factoryShipCodShowDivBottom" class="dispatching">
                              部分商品货到付款方式：先由京东配送“提货单”并收款，然后厂商发货。
                            </div-->
                        </div>
                        <span id="submit_message" style="display:none" class="submit-error"></span>

                        <div class="submit-check-info" id="submit_check_info_message" style="display:none"></div>
                    </div>
                </div>
            </div>

        </div>
        <!--/ /widget/checkout-floatbar/checkout-floatbar.tpl -->

        <!--  /widget/backpanel/backpanel.tpl -->
        <div id="backpanel">
            <div id="backpanel-inner" class="hide" style="right: 414.5px;">
                <div class="bp-item bp-item-survey">
                    <a href="http://surveys.jd.com/index.php?r=survey/index/sid/416587/lang/zh-Hans" class="survey" target="_blank">我要反馈</a>
                </div>
                <div class="bp-item bp-item-backtop" data-top="0">
                </div>
            </div>
        </div>
        <!--/ /widget/backpanel/backpanel.tpl -->

    </div>

</div>


<script type="text/javascript" rel="stylesheet" src="/js/订单结算页 -京东商城_files/saved_resource(3)" source="widget"></script>
<script type="text/javascript" rel="stylesheet" src="/js/订单结算页 -京东商城_files/paypwd.js"></script>

<!-- 港澳售项目 -->
<script id="hkmt-box01" type="text/temp">
<div class="hkmt-thickbox-warn">
	<div class="tip-box icon-box-new">
		<span class="warn-icon-yellow m-icon"></span>
		<div class="item-fore">
			<span>订单中部分商品不支持对当前地址的配送<br>请返回购物车修改</span>
		</div>
	</div>
	<div class="op-btns ac mt30 mb30">
		<a href="//cart.jd.com" class="btn-1">返回购物车</a>
		<a href="#none" class="btn-9 ml10" onclick="javascript:closeDialog();">取消</a>
	</div>
</div>
</script>
<!-- 海外、台湾协议 -->
<style>
    .overseaConfirmBtn a {
        padding:5px 50px;
        margin-top:15px;
        color:#fff;
        background:#e22;
        border:0;
        font-size:16px;
        font-family:"Microsoft YaHei","Hiragino Sans GB";
    }
    .hkbuy-dialog p {
        line-height:20px;
        margin:10px;
    }
</style>
<style>
    .tableborder {
        border-right-width: 1px;
        border-bottom-width: 1px;
        border-right-style: solid;
        border-bottom-style: solid;
    }
    .tableborder th{
        border-top-width: 1px;
        border-left-width: 1px;
        border-top-style: solid;
        border-left-style: solid;
    }
    .tableborder td{
        border-top-width: 1px;
        border-left-width: 1px;
        border-top-style: solid;
        border-left-style: solid;
    }
</style>


<!-- 不降级  -->
<script src="/js/订单结算页 -京东商城_files/td.js"></script>
<script src="/js/订单结算页 -京东商城_files/y.html"></script>




<script src="/js/订单结算页 -京东商城_files/td.js(1)"></script>
</body><script src="/js/订单结算页 -京东商城_files/td.js(1)"></script></html>