package app.launcher;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by daijitao on 2018/10/25.
 */
public class AppServer {
    public static void main(String[] args) throws Exception {
        AppServer server = new AppServer();
        server.start();
    }
    private void start() throws Exception{
        Server server = new Server(8080); // 监听8282端口
        ServletHolder servlet = new ServletHolder(ServletContainer.class);
        // 设置初始化参数
        servlet.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
        servlet.setInitParameter("com.sun.jersey.config.property.packages", "rest.api"); //换成自己的包名
        servlet.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true"); // 自动将对象映射成json返回
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        handler.addServlet(servlet, "/*"); server.setHandler(handler);
        server.start();
        System.out.println("start...in 8282");
    }
}
