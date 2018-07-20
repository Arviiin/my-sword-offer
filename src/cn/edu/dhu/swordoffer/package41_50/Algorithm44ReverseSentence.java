package cn.edu.dhu.swordoffer.package41_50;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Algorithm44ReverseSentence {

    public String ReverseSentence(String str) {
        /*if (" ".equals(str))
            return str;*/
        if (str == null || "".equals(str.trim())) return str;//例子里边的" ",可能包含多个空格...!因此上面不对,
        String[] split = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]);
            if (i != 0)
                sb.append(" ");
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
//        String string = "I am a student.";//"student. a am I"
        String string = " ";//"student. a am I"
        Algorithm44ReverseSentence obj = new Algorithm44ReverseSentence();
        String result = obj.ReverseSentence(string);
        System.out.println(result);
    }
}
