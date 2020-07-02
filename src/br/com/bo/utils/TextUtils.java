package br.com.bo.utils;

public class TextUtils {
	
	static public boolean isBlank(String texto) {
		return (texto == null || texto.isBlank() || texto.isEmpty());
	}
}
