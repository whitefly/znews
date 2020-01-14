<div role="navigation" class="zu-top">
    <div class="zg-wrap modal-shifting clearfix" id="zh-top-inner">
        <a href="https://nowcoder.com/" class="zu-top-link-logo" id="zh-top-link-logo" data-za-c="view_home"
           data-za-a="visit_home" data-za-l="top_navigation_zhihu_logo">牛客</a>
        <div class="top-nav-profile">

            <#if user??>
                <a href="https://nowcoder.com/people/hu-yuan-24-48" class="zu-top-nav-userinfo " id=":0" role="button"
                   aria-haspopup="true">
                    <span class="name">${(user.name)}</span>
                    <img class="Avatar" src="../images/res/${user.headUrl}">
                    <span id="zh-top-nav-new-pm" class="zg-noti-number zu-top-nav-pm-count" style="visibility:hidden"
                          data-count="0">
                    </span>
                </a>
                <ul class="top-nav-dropdown" id="top-nav-profile-dropdown" aria-labelledby=":0">
                    <li>
                        <a href="/user/${(user.id)!"-1"}" tabindex="-1" id=":1">
                            <i class="zg-icon zg-icon-dd-home"></i>我的主页
                        </a>
                    </li>
                    <li>
                        <a href="/message/list" tabindex="-1" id=":2">
                            <i class="zg-icon zg-icon-dd-pm"></i>私信
                            <span id="zh-top-nav-pm-count" class="zu-top-nav-pm-count zg-noti-number"
                                  style="visibility:hidden" data-count="0">
                    </span>
                        </a>
                    </li>
                    <li>
                        <a href="https://nowcoder.com/settings" tabindex="-1" id=":3">
                            <i class="zg-icon zg-icon-dd-settings"></i>设置
                        </a>
                    </li>
                    <li>
                        <a href="/logout" tabindex="-1" id=":4">
                            <i class="zg-icon zg-icon-dd-logout"></i>退出
                        </a>
                    </li>
                </ul>

            <#else>
                <a class="name" href="/loginPage">登录/注册</a>

            </#if>
        </div>

        <button class="zu-top-add-question" id="zu-top-add-question">提问</button>
        <div role="search" id="zh-top-search" class="zu-top-search">
            <form method="GET" action="https://nowcoder.com/search" id="zh-top-search-form" class="zu-top-search-form">
                <input type="hidden" name="type" value="content">
                <label for="q" class="hide-text">牛客搜索</label><input type="text" class="zu-top-search-input" id="q"
                                                                    name="q" autocomplete="off" value=""
                                                                    placeholder="搜索你感兴趣的内容..." role="combobox"
                                                                    aria-autocomplete="list">
                <button type="submit" class="zu-top-search-button"><span class="hide-text">搜索</span><span
                            class="sprite-global-icon-magnifier-dark"></span></button>
            </form>
        </div>
        <div id="zg-top-nav" class="zu-top-nav">
            <ul class="zu-top-nav-ul zg-clear">
                <li class="zu-top-nav-li current" id="zh-top-nav-home">
                    <a class="zu-top-nav-link" href="https://nowcoder.com/" id="zh-top-link-home" data-za-c="view_home"
                       data-za-a="visit_home" data-za-l="top_navigation_home">首页</a>
                </li>
                <li class="zu-top-nav-li " id="zh-top-nav-explore">
                    <a class="zu-top-nav-link" href="https://nowcoder.com/explore">发现</a>
                </li>
                <li class="top-nav-noti zu-top-nav-li ">
                    <a class="zu-top-nav-link" href="javascript:;" id="zh-top-nav-count-wrap" role="button"><span
                                class="mobi-arrow"></span>消息<span id="zh-top-nav-count"
                                                                  class="zu-top-nav-count zg-noti-number"
                                                                  style="display: none;">0</span></a>
                </li>
            </ul>
            <div class="zu-top-nav-live zu-noti7-popup zg-r5px no-hovercard" id="zh-top-nav-live-new" role="popup"
                 tabindex="0">
                <div class="zu-top-nav-live-inner zg-r5px">
                    <div class="zu-top-live-icon">&nbsp;</div>
                    <div class="zu-home-noti-inner" id="zh-top-nav-live-new-inner">
                        <div class="zm-noti7-popup-tab-container clearfix" tabindex="0" role="tablist">
                            <button class="zm-noti7-popup-tab-item message" role="tab">
                                <span class="icon">消息</span>
                            </button>
                            <button class="zm-noti7-popup-tab-item user" role="tab">
                                <span class="icon">用户</span>
                            </button>
                            <button class="zm-noti7-popup-tab-item thanks" role="tab">
                                <span class="icon">赞同和感谢</span>
                            </button>
                        </div>
                    </div>
                    <div class="zm-noti7-frame-border top"></div>
                    <div class="zm-noti7-frame">
                        <div class="zm-noti7-content message zh-scroller" style="position: relative; overflow: hidden;">
                            <div class="zh-scroller-inner" style="height: 100%; width: 150%; overflow: auto;">
                                <div class="zh-scroller-content"
                                     style="position: static; display: block; visibility: visible; overflow: hidden; width: 315px; min-height: 100%;">
                                    <div class="zm-noti7-content-inner">
                                        <div class="zm-noti7-content-body">
                                            <div class="zm-noti7-popup-loading">
                                                <span class="noti-spinner-loading"></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="zh-scroller-bar-container"
                                 style="position: absolute; right: 1px; top: 0px; height: 98px; width: 6px; border: 1px solid rgb(68, 68, 68); opacity: 0; cursor: default; border-radius: 2px; -webkit-user-select: none; background: rgb(102, 102, 102);">
                                <div style="-webkit-user-select: none;"></div>
                            </div>
                            <div class="zh-scroller-bar"
                                 style="position: absolute; right: 2px; top: 2px; opacity: 0.5; width: 6px; border-radius: 3px; cursor: default; -webkit-user-select: none; display: none; background: rgb(0, 0, 0);"></div>
                        </div>
                        <div class="zm-noti7-content user zh-scroller"
                             style="display: none; position: relative; overflow: hidden;">
                            <div class="zh-scroller-inner" style="height: 100%; width: 150%; overflow: auto;">
                                <div class="zh-scroller-content"
                                     style="position: static; display: block; visibility: visible; overflow: hidden; width: 315px; min-height: 100%;">
                                    <div class="zm-noti7-content-inner">
                                        <div class="zm-noti7-content-body">
                                            <div class="zm-noti7-popup-loading">
                                                <span class="noti-spinner-loading"></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="zh-scroller-bar-container"
                                 style="position: absolute; right: 1px; top: 0px; height: 98px; width: 6px; border: 1px solid rgb(68, 68, 68); opacity: 0; cursor: default; border-radius: 2px; -webkit-user-select: none; background: rgb(102, 102, 102);">
                                <div style="-webkit-user-select: none;"></div>
                            </div>
                            <div class="zh-scroller-bar"
                                 style="position: absolute; right: 2px; top: 2px; opacity: 0.5; width: 6px; border-radius: 3px; cursor: default; -webkit-user-select: none; display: none; background: rgb(0, 0, 0);"></div>
                        </div>
                        <div class="zm-noti7-content thanks zh-scroller"
                             style="display: none; position: relative; overflow: hidden;">
                            <div class="zh-scroller-inner" style="height: 100%; width: 150%; overflow: auto;">
                                <div class="zh-scroller-content"
                                     style="position: static; display: block; visibility: visible; overflow: hidden; width: 315px; min-height: 100%;">
                                    <div class="zm-noti7-content-inner">
                                        <div class="zm-noti7-content-body">
                                            <div class="zm-noti7-popup-loading">
                                                <span class="noti-spinner-loading"></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="zh-scroller-bar-container"
                                 style="position: absolute; right: 1px; top: 0px; height: 98px; width: 6px; border: 1px solid rgb(68, 68, 68); opacity: 0; cursor: default; border-radius: 2px; -webkit-user-select: none; background: rgb(102, 102, 102);">
                                <div style="-webkit-user-select: none;"></div>
                            </div>
                            <div class="zh-scroller-bar"
                                 style="position: absolute; right: 2px; top: 2px; opacity: 0.5; width: 6px; border-radius: 3px; cursor: default; -webkit-user-select: none; display: none; background: rgb(0, 0, 0);"></div>
                        </div>
                    </div>
                    <div class="zm-noti7-frame-border bottom"></div>
                    <div class="zm-noti7-popup-footer">
                        <a href="https://nowcoder.com/notifications" class="zm-noti7-popup-footer-all zg-right">查看全部
                            »</a>
                        <a href="https://nowcoder.com/settings/notification" class="zm-noti7-popup-footer-set"
                           title="通知设置"><i class="zg-icon zg-icon-settings"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="zu-global-notify" id="zh-global-message" style="display:none">
    <div class="zg-wrap">
        <div class="zu-global-nitify-inner">
            <a class="zu-global-notify-close" href="javascript:;" title="关闭" name="close">x</a>
            <span class="zu-global-notify-icon"></span>
            <span class="zu-global-notify-msg"></span>
        </div>
    </div>
</div>
