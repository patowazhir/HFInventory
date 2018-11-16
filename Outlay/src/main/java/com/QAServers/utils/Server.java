package com.QAServers.utils;
import java.io.Serializable;

public class Server implements Serializable 
{
    private static final long serialVersionUID = -1280037900360314186L;
    private String name,host,state,notes,os,purpose,version,owner,sqlVer,ewaLink,type,visible;
    
	public Server() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Server(String name, String host, String state, String notes, String os, String purpose, String version,
			String owner, String sqlVer, String ewaLink, String type, String visible) {
		super();
		this.name = name;
		this.host = host;
		this.state = state;
		this.notes = notes;
		this.os = os;
		this.purpose = purpose;
		this.version = version;
		this.owner = owner;
		this.sqlVer = sqlVer;
		this.ewaLink = ewaLink;
		this.type = type;
		this.visible = visible;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSqlVer() {
		return sqlVer;
	}

	public void setSqlVer(String sqlVer) {
		this.sqlVer = sqlVer;
	}

	public String getEwaLink() {
		return ewaLink;
	}

	public void setEwaLink(String ewaLink) {
		this.ewaLink = ewaLink;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ewaLink == null) ? 0 : ewaLink.hashCode());
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((os == null) ? 0 : os.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + ((sqlVer == null) ? 0 : sqlVer.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		result = prime * result + ((visible == null) ? 0 : visible.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		if (ewaLink == null) {
			if (other.ewaLink != null)
				return false;
		} else if (!ewaLink.equals(other.ewaLink))
			return false;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (sqlVer == null) {
			if (other.sqlVer != null)
				return false;
		} else if (!sqlVer.equals(other.sqlVer))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		if (visible == null) {
			if (other.visible != null)
				return false;
		} else if (!visible.equals(other.visible))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Server [name=" + name + ", host=" + host + ", state=" + state + ", notes=" + notes + ", os=" + os
				+ ", purpose=" + purpose + ", version=" + version + ", owner=" + owner + ", sqlVer=" + sqlVer
				+ ", ewaLink=" + ewaLink + ", type=" + type + ", visible=" + visible + "]";
	}
	
	
	
}