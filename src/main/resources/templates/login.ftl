<!DOCTYPE html>
<html lang="zh-CN" class="is-AppPromotionBarVisible cssanimations csstransforms csstransitions flexbox no-touchevents no-mobile">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="apple-itunes-app" content="app-id=432274380">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="description" content="一个真实的网络问答社区，帮助你寻找答案，分享知识。">
    <meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title>牛客 - 与世界分享你的知识、经验和见解</title>
    <link rel="dns-prefetch" href="">
    <link rel="stylesheet" href="/styles/login.css">
</head>
<body class="zhi  no-auth">
    <div class="index-main">
        <div class="index-main-body">
            <div class="index-header">
                <h1 class="logo hide-text"><img src="../images/res/nk.png" alt=""></h1>
                <h2 class="subtitle">与世界分享你的知识、经验和见解</h2>
            </div>
            <div class="desk-front sign-flow clearfix sign-flow-simple">
                <div class="view view-signin" data-za-module="SignInForm" style="display: block;">
                    <form novalidate="novalidate" id="myForm" method="post">
                        <div class="group-inputs">
                            <div class="email input-wrapper">
                                <input type="text" name="account" aria-label="手机号或邮箱" placeholder="手机号或邮箱" required="">
                            </div>
                            <div class="input-wrapper">
                                <input type="password" name="password" aria-label="密码" placeholder="密码" required="">
                            </div>
                            <input type="hidden" name="next" value="${next!""}">
                            <div class="input-wrapper captcha-module" data-type="en">
                                <input id="captcha" name="" placeholder="验证码" required="" data-rule-required="true" data-msg-required="请填写验证码" class="is-ignoreValidation">
                                <div class="captcha-container">
                                    <img class="js-refreshCaptcha captcha" width="120" height="30" data-tip="s$t$看不清楚？换一张" alt="验证码">
                                </div>
                            </div>
                        </div>
                        <script>
                            function login() {
                                myForm = document.getElementById("myForm");
                                myForm.action = '/login';
                                myForm.submit();
                            }
                            function register() {
                                myForm = document.getElementById("myForm");
                                myForm.action = '/register';
                                myForm.submit();
                            }
                        </script>
                        <div class="button-wrapper command clearfix">
                            <button class="sign-button submit" type="submit" onclick="login()">登录</button>
                            <button class="sign-button submit" type="submit" onclick="register()">注册</button>
                        </div>

                        <div class="signin-misc-wrapper clearfix">
                            <label class="remember-me">
                                <input type="checkbox" name="remember_me" checked="" value="true"> 记住我
                            </label>
                            <a class="unable-login" href="#">无法登录?</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>