package module;/**
 * Created by Hatsune Mona on 2020/4/3. 初音萌奈什喵的最可爱了喵！
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: JavaWeb
 * @description: 计算MD5
 * @author: Created by Hatsune Mona. 初音萌奈什喵的最可爱了喵！
 * @create: 2020-04-03 16:58
 **/
public class MD5 {

  public static String GetMD5(String string) {

    MessageDigest md;
    try {
      md = MessageDigest.getInstance("MD5");//利用哈希算法，MD5
      //面向字节处理，所以可以处理字节的东西，如图片，压缩包。。
      byte[] input = string.getBytes();
      byte[] output = md.digest(input);
      //将md5处理后的output结果利用Base64转成原有的字符串,不会乱码
//      String str = Base64.encodeBase64String(output);
//      String str = new String(output); //原有转换
      String str = byte2Hex(output);
      return str;
    } catch (NoSuchAlgorithmException e) {
      System.out.println("密码加密失败");
      return "";

    }
  }

  private final static char[] HEX = "0123456789abcdef".toCharArray();

  /**
   * 将字节数组转成 16 进制的字符串来表示，每个字节采用两个字符表表示
   *
   * @param bys 需要转换成 16 进制的字节数组
   */
  private static String byte2Hex(byte[] bys) {
    char[] chs = new char[bys.length * 2];
    for (int i = 0, offset = 0; i < bys.length; i++) {
      chs[offset++] = HEX[bys[i] >> 4 & 0xf];
      chs[offset++] = HEX[bys[i] & 0xf];
    }
    return new String(chs);
  }
}
