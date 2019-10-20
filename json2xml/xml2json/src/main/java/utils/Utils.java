package utils;

import net.sf.json.JSON;


import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;
import org.jdom.Document;
/*
java中有json对象，而没有xml对象，所以xml是以字符串的形式表现出来的
* */
public class Utils {
    /**
     * 将xml字符串<STRONG>转换</STRONG>为JSON字符串
     *
     * @param xmlString
     *            xml字符串
     * @return JSON<STRONG>对象</STRONG>
     */
    public static String xml2json(String xmlString) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        JSON json = xmlSerializer.read(xmlString);
        return json.toString(1);
    }

    /**
     * 将xmlDocument<STRONG>转换</STRONG>为JSON<STRONG>对象</STRONG>
     *
     * @param xmlDocument
     *            XML Document
     * @return JSON<STRONG>对象</STRONG>
     */
    public static String xml2json(Document xmlDocument) {
        return xml2json(xmlDocument.toString());
    }

    /**
     * JSON(数组)字符串<STRONG>转换</STRONG>成XML字符串
     *
     * @param jsonString
     * @return
     */
    /*使用json-lib，转换后的格式不好看，是那种一行到头的输出格式
    * */
    public static String json2xml(String jsonString) {

        XMLSerializer xmlSerializer = new XMLSerializer();
        return xmlSerializer.write(JSONSerializer.toJSON(jsonString));
        // return xmlSerializer.write(JSONArray.fromObject(jsonString));//这种方式只支持JSON数组
    }
}
