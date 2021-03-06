package com.library.app.common.model;

public enum HttpCode {
	CREATED(201);

	private int code;

	private HttpCode(final int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}