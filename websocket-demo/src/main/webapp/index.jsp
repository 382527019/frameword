<%@ page import="top.hygyxx.websocketdemo.HelloServlet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>WebSocket Example</title>
    <script>
        // 创建WebSocket对象并连接到服务器
        var socket = new WebSocket("ws://localhost:8080/ws");

        // 当WebSocket打开时执行此函数
        socket.onopen = function (event) {
            console.log("WebSocket opened");
            // 发送一条消息到服务器
            socket.send("Hello, Server!");
        };

        // 当WebSocket接收到消息时执行此函数
        socket.onmessage = function (event) {
            console.log("receive：" + event.data);
            // 将接收到的消息显示在页面上
            document.getElementById("receive").innerHTML += "<p>" + event.data + "</p>";
        };

        // 当WebSocket发生错误时执行此函数
        socket.onerror = function (event) {
            console.log("WebSocket event：" + event);
        };

        // 当WebSocket关闭时执行此函数
        socket.onclose = function (event) {
            console.log("WebSocket coled");
        };

        // 发送消息到服务器
        function sendMessage() {
            var message = document.getElementById("message").value;
            socket.send(message);
            console.log("send msg：" + message);
            document.getElementById("message").value = "";
        }
    </script>
</head>
<body>
<h3>WebSocket Example</h3>
<p>send msg to service：</p>
<input type="text" id="message" placeholder="input msg">
<button onclick="sendMessage()">send</button>
<hr>
<p>receive msg form service：</p>
<div id="receive"></div>
</body>
</html>