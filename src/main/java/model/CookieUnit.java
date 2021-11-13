package model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUnit {
	public static String get(String name, HttpServletRequest request)
	{
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie item : cookies) {
				if(item.getName().equalsIgnoreCase(name)) {
					return item.getValue();
				}
			}
		}
		return "";
	}
	public static Cookie add(String name, String value, int hours, HttpServletResponse response) {
		Cookie cook = new Cookie(name,value);
		cook.setMaxAge(60*60*hours);
		cook.setPath("/");
		response.addCookie(cook);
		return cook;
	}
	public static void eraseCookie(HttpServletRequest request, HttpServletResponse response) {
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null)
	        for (Cookie cookie : cookies) {
	            cookie.setValue("");
	            cookie.setPath("/");
	            cookie.setMaxAge(0);
	            response.addCookie(cookie);
	        }
	}
}
