package me.halotu.model;

import org.json.JSONException;
import org.json.JSONObject;

public class UserModel {
	private Long id;
	private String username;
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JSONObject toJSON() throws JSONException {
		JSONObject jo = new JSONObject();
		jo.put("id", this.id);
		try {
			jo.put("username", this.username);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jo;
	}
}
