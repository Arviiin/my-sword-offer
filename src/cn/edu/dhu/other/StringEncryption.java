package cn.edu.dhu.other;

/**
 * 字符串向前移动解密,向后加密
 */
public class StringEncryption {
    public static void main(String[] args) {
        String str = "ABXYZ.89043457#$";
        String encryRestult = stringEncry(str);
        String dencryRestult = stringDecrypt(encryRestult);
        System.out.println(str);
        System.out.println(encryRestult);
        System.out.println(dencryRestult);
    }

    public static String stringEncry(String string){
        char[] charArray = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] >= 65 && charArray[i] <=90){
                charArray[i] = (char) (charArray[i] + 5);
                if (charArray[i] > 90){
                    charArray[i] = (char) (charArray[i] - 26);
                }
            }
            sb.append(charArray[i]);
        }
        return sb.toString();
    }

    public static String stringDecrypt(String string){
        char[] charArray = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] >= 65 && charArray[i] <=90){
                charArray[i] = (char) (charArray[i] - 5);
                if (charArray[i] <65 ){
                    charArray[i] = (char) (charArray[i] + 26);
                }
            }
            sb.append(charArray[i]);
        }
        return sb.toString();
    }
}
