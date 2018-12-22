package self.yang.tools.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import self.yang.tools.configs.DefineXStream;

/**
 * xml操作工具类
 */
public class XmlUtil {

    /**
     * 通过xml转换t
     *
     * @param xml  待格式化xml
     * @param root 根结点名称
     * @param cl   目标对象文件
     * @param <T>
     * @return
     */
    public static <T> T xml2T(
            String xml,
            String root,
            Class cl
    ) {
        XStream xstream = new DefineXStream(new DomDriver("UTF-8"));

        xstream.autodetectAnnotations(true);
        xstream.alias(root, cl);

        return (T) xstream.fromXML(xml);
    }

    /**
     * 获取t的xml形式，标签结构中忽略class属性
     *
     * @param t   待转对象
     * @param <T>
     * @return
     */
    public static <T> String t2Xml(T t) {
        XStream xstream = new XStream(new StaxDriver());

        xstream.autodetectAnnotations(true);
        xstream.processAnnotations(t.getClass());
        xstream.aliasSystemAttribute(null, "class");

        return xstream.toXML(t);
    }
}
