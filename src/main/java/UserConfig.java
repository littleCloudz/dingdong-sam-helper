import cn.hutool.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户信息
 * 通过小程序抓包购物车接口获取headers和body中的数据填入
 */
public class UserConfig {

    //城市
    public static final String cityId = "0101";//默认上海

    //站点id
    public static final String stationId = "";

    //收货地址id
    public static final String addressId = "";

    /**
     * 确认收货地址id和站点id
     * 每天抢之前先允许一下此接口 确认登录信息是否有效 如果失效了重新抓一次包
     */
    public static void main(String[] args) {
        Api.checkUserConfig();
    }

    /**
     * 抓包后参考项目中的image/headers.jpeg 把信息一行一行copy到下面 没有的key不需要复制
     */
    public static Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("ddmc-city-number", cityId);
        headers.put("ddmc-time", String.valueOf(new Date().getTime() / 1000));
        headers.put("ddmc-build-version", "2.83.0");
        headers.put("ddmc-station-id", stationId);
        headers.put("ddmc-channel", "applet");
        headers.put("ddmc-os-version", "[object Undefined]");
        headers.put("ddmc-app-client-id", "4");
        headers.put("ddmc-ip", "");
        headers.put("ddmc-api-version", "9.50.0");
        headers.put("accept-encoding", "gzip,compress,br,deflate");
        headers.put("referer", "https://servicewechat.com/wx1e113254eda17715/425/page-frame.html");

        // ------------  填入以下6项 上面不要动 ------------
        headers.put("ddmc-device-id", "");
        headers.put("cookie", "");
        headers.put("ddmc-longitude", "");
        headers.put("ddmc-latitude", "");
        headers.put("ddmc-uid", "");
        headers.put("user-agent", "");
        return headers;
    }

    /**
     * 抓包后参考项目中的image/body.jpeg 把信息一行一行copy到下面 没有的key不需要复制
     * <p>
     * 这里不能加泛型 有些接口是params  泛型必须要求<String,String> 有些是form表单 泛型要求<String,Object> 无法统一
     */
    public static Map getBody(Map<String, String> headers) {
        Map body = new HashMap<>();
        body.put("uid", headers.get("ddmc-uid"));
        body.put("longitude", headers.get("ddmc-longitude"));
        body.put("latitude ", headers.get("ddmc-latitude"));
        body.put("station_id", headers.get("ddmc-station-id"));
        body.put("city_number", headers.get("ddmc-city-number"));
        body.put("api_version", headers.get("ddmc-api-version"));
        body.put("app_version ", headers.get("ddmc-build-version"));
        body.put("applet_source", "");
        body.put("channel", "applet");
        body.put("app_client_id", "4");
        body.put("sharer_uid", "");
        body.put("h5_source", "");
        body.put("time", headers.get("ddmc-time"));
        body.put("openid", headers.get("ddmc-device-id"));

        // ------------  填入这2项上面不要动 ------------
        body.put("s_id", "");
        body.put("device_token", "");
        return body;
    }

    /**
     * POST /api/v1/sams/decoration/portal/show/getPageData HTTP/1.1
     * Host	api-sams.walmartmobile.cn
     * Connection	keep-alive
     * Content-Length	398
     * system-language	CN
     * content-type	application/json;charset=utf-8
     * device-type	mini_program
     * auth-token	0f7d247a1a3e9c82d71c8b92ae68495cc50f4d30e3758ccac318a06ce5ce0cbe
     * Accept-Encoding	gzip,compress,br,deflate
     * User-Agent	Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 MicroMessenger/8.0.20(0x1800142f) NetType/WIFI Language/zh_CN
     * Referer	https://servicewechat.com/wxb344a8513eaaf849/230/page-frame.html
     */
    public static Map<String, String> getHeaders4Sam() {
        Map<String, String> headers = new HashMap<>();

        // ------------ 小程序 ------------
//        headers.put("content-type", "application/json;charset=utf-8");
//        headers.put("device-type", "mini_program");
//        headers.put("auth-token", "0f7d247a1a3e9c82d71c8b92ae68495cc50f4d30e3758ccac318a06ce5ce0cbe");
//        headers.put("accept-encoding", "gzip,compress,br,deflate");
//        headers.put("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 MicroMessenger/8.0.20(0x1800142f) NetType/WIFI Language/zh_CN");
//        headers.put("referer", "https://servicewechat.com/wx1e113254eda17715/425/page-frame.html");

        // ------------ App ------------
        headers.put("auth-token", "0f7d247a1a3e9c821414e50345a839f3c50f4d30e3758cca40a9ab8d436f08bb");
        headers.put("app-version", "5.0.50.1");
        headers.put("longitude", "121.734363");
        headers.put("latitude", "31.172187000000001");
        headers.put("device-id", "6cbcb1f1818fe502d556ae81000016c16309");
        headers.put("device-type", "ios");
        headers.put("Accept-Language", "zh-Hans-CN;q=1");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("apptype", "ios");
        headers.put("device-name", "iPhone14,5");
        headers.put("device-os-version", "15.4.1");
        headers.put("User-Agent", "SamClub/5.0.50 (iPhone; iOS 15.4.1; Scale/3.00)");
        headers.put("Content-Length", "242");
        headers.put("system-language", "CN");

        // ------------  填入以下6项 上面不要动 ------------
//        headers.put("ddmc-device-id", "");
//        headers.put("cookie", "");
//        headers.put("ddmc-longitude", "");
//        headers.put("ddmc-latitude", "");
//        headers.put("ddmc-uid", "");
//        headers.put("user-agent", "");
        return headers;
    }

    public static JSONObject getBody4Sam() {
        JSONObject jsonParam = new JSONObject();

        // 设置参数------------ 小程序 ------------
//        jsonParam.put("pageContentId", "1187641882302384150");
//        jsonParam.put("modulePagination", true);
//        jsonParam.put("pageNum", 1);
//        jsonParam.put("pageSize", 20);
//        jsonParam.put("latitude", 31.172187);
//        jsonParam.put("longitude", 121.734363);
//        jsonParam.put("uid", "262685834");
//        jsonParam.put("appId", "wxb344a8513eaaf849");
//        jsonParam.put("saasId", "1818");

        // 设置参数------------ APP ------------
        jsonParam.put("uid", "262685834");
        jsonParam.put("pageContentId", "1187641882302384150");
        jsonParam.put("authorize", true);
        jsonParam.put("latitude", "31.172187000000001");
        jsonParam.put("longitude", "121.734363");
        JSONObject addressInfo = new JSONObject();
        addressInfo.put("provinceCode", "");
        addressInfo.put("receiverAddress", "江凌苑55号楼1303室");
        addressInfo.put("districtCode", "");
        addressInfo.put("cityCode", "");
        jsonParam.put("addressInfo", addressInfo);

        // ------------  填入这2项上面不要动 ------------
//        jsonParam.put("s_id", "");
//        jsonParam.put("device_token", "");
        return jsonParam;
    }
}
