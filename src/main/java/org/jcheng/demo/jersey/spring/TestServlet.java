package jcheng.demo.jersey.spring;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = false, name = "HelloAnnotationServlet", urlPatterns = {"/testServlet"},
initParams = {@WebInitParam(name="param1", value="value1"), @WebInitParam(name="param2", value="value2")}
)
public class TestServlet extends HttpServlet {

	public TestServlet() {
		System.out.println("hi");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("hello world");
	}
}