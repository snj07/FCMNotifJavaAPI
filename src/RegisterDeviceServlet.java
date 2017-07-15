import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dbase.DbOperation;

@WebServlet("/registerDevice")
public class RegisterDeviceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RegisterDeviceServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("GET not supported ").append(request.getContextPath());
	}

	// register a device to server
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject json = new JSONObject();
		System.out.println("post..");
		DbOperation dbOperation = new DbOperation();
		String email = request.getParameter("email");
		String token = request.getParameter("token");
		if (email != null && token != null) {
			int flag = dbOperation.registerDevice(email, token);
			if (flag == 1) {
				json.put("info", "success");
			} else {
				json.put("info", "fail");
			}
		} else {
			json.put("info", "fail");
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}
}
