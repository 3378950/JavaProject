package test;

import java.sql.Date;
import java.util.List;

import entity.coach;
import entity.player;
import entity.team;
import utils.DBUtils;

public class test {

	public static <E>void main(String[] args) {
		// TODO Auto-generated method stub
//		List<coach> coachList = DBUtils.findAll(coach.class);
//		for (coach coaches : coachList) {
//			System.out.println(coaches);
//		}
//		
//		List<player> res = DBUtils.findByTeam("��������");
//		for (player players : res) {
//			System.out.println(players);
//		}
//		
//		List<player> res = DBUtils.findByPersonId("1234567840117");
//		for (player players : res) {
//			System.out.println(players);
//		}
//		List<coach> res = DBUtils.findByCoachId(1213);
//		for (coach teams : res) {
//			System.out.println(teams);
//		}
		java.sql.Date sqlDate = java.sql.Date.valueOf("1978-11-12"); 
//		DBUtils.addCoach("С��", "65666", sqlDate, "2211", "C", "���������");
//		List<coach> coachinfo = DBUtils.findCoach("���������");
//		for (coach coachs : coachinfo) {
//			System.out.println(coachs);
//		}
		player e = new player("С��", "123", sqlDate, 163, "����", "�������");
//		System.out.println(e.values());
//		DBUtils.save(e);
		
//		DBUtils.update(e, "height", "162");
		DBUtils.delete(e, "birthDate", sqlDate);
	}

}
