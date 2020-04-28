<!DOCTYPE html>
<!-- saved from url=(0029)#signin -->
<html lang="zh-CN" dropeffect="none"
      class="js is-AppPromotionBarVisible cssanimations csstransforms csstransitions flexbox no-touchevents no-mobile"
      style="">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" async="" src="/scripts/za-0.1.1.min.js"></script>
    <script async="" src="/scripts/ga.js"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-ZA-Response-Id" content="46acde5c53db46f2806ccad726de9826">
    <title>首页 - 牛客</title>
    <meta name="apple-itunes-app" content="app-id=432274380">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="mobile-agent" content="format=html5;url=https://nowcoder.com/">
    <meta id="znonce" name="znonce" content="d3edc464cf014708819feffde7ddd01e">
    <link rel="search" type="application/opensearchdescription+xml" href="https://nowcoder.com/static/search.xml"
          title="牛客">
    <link rel="stylesheet" href="/styles/index.css">
    <style>
        .zm-item-answer-author-info a.collapse {
            margin-top: 0
        }
    </style>

</head>
<body class="zhi ">
<#include "top.ftl">
<div class="zg-wrap zu-main clearfix " role="main">
    <div class="zu-main-content">
        <div class="zu-main-content-inner">
            <div class="zg-section" id="zh-home-list-title">
                <i class="zg-icon zg-icon-feedlist"></i>最新动态
                <span class="zg-right zm-noti-cleaner-setting" style="list-style:none">
                        <a href="https://nowcoder.com/settings/filter" class="zg-link-gray-normal">
                            <i class="zg-icon zg-icon-settings"></i>设置
                        </a>
                    </span>
            </div>
            <div class="zu-main-feed-con navigable" data-feedtype="topstory" id="zh-question-list">
                <div id="js-home-feed-list" class="zh-general-list topstory clearfix">
                    <#list  vos as vo>
                        <div class="feed-item folding feed-item-hook feed-item-1
                        ">
                            <div class="feed-item-inner">
                                <div class="avatar">
                                    <a title="赵永峰" class="zm-item-link-avatar" target="_blank"
                                       href="/user/${vo["user"].id}">
                                        <img src="../images/res/${vo["user"].headUrl}"
                                             class="zm-item-img-avatar">
                                    </a>
                                </div>
                                <div class="feed-main">
                                    <div class="feed-source" data-za-module="FeedSource">您关注的问题有新的回答</div>
                                    <div class="feed-content" data-za-module="PostItem">
                                        <h2 class="feed-title">
                                            <a target="_blank" class="post-link"
                                               href="/question/${vo["question"].id}">${vo["question"].title}</a>
                                        </h2>
                                        <div class="entry-body post-body js-collapse-body">
                                            <div class="author-info">
                                                <a href="https://nowcoder.com/people/zhao-yong-feng"
                                                   class="name">${vo["user"].name}</a>
                                            </div>
                                            <div class="post-content">
                                                <div class="zh-summary summary clearfix">
                                                    ${vo["answer"].content}
                                                    <a href="https://nowcoder.com/question/19857995/answer/13174385"
                                                       class="toggle-expand">显示全部</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="feed-meta">
                                            <div class="zm-item-meta answer-actions clearfix js-contentActions">
                                                <div class="zm-meta-panel">
                                                    <a data-follow="q:link" class="follow-link zg-follow meta-item"
                                                       href="javascript:;" id="sfb-123114">
                                                        <i class="z-icon-follow"></i>关注问题
                                                    </a>
                                                    <a href="#" name="addcomment"
                                                       class="meta-item toggle-comment js-toggleCommentBox">
                                                        <i class="z-icon-comment"></i>69 条评论
                                                    </a>
                                                    <a href="#" class="meta-item js-thank" data-thanked="false">
                                                        <i class="z-icon-thank"></i>感谢
                                                    </a>
                                                    <button class="meta-item item-collapse js-collapse">
                                                        <i class="z-icon-fold"></i>收起
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
                <a href="javascript:;" id="zh-load-more" class="zg-btn-white zg-r3px zu-button-more">更多</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>