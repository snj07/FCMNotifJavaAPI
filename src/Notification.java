import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Notification {

	private HashMap<String, Object> data_params;
	private HashMap<String, Object> notification_params;
	private ArrayList<String> user_token;
	private final String PARAM_TITLE = "title";
	private final String PARAM_TO = "registration_ids";
	private final String PARAM_BODY = "body";
	private final String PARAM_ICON = "icon";
	private final String PARAM_SOUND = "sound";
	private final String PARAM_TAG = "tag";
	private final String PARAM_COLOR = "color";
	private final String PARAM_CLICK_ACTION = "click_action";
	private final String PARAM_BODY_LOC_KEY = "body_loc_key";
	private final String PARAM_TITLE_LOC_KEY = "title_loc_key";

	public Notification() {
		data_params = new HashMap<>();
		user_token = new ArrayList<>();
		notification_params = new HashMap<>();
	}

	public String toJsonString() {
		JSONObject json = new JSONObject();

		JSONArray jsonArray = new JSONArray();
		jsonArray.addAll(user_token);
		json.put("registration_ids", jsonArray);
		if (notification_params.size() > 0) {
			JSONObject jsonNotif = new JSONObject();
			jsonNotif.putAll(notification_params);
			json.put("notification", jsonNotif);
		}
		if (data_params.size() > 0) {
			JSONObject jsonData = new JSONObject();
			jsonData.putAll(data_params);
			json.put("data", jsonData);
		}

		return json.toString();
	}

	public Notification addDeviceToSend(String token) {
		user_token.add(token);
		return this;
	}

	public List<String> getDeviceListToSend() {
		return user_token;
	}

	public Notification addDataAttribute(String param, String value) {
		data_params.put(param, value);
		return this;
	}

	public Notification addNotificationAttribute(String param, String value) {
		notification_params.put(param, value);
		return this;
	}

	public Notification removeNotificationAttribute(String param) {
		notification_params.remove(param);
		return this;
	}

	public Notification setTitle(String title) {
		notification_params.put(PARAM_TITLE, title);
		return this;
	}

	public Notification setMessageBody(String msg) {
		notification_params.put(PARAM_BODY, msg);
		return this;
	}

	public Notification setIconUrl(String icon_url) {
		notification_params.put(PARAM_ICON, icon_url);
		return this;
	}

	public Notification setClickAction(String click_action) {
		notification_params.put(PARAM_CLICK_ACTION, click_action);
		return this;
	}

}
