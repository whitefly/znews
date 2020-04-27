package com.example.znews.utils;

public class WendaUtil {
    private static final int LIMIT_COUNT = 30; //问题预览的限制长度

    public static String previewContent(String content) {
        //返回问题的折叠形式
        if (content.length() > LIMIT_COUNT) {
            return content.substring(0, LIMIT_COUNT) + "...";
        } else return content;
    }

    public static void main(String[] args) {
        String content = "刚进入摄影门槛是不是很迷茫，连个相机都不会开机怎么办，更别说什么光圈快门感光度如何搭配，买了一大堆书发现看完了还是什么都不懂，这绝对是本人血的教训，所以我深知入门打好基础的重要性，基础打得越好，以后少走很多弯路。以下这10个回答或许能帮你解决如何入门摄影这个新世界";
        System.out.printf(previewContent(content));
    }
}
