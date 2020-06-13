package entity;

import java.util.Date;

public class coach {
	private String name;
	private String personId;
	private Date birthDate;
	private String certificate;
	private String level;
	private String teamName;
	public coach() {
		super();
	}
	public coach(String name, String personId, Date birthDate, String certificate, String level, String teamName) {
		super();
		this.name = name;
		this.personId = personId;
		this.birthDate = birthDate;
		this.certificate = certificate;
		this.level = level;
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
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	@Override
	public String toString() {
		return "coach [name=" + name + ", personId=" + personId + ", birthDate=" + birthDate + ", certificate="
				+ certificate + ", level=" + level + ", teamName=" + teamName + "]";
	}
	
	public String values() {
		return "values('" + name + "','" + personId + "','" + birthDate + "','" + certificate + "','" + level + "','" + teamName + "');";
	}
	
	
}
