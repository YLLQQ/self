package self.yang.tools.utils;

import com.google.common.collect.Lists;
import org.apache.commons.codec.binary.Base64;
import org.apache.xml.security.signature.XMLSignature;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Constants;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;

public class SignatureTool {

    private static final String CHARSET = "UTF-8";
    private static final String SIGN_ALGORITHM = "SHA256withRSA";
    private static final String XML_ALGORITHM = "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256";
    private static final String REQUEST_TAG_NAME = "request";
    private static final String RESPONSE_TAG_NAME = "response";
    private static final String SIGNATURE_TAG_NAME = "Signature";

    /**
     * 测试私钥
     */
    private static final String TEST_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCw8qSIJSCE0qtziM4KvvHNOWp+sPAO5Xs1nMEWgCnyMvzOyzN4CdIKWKjHsnks4hA4vYAtCGSsjRk4awtayc6qxn8kFHPaazqEzqwiBCO34+weqN0wfvre7HZXquHtoVtede2vWt0t7UygvFNHtdoQPNPFOijewyRfBQ02iiMZvFlgYqjoZiAtZbW6jFTDQc50GbUsSnOLo3m7QBZZjf0tx5bHmkkg25+kgAYVKuNASlGrAgUp4GbMWECCiKpKPt3btdPSiDyZtUcF2RCNY1q6R5JHEooX/gUAEUJqlQuYaGSAu9NYzsI59Huhcva30oGS7P1Ztfx26m4ev/UHLh81AgMBAAECggEBAI+dMArLz1vePId15nz0Qv6k9hlDdGMyv9BgnJqthN3toiAY7nojxlTdZodGBHF4PWA/9bMXF9awYmLXBo02M8WJe5GGBA2ncARwVWb6Yx8SHwc3WObOeMDLvLUknWAn0SeWoUXsgo2PBt2CXDlckFMTe3Gc5aT/TxrL19CHRzvPuE8dRhjVcECPZFmezETJe7J7xZgEQZvnKmrGLYwVG31m5dd2SchG5UGy80cW8kHCbMjp3nXk2vrqa8ifooJzA91LJ2a+eTqf8vsVEl8mpvgqFeURGnrebvH66P24+SP5dTNMip3lLVj+845A9OtLSeJi+ANT7SQrjBtP0r3h+zUCgYEA2U2Kl09I0/9rQY+mGYFe82ttkvwf/b75msmYOkklq3ZZfuRZtZa+Fy1o3tYGjP2zbzPDHF2FYZvS4vNa9F2wTxexlCINcq3TdgI+ATV4Pqds4CC9WPq/MQqevOgXHQVqv2uq2sarTInKFQ0eB292ZzN5VphdLXFh/BgGEelGpa8CgYEA0HViWu0TpbytEsPib0bOWvlP9l9+/+OKQ21EFARX5lvYNeYcRtRl+m40drEr7NYPsHCBLjDk88IuBMMY9jpiAivgsCqBTjO0DFeEc6qFaKvDTOV5kwbha9I/NQWApaP94AHSKygUL/kn4YSJ0nx3qlJgP7c036xwad6CpSSq5lsCgYEAs0ZZtINgniX3ItuUOS6WW1ShzcXbzsgjvSPcRxnZzh+RrjJOIJYAtbZs8oq4VNFpm7Cko140kFayITKMM1aoAliV1JRTa+0krBMlfHHUhjwygqYAEMytt5P/afJAP10cuFfnWR7WbAqxgbSUtaWrlXDOBjcliDwmjohzWYuPEVkCgYBg36wthS80PlJP/igkfks3i9TVMdvbHusKGqUgiEQxEU2Q/rb1U49wqfZHkl5PWctAu4fM53v+q6anH+Nhyg/x4mIwfBBLP0vU0HcFKaGF2wyPl7S/1tq7OKGXCk+Wqnc4up/o3l9DTA50hxtlbeJOjKmd8o3nxEMZcAZWqIujMQKBgQCEdlItcNT7FFVYDHAg1oPQK9iC8coBa+cBxbFGsEH+co4J4qxhv0NnCarvnz5koptPrwn8iWWfnb4oU2/yottgURq4xUySAT/wxtYiEyBJAMRMXaNeiJxjYghNrmOjs3rUUMQBeHVZ4THkPGLkpp/ma96Bp9rjqvapf/qFsFZ3Hg==";

    /**
     * 测试公钥
     */
    private static final String TEST_PUB_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsPKkiCUghNKrc4jOCr7xzTlqfrDwDuV7NZzBFoAp8jL8zsszeAnSCliox7J5LOIQOL2ALQhkrI0ZOGsLWsnOqsZ/JBRz2ms6hM6sIgQjt+PsHqjdMH763ux2V6rh7aFbXnXtr1rdLe1MoLxTR7XaEDzTxToo3sMkXwUNNoojGbxZYGKo6GYgLWW1uoxUw0HOdBm1LEpzi6N5u0AWWY39LceWx5pJINufpIAGFSrjQEpRqwIFKeBmzFhAgoiqSj7d27XT0og8mbVHBdkQjWNaukeSRxKKF/4FABFCapULmGhkgLvTWM7COfR7oXL2t9KBkuz9WbX8dupuHr/1By4fNQIDAQAB";

    public static void main(String[] args) throws Exception {
        System.out.println("测试私钥数据如下：");
        System.out.println(TEST_PRIVATE_KEY);

        printLine();

        PrivateKey privateKey = getPrivateKey(TEST_PRIVATE_KEY.getBytes());

        System.out.println("读取私钥数据如下：");
        System.out.println(privateKey);

        printLine();

        String testString = "<document><request><head><appid>2017060700000025</appid></head></request></document>";

        String signatureString = signRequestMessage(testString, privateKey);

        System.out.println("签名报文数据如下：");
        System.out.println(signatureString);

        PublicKey publicKey = getPublicKey(TEST_PUB_KEY.getBytes());

        printLine();

        System.out.println("读取公钥数据如下：");
        System.out.println(publicKey);

        printLine();

        boolean result = verifyXmlMessage(signatureString, publicKey);

        System.out.println("验签结果如下：");
        System.out.println(result);

        List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        System.out.println("sum is:" +
                        nums.stream()
                                .filter(num -> num != null)
                                // 1，1，2，3，4，5，6，7，8，9，10
                                .distinct()
                                // 1，2，3，4，5，6，7，8，9，10
                                .mapToInt(num -> num * 2)
                                // 2，4，6，8，10，12，14，16，18，20
                                .skip(2)
                                // 6，8，10，12，14，16，18，20
                                .limit(4)
                                // 6，8，10，12
                                .sum()
                // 36
        );

        nums.stream().forEach(x -> System.out.print(x + "\t"));
        System.out.println();

        nums.stream().filter(num -> num != null).forEach(x -> System.out.print(x + "\t"));
        System.out.println();

        nums.stream().filter(num -> num != null).distinct().forEach(x -> System.out.print(x + "\t"));
        System.out.println();

        nums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).forEach(x -> System.out.print(x + "\t"));
        System.out.println();

        nums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).skip(2).forEach(x -> System.out.print(x + "\t"));
        System.out.println();

        nums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).skip(2).limit(4).forEach(x -> System.out.print(x + "\t"));
        System.out.println();

        nums.stream().filter(num -> num != null).peek(x -> System.out.print(x + "\t")).count();

    }

    private static void printLine() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    /**
     * 对字符串进行签名
     *
     * @param source     待签名的数据
     * @param privateKey 私钥
     * @return Base64编码后的签名信息
     * @throws Exception
     */
    public static String sign(
            String source,
            PrivateKey privateKey
    ) throws Exception {
        final Signature signatureChecker = Signature.getInstance(SIGN_ALGORITHM);
        signatureChecker.initSign(privateKey);
        signatureChecker.update(source.getBytes(CHARSET));
        return Base64.encodeBase64String(signatureChecker.sign());
    }

    /**
     * 对字符串进行验签
     *
     * @param source    待验签的数据
     * @param signature Base64编码后的签名信息
     * @param publicKey 公钥
     * @return
     * @throws Exception
     */
    public static boolean verify(
            String source,
            String signature,
            PublicKey publicKey
    ) throws Exception {
        final Signature signatureChecker = Signature.getInstance(SIGN_ALGORITHM);

        signatureChecker.initVerify(publicKey);
        signatureChecker.update(source.getBytes(CHARSET));

        return signatureChecker.verify(Base64.decodeBase64(signature));
    }

    /**
     * 验证XML签名
     *
     * @param xmlMessage 带有签名的XML
     * @param publicKey  公钥
     * @return 签名验证结果 boolean
     * @throws Exception the exception
     */
    public static boolean verifyXmlMessage(
            String xmlMessage,
            PublicKey publicKey
    ) throws Exception {
        Document xmlDocument = getDocument(xmlMessage);
        NodeList signatureNodes = xmlDocument.getElementsByTagNameNS(Constants.SignatureSpecNS, SIGNATURE_TAG_NAME);

        if (signatureNodes == null || signatureNodes.getLength() != 1) {
            throw new Exception("Document element with tag name " + SIGNATURE_TAG_NAME + " not fount");
        }

        Element signElement = (Element) signatureNodes.item(0);
        XMLSignature signature = new XMLSignature(signElement, "");

        return signature.checkSignatureValue(publicKey);
    }

    /**
     * 读取公钥
     *
     * @param keyData
     * @return
     * @throws Exception
     */
    private static PublicKey getPublicKey(final byte[] keyData) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] encodedKey = Base64.decodeBase64(keyData);

        return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
    }

    /**
     * 解析XML字符
     *
     * @param xmlMessageSource
     * @return
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    private static Document getDocument(String xmlMessageSource)
            throws ParserConfigurationException, SAXException, IOException, UnsupportedEncodingException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        factory.setNamespaceAware(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document xmlDocument = builder.parse(new InputSource(new ByteArrayInputStream(xmlMessageSource.getBytes(CHARSET))));

        return xmlDocument;
    }

    /**
     * 私钥签名请求报文
     *
     * @param requestMessage
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String signRequestMessage(
            String requestMessage,
            PrivateKey privateKey
    ) throws Exception {
        org.apache.xml.security.Init.init();

        return signXmlMessage(requestMessage, REQUEST_TAG_NAME, privateKey);
    }

    /**
     * 私钥签名应答报文
     *
     * @param responseMessage
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String signResponseMessage(
            String responseMessage,
            PrivateKey privateKey
    ) throws Exception {
        return signXmlMessage(responseMessage, RESPONSE_TAG_NAME, privateKey);
    }

    /**
     * 读取私钥
     *
     * @param keyData 私钥数据
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(final byte[] keyData) throws Exception {
        byte[] encodedKey = Base64.decodeBase64(keyData);
        final PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedKey);
        final KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        return keyFactory.generatePrivate(keySpec);
    }


    /**
     * 私钥签名
     *
     * @param xmlMessageSource 待签名的XML
     * @param elementTagName
     * @param privateKey
     * @return
     * @throws Exception
     */
    private static String signXmlMessage(
            String xmlMessageSource,
            String elementTagName,
            PrivateKey privateKey
    ) throws Exception {
        Document xmlDocument = getDocument(xmlMessageSource);
        XMLSignature xmlSignature = new XMLSignature(xmlDocument, xmlDocument.getDocumentURI(), XML_ALGORITHM);
        NodeList nodeList = xmlDocument.getElementsByTagName(elementTagName);

        if (nodeList == null || nodeList.getLength() != 1) {
            throw new Exception("Document element with tag name " + elementTagName + " not fount");
        }

        Node elementNode = nodeList.item(0);

        elementNode.getParentNode().appendChild(xmlSignature.getElement());

        Transforms transforms = new Transforms(xmlDocument);

        transforms.addTransform(Transforms.TRANSFORM_ENVELOPED_SIGNATURE);
        xmlSignature.addDocument("", transforms, Constants.ALGO_ID_DIGEST_SHA1);
        xmlSignature.sign(privateKey);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        XMLUtils.outputDOM(xmlDocument, os);

        return os.toString(CHARSET);
    }


}
