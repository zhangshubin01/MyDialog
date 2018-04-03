package com.padtast.mydialog;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 字符串 工具类
 */
public class StringUtils {
    // 字符串的非空
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input) || "null".equals(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }
    public static boolean isNumber(String s) {

        try {
            Float.parseFloat(s);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    /**
     * 比较第一个数组中的 元素是否和 bt2 中相同 （从srcPos开始比较）
     *
     * @param src
     *            被比较的byte数组
     * @param srcPos
     *            开始点
     * @param bt2
     *            目标数组
     * @param length
     *            长度
     * @return
     */
    public static boolean isEqualsByte(byte[] src, int srcPos, byte[] bt2,
                                       int length) {

        byte[] temp = new byte[length];
        System.arraycopy(src, srcPos, temp, 0, length);

        return Arrays.equals(temp, bt2);

    }

    /**
     * 字符串格式化为日期时间格式
     *
     * @param format
     *            原来格式 yyyyMMdd HHmmss
     * @param toformat
     *            目标格式 yyyy-MM-dd HH:mm:ss
     * @param time
     *            时间或日期
     * @return 目标日期时间字符串
     */
    public static String str2DateTime(String format, String toformat,
                                      String time) {
        String str = "";
        Date date;

        try {
            date = new SimpleDateFormat(format).parse(time);
            str = new SimpleDateFormat(toformat).format(date);
        } catch (java.text.ParseException ignored) {
        }

        return str;

    }

    /**
     * short转换为字节
     *
     * @param s
     * @return
     */
    public static byte[] shortToByteArray(short s) {
        byte[] targets = new byte[2];
        // for (int i = 0; i < 2; i++) {
        // int offset = (targets.length - 1 - i) * 8;
        // targets[i] = (byte) ((s >>> offset) & 0xff);
        // }
        targets[0] = (byte) (s & 0x00ff);
        targets[1] = (byte) ((s & 0xff00) >> 8);
        return targets;
    }
    /**
     * int类型转换为字节数组,小端模式
     *
     */
    public static byte[] intToByteArray(int i) {
        byte[] targets = new byte[4];
        targets[0] = (byte) (i & 0xFF);
        targets[1] = (byte) ((i>>8) & 0xFF);
        targets[2] = (byte) ((i>>16) & 0xFF);
        targets[3] = (byte) ((i>>24) & 0xFF);
        return targets;
    }
    /**
     * 字节数组转换为int类型,小端模式
     *
     */
    public static int byteArrayToInt(byte[] b) {
        int result = 0;
        result = (b[0]&0xFF)|(b[1]<<8&0xFFFF)|(b[2]<<16&0xFFFFFF)|(b[3]<<24&0xFFFFFFFF);
        return result;
    }

    /**
     * short转换为字节
     *
     * @param s
     * @return
     */
    public static byte[] shortToByteArrayTwo(short s) {
        byte[] targets = new byte[2];
        // for (int i = 0; i < 2; i++) {
        // int offset = (targets.length - 1 - i) * 8;
        // targets[i] = (byte) ((s >>> offset) & 0xff);
        // }
        targets[1] = (byte) (s & 0x00ff);
        targets[0] = (byte) ((s & 0xff00) >> 8);
        return targets;
    }

    /**
     * short[]转换为字节[]
     *
     * @param s
     * @return
     */
    public static byte[] shortArrayToByteArray(short[] s) {
        byte[] targets = new byte[s.length * 2];
        for (int i = 0; i < s.length; i++) {
            byte[] tmp = shortToByteArray(s[i]);

            targets[2 * i] = tmp[0];
            targets[2 * i + 1] = tmp[1];
        }
        return targets;
    }

    /**
     * byte[]到Short
     *
     * @param buf
     * @return
     */
    public static short[] byteArraytoShort(byte[] buf) {
        short[] targets = new short[buf.length / 2];
        short vSample;
        int len = 0;
        for (int i = 0; i < buf.length; i += 2) {
            vSample = (short) (buf[i] & 0x00FF);
            vSample |= (short) ((((short) buf[i + 1]) << 8) & 0xFF00);
            targets[len++] = vSample;
        }
        return targets;
    }

    /**
     * 字符串转换成十六进制字符串
     * @return String 每个Byte之间空格分隔，如: [61 6C 6B]
     */
    public static String str2HexStr(String str) {

        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;

        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    /**
     * 十六进制转换字符串
     *
     * @return String 对应的字符串
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;

        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        try {
            return new String(bytes, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return "";
    }

    /**
     * bytes转换成十六进制字符串
     *
     * @param  b  byte数组
     * @return String 每个Byte值之间空格分隔
     */
    public static String bytes2HexStr(byte[] b) {
        if(b==null)
            return "";

        String stmp = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            sb.append((stmp.length() == 1) ? "0" + stmp : stmp);
            // sb.append(" ");
        }
        return sb.toString().toUpperCase().trim();
    }

    /**
     *
     * @param b 代转换的字节
     * @return 16进制的字符串
     */
    public static String byte2HexStr(byte b){
        String stmp = "";
        StringBuilder sb = new StringBuilder("");
        stmp = Integer.toHexString(b & 0xFF);
        sb.append((stmp.length() == 1) ? "0" + stmp : stmp);
        return sb.toString().toUpperCase().trim();
    }
    /**
     * bytes字符串转换为Byte值
     *
     * @param
     *            src Byte字符串，每个Byte之间没有分隔符
     * @return byte[]
     */
    public static byte[] hexStr2Bytes(String src) {
        int m = 0, n = 0;
        if((src.length()%2)!=0)
            src = "0"+src;
        int l = src.length() / 2;
//		System.out.println(l);
        byte[] ret = new byte[l];
        for (int i = 0; i < l; i++) {
            m = i * 2 + 1;
            n = m + 1;
            ret[i] = Integer.decode(
                    "0x" + src.substring(i * 2, m) + src.substring(m, n))
                    .byteValue();
        }
        return ret;
    }

    /**
     * String的字符串转换成unicode的String
     *
     * @param
     *            strText 全角字符串
     * @return String 每个unicode之间无分隔符
     * @throws Exception
     */
    public static String strToUnicode(String strText) throws Exception {
        char c;
        StringBuilder str = new StringBuilder();
        int intAsc;
        String strHex;
        for (int i = 0; i < strText.length(); i++) {
            c = strText.charAt(i);
            intAsc = (int) c;
            strHex = Integer.toHexString(intAsc);
            if (intAsc > 128)
                str.append("\\u" + strHex);
            else
                // 低位在前面补00
                str.append("\\u00" + strHex);
        }
        return str.toString();
    }

    /**
     * unicode的String转换成String的字符串
     *
     * @param
     *            hex 16进制值字符串 （一个unicode为2byte）
     * @return String 全角字符串
     */
    public static String unicodeToString(String hex) {
        int t = hex.length() / 6;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String s = hex.substring(i * 6, (i + 1) * 6);
            // 高位需要补上00再转
            String s1 = s.substring(2, 4) + "00";
            // 低位直接转
            String s2 = s.substring(4);
            // 将16进制的string转为int
            int n = Integer.valueOf(s1, 16) + Integer.valueOf(s2, 16);
            // 将int转换为字符
            char[] chars = Character.toChars(n);
            str.append(new String(chars));
        }
        return str.toString();
    }
}
