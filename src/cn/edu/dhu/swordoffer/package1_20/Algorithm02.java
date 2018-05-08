package cn.edu.dhu.swordoffer.package1_20;

public class Algorithm02 {
    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public static String replaceSpace(StringBuffer str) {

        int index = str.indexOf(" ");
        while(index != -1){
            str.replace(index,index+1,"%20");
            index = str.indexOf(" ",index);
        }
        String result = str.toString();
        return result;
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("we are happy");
        String s = replaceSpace(sb);
        System.out.println(s);
    }
}
