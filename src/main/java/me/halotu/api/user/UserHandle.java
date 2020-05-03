package me.halotu.api.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import me.halotu.mapper.StandardResponse;
import me.halotu.model.UserModel;
import me.halotu.service.impl.UserService;

public class UserHandle {
	
	
	public static void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UserModel userModel = new Gson().fromJson(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())), UserModel.class);
		UserService userService = new UserService();
		
		UserModel user2 = userService.addUser(userModel);
		if(user2!=null) {
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(new Gson()
					    .toJsonTree(new StandardResponse("success",new Gson()
							    .toJsonTree(user2))));
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(new Gson()
					    .toJsonTree(new StandardResponse("failed", "user ist exits or error while insert")));
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void editUser(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, IOException {
		UserService userService = new UserService();
		UserModel userModel = new Gson().fromJson(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())), UserModel.class);
		
		UserModel user2 = userService.update(userModel);
		
		if(user2 != null) {
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(new Gson()
					    .toJsonTree(new StandardResponse("success", new Gson()
							    .toJsonTree(user2))));
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(new Gson()
					    .toJsonTree(new StandardResponse("fail", "fail to update user")));
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void getUserById(HttpServletRequest request, HttpServletResponse response) {
		UserService userService = new UserService();
		String requestUrl = request.getRequestURI();
		String[] pathParts = requestUrl.split("/");
		Long id = Long.parseLong(pathParts[6]);
		
		UserModel userData = userService.findOne(id);
		
		if(userData != null) {
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(new Gson()
					    .toJsonTree(new StandardResponse("success", new Gson()
							    .toJsonTree(userData))));
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(new Gson()
					    .toJsonTree(new StandardResponse("fail", "cannot get user by this id")));
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void getAllUser(HttpServletRequest request, HttpServletResponse response) {
		UserService userService = new UserService();
		List<UserModel> users = userService.getUsers();
		
		if(users!=null) {
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(new Gson()
					    .toJsonTree(new StandardResponse("success", 
					    		new Gson().toJsonTree(users)
					    		)));
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(new Gson()
					    .toJsonTree(new StandardResponse("fail", "cannot get all users")));
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void noTypeOfApi(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(new Gson()
				    .toJsonTree(new StandardResponse("fail", "Api invaild")));
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteUserById(HttpServletRequest request, HttpServletResponse response) {
	}

}
