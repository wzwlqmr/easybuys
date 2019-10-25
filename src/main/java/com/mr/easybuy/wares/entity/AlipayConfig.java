package com.mr.easybuy.wares.entity;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101300672669";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC0Cz+8X0nLtRPwCCx/wD0wb8w+HYJ6osKK9i0/VapOXiY0sENcTOdCSRJITmQ7fVK7iD67cu82GB6N7e0NKiboODFFbBzjlg62JpfSWS2HlcsxJLNyxp94Y+8yoPb4cDlDe6VDoAG0A2m9zN61+bnbjn9WSXjZ+CG/2RuJ7/6o90DpLijZylHxCSmngJ5NJB8DrwRYbFIkfk5+Z9WI3SohhIxLUaYQAAmmCaCesK4KxM8uLthCI5avYufPjfjym0LUyRkqCEBsjh357QfjJSWwO72gvixaz/ZOk+zqsdZBzQWE+6Cu5QleNstt2P61jC4d/tC8cQVusbHmRqNxxQUHAgMBAAECggEAWmZTiDeoC/pNmnXgMfzKPGnF+WJDw2O5nqBgs65FprerI0VlbRDIBQY/gcKqnRwd0D9mkCPzbAvMO6M9JSEHDA463wqbrsIHfPn/vQQ90hgqP/CXkYedRouW7KrZloByoCmTH1NVx5b3Hu+g22oaId14nlCht3/ZIkTWiPnRufAkFK51wQ1lmuWvuNj7/c8WiHEcczTPPi75MoKy70avf0Px8rIjPR6bkrCQLTvhGJ3ZY2aeh32QQ0hhGRU0nfF8kkNkPnnmewjTWjCRnZtMH38n481Q/hcwFZq848ete7k/mlfhrsX0RfvejDvpld0HePPMrGuizDFYBz2Gjyf+wQKBgQDePYsGEuIiJIree3SrKtUms6Tu4L/rXipJso55CvWME0hjRbHCOVL3tKkAOxSWMPKKccHhI6oAQH8otzn4bn58YojBI8LvAtlASalrGl8ZcTBvlL4ChLEKG6nUoePqLo+B1EZPg8jfT2t7js9fVqkUldcwMG26Lv5qkIFOi0BhVwKBgQDPZMZz1H87oyRK9zOCzdPkUogb0DJxXO043L9ZpQYziSy7OrZ7nIgQdGMb+sUDEzp8XfLO9Y2Fb4XHpDCbRvZ+sB24VrJR+zleD9S8tgB1z6TZu3yOIyt+S9GZtDz11eoq5UGxxaZHD6Ya6+rQ8eNijXdbVjCz20NHpEWXBd270QKBgHn9gkCVQPfI40l4rvP+EP6rgY92YyLJj6DgmIAs2dhIBWYorYiVestpqZLs20IOIDSKeQgiUYDN5n7tBK8vx9JzK+oIvUoBYEt/o7WcxjLrBNFa7mnneF66DKEhNEApyrBTWzzuc+bQa4lpPL9yjGE2VuamzrRyc0j/hVsd6PsFAoGAK1DpAhhH2rTgR6gJ4jALKYzzUJvTbUnzYgT5EkgdW3YzGYfRxU+UO5uTd6yQqWvCs2cL553xyQTZ9DCe1k+j/CHckzvIUscd3D+CN0fsIK8Vx0QZZ7aAxwge5vN2KAJdvkfTyMV3TTA/iS/tA2cCDvttCm6eDXKmQrhUsI5RGYECgYAuk0GxspVWhbUKzdwzAPLakTJTQ6++7w0fnmtrX7l9MVjgikZSmDmqoJRFpSmI6CYsnGFaABjrC31vZvnoRwHFsJQM2Y5gOzeVrxcG1objvp5RNWouqBQJyx2a6cKjLF0LIfMcFR+HaL59M5tYUjciaZmRytbFUJQt/km0uuZMWQ==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtAs/vF9Jy7UT8Agsf8A9MG/MPh2CeqLCivYtP1WqTl4mNLBDXEznQkkSSE5kO31Su4g+u3LvNhgeje3tDSom6DgxRWwc45YOtiaX0lkth5XLMSSzcsafeGPvMqD2+HA5Q3ulQ6ABtANpvczetfm5245/Vkl42fghv9kbie/+qPdA6S4o2cpR8Qkpp4CeTSQfA68EWGxSJH5OfmfViN0qIYSMS1GmEAAJpgmgnrCuCsTPLi7YQiOWr2Lnz4348ptC1MkZKghAbI4d+e0H4yUlsDu9oL4sWs/2TpPs6rHWQc0FhPugruUJXjbLbdj+tYwuHf7QvHEFbrGx5kajccUFBwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://127.0.0.1:8085/order/notifyUrl";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://127.0.0.1:8085/order/returnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\Alibaba";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

