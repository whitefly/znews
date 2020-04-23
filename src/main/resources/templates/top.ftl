<div class="zu-top">
    <div class="zg-wrap clearfix" id="zh-top-inner">
        <a href="https://nowcoder.com/" class="zu-top-link-logo" id="zh-top-link-logo">牛客</a>
        <#if user??>
        <div class="top-nav-profile">
            <a href="#" class="zu-top-nav-userinfo">
                <span class="name">${user.name}</span>
                <img class="Avatar" src="../images/res/${user.headUrl}" alt="牛客">
            </a>
            <ul class="top-nav-dropdown" id="top-nav-profile-dropdown">
                <li>
                    <a href="/user/${(user.id)!"-1"}" tabindex="-1">
                        <i class="zg-icon zg-icon-dd-home"></i>我的主页
                    </a>
                </li>

                <li>
                    <a href="/followees" tabindex="-1">
                        <i class="zg-icon zg-icon-dd-home"></i>关注
                    </a>
                </li>

                <li>
                    <a href="/followers" tabindex="-1">
                        <i class="zg-icon zg-icon-dd-home"></i>粉丝
                    </a>
                </li>

                <li>
                    <a href="/message/list">
                        <i class="zg-icon zg-icon-dd-pm"></i>私信
                    </a>
                </li>
                <li>
                    <a href="https://nowcoder.com/settings">
                        <i class="zg-icon zg-icon-dd-settings"></i>设置
                    </a>
                </li>
                <li>
                    <a href="/logout">
                        <i class="zg-icon zg-icon-dd-logout"></i>退出
                    </a>
                </li>
            </ul>
        </div>
        <#else>
            <script>
                function jump() {
                    window.location.href="/loginPage?next="+window.location.pathname
                }
            </script>
            <a class="name" href="javascript:void(0)" onclick="jump()">登录/注册</a>
        </#if>
        <button class="zu-top-add-question" id="zu-top-add-question">提问</button>
        <div role="search" id="zh-top-search" class="zu-top-search">
            <form method="GET" action="https://nowcoder.com/search" id="zh-top-search-form" class="zu-top-search-form">
                <input type="hidden" name="type" value="content">
                <label for="q" class="hide-text">牛客搜索</label><input type="text" class="zu-top-search-input" id="q" name="q" autocomplete="off" value="" placeholder="搜索你感兴趣的内容...">
                <button type="submit" class="zu-top-search-button">
                    <span class="hide-text">搜索</span>
                    <span class="sprite-global-icon-magnifier-dark"></span>
                </button>
            </form>
        </div>
        <div id="zg-top-nav" class="zu-top-nav">
            <ul class="zu-top-nav-ul zg-clear">
                <li class="zu-top-nav-li current" id="zh-top-nav-home">
                    <a class="zu-top-nav-link" href="/" id="zh-top-link-home">首页</a>
                </li>
                <li class="zu-top-nav-li " id="zh-top-nav-explore">
                    <a class="zu-top-nav-link" href="https://nowcoder.com/explore">发现</a>
                </li>
                <li class="top-nav-noti zu-top-nav-li ">
                    <a class="zu-top-nav-link" href="/message/list" id="zh-top-nav-count-wrap" role="button">
                        <span class="mobi-arrow"></span>消息
                        <span id="zh-top-nav-count" class="zu-top-nav-count zg-noti-number" style="display: none;">0</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>