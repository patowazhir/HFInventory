package com.hfinventory.utils;

public class Server {
	protected String name,
    host,
    state,
    notes,
    os,
    purpose,
    version,
    owner,
    sqlVer,
    type;

	protected Float size;
	protected Boolean powered;
	
	public Server(String name, String host, String state) {
		this.name = name;
		this.host = host;
		this.state = state;
	}
}
