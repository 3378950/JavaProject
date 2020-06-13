package dto;

import java.util.List;

import entity.coach;
import entity.player;
import entity.team;

public class teamInfo {
	private team teambasic;
	private List<player> playerList;
	private List<coach> coachList;
	public teamInfo() {
		super();
	}
	public teamInfo(team teambasic, List<player> playerList, List<coach> coachList) {
		super();
		this.teambasic = teambasic;
		this.playerList = playerList;
		this.coachList = coachList;
	}
	public team getTeambasic() {
		return teambasic;
	}
	public void setTeambasic(team teambasic) {
		this.teambasic = teambasic;
	}
	public List<player> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(List<player> playerList) {
		this.playerList = playerList;
	}
	public List<coach> getCoachList() {
		return coachList;
	}
	public void setCoachList(List<coach> coachList) {
		this.coachList = coachList;
	}
	@Override
	public String toString() {
		return "teamInfo [teambasic=" + teambasic + ", playerList=" + playerList + ", coachList=" + coachList + "]";
	}
	
}
