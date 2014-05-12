package org.siwoz.model;

import java.util.HashMap;
import java.util.Map;

public enum MyUserType {

	OWNER("Właściciel", "1"), EMPLOYEE("Pracownik", "2"), PATIENT("Pacjent",
			"3");

	private String plName;
	private String id;

	private MyUserType(String plName, String id) {
		this.plName = plName;
		this.id = id;
	}

	public String getName() {
		return plName;
	}

	public String getId() {
		return id;
	}

	public static Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		for (MyUserType userType : values()) {
			map.put(userType.getId(), userType.getName());
		}
		return map;
	}
}
