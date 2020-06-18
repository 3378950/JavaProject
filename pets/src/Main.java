import java.awt.*;

import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

import dao.PetDao;
import server.AdminService;
import view.WelcomeFrame;
public  class Main {
	public  static void main(String[] args) {
		new WelcomeFrame().setVisible(true);
	}
}