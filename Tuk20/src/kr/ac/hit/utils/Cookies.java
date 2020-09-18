package kr.ac.hit.utils;

import java.io.IOException;

import java.net.URLDecoder;

import java.net.URLEncoder;

import java.util.Map;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;

public class Cookies {

	private Map<String, Cookie> cookieMap = new java.util.HashMap<String, Cookie>(); //클래스 전역변수

	public Cookies(HttpServletRequest request) {

		Cookie[] cookies = request.getCookies(); //request에서 쿠키를 얻어와서 쿠키배열에 넣엇다가

		if (cookies != null) { 

			for (int i = 0; i < cookies.length; i++) {

				cookieMap.put(cookies[i].getName(), cookies[i]);

			}

		}

	}

	public Cookie getCookie(String name) {

		return cookieMap.get(name);

	}

	public String getValue(String name) throws IOException {

		Cookie cookie = cookieMap.get(name);

		if (cookie == null) {

			return null;

		}

		return URLDecoder.decode(cookie.getValue(), "utf-8");

	}

	public boolean exists(String name) {

		return cookieMap.get(name) != null;

	}

	public static Cookie createCookie(String name, String value)

			throws IOException {

		return new Cookie(name, URLEncoder.encode(value, "utf-8"));

	}

	public static Cookie createCookie(String name, String value, String path, int maxAge) throws IOException {

		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));

		cookie.setPath(path);

		cookie.setMaxAge(maxAge);

		return cookie;

	}

}