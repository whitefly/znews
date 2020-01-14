package com.example.znews.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageUtil {
    private static final Logger logger = LoggerFactory.getLogger(MessageUtil.class);

    public static String generateConversationId(int fromId, int toId) {
        if (fromId < toId) return fromId + "_" + toId;
        else return toId + "_" + fromId;
    }
}
