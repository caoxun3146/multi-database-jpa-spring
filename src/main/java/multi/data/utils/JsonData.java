package multi.data.utils;

import multi.data.dao.model.other.redpacks.JsonRedpackBean;

public class JsonData {
    public static String getJsonData(String token, String orderId, String prdID, String sourceID) {

        // "is_match":1  新增需要匹配
        String parameters = "{\n" +
                "\"handle\": 0,\n" +
                "\"shandle\": 0,\n" +
                "\"data\": {\n" +
                "\"phead\": {\n" +
                "\"pversion\": 88,\n" +
                "\"phoneid\": \"18f3361f10003442\",\n" +
                "\"phone\": \"M A5\",\n" +
                "\"imei\": \"866746033563041\",\n" +
                "\"cversion\": 132,\n" +
                "\"cversionname\": \"2.20.0\",\n" +
                "\"channel\": \"91000\",\n" +
                "\"lang\": \"zh_cn\",\n" +
                "\"sdk\": 23,\n" +
                "\"imsi\": \"\",\n" +
                "\"sys\": \"6.0\",\n" +
                "\"lng\": -1,\n" +
                "\"lat\": -1,\n" +
                "\"cityid\": -1,\n" +
                "\"gcityid\": -1,\n" +
                "\"platform\": \"android\",\n" +
                "\"prdid\": \"" + prdID + "\",\n" +
                "\"time_zone\": \"GMT+08:00\",\n" +
                "\"timezoneid\": \"Asia\\/Shanghai\",\n" +
                "\"dpi\": \"720*1280\",\n" +
                "\"user_create_time\": \"2019-06-14 13:30:27\",\n" +
                "\"access_token\": \"" + token + "\",\n" +
                "\"net\": \"WIFI\",\n" +
                "\"mac\": \"D8:6C:02:AD:D7:B4\",\n" +
                "\"shumei_deviceid\": \"20180411164322e42a96edcede00eae19f572c897671a701e5626995bce155\",\n" +
                "\"vendor\": \"meizu\",\n" +
                "\"ua\": \"Mozilla\\/5.0 (Linux; Android 6.0; M A5 Build\\/MRA58K; wv) AppleWebKit\\/537.36 (KHTML, like Gecko) Version\\/4.0 Chrome\\/44.0.2403.143 Mobile Safari\\/537.36\"\n" +
                "},\n" +
                "\"fromMall\": 0,\n" +
                "\"orderId\": \"" + orderId + "\",\n" +
                "\"type\": 2,\n" +
                "\"topicId\": 100088,\n" +
                "\"isMachine\": 2,\n" +
                "\"activity_id\": 100088,\n" +
                "\"pro_father_source\": \"3天签到活动领奖页\",\n" +
                "\"is_zero\": \"0\",\n" +
                "\"source_id\": \"" + sourceID + "\",\n" +
                "\"orderActivityId\": 12,\n" +
                "\"mod_click_mod_sequence_id\": \"1\",\n" +
                "\"is_produce_have_vedio\": true,\n" +
                "\"redpackTabId\": \"90024\",\n" +
                "\"sc_buy_url\": \"https:\\/\\/uland.taobao.com\\/coupon\\/edetail?e=CYgf14hw%2BJMGQASttHIRqbUOlvO0YiaOvMJ%2BG%2FDFsBfl8TyjTR1o2CHO2FjjH5sluE9t7%2FQPwGcvc742eFIdw8WKxy1EFPIV%2BGoSNEAjokSwbCChdx8LEBemP0hpIIPvjDppvlX%2Bob8NlNJBuapvQ2MDg9t1zp0R8pjV3C9qcwRGjmKUYMS5NcOmoBlQwM0z&traceId=0b0fe8b615606864959028432e&union_lens=lensId:0b0aff46_0c21_16b602a08b3_d76d&xId=6n8sKFfdZFsmCX0TqaRxil7RhA542rmFxlSCfFpiKvQViGjqkW6B6GgZDc3FvI98gBoGnXmceAMmpqMCpMnkOx\",\n" +
                "\"is_match\":1\n" +
                "}\n" +
                "}";

        return parameters;
    }

    /**
     * 上传红包ID , 使用返现红包
     * @param token
     * @return
     */
    public static String getJsonDataRedPack(String token, String orderId, String prdID, String sourceID, JsonRedpackBean jsonRedpackBean) {

        String source_path = "T1000_G" + sourceID;  //T1000_G571462173525
        String parameters = "{\n" +
                "\t\"handle\": 0,\n" +
                "\t\"shandle\": 0,\n" +
                "\t\"data\": {\n" +
                "\t\t\"phead\": {\n" +
                "\t\t\t\"pversion\": 100,\n" +
                "\t\t\t\"phoneid\": \"0776f3c9876341ad\",\n" +
                "\t\t\t\"phone\": \"vivo Y85A\",\n" +
                "\t\t\t\"imei\": \"869701031290789\",\n" +
                "\t\t\t\"cversion\": 155,\n" +
                "\t\t\t\"cversionname\": \"2.25.2\",\n" +
                "\t\t\t\"channel\": \"91000\",\n" +
                "\t\t\t\"lang\": \"zh_cn\",\n" +
                "\t\t\t\"sdk\": 27,\n" +
                "\t\t\t\"imsi\": \"46002\",\n" +
                "\t\t\t\"sys\": \"8.1.0\",\n" +
                "\t\t\t\"lng\": -1,\n" +
                "\t\t\t\"lat\": -1,\n" +
                "\t\t\t\"cityid\": -1,\n" +
                "\t\t\t\"gcityid\": -1,\n" +
                "\t\t\t\"platform\": \"android\",\n" +
                "\t\t\t\"prdid\": \""+prdID+"\",\n" +
                "\t\t\t\"time_zone\": \"GMT+08:00\",\n" +
                "\t\t\t\"timezoneid\": \"Asia\\/Shanghai\",\n" +
                "\t\t\t\"dpi\": \"1080*2280\",\n" +
                "\t\t\t\"user_create_time\": \"2019-08-16 21:30:16\",\n" +
                "\t\t\t\"access_token\": \""+token+"\",\n" +
                "\t\t\t\"net\": \"WIFI\",\n" +
                "\t\t\t\"mac\": \"4C:C0:0A:C5:E3:41\",\n" +
                "\t\t\t\"shumei_deviceid\": \"20190730185207d1b0b599ecb60ec28e294484c79bcee7014d0e2ee2da2808\",\n" +
                "\t\t\t\"vendor\": \"vivo\",\n" +
                "\t\t\t\"ua\": \"Mozilla\\/5.0 (Linux; Android 8.1.0; vivo Y85A Build\\/OPM1.171019.011; wv) AppleWebKit\\/537.36 (KHTML, like Gecko) Version\\/4.0 Chrome\\/62.0.3202.84 Mobile Safari\\/537.36\"\n" +
                "\t\t},\n" +
                "\t\t\"fromMall\": 0,\n" +
                "\t\t\"orderId\": \""+orderId+"\",\n" +
                "\t\t\"type\": 2,\n" +
                "\t\t\"topicId\": 10,\n" +
                "\t\t\"isMachine\": 2,\n" +
                "\t\t\"activity_id\": 10,\n" +
                "\t\t\"source_path\": \""+source_path+"\",\n" +
                "\t\t\"pro_father_source\": \"首页瀑布流\",\n" +
                "\t\t\"recommend_source_type\": \"3\",\n" +
                "\t\t\"is_zero\": \"0\",\n" +
                "\t\t\"source_id\": \""+sourceID+"\",\n" +
                "\t\t\"mod_click_mod_sequence_id\": \"20\",\n" +
                "\t\t\"is_produce_have_vedio\": true,\n" +
                "\t\t\"redpackTabId\": \"1000\",\n" +
                "\t\t\"sc_mod_click_id\": \"520\",\n" +
                "\t\t\"sc_mod_click_tabid\": \"1000\",\n" +
                "\t\t\"sc_mod_click_page_name\": \"今日推荐\",\n" +
                "\t\t\"sc_mod_click_adid\": \""+sourceID+"\",\n" +
                "\t\t\"sc_mod_click_ad_name\": \"销量王！出风口万能通用车载手机支架\",\n" +
                "\t\t\"sclist_cash_coupons_plan_id\": \"391\",\n" +
                "\t\t\"sclist_cash_coupons_tittle\": \"首单后领取-3天\",\n" +
                "\t\t\"sclist_cash_coupons_id\": \"142\",\n" +
                "\t\t\"sclist_cash_coupons_list\": \"无门槛\",\n" +
                "\t\t\"sc_used_cash_coupons_id\": \"142\",\n" +
                "\t\t\"sc_used_cash_coupons_money\": 3,\n" +
                "\t\t\"sc_used_coupons_plan_id\": \"391\",\n" +
                "\t\t\"sc_activity_module_id\": 0,\n" +
                "\t\t\"sc_product_group_id\": 0,\n" +
                "\t\t\"sc_buy_url\": \"https:\\/\\/uland.taobao.com\\/coupon\\/edetail?e=Nv8jE2HIDpIGQASttHIRqXlZD1Sx8XRvQuFq3vLjHgHl8TyjTR1o2CHO2FjjH5sluE9t7%2FQPwGcvc742eFIdw8WKxy1EFPIV%2BGoSNEAjokSwbCChdx8LEBemP0hpIIPvjDppvlX%2Bob8NlNJBuapvQ2MDg9t1zp0RW22rjtZ8rUobuSUWVaLqqEMuxoRQ3C%2BHfZgJptiVnUiie%2FpBy9wBFg%3D%3D&traceId=0baf4d4c15659569361131223e&union_lens=lensId:0b832c69_0c1f_16c9a4e91ca_378f&xId=5fn8NxH0uUo802UirGWVa6e8JRjTUH2ILQxOHREbXRMSnOTNTklSy99tSNcjLddeKypUjjO3x9ZSPvvFsDU29a\",\n" +
                "\t\t\"sc_product_recommend_id\": \"-9\",\n" +
                "\t\t\"sc_product_maths_task_id\": \"0\",\n" +
                "\t\t\"is_match\":1\n" +
                "\t}\n" +
                "}";

        return  parameters;

    }

    /**
     * 获取红包列表
     * @param token
     * @return
     */
    public static String getRedpackListJsonData(String token) {

        String parameters = "{\n" +
                "\t\"handle\": 0,\n" +
                "\t\"shandle\": 0,\n" +
                "\t\"data\": {\n" +
                "\t\t\"phead\": {\n" +
                "\t\t\t\"pversion\": 99,\n" +
                "\t\t\t\"phoneid\": \"0776f3c9876341ad\",\n" +
                "\t\t\t\"phone\": \"vivo Y85A\",\n" +
                "\t\t\t\"imei\": \"869701031290789\",\n" +
                "\t\t\t\"cversion\": 153,\n" +
                "\t\t\t\"cversionname\": \"2.25.0\",\n" +
                "\t\t\t\"channel\": \"91000\",\n" +
                "\t\t\t\"lang\": \"zh_cn\",\n" +
                "\t\t\t\"sdk\": 27,\n" +
                "\t\t\t\"imsi\": \"46002\",\n" +
                "\t\t\t\"sys\": \"8.1.0\",\n" +
                "\t\t\t\"lng\": -1,\n" +
                "\t\t\t\"lat\": -1,\n" +
                "\t\t\t\"cityid\": -1,\n" +
                "\t\t\t\"gcityid\": -1,\n" +
                "\t\t\t\"platform\": \"android\",\n" +
                "\t\t\t\"prdid\": \"14000\",\n" +
                "\t\t\t\"time_zone\": \"GMT+08:00\",\n" +
                "\t\t\t\"timezoneid\": \"Asia\\/Shanghai\",\n" +
                "\t\t\t\"dpi\": \"1080*2280\",\n" +
                "\t\t\t\"user_create_time\": \"2019-08-15 13:35:50\",\n" +
                "\t\t\t\"access_token\": \""+token+"\",\n" +
                "\t\t\t\"net\": \"WIFI\",\n" +
                "\t\t\t\"mac\": \"4C:C0:0A:C5:E3:41\",\n" +
                "\t\t\t\"shumei_deviceid\": \"20190730185207d1b0b599ecb60ec28e294484c79bcee7014d0e2ee2da2808\",\n" +
                "\t\t\t\"vendor\": \"vivo\",\n" +
                "\t\t\t\"ua\": \"Mozilla\\/5.0 (Linux; Android 8.1.0; vivo Y85A Build\\/OPM1.171019.011; wv) AppleWebKit\\/537.36 (KHTML, like Gecko) Version\\/4.0 Chrome\\/62.0.3202.84 Mobile Safari\\/537.36\"\n" +
                "\t\t},\n" +
                "\t\t\"status\": \"1\",\n" +
                "\t\t\"redpackTabId\": \"1000\",\n" +
                "\t\t\"title\": \"\"\n" +
                "\t}\n" +
                "}";

        return  parameters;

    }

    /**
     * 33006 接口上传红包信息
     * @param token
     * @param sourceId
     * @return
     */
    public static String getJsonDataRedPackInfo(String token,String sourceId) {

        String source_path = "T1000_G" + sourceId;  //T1000_G571462173525

        String param = "{\n" +
                "\t\"handle\": 0,\n" +
                "\t\"shandle\": 0,\n" +
                "\t\"data\": {\n" +
                "\t\t\"phead\": {\n" +
                "\t\t\t\"pversion\": 100,\n" +
                "\t\t\t\"phoneid\": \"0776f3c9876341ad\",\n" +
                "\t\t\t\"phone\": \"vivo Y85A\",\n" +
                "\t\t\t\"imei\": \"869701031290789\",\n" +
                "\t\t\t\"cversion\": 155,\n" +
                "\t\t\t\"cversionname\": \"2.25.2\",\n" +
                "\t\t\t\"channel\": \"91000\",\n" +
                "\t\t\t\"lang\": \"zh_cn\",\n" +
                "\t\t\t\"sdk\": 27,\n" +
                "\t\t\t\"imsi\": \"46002\",\n" +
                "\t\t\t\"sys\": \"8.1.0\",\n" +
                "\t\t\t\"lng\": -1,\n" +
                "\t\t\t\"lat\": -1,\n" +
                "\t\t\t\"cityid\": -1,\n" +
                "\t\t\t\"gcityid\": -1,\n" +
                "\t\t\t\"platform\": \"android\",\n" +
                "\t\t\t\"prdid\": \"14000\",\n" +
                "\t\t\t\"time_zone\": \"GMT+08:00\",\n" +
                "\t\t\t\"timezoneid\": \"Asia\\/Shanghai\",\n" +
                "\t\t\t\"dpi\": \"1080*2280\",\n" +
                "\t\t\t\"user_create_time\": \"2019-08-16 21:30:16\",\n" +
                "\t\t\t\"access_token\": \""+token+"\",\n" +
                "\t\t\t\"net\": \"WIFI\",\n" +
                "\t\t\t\"mac\": \"4C:C0:0A:C5:E3:41\",\n" +
                "\t\t\t\"shumei_deviceid\": \"20190730185207d1b0b599ecb60ec28e294484c79bcee7014d0e2ee2da2808\",\n" +
                "\t\t\t\"vendor\": \"vivo\",\n" +
                "\t\t\t\"ua\": \"Mozilla\\/5.0 (Linux; Android 8.1.0; vivo Y85A Build\\/OPM1.171019.011; wv) AppleWebKit\\/537.36 (KHTML, like Gecko) Version\\/4.0 Chrome\\/62.0.3202.84 Mobile Safari\\/537.36\"\n" +
                "\t\t},\n" +
                "\t\t\"topicId\": 10,\n" +
                "\t\t\"isMachine\": 2,\n" +
                "\t\t\"activity_id\": 10,\n" +
                "\t\t\"source_path\": \""+source_path+"\",\n" +
                "\t\t\"pro_father_source\": \"首页瀑布流\",\n" +
                "\t\t\"recommend_source_type\": \"3\",\n" +
                "\t\t\"is_zero\": \"0\",\n" +
                "\t\t\"source_id\": \""+sourceId+"\",\n" +
                "\t\t\"mod_click_mod_sequence_id\": \"20\",\n" +
                "\t\t\"is_produce_have_vedio\": true,\n" +
                "\t\t\"redpackTabId\": \"1000\",\n" +
                "\t\t\"sc_mod_click_id\": \"520\",\n" +
                "\t\t\"sc_mod_click_tabid\": \"1000\",\n" +
                "\t\t\"sc_mod_click_page_name\": \"今日推荐\",\n" +
                "\t\t\"sc_mod_click_adid\": \""+sourceId+"\",\n" +
                "\t\t\"sc_mod_click_ad_name\": \"销量王！出风口万能通用车载手机支架\",\n" +
                "\t\t\"sc_source_shop\": 0,\n" +
                "\t\t\"sclist_cash_coupons_plan_id\": \"391\",\n" +
                "\t\t\"sclist_cash_coupons_tittle\": \"首单后领取-3天\",\n" +
                "\t\t\"sclist_cash_coupons_id\": \"142\",\n" +
                "\t\t\"sclist_cash_coupons_list\": \"无门槛\",\n" +
                "\t\t\"sc_used_cash_coupons_id\": \"142\",\n" +
                "\t\t\"sc_used_cash_coupons_money\": 3,\n" +
                "\t\t\"sc_used_coupons_plan_id\": \"391\",\n" +
                "\t\t\"sc_activity_module_id\": 0,\n" +
                "\t\t\"sc_product_group_id\": 0,\n" +
                "\t\t\"sc_is_open_app\": false,\n" +
                "\t\t\"sc_buy_url\": \"https:\\/\\/uland.taobao.com\\/coupon\\/edetail?e=Nv8jE2HIDpIGQASttHIRqXlZD1Sx8XRvQuFq3vLjHgHl8TyjTR1o2CHO2FjjH5sluE9t7%2FQPwGcvc742eFIdw8WKxy1EFPIV%2BGoSNEAjokSwbCChdx8LEBemP0hpIIPvjDppvlX%2Bob8NlNJBuapvQ2MDg9t1zp0RW22rjtZ8rUobuSUWVaLqqEMuxoRQ3C%2BHfZgJptiVnUiie%2FpBy9wBFg%3D%3D&traceId=0baf4d4c15659569361131223e&union_lens=lensId:0b832c69_0c1f_16c9a4e91ca_378f&xId=5fn8NxH0uUo802UirGWVa6e8JRjTUH2ILQxOHREbXRMSnOTNTklSy99tSNcjLddeKypUjjO3x9ZSPvvFsDU29a\",\n" +
                "\t\t\"sc_product_recommend_id\": \"-9\",\n" +
                "\t\t\"sc_product_maths_task_id\": \"0\",\n" +
                "\t\t\"minSkuPrice\": 0\n" +
                "\t}\n" +
                "}";

        return param;
    }


}
