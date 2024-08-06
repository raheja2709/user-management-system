package com.demo.user.mng.sys.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiPathConstants {

	public static final String API_V1 = "/api/v1";

	public static final String AUTH = API_V1 + "/auth";

	public static final String USER = API_V1 + "/user";

	public static final String ADMIN  = API_V1 + "/admin";

	public static final String LOGIN = "/login";

	public static final String LOGOUT = "/logout";

	public static final String REGISTER = "/register";

}
