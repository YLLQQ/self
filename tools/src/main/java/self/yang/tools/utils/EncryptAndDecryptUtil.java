package self.yang.tools.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * self.yang.tools.utils.EncryptAndDecryptUtil
 *
 * @author eleven
 * @date 2019/09/12
 */
public class EncryptAndDecryptUtil {

    /**
     * 指定加密算法为RSA
     */
    private static final String RSA_ALGORITHM = "RSA";

    /**
     * 密钥长度，用来初始化
     */
    private static final int RSA_KEY_SIZE = 1024;

    /**
     * 分段加密，分段大小
     */
    private static final int ENCRYPT_SEGMENT_SIZE = RSA_KEY_SIZE / 8 - 11;

    /**
     * 分段解密，分段大小
     */
    private static final int DECRYPT_SEGMENT_SIZE = RSA_KEY_SIZE / 8;

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {
        String sourceString = "{\n" +
                "    \"authCardId\": \"411329\",\n" +
                "    \"authCardName\": \"test\",\n" +
                "    \"authCode\": \"code\",\n" +
                "    \"authType\": \"1\",\n" +
                "    \"pictureData\": \"pictureData\",\n" +
                "    \"requestSendTime\": \"20190911\",\n" +
                "    \"terminalId\": \"201808909909\"\n" +
                "}";

        String[] keys = generateRsaKeys();

        String privateKey = keys[0];
        String publicKey = keys[1];

        System.out.println(privateKey);
        System.out.println(publicKey);

        System.out.println(getPrivateKeyFromBase64(privateKey));
        System.out.println(getPublicKeyFromBase64(publicKey));

        String encrypt = rsaEncryptWithPublicKey(sourceString, publicKey);

        System.out.println(encrypt);

        String source = rsaDecryptWithPrivateKey(encrypt, privateKey);

        System.out.println(source);

        encrypt = rsaEncryptWithPrivateKey(sourceString, privateKey);

        System.out.println(encrypt);

        source = rsaDecryptWithPublicKey(encrypt, publicKey);

        System.out.println(source);
    }

    /**
     * rsa通过公钥对字符串解密
     *
     * @param encryptString
     * @param publicKeyBase64
     * @return
     */
    public static String rsaDecryptWithPublicKey(String encryptString, String publicKeyBase64) {
        try {
            PublicKey publicKey = getPublicKeyFromBase64(publicKeyBase64);

//            return decrypt(encryptString, publicKey);
            return decipher(encryptString, publicKey);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | InvalidKeySpecException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * rsa通过私钥对字符串解密
     *
     * @param encryptString
     * @param privateKeyBase64
     * @return
     */
    public static String rsaDecryptWithPrivateKey(String encryptString, String privateKeyBase64) {
        try {
            PrivateKey privateKey = getPrivateKeyFromBase64(privateKeyBase64);

//            return decrypt(encryptString, privateKey);
            return decipher(encryptString, privateKey);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | InvalidKeySpecException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * rsa通过私钥对字符串加密
     *
     * @param sourceString
     * @param privateKeyBase64
     * @return
     */
    public static String rsaEncryptWithPrivateKey(String sourceString, String privateKeyBase64) {

        try {
            PrivateKey privateKey = getPrivateKeyFromBase64(privateKeyBase64);

//            return encrypt(sourceString, privateKey);
            return encipher(sourceString, privateKey);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | InvalidKeySpecException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * rsa通过公钥对字符串加密
     *
     * @param sourceString
     * @param publicKeyBase64
     * @return
     */
    public static String rsaEncryptWithPublicKey(String sourceString, String publicKeyBase64) {

        try {
            PublicKey publicKey = getPublicKeyFromBase64(publicKeyBase64);

//            return encrypt(sourceString, publicKey);
            return encipher(sourceString, publicKey);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | InvalidKeySpecException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 分段解密
     *
     * @param contentBase64
     * @param key
     * @return
     */
    public static String decipher(
            String contentBase64,
            Key key
    ) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException {

        byte[] srcBytes = Base64.getDecoder().decode(contentBase64);
        Cipher deCipher = Cipher.getInstance(RSA_ALGORITHM);
        deCipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decBytes;
        if (DECRYPT_SEGMENT_SIZE > 0) {
            decBytes = cipherDoFinal(deCipher, srcBytes, DECRYPT_SEGMENT_SIZE);
        } else {
            decBytes = deCipher.doFinal(srcBytes);
        }

        return new String(decBytes);
    }


    /**
     * 分段加密
     *
     * @param sourceString
     * @param key
     * @return
     */
    public static String encipher(
            String sourceString,
            Key key
    ) throws BadPaddingException, IllegalBlockSizeException, IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] srcBytes = sourceString.getBytes();

        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] resultBytes;

        if (ENCRYPT_SEGMENT_SIZE > 0) {
            resultBytes = cipherDoFinal(cipher, srcBytes, ENCRYPT_SEGMENT_SIZE);
        } else {
            resultBytes = cipher.doFinal(srcBytes);
        }
        return Base64.getEncoder().encodeToString(resultBytes);

    }

    /**
     * 分段处理
     *
     * @param cipher
     * @param srcBytes
     * @param segmentSize
     * @return
     * @throws Exception
     */
    public static byte[] cipherDoFinal(
            Cipher cipher, byte[] srcBytes, int segmentSize
    ) throws BadPaddingException, IllegalBlockSizeException, IOException {
        if (segmentSize <= 0) {
            throw new RuntimeException("segmentSize must greater than 0");
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int inputLen = srcBytes.length;
        int offSet = 0;
        byte[] cache;
        int i = 0;
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > segmentSize) {
                cache = cipher.doFinal(srcBytes, offSet, segmentSize);
            } else {
                cache = cipher.doFinal(srcBytes, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * segmentSize;
        }
        byte[] data = out.toByteArray();
        out.close();
        return data;
    }

    /**
     * 解密
     *
     * @param encryptString
     * @param key
     * @return
     */
    private static String decrypt(
            String encryptString,
            Key key
    ) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(encryptString.getBytes()));

        return new String(bytes);
    }

    /**
     * 加密
     *
     * @param sourceString
     * @param key
     * @return
     */
    private static String encrypt(
            String sourceString,
            Key key
    ) throws BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);

        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] sourceBytes = sourceString.getBytes();
        byte[] encryptBytes = cipher.doFinal(sourceBytes);

        return Base64.getEncoder().encodeToString(encryptBytes);
    }

    /**
     * 获取privateKey
     *
     * @param privateKeyBase64
     * @return
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    private static PrivateKey getPrivateKeyFromBase64(String privateKeyBase64) throws InvalidKeySpecException, NoSuchAlgorithmException {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyBase64));
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 获取publicKey
     *
     * @param publicKeyBase64
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static PublicKey getPublicKeyFromBase64(String publicKeyBase64) throws NoSuchAlgorithmException, InvalidKeySpecException {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyBase64));
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        return keyFactory.generatePublic(keySpec);
    }

    /**
     * 生成RSA密钥对
     * <p>
     * 0，私钥
     * 1，公钥
     *
     * @return
     */
    public static String[] generateRsaKeys() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA_ALGORITHM);

            keyPairGenerator.initialize(RSA_KEY_SIZE);

            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            String[] keys = new String[2];

            byte[] privateKeyEncoded = keyPair.getPrivate().getEncoded();
            byte[] publicKeyEncoded = keyPair.getPublic().getEncoded();

            String privateKeyBase64 = Base64.getEncoder().encodeToString(privateKeyEncoded);
            String publicKeyBase64 = Base64.getEncoder().encodeToString(publicKeyEncoded);

            keys[0] = privateKeyBase64;
            keys[1] = publicKeyBase64;

            return keys;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
