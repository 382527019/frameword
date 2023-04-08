package top.hygyxx.websocketdemo;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet") public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            stringBuilder.append(stringEntry.getKey()).append("=").append(Arrays.toString(stringEntry.getValue()));
        }
        message = stringBuilder.toString();
        //websocket收到消息
        WebSocketServer.broadcast(message);
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}