<!DOCTYPE html>
<!-- saved from url=(0029)#signin -->
<html lang="zh-CN" dropeffect="none"
      class="js is-AppPromotionBarVisible cssanimations csstransforms csstransitions flexbox no-touchevents no-mobile"
      style="">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" async="" src="../scripts/za-0.1.1.min.js"></script>
    <script async="" src="../scripts/ga.js"></script>
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
    <link rel="stylesheet" href="../styles/index.css">
    <link rel="stylesheet" href="../styles/message.css">
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
                <input type="hidden" id="is-topstory">
                <span class="zg-right zm-noti-cleaner-setting" style="list-style:none">
                        <a href="https://nowcoder.com/settings/filter" class="zg-link-gray-normal">
                            <i class="zg-icon zg-icon-settings"></i>设置</a></span>
            </div>
            <div class="zu-main-feed-con navigable" data-feedtype="topstory" id="zh-question-list"
                 data-widget="navigable"
                 data-navigable-options="{&quot;items&quot;:&quot;&gt; .zh-general-list .feed-content&quot;,&quot;offsetTop&quot;:-82}">
                <a href="javascript:;" class="zu-main-feed-fresh-button" id="zh-main-feed-fresh-button"
                   style="display:none"></a>
                <div id="js-home-feed-list" class="zh-general-list topstory clearfix"
                     data-init="{&quot;params&quot;: {}, &quot;nodename&quot;: &quot;TopStory2FeedList&quot;}"
                     data-delayed="true" data-za-module="TopStoryFeedList">
                    <#list  vos as vo>
                        <div class="feed-item folding feed-item-hook feed-item-2
                        " feed-item-a="" data-type="a" id="feed-2" data-za-module="FeedItem" data-za-index="">
                            <meta itemprop="ZReactor" data-id="389034"
                                  data-meta="{&quot;source_type&quot;: &quot;promotion_answer&quot;, &quot;voteups&quot;: 4168, &quot;comments&quot;: 69, &quot;source&quot;: []}">
                            <div class="feed-item-inner">
                                <div class="avatar">
                                    <a title="李淼" data-tip="p$t$amuro1230" class="zm-item-link-avatar" target="_blank"
                                       href="https://nowcoder.com/people/amuro1230">
                                        <img src="../images/res/${vo["user"].headUrl}"
                                             class="zm-item-img-avatar"></a>
                                </div>
                                <div class="feed-main">
                                    <div class="feed-source" data-za-module="FeedSource">热门回答，来自
                                        <a href="https://nowcoder.com/topic/19562033" data-tip="t$t$19562033"
                                           data-token="19562033" data-topicid="3946" target="_blank">人际交往</a>
                                        <a data-follow="t:link" href="javascript:;"
                                           class="zg-follow zu-autohide follow-topic zu-edit-button"
                                           data-id="3946">关注话题</a>
                                    </div>
                                    <div class="feed-content" data-za-module="AnswerItem">
                                        <meta itemprop="answer-id" content="389034">
                                        <meta itemprop="answer-url-token" content="13174385">
                                        <h2 class="feed-title">
                                            <a class="question_link" target="_blank"
                                               href="/question/${vo["question"].id}">${vo["question"].title}</a>
                                        </h2>
                                        <div class="feed-question-detail-item">
                                            <div class="question-description-plain zm-editable-content"></div>
                                        </div>
                                        <div class="expandable entry-body">
                                            <!-- <link itemprop="url" href="/question/19857995/answer/13174385">
                                            <meta itemprop="answer-id" content="389034">
                                            <meta itemprop="answer-url-token" content="13174385"> -->
                                            <div class="zm-item-vote">
                                                <a class="zm-item-vote-count js-expand js-vote-count"
                                                   href="javascript:;"
                                                   data-bind-votecount="">4168</a></div>
                                            <div class="zm-votebar" data-za-module="VoteBar">
                                                <button class="up" aria-pressed="false" title="赞同">
                                                    <i class="icon vote-arrow"></i>
                                                    <span class="count">4168</span>
                                                    <span class="label sr-only">赞同</span></button>
                                                <button class="down" aria-pressed="false" title="反对，不会显示你的姓名">
                                                    <i class="icon vote-arrow"></i>
                                                    <span class="label sr-only">反对，不会显示你的姓名</span></button>
                                            </div>
                                            <div class="zm-item-answer-author-info">
                                                <a class="author-link" data-tip="p$b$amuro1230" target="_blank"
                                                   href="https://nowcoder.com/people/amuro1230">${vo["user"].name}</a>
                                                <span title="从互联网行业出来在做旅行的前对冲基金从业者"
                                                      class="bio">${vo["question"].createdDate?string('yyyy-MM-dd HH:mm:ss')}</span>
                                            </div>
                                            <div class="zm-item-vote-info" data-votecount="4168"
                                                 data-za-module="VoteInfo">
                                                <span class="voters text">
                                                    <a href="#" class="more text">
                                                        <span class="js-voteCount">4168</span>&nbsp;人赞同</a></span>
                                            </div>
                                            <div class="zm-item-rich-text expandable js-collapse-body"
                                                 data-resourceid="123114" data-action="/answer/content"
                                                 data-author-name="李淼"
                                                 data-entry-url="/question/19857995/answer/13174385">
                                                <div class="zh-summary summary clearfix">${vo["question"].content}
                                                    <a href="/question/${vo["question"].id}"
                                                       class="toggle-expand">显示全部</a></div>
                                                <p class="visible-expanded">
                                                    <a itemprop="url" class="answer-date-link meta-item"
                                                       data-tip="s$t$发布于 2011-09-23" target="_blank"
                                                       href="https://nowcoder.com/question/19857995/answer/13174385">编辑于
                                                        2015-06-24</a></p>
                                            </div>
                                        </div>
                                        <div class="feed-meta">
                                            <div class="zm-item-meta answer-actions clearfix js-contentActions">
                                                <div class="zm-meta-panel">
                                                    <a data-follow="q:link" class="follow-link zg-follow meta-item"
                                                       href="javascript:;" id="sfb-123114">
                                                        <i class="z-icon-follow"></i>关注问题</a>
                                                    <a href="#" name="addcomment"
                                                       class="meta-item toggle-comment js-toggleCommentBox">
                                                        <i class="z-icon-comment"></i>${vo["question"].commentCount} 条评论</a>

                                                    <button class="meta-item item-collapse js-collapse">
                                                        <i class="z-icon-fold"></i>收起
                                                    </button>
                                                </div>
                                            </div>
                                            <a href="#" class="ignore zu-autohide" name="dislike"
                                               data-tip="s$b$不感兴趣"></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="undo-dislike-options" data-item_id="2">此内容将不会在动态中再次显示
                                <span class="zg-bull">•</span>
                                <a href="#" class="meta-item revert">撤销</a>
                                <a href="#" class="ignore zu-autohide close"></a>
                            </div>
                        </div>
                    </#list>
                </div>

                <a href="javascript:;" id="zh-load-more" data-method="next" class="zg-btn-white zg-r3px zu-button-more"
                   style="">更多</a></div>
        </div>
    </div>
</div>
<script type="text/json" class="json-inline" data-name="guiders2">{
            "exclusive-popover": {},
            "section": {
                "home-topstory": {
                    "content": "\u5173\u6ce8\u4e00\u4e9b\u8bdd\u9898\u548c\u4eba\uff0c\u8fd9\u91cc\u4f1a\u6709\u66f4\u591a\u4f60\u611f\u5174\u8da3\u7684\u5185\u5bb9",
                    "dismissText": "\u77e5\u9053\u4e86",
                    "title": "\u6700\u65b0\u52a8\u6001"
                }
            },
            "editor": ["bio", "topic"]
        }






</script>
<script type="text/template" id="tmpl-Guide-BioEditor">< div class = "Guide-BioEditor" >
    <div class="Guide-header">
        <h2 class="Guide-title"> 你的职业或专业是什么？ </h2>
        <p class="Guide-subtitle">简单介绍自己，会为你挑选你可能感兴趣话题</p>
    </div>
    <div class="Guide-content">
        <div class="Guide-BioEditorForm">
            <button class="Guide-BioEditorButton Button Button-flatPrimary js-submit">完成</button>
            <div class="Guide-BioEditorInputWrapper"><input class="Guide-BioEditorInput Input" name="bio"
                                                            placeholder="比如医生、律师、设计师"></div>
        </div>
        <div class="Guide-BioEditorUsers"><p class="Guide-BioEditorDescription"> 他们是这样介绍自己的 < /p>
            <ul>
                <li class="Guide-BioEditorItem Guide-BioEditorItem--first">
                    <img class="Guide-BioEditorAvatar"
                         src="https:/ / pic3.zhimg.com / 7f5966584a3301d83ed24708d9d56aea_l.jpg " width="50 "
                         height="50 ">
                    <span class="Guide - BioEditorBio ">系外行星的研究生</span></li>
                <li class="Guide - BioEditorItem Guide - BioEditorItem--second ">
                    <img class="Guide - BioEditorAvatar " src="https: //pic2.zhimg.com/6e5a78fe9_l.jpg" width="50"
                         height="50">
                    < span class = "Guide-BioEditorBio" > Lonely Planet作者，潜水员 < /span>
                </li>
                <li class="Guide-BioEditorItem Guide-BioEditorItem--third"><img class="Guide-BioEditorAvatar"
                                                                                src="https://pic2.zhimg.com/02295607d866419c478062d9bfc5a041_l.jpg"
                                                                                width="50" height="50"> <span
                            class="Guide-BioEditorBio"> 北京大学南亚学系 < /span></li>
                <li class="Guide-BioEditorItem Guide-BioEditorItem--fourth"><img class="Guide-BioEditorAvatar"
                                                                                 src="https://pic3.zhimg.com/47e67af4e15cb97d47da376d1b83cae6_l.jpg"
                                                                                 width="50" height="50"> <span
                            class="Guide-BioEditorBio"> 机械工程师，pegasister < /span></li>
                <li class="Guide-BioEditorItem Guide-BioEditorItem--fifth"><img class="Guide-BioEditorAvatar"
                                                                                src="https://pic3.zhimg.com/f374969469745635565a63bcd36842f6_l.jpg"
                                                                                width="50" height="50"> <span
                            class="Guide-BioEditorBio"> 钛度科技 / 电子竞技 < /span></li>
                <li class="Guide-BioEditorItem Guide-BioEditorItem--sixth"><img class="Guide-BioEditorAvatar"
                                                                                src="https://pic2.zhimg.com/fe9e9e6dd_l.jpg"
                                                                                width="50" height="50"> <span
                            class="Guide-BioEditorBio"> 工科女博士 / 专业西点师 / 东京时差党 < /span></li>
            </ul>
        </div>
    </div>
    </div > </script>
<script type="text/template" id="tmpl-Guide-Topics">< div class = "Guide-Topics" >
    <div class="Guide-header">
        <h2 class="Guide-title"> 你想关注哪些话题？ < /h2>
            <p class="Guide-subtitle">我们将根据你关注的话题定制首页推荐内容</p>
    </div>
    <div class="Guide-content">
        <div class="Guide-topicsLoading">
            <span class="Spinner"></span>
            <p> 正在加载中 < /p></div>
    </div>
    <div class="Guide-TopicsFooter GaussianBlur">
        <button class="Guide-TopicsSubmit Button Button-flatPrimary js-submit">进入牛客</button>
    </div></div > </script>
<script type="text/template" class="activate-dialog-template">< div class = "code-activate-view clearfix" >
    <div class="tip"> 为了正常使用牛客的提问、回答、评论和编辑功能，请绑定你的手机或邮箱。 < /div>
        <form class="send-code">
            <div class="input-wrapper">
                <label class="info" for="account">手机或邮箱：</label> <input type="text" name="account" class="text"
                                                                        placeholder="手机号或邮箱" required></div>
            <button class="submit zg-btn-blue">获取验证码</button>
        </form>
        <form class="activate">
            <div class="input-wrapper">
                <label class="info" for="account">手机或邮箱：</label> <input type="text" name="account" class="text"
                                                                        placeholder="手机号或邮箱" required></div>
            <div class="input-wrapper verification-code">
                <label class="info" for="digits">验证码：</label> <input type="text" name="digits" class="text"
                                                                     placeholder="6 位数验证码" maxlength="6" required>
                <button type="button" class="resend-code"> 重发验证码</button>
            </div>
            <button class="submit zg-btn-blue"> 激活 < /button>
        </form>
    </div>

    /</script>
<script type="text/json" class="json-inline" data-name="current_user">
    ["\u80e1\u539f", "hu-yuan-24-48", "https:\/\/pic1.zhimg.com\/da8e974dc_s.jpg", "69e344deb3bd4d35db07194565261bbe", "", 0, 0, false, null, "", 0, true, false, false, "734705672150609920", false]






</script>
<script type="text/json" class="json-inline" data-name="user_status">[null, null]</script>
<script type="text/json" class="json-inline" data-name="env">["zhihu.com", "comet.zhihu.com", false, null, false]






</script>
<script type="text/json" class="json-inline" data-name="permissions">[]</script>
<script type="text/json" class="json-inline" data-name="ga_vars">{
            "user_created": 1467947482000,
            "now": 1467947482000,
            "abtest_mask": "---------1--------------------",
            "user_attr": [1, 0, 0, "-", "-"],
            "user_hash": "69e344deb3bd4d35db07194565261bbe"
        }






</script>
<script type="text/json" class="json-inline" data-name="ra-urls">{
            "Report": "https:\/\/static.zhihu.com\/static\/revved\/-\/apps\/Report.d6e20840.js",
            "Community": "https:\/\/static.zhihu.com\/static\/revved\/-\/apps\/Community.4e11c449.js",
            "OrgAnalytics": "https:\/\/static.zhihu.com\/static\/revved\/-\/apps\/OrgAnalytics.47e1a483.js",
            "common": "https:\/\/static.zhihu.com\/static\/revved\/-\/apps\/common.ed1d17c3.js",
            "CommentApp": "https:\/\/static.zhihu.com\/static\/revved\/-\/apps\/CommentApp.2ab02258.js"
        }






</script>
<script src="../scripts/vendor.ff76fbae.js"></script>
<script src="../scripts/base.fb262f0e.js"></script>
<script src="../scripts/common.fed5411f.js"></script>
<script src="../scripts/richtexteditor.aa0a4005.js" async=""></script>
<script src="../scripts/page-main.5d4c554d.js"></script>
<meta name="entry" content="ZH.entryHome" data-module-id="page-main">
<script type="text/zscript" znonce="d3edc464cf014708819feffde7ddd01e"></script>
<input type="hidden" name="_xsrf" value="21aa1c8d254df2899b23ab9afbd62a53">
<div class="zh-backtotop" style="opacity: 0; display: none;">
    <a data-action="backtotop" data-tip="s$r$回到顶部" href="javascript:;" class="btn-backtotop btn-action">
        <div class="arrow"></div>
        <div class="stick"></div>
    </a>
</div>
<div id="zh-tooltip" data-theme="" class="tooltip bottom"
     style="visibility: hidden; left: 778px; top: 321px; display: none;">
    <div class="tooltip-arrow"></div>
    <div class="tooltip-inner content-prewrap">不感兴趣</div>
</div>
<div class="copyright-notification">
    <div class="user-image-container">
        <img class="user-image" src="https://nowcoder.com/"></div>
    <div class="tooltip right noty-tooltip">
        <div class="tooltip-arrow arrow"></div>
        <div class="tooltip-inner inner">如需转载，请通过私信或评论联系我</div>
    </div>
</div>
</body>
</html>