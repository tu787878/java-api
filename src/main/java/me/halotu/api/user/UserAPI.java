package me.halotu.api.user;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import me.halotu.service.impl.UserService;

@WebServlet(urlPatterns = { "/api/1.0/user/*" })
public class UserAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();
	Gson gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestUrl = request.getRequestURI();
		String[] pathParts = requestUrl.split("/");
		String test = pathParts[5];

		switch (test) {
		case "detail":
			UserHandle.getUserById(request, response);
			break;
		case "details":
			UserHandle.getAllUser(request, response);
			break;
		case "delete":
			UserHandle.deleteUserById(request, response);
			break;
		default:
			UserHandle.noTypeOfApi(request, response);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestUrl = request.getRequestURI();
		String[] pathParts = requestUrl.split("/");
		String test = pathParts[5];

		switch (test) {
		case "add":
			UserHandle.addUser(request, response);
			break;
		case "edit":
			UserHandle.editUser(request, response);
			break;
		default:
			UserHandle.noTypeOfApi(request, response);
			break;
		}
	}

}
