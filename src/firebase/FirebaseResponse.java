package firebase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class FirebaseResponse {

	private HttpURLConnection httpURLConnection;

	public FirebaseResponse(HttpURLConnection httpURLConnection) {
		this.httpURLConnection = httpURLConnection;
	}

	public int getFCMResponseCode() {
		try {
			return httpURLConnection.getResponseCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public String getErrorMessage() {
		return readInputStream(httpURLConnection.getErrorStream());
	}

	public String getSuccessMessage() {
		try {
			return readInputStream(httpURLConnection.getInputStream());
		} catch (IOException e) {

			e.printStackTrace();
		}
		return "Error in Reading InputStream";
	}

	public String readInputStream(InputStream inputStream) {
		if (inputStream == null)
			return new String(" ");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder s = new StringBuilder();
		String line = null;
		try {
			while ((line = bufferedReader.readLine()) != null) {
				s.append(line);
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s.toString();
	}

}
