package view;


import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import server.AdminService;
import tools.GUITools;


/**
 * 欢迎窗口
 */
@SuppressWarnings("serial")
public class WelcomeFrame extends JFrame{
	private JButton btn = new JButton("进入商店");
	private JLabel titleLabel = new JLabel(new ImageIcon("pet.jpg"));
	
	//构造方法
	public WelcomeFrame() {
		this.init();                 //初始化
		this.addComponent();         //添加组件
		this.addListener();          //添加监听器
	}	
	//窗口初始化
	private void init() {
		this.setTitle("欢迎光临宠物商店！");
		this.setSize(500,600);
		GUITools.center(this);    //窗口居中
		GUITools.setTitleImage(this,"title.jpg");  // 显示窗口图标
		this.setResizable(false);   //窗体大小固定
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	//添加组件
	private void addComponent() {
		this.add(this.titleLabel,BorderLayout.NORTH);
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(null);  // 清除JPanel的布局
		this.add(btnPanel);
		btn.setBounds(200,2,100,50);   //定义按钮边界位置
		btnPanel.add(btn,BorderLayout.CENTER);		
	}
	//添加监听器
	private void addListener() {	
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				showAdminDialog();
			}
		});		
	}

	public void showAdminDialog() {
		this.setVisible(false);
		SignInPanel sip = new SignInPanel();
		sip.listener();
		sip.display();
	}
}

class SignInPanel {
	private AdminService adminService;

	//声明登陆面板的组件
	private JFrame frame;
	private JPanel panel;
	private JLabel userName;
	private JTextField userNameFrame;
	private JLabel userPassword;
	private JPasswordField userPasswordFrame;
	private JButton SignUp;
	private JButton SignIn;

	//注册界面
	private JDialog dialog;
	private JPanel alert;
	private JLabel son_userName;
	private JTextField son_userNameFrame;
	private JLabel son_userPassword;
	private JPasswordField son_userPasswordFrame;
	private JButton son_SignUp;

	public SignInPanel() {
		// new PetDao();
		adminService = new AdminService();
		
		//实例化组件
		frame = new JFrame("欢迎光临宠物商店");
		panel = new JPanel();
		userName = new JLabel("用户名:");
		userNameFrame = new JTextField();
		userPassword = new JLabel("密码:");
		userPasswordFrame = new JPasswordField();
		SignUp = new JButton("注册");
		SignIn = new JButton("登录");
		
		dialog = new JDialog(frame,"注册",true);
		alert = new JPanel();
		
		son_userName = new JLabel("用户名:");
		son_userNameFrame = new JTextField();
		son_userPassword = new JLabel("密   码:");
		son_userPasswordFrame = new JPasswordField();
		son_SignUp = new JButton("注册");
	}
	
	public void display() throws HeadlessException{
		//定义组件的显示
		Toolkit kit = Toolkit.getDefaultToolkit();
		frame.setIconImage(kit.createImage("title.jpg"));
		frame.setSize(350, 180);//设置好宽高
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);	
		frame.setLayout(null);
		
		userName.setBounds(0, 20, 100, 20);
		userName.setHorizontalAlignment(JTextField.CENTER);
		
		userNameFrame.setBounds(110,20,220,20);
		
		userPassword.setBounds(0, 50, 100, 20);
		userPassword.setHorizontalAlignment(JTextField.CENTER);
		
		userPasswordFrame.setBounds(110, 50, 220, 20);
		
		SignUp.setBounds(80, 90, 80, 35);
		
		SignIn.setBounds(180,90,80,35);
		
		panel.setLayout(null);
		frame.add(userName);
		frame.add(userNameFrame);
		frame.add(userPassword);
		frame.add(userPasswordFrame);
		frame.add(SignUp);
		frame.add(SignIn);
		frame.setVisible(true);
		
		dialog.setSize(400, 200);//设置好宽高
		dialog.setLocationRelativeTo(null);
		dialog.add(alert);
		
		son_userName.setBounds(0, 20, 100, 20);
		son_userName.setHorizontalAlignment(JTextField.CENTER);
		
		son_userNameFrame.setBounds(110,20,220,20);
		
		son_userPassword.setBounds(0, 50, 100, 20);
		son_userPassword.setHorizontalAlignment(JTextField.CENTER);
		
		son_userPasswordFrame.setBounds(110, 50, 220, 20);
		
		son_SignUp.setBounds(130, 90, 80, 35);
		
		alert.setLayout(null);
		alert.add(son_userName);
		alert.add(son_userNameFrame);
		alert.add(son_userPassword);
		alert.add(son_userPasswordFrame);
		alert.add(son_SignUp);
	}
	
	public void listener() {
		//为组件添加监听器
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		SignIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO 自动生成的方法存根
				int flag = 0;
				try {
					flag = adminService.signInRun(flag,userNameFrame.getText(),String.valueOf(userPasswordFrame.getPassword()));
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				char nameFlag = userNameFrame.getText().charAt(0);
				
				if(flag == 1) {
					if('A' == nameFlag) {
						Administrator ad = new Administrator();
						try {
							ad.display();
							ad.listener();
							frame.dispose();
							
						} catch (Exception e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						
					}else {
						Subscriber sub = new Subscriber(userNameFrame.getText());
						try {
							
							sub.display();
							
						} catch (Exception e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
						sub.listener();
						frame.dispose();
					}
				}else if(flag == 2){
//					userNameFrame.setText("密码错误！！");
					JOptionPane.showMessageDialog(frame, "密码错误！");
					userPasswordFrame.setText("");
				} else {
					JOptionPane.showMessageDialog(frame, "用户不存在！");
					userPasswordFrame.setText("");
				}
				
			}
			
	});
		
		SignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				dialog.setVisible(true);
			}
			
		});
		
		dialog.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent we) {
				son_userNameFrame.setText("");
				son_userPasswordFrame.setText("");
			}
			
		});
		
		son_SignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String name = son_userNameFrame.getText();
				String password = String.valueOf(son_userPasswordFrame.getPassword());
				try {
					if('G' == name.charAt(0)) {
						adminService.signUp(name, password);
						dialog.dispose();
					}else {
						adminService.createUserTable(name,password);
						dialog.dispose();
					}
					
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
					JOptionPane.showMessageDialog(dialog, "用户名重复！");
				}
				
				son_userPasswordFrame.setText("");
				
			}
			
		});
	}
	
}

