package me.halotu.api.user;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import me.halotu.api.JWebToken;
import me.halotu.model.UserModel;
import me.halotu.service.impl.UserService;


@WebServlet(urlPatterns = { "/api/test/*" })
public class TestAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();
	Gson gson = new Gson();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestUrl = request.getRequestURI();
		String[] pathParts = requestUrl.split("/");
		Long id = Long.parseLong(pathParts[4]);
		
		UserModel user = new UserModel();
		JsonObject json = new JsonObject();	
		
		String token = request.getHeader("token");
//		System.out.println("recived: " + token);

		// create token
//    	String testToken = JWebToken.createJWT("12", "vantu7849", "me.halotu", 0);
//    	System.out.println(testToken);
//    	String json = gson.toJson(staff); //object to json: important!
		
		user = userService.findOne(id);	
		String data = gson.toJson(user);

		//check token 
		if (JWebToken.checkToken(token)) {
			json.addProperty("message", "welcome");
			json.addProperty("status", "succeeded");
			json.addProperty("data", data);
		} else {
			json.addProperty("message", "token is invalid or null, please check again");
			json.addProperty("status", "failed");
			json.add("data", null);
		}

		//response Json to client
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(json.toString());
		out.flush();
	}

}
