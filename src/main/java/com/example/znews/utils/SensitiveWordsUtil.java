package com.example.znews.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class SensitiveWordsUtil implements InitializingBean {
    private static Logger logger = LoggerFactory.getLogger(SensitiveWordsUtil.class);
    static final String sensitiveFolder = "static/sensitiveWord/sample.txt";  //敏感词文件位置
    TrieNode root; //敏感词前缀树的根节点
    static final String replaceWord = "***";  //敏感词的替换词


    /*
       前缀树用于匹配敏感词.
        */
    static private class TrieNode {
        private boolean end = false;
        private Map<Character, TrieNode> subTrie = new HashMap<>();

        void addNode(Character c, TrieNode node) {
            subTrie.put(c, node);
        }

        TrieNode getNode(Character c) {
            return subTrie.get(c);
        }

        boolean existChar(Character c) {
            return subTrie.get(c) != null;
        }

        boolean isEnd() {
            return end;
        }

        void setEndNode() {
            end = true;
        }
    }


    public SensitiveWordsUtil() {
        this.root = new TrieNode();
    }


    @Override
    public void afterPropertiesSet() {
        /*
         读取文件,构造敏感词前缀树
         */
        try {
            ClassPathResource classPathResource = new ClassPathResource(sensitiveFolder);
            InputStreamReader is = new InputStreamReader(classPathResource.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(is);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String processedWord = wordHandler(line);
                addWord(processedWord);
            }
        } catch (IOException e) {

            logger.error("读取敏感词文件出错", e);
        }
    }

    private String wordHandler(String word) {
        /*
         消除每行关键词的特殊符号,用于后续扩展;
         */
        return word.replace(" ", "");
    }

    private void addWord(String word) {
        TrieNode index = this.root;
        if (StringUtils.isEmpty(word)) return;

        for (Character c : word.toCharArray()) {
            TrieNode newNode = index.getNode(c);
            if (newNode == null) {
                newNode = new TrieNode();
                index.addNode(c, newNode);
            }
            index = newNode;
        }
        //将word最后一个字符节点打上标记
        index.setEndNode();
    }

    private boolean isSymbol(Character c) {
        int ci = (int) c;
        return ci < 0x2e80 || ci > 0x9FFF;
    }

    public String filter(String input) {
        if (StringUtils.isEmpty(input)) return input;

        StringBuilder sb = new StringBuilder();
        int left = 0;
        while (left < input.length()) {
            char start = input.charAt(left);
            //触发了首字符,开始进入匹配
            if (root.existChar(start)) {
                TrieNode temp = root;
                for (int right = left; right < input.length(); right++) {
                    Character c = input.charAt(right);
                    if (isSymbol(c)) continue;
                    if (temp.existChar(c)) {
                        temp = temp.getNode(c);
                        if (temp.isEnd()) {
                            //匹配到一条完整敏感词
                            sb.append(replaceWord);
                            left = right + 1;
                            break;
                        }
                    } else {
                        //无法找到继续匹配的节点,退出
                        sb.append(input.charAt(left));
                        left++;
                        break;
                    }
                }
            } else {
                sb.append(input.charAt(left));
                left++;
            }
        }
        return sb.toString();
    }
}
