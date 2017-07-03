import dbase.*;
import firebase.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendFirebaseNotifServlet
 */
@WebServlet("/SendFirebaseNotifServlet")
public class SendFirebaseNotifServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendFirebaseNotifServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Only post supported ").append(request.getContextPath());
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Notification notification = new Notification();
		DbOperation dbOperation = new DbOperation();
		List<String> list = dbOperation.getAllTokens();
		for (String s : list)
			notification.addDeviceToSend(s);
		notification.setTitle(request.getParameter("title"));
		notification.setMessageBody(request.getParameter("message"));
//		notification.addDataAttribute("image", "https://i.ytimg.com/vi/d_T5P-zIIAs/maxresdefault.jpg");
		notification.addDataAttribute("image", request.getParameter("image"));  // custom data payload

		FirebaseResponse fr = new PushNotifHelper().sendNotificationToSingleDevice(notification);
		System.out.println(fr.getErrorMessage());
		System.out.println(fr.getFCMResponseCode());
		System.out.println(fr.getSuccessMessage());
	}

	
}
