<!DOCTYPE html>
<html lang="zh-CN" class="is-AppPromotionBarVisible cssanimations csstransforms csstransitions flexbox no-touchevents no-mobile">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" async="" src="../images/res/za-0.1.1.min.js"></script>
<script async="" src="../images/res/ga.js"></script>
<title>qiche - 搜索结果 - 牛客</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="../styles/result.css" />
<script src="../images/res/instant.e7a17de6.js"></script>
<style type="text/css">._colors_text-muted_5fu-{color:#999}</style>
<style type="text/css">._Pager_root_2GoR{font-size:1.1em;text-align:center;line-height:3}._Pager_item_3xy4{padding:.5em;-webkit-transition:color .5s ease;transition:color .5s ease}</style>

</head>
<body class="posts_show">
    <#include "top.ftl">
    <div id="main">
        <div class="zg-wrap zu-main clearfix ">
            <div class="zm-profile-section-wrap zm-profile-followee-page">
                <div class="zm-profile-section-head">
                    <span class="zm-profile-section-name">
                        <a href="/user/${user.id}">${user.name}</a>  拥有粉丝:${followerCount}人
                    </span>
                    <a class="zg-right zg-link-litblue-normal zm-profile-answer-page-return" href="/people/zjuyxy">返回个人主页</a>
                </div>
                <div class="zm-profile-section-list">
                    <div id="zh-profile-follows-list">
                        <div class="zh-general-list clearfix">
                            <#list  vos as vo>
                            <div class="zm-profile-card zm-profile-section-item zg-clear no-hovercard">
                                <div class="zg-right">
                                    <button class="zg-btn zg-btn-unfollow zm-rich-follow-btn small nth-0">取消关注</button>
                                </div>
                                <a title="Barty" class="zm-item-link-avatar" href="/user/${vo["user"].id}">
                                    <img src="../images/res/${vo["user"].headUrl}" class="zm-item-img-avatar">
                                </a>
                                <div class="zm-list-content-medium">
                                    <h2 class="zm-list-content-title"><a data-tip="p$t$buaabarty" href="https://www.nowcoder.com/people/buaabarty" class="zg-link" title="Barty">${vo["user"].name}</a></h2>

                                    <div class="zg-big-gray">暂时没有填写</div>
                                    <div class="details zg-gray">
                                        <a target="_blank" href="/people/buaabarty/followers" class="zg-link-gray-normal">${vo.followerCount} 关注者</a>
                                        /
                                        <a target="_blank" href="/people/buaabarty/asks" class="zg-link-gray-normal">${vo.questionCount} 提问</a>
                                        /
                                        <a target="_blank" href="/people/buaabarty/answers" class="zg-link-gray-normal">${vo.answerCount} 回答</a>
                                        /
                                        <a target="_blank" href="/people/buaabarty" class="zg-link-gray-normal">548 赞同</a>
                                    </div>
                                </div>
                            </div>
                            </#list>
                        </div>
                        <a aria-role="button" class="zg-btn-white zu-button-more">更多</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#include "footer.ftl">

</body>
</html>