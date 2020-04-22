<!DOCTYPE html>
<html lang="zh-CN" class="is-AppPromotionBarVisible cssanimations csstransforms csstransitions flexbox no-touchevents no-mobile">
    <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>读《Web 全栈工程师的自我修养》 - web开发的愚人之旅 - 牛客网</title>
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
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
            <ul class="letter-chatlist">
                <#list  vos as vo>
                <li id="msg-item-4009580">
                    <a class="list-head">
                        <img alt="头像" src="../images/res/${vo["user"].headUrl}">
                    </a>
                    <div class="tooltip fade right in">
                        <div class="tooltip-arrow"></div>
                        <div class="tooltip-inner letter-chat clearfix">
                            <div class="letter-info">
                                <p class="letter-time">${vo["message"].createdDate?string('yyyy-MM-dd HH:mm:ss')}</p>
                                <a href="javascript:void(0);" id="del-link" name="4009580">删除</a>
                            </div>
                            <p class="chat-content">
<#--                                你收藏的问题<a class="msg-view-all" href="/questionTerminal/abc3fe2ce8e146608e868a70efebf62e?toCommentId=141625">"二维数组中的查找"</a>-->
<#--                                有了新的回答，去看看对自己是否有用吧。（不想再收到此类提醒？<a class="msg-view-all" href="/profile/account#setNotification">点击设置</a>-->
<#--                                ）-->
                                ${vo["message"].content}
                            </p>
                        </div>
                    </div>
                </li>
                </#list>
            </ul>
        </div>

    </div>
    <#include "footer.ftl">
</body>
</html>