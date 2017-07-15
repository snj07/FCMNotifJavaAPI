import dbase.*;
import firebase.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SendFirebaseNotifServlet")
public class SendFirebaseNotifServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public SendFirebaseNotifServlet() {
		super();
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Only post supported ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Notification notification = new Notification();
		DbOperation dbOperation = new DbOperation();
		if (request.getParameter("push_type").equals("all")) {
			List<String> list = dbOperation.getAllTokens();
			for (String token : list)
				notification.addDeviceToSend(token);
		}else {
			String token = dbOperation.getTokenByEmail(request.getParameter("regId"));
			notification.addDeviceToSend(token);
		}
		notification.setTitle(request.getParameter("title"));
		notification.setMessageBody(request.getParameter("message"));
	
		notification.addDataAttribute("image", request.getParameter("image")); // custom data payload

		FirebaseResponse fr = new PushNotifHelper().sendNotificationToDevice(notification);
		System.out.println(fr.getErrorMessage());
		System.out.println(fr.getFCMResponseCode());
		System.out.println(fr.getSuccessMessage());
		response.getWriter().append("Notification sent!!!").append(request.getContextPath());
	}

}
