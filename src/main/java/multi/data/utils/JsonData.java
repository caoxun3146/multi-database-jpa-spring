package multi.data.utils;

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


}
