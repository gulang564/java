public class Hellow {
    /*
    * json 与xml之间的转换的jar包很多，但是，json-lib 导入的包太多，而且输出的格式还不好看
    * 都是一整行输出，
    *
    * 使用 staxon包，只需导入这个包就可以，不需要额外下载其他的jar。而且输出的格式还好看，
    * 格式输出清晰，输出的时候帮我们格式化好了。
    * */
    public static void main(String[] args) {
        System.out.println("hello word");
        System.out.println("json------------>xml");
        String json = "{\"HeWeather6\":[{\"basic\":{\"cid\":\"CN101200801\",\"location\":\"荆州\",\"parent_city\":\"荆州\",\"admin_area\":\"湖北\",\"cnty\":\"中国\",\"lat\":\"30.32685661\",\"lon\":\"112.23812866\",\"tz\":\"+8.00\"},\"update\":{\"loc\":\"2019-10-20 10:30\",\"utc\":\"2019-10-20 02:30\"},\"status\":\"ok\",\"now\":{\"cloud\":\"91\",\"cond_code\":\"104\",\"cond_txt\":\"阴\",\"fl\":\"21\",\"hum\":\"71\",\"pcpn\":\"0.0\",\"pres\":\"1017\",\"tmp\":\"20\",\"vis\":\"16\",\"wind_deg\":\"359\",\"wind_dir\":\"北风\",\"wind_sc\":\"1\",\"wind_spd\":\"3\"}}]}";
        System.out.println(Json2xml_Utils.json2xml(json));

        System.out.println("xml----------->json");
        String xml = "<goods><name type=\"book\" prices=\"100\">钢铁是怎样炼成的</name><name1 type='book' prices='100'>钢铁是怎样炼成的</name1><name type='book' prices='100'>钢铁是怎样炼成的</name></goods>";
        System.out.println(xml);
        String js = Json2xml_Utils.xml2json(xml);
        System.out.println(js);
    }
}
