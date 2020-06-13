package entity;

import java.util.Date;
import java.util.List;

public class team {
	private String teamName;
	private String address;
	private String id;
	private Date setUp;
	private Integer peopleCounting;
	
	public team() {
		super();
	}

	public team(String teamName, String address, String id, Date setUp, Integer peopleCounting) {
		super();
		this.teamName = teamName;
		this.address = address;
		this.id = id;
		this.setUp = setUp;
		this.peopleCounting = peopleCounting;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getSetUp() {
		return setUp;
	}

	public void setSetUp(Date setUp) {
		this.setUp = setUp;
	}

	public Integer getPeopleCounting() {
		return peopleCounting;
	}

	public void setPeopleCounting(Integer peopleCounting) {
		this.peopleCounting = peopleCounting;
	}

	@Override
	public String toString() {
		return "team [teamName=" + teamName + ", address=" + address + ", id=" + id + ", setUp=" + setUp
				+ ", peopleCounting=" + peopleCounting + "]";
	}
	
	public String values() {
		return " values('" + teamName + "','" + address + "','" + id + "','" + setUp + "'," + peopleCounting + ");";
	}
	
	
}
