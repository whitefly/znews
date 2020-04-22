<!DOCTYPE html>
<html lang="zh-CN"
      class="is-AppPromotionBarVisible cssanimations csstransforms csstransitions flexbox no-touchevents no-mobile">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>读《Web 全栈工程师的自我修养》 - web开发的愚人之旅 - 牛客网</title>
    <meta name="viewport"
          content="width=device-width, minimum-scale=1.0, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta name="keywords" content="读《Web 全栈工程师的自我修养》">
    <meta name="description" content="阅读影浅分享的读《Web 全栈工程师的自我修养》，就在牛客网。">

    <link rel="stylesheet" type="text/css" href="/styles/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/styles/font-awesome.min.css">

    <link rel="stylesheet" media="all" href="/styles/letter.css">

    <script src="/scripts/hm.js"></script>
    <script src="/scripts/detail.js"></script>

    <script type="text/javascript" src="/scripts/bootstrap.min.js"></script>
    <script type="text/javascript" src="/scripts/jquery.qrcode.min.js"></script>
</head>
<body class="posts_show">
<#include "top.ftl">
<div id="main">
    <div class="zg-wrap zu-main clearfix ">
        <ul class="letter-list">
            <#list  vos as vo>
            <li id="conversation-item-10005_622873">
                <a class="letter-link" href="msg-list?conversationId=10005_622873&amp;updateRead=1&amp;msgType=1"></a>
                <div class="letter-info">
                    <span class="l-time">${vo["message"].createdDate?string('yyyy-MM-dd HH:mm:ss')}</span>
                    <div class="l-operate-bar">
                        <a href="javascript:void(0);" class="sns-action-del" data-id="10005_622873">
                            删除
                        </a>
                        <a href="msg-list?conversationId=10005_622873&amp;updateRead=1&amp;msgType=1">
                            共${vo["message"].id}条会话
                        </a>
                    </div>
                </div>
                <div class="chat-headbox">
                        <span class="msg-num">
                            ${vo["message"].id}
                        </span>
                    <a class="list-head">
                        <img alt="头像" src="../images/res/${vo["user"].headUrl}">
                    </a>
                </div>
                <div class="letter-detail">
                    <a title="通知" class="letter-name level-color-1">
                        通知
                    </a>
                    <p class="letter-brief">
                        <a href="/message/detail?conversation=${vo["message"].conversationId}">
                            ${vo["message"].content}
                        </a>
                    </p>
                </div>
            </li>
            </#list>
        </ul>

    </div>

</div>
<#include  "footer.ftl">
</body>
</html>