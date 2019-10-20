package test;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import utils.Utils;



public class XmlTest extends Utils {
    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "horizon");
        JSONArray jsonArray = new JSONArray();
        JSONObject dataJson = new JSONObject();
        System.out.println("dataJson----" + dataJson);
        jsonArray.add(jsonObject);
        //jsonArray.add(jsonObject);
        dataJson.put("data", jsonArray);
        System.out.println(dataJson);

        //  String xml = json2xml(dataJson.toString());
        //   System.out.println("xml:" + xml);
        //  String str = xml2json(xml);

        // System.out.println("to_json" + str);

        System.out.println("----------------------");
        String json = "{\"HeWeather6\":[{\"basic\":{\"cid\":\"CN101200801\",\"location\":\"荆州\",\"parent_city\":\"荆州\",\"admin_area\":\"湖北\",\"cnty\":\"中国\",\"lat\":\"30.32685661\",\"lon\":\"112.23812866\",\"tz\":\"+8.00\"},\"update\":{\"loc\":\"2019-10-20 10:30\",\"utc\":\"2019-10-20 02:30\"},\"status\":\"ok\",\"now\":{\"cloud\":\"91\",\"cond_code\":\"104\",\"cond_txt\":\"阴\",\"fl\":\"21\",\"hum\":\"71\",\"pcpn\":\"0.0\",\"pres\":\"1017\",\"tmp\":\"20\",\"vis\":\"16\",\"wind_deg\":\"359\",\"wind_dir\":\"北风\",\"wind_sc\":\"1\",\"wind_spd\":\"3\"}}]}";

        System.out.println(json2xml(json));
    }
}
