<!DOCTYPE html>
<!-- saved from url=(0039)question/36301524 -->
<html lang="zh-CN" dropeffect="none"
      class="js  is-AppPromotionBarVisible cssanimations csstransforms csstransitions flexbox no-touchevents no-mobile"
      style="">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="/scripts/main/jquery.js"></script>
    <script type="text/javascript" async="" src="/scripts/za-0.1.1.min.js"></script>
    <script type="text/javascript" src="/scripts/main/base/base.js"></script>
    <script type="text/javascript" src="/scripts/main/base/util.js"></script>
    <script type="text/javascript" src="/scripts/main/base/event.js"></script>
    <script type="text/javascript" src="/scripts/main/util/action.js"></script>
    <script async="" src="https://ssl.google-analytics.com/ga.js"></script>


    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-ZA-Response-Id" content="4b3ad1bf1e8045f1a016c31f5fbb40c8">

    <title>现在的微博里僵尸和水军泛滥，随便一个明星的粉丝力有八成都不是真粉丝。请问这些网络水军是怎么来的啊？ - 牛客</title>

    <meta name="apple-itunes-app" content="app-id=432274380, app-argument=nowcoder://questions/36301524">

    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="mobile-agent" content="format=html5;url=">
    <meta id="znonce" name="znonce" content="8d61d9c6697d4080ab36aa3bdb21b9d8">

    <link rel="search" type="application/opensearchdescription+xml" href="" title="牛客">
    <link rel="stylesheet" href="/styles/detail.css">
    <script src="/scripts/instant.e7a17de6.js"></script>

</head>

<body class="zhi">
<#include "top.ftl">
<div class="zg-wrap zu-main clearfix with-indention-votebar" id="zh-single-question-page">
    <div class="zu-main-content">
        <div class="zu-main-content-inner">
            <div class="zm-tag-editor zg-section">
                <div class="zm-tag-editor-labels zg-clear">
                    <a class="zm-item-tag" href="">新浪微博</a>
                    <a class="zm-item-tag" href="">网络营销</a>
                    <a class="zm-item-tag" href="">微博粉丝</a>
                    <a class="zm-item-tag" href="">僵尸粉</a>
                    <a class="zm-item-tag" href="">网络水军</a>
                    <a href="javascript:;" class="zu-edit-button" name="edit">
                        <i class="zu-edit-button-icon"></i>修改
                    </a>
                </div>
            </div>
            <div id="zh-question-title" class="zm-editable-status-normal">
                <h2 class="zm-item-title">
                    <span class="zm-editable-content">${question.title}</span>
                </h2>
            </div>
            <div id="zh-question-detail" class="zm-item-rich-text zm-editable-status-normal">
                <div class="zm-editable-content">${question.content}</div>
            </div>
            <div class="zm-side-section">
                <div class="zm-side-section-inner" id="zh-question-side-header-wrap">
                    <button class="follow-button zg-follow zg-btn-green js-follow" data-id="${question.id}">关注问题</button>
                    <div class="zg-btn-white goog-inline-block goog-menu-button" id="zh-question-operation-menu"
                         style="-webkit-user-select: none;">
                        <div class="goog-inline-block goog-menu-button-outer-box">
                            <div class="goog-inline-block goog-menu-button-inner-box">
                                <div class="goog-inline-block goog-menu-button-caption">
                                    <i class="zg-icon-dropdown-menu zg-icon"></i>
                                    <b class="hide-text">设置</b></div>
                                <div class="goog-inline-block goog-menu-button-dropdown">&nbsp;</div>
                            </div>
                        </div>
                    </div>

                    <div class="zh-question-followers-sidebar">
                        <div class="zg-gray-normal">
                            <a href="">
                                <strong>${followers?size}</strong>
                            </a>人关注该问题
                        </div>
                        <div class="list zu-small-avatar-list zg-clear">
                            <#list  followers as follower>
                            <a class="zm-item-link-avatar" href="/user/${follower.id}">

                                <img src="../images/res/${follower.headUrl}"
                                     class="zm-item-img-avatar"></a>
                            </#list>
                        </div>
                    </div>
                </div>
            </div>
            <div id="zh-question-answer-wrap" class="zh-question-answer-wrapper navigable">

                <#list  vos as vo>
                    <div class="zm-item-answer  zm-item-expanded">
                        <div class="zm-votebar goog-scrollfloater js-vote" data-id="${vo["comment"].id}">
                            <button class="up js-like" title="赞同">
                                <i class="icon vote-arrow"></i>
                                <span class="count js-count">${vo["likeCount"]}</span>
                                <span class="label sr-only">赞同</span>
                            </button>
                            <button class="down js-dislike" title="反对，不会显示你的姓名">
                                <i class="icon vote-arrow"></i>
                                <span class="label sr-only">反对，不会显示你的姓名</span>
                            </button>
                        </div>
                        <#--                        <script>-->
                        <#--                            $(".up.js-like").click(function () {-->
                        <#--                                let data_div = $(this).closest("div.zm-votebar.goog-scrollfloater.js-vote");-->
                        <#--                                let rnt=data_div.attr("data-id");-->
                        <#--                                alert(rnt);-->
                        <#--                            })-->
                        <#--                        </script>-->
                        <div class="answer-head">
                            <div class="zm-item-answer-author-info">
                                <a class="zm-item-link-avatar avatar-link" href="" target="_blank">
                                    <img src="../images/res/${vo["user"].headUrl}"
                                         class="zm-list-avatar avatar">
                                </a>
                                <a class="author-link" target="_blank"
                                   href="/user/${vo["user"].id}">${vo["user"].name}</a>
                            </div>
                            <div class="zm-item-vote-info">
                                <span class="voters text">
                                    <a href="" class="more text">
                                        <span
                                                class="js-voteCount">${vo["likeCount"]}
                                        </span>&nbsp;人赞同</a></span>
                            </div>
                        </div>
                        <div class="zm-item-rich-text expandable js-collapse-body">
                            <div class="zm-editable-content clearfix">
                                ${vo["comment"].content}
                            </div>
                        </div>
                        <a class="zg-anchor-hidden ac" name="22162611-comment"></a>
                        <div class="zm-item-meta answer-actions clearfix js-contentActions">
                            <div class="zm-meta-panel">
                                <a itemprop="url" class="answer-date-link meta-item" target="_blank" href="">发布于
                                    ${vo["comment"].createdDate?string('yyyy-MM-dd HH:mm:ss')}</a>
                                <a href="" name="addcomment" class="meta-item toggle-comment js-toggleCommentBox">
                                    <i class="z-icon-comment"></i>4 条评论</a>
                                <a href="" class="meta-item zu-autohide js-thank">
                                    <i class="z-icon-thank"></i>感谢</a>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
            <div id="zh-question-answer-form-wrap" class="zh-question-answer-form-wrap">
                <#if user??>
                    <div class="zm-editable-editor-wrap" style="">
                        <div class="zh-answer-form clearfix">
                            <a href="/user/${user.id}" title="${user.name}" class="zm-item-link-avatar">
                                <img src="../images/res/${user.headUrl}" class="zm-list-avatar">
                            </a>
                            <div class="zu-answer-form-title">
                                <a href="/user/${user.id}" title="${user.name}">${user.name}</a>
                                <span>
                                    <a name="edit_bio" class="zu-edit-button" href="question/36301524#">
                                        <i class="zu-edit-button-icon"></i>填写话题经验，提升回答可信度</a>
                                </span>
                            </div>
                        </div>
                        <div class="zm-editable-editor-outer">
                            <div class="zm-editable-editor-field-wrap">
                                <div id="mock:f" class="zm-editable-editor-field-element editable" g_editable="true"
                                     role="textbox" contenteditable="true" style="font-style: italic;">
                                    <p>
                                    <form id="answer_box" method="post" action="/comment/add">
                                        <input type="hidden" name="questionId" value="${question.id}"/>
                                        <input style="font-style: normal;color: #999;" type="text" name="content"
                                               value="写回答...">
                                    </form>
                                    <#--                                    <span  id="answer_box">写回答...</span>-->
                                    </p>
                                </div>

                            </div>
                        </div>
                        <div class="zm-command clearfix">
                            <label class="zg-left anno-box" style="-webkit-user-select: none;">
                                <input name="anno-checkbox" type="checkbox" style="-webkit-user-select: none;">匿名
                                <span style="-webkit-user-select: none;">&nbsp;</span></label>
                            <label class="zg-left copyright-box">
                                <input name="copyright-checkbox" type="checkbox">未经许可，禁止转载
                                <a href="terms#sec-licence-6" target="_blank">
                                    <i class="zg-icon zg-icon-question-mark" style="margin-left: 5px;"
                                       id="copyright_question_mark"></i></a>
                            </label>
                            <span class=" zg-right">
                            <script>

                                let content = document.getElementById("answer_box");

                            </script>
                                <a class="submit-button zg-btn-blue" name="save"
                                   onclick="document.getElementById('answer_box').submit();">发布回答</a></span>
                        </div>
                    </div>
                <#else>
                    <span>
                                    <a name="edit_bio" class="zu-edit-button" href="/loginPage">
                                        <i class="zu-edit-button-icon"></i>登录后回答问题</a>
                                </span>
                </#if >
            </div>

        </div>
    </div>
</div>
<script src="/scripts/vendor.ff76fbae.js"></script>
<script src="/scripts/base.fb262f0e.js"></script>
<script src="/scripts/common.fed5411f.js"></script>
<script src="/scripts/richtexteditor.aa0a4005.js" async=""></script>
<script src="/scripts/page-main.5d4c554d.js"></script>
<script type="text/zscript" znonce="8d61d9c6697d4080ab36aa3bdb21b9d8"></script>
<input type="hidden" name="_xsrf" value="21aa1c8d254df2899b23ab9afbd62a53">
<div class="zh-backtotop" style="opacity: 0; display: none;">
    <a href="javascript:;" class="btn-backtotop btn-action">
        <div class="arrow"></div>
        <div class="stick"></div>
    </a>
</div>

<script>
    var base = window.Base;
    var Action = base.getClass("main.util.Action");
    //点赞函数绑定
    $(".up.js-like").click(function () {
            let data_div = $(this).closest("div.zm-votebar.goog-scrollfloater.js-vote");
            let rnt = data_div.attr("data-id").toString();
            let count_span = $(this).find("span.count.js-count");
            let count_span2 = $(this).closest("div.zm-item-answer.zm-item-expanded").find("span.js-voteCount");
            let url = window.location.pathname;
            //绑定点赞函数
            let like_params = {
                commentId: rnt,
                call: function (result) {
                    //更新点赞数
                    let  like_count=result.msg
                    count_span.html(like_count)
                    count_span2.html(like_count)
                },
                error: function (result) {
                    console.log(result.code)
                    if (result.code === 999) {
                        window.location.href = "/loginPage?next=" + url;
                    }
                    //转跳到登录界面
                },
                always: function () {
                }
            };
            Action.like(like_params);
        }
    );
    //反对点赞函数绑定
    $(".down.js-dislike").click(function () {
            let data_div = $(this).closest("div.zm-votebar.goog-scrollfloater.js-vote");
            let rnt = data_div.attr("data-id").toString();
            //绑定点赞函数
            let like_params = {
                commentId: rnt,
                call: function (result) {

                },
                error: function (result) {
                    console.log(result.msg)
                },
                always: function () {
                }
            };
            Action.dislike(like_params);
        }
    );
    //关注问题函数绑定
    $("button.follow-button.zg-follow.zg-btn-green.js-follow").click(function () {
        let questionId=$(this).attr("data-id").toString();
        let follow_params={
            questionId:questionId,
            call: function (result) {
                    //修改人数和头像
                let num_position=$("div.zh-question-followers-sidebar strong")
                num_position.html(result.msg)
            },
            error: function (result) {
                console.log(result.msg)
            },
            always: function () {
            }

        }
        Action.followQuestion(follow_params)
    })
</script>

</body>
</html>