package entity;

import java.util.Date;

public class player {
	private String name;
	private String personId;
	private Date birthDate;
	private int height;
	private String address;
	private String teamName;
	public player() {
		super();
	}
	public player(String name, String personId, Date birthDate, int height, String address, String teamName) {
		super();
		this.name = name;
		this.personId = personId;
		this.birthDate = birthDate;
		this.height = height;
		this.address = address;
		this.teamName = teamName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	@Override
	public String toString() {
		return "player [name=" + name + ", personId=" + personId + ", birthDate=" + birthDate + ", height=" + height
				+ ", address=" + address + ", teamName=" + teamName + "]";
	}
	
	public String values() {
		return " values('" + name + "','" + personId + "','" + birthDate + "'," + height + ",'" + address + "','" + teamName + "');";
	}
}
