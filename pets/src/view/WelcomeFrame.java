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
 * ��ӭ����
 */
@SuppressWarnings("serial")
public class WelcomeFrame extends JFrame{
	private JButton btn = new JButton("�����̵�");
	private JLabel titleLabel = new JLabel(new ImageIcon("pet.jpg"));
	
	//���췽��
	public WelcomeFrame() {
		this.init();                 //��ʼ��
		this.addComponent();         //������
		this.addListener();          //��Ӽ�����
	}	
	//���ڳ�ʼ��
	private void init() {
		this.setTitle("��ӭ���ٳ����̵꣡");
		this.setSize(500,600);
		GUITools.center(this);    //���ھ���
		GUITools.setTitleImage(this,"title.jpg");  // ��ʾ����ͼ��
		this.setResizable(false);   //�����С�̶�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	//������
	private void addComponent() {
		this.add(this.titleLabel,BorderLayout.NORTH);
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(null);  // ���JPanel�Ĳ���
		this.add(btnPanel);
		btn.setBounds(200,2,100,50);   //���尴ť�߽�λ��
		btnPanel.add(btn,BorderLayout.CENTER);		
	}
	//��Ӽ�����
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

	//������½�������
	private JFrame frame;
	private JPanel panel;
	private JLabel userName;
	private JTextField userNameFrame;
	private JLabel userPassword;
	private JPasswordField userPasswordFrame;
	private JButton SignUp;
	private JButton SignIn;

	//ע�����
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
		
		//ʵ�������
		frame = new JFrame("��ӭ���ٳ����̵�");
		panel = new JPanel();
		userName = new JLabel("�û���:");
		userNameFrame = new JTextField();
		userPassword = new JLabel("����:");
		userPasswordFrame = new JPasswordField();
		SignUp = new JButton("ע��");
		SignIn = new JButton("��¼");
		
		dialog = new JDialog(frame,"ע��",true);
		alert = new JPanel();
		
		son_userName = new JLabel("�û���:");
		son_userNameFrame = new JTextField();
		son_userPassword = new JLabel("��   ��:");
		son_userPasswordFrame = new JPasswordField();
		son_SignUp = new JButton("ע��");
	}
	
	public void display() throws HeadlessException{
		//�����������ʾ
		Toolkit kit = Toolkit.getDefaultToolkit();
		frame.setIconImage(kit.createImage("title.jpg"));
		frame.setSize(350, 180);//���úÿ��
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
		
		dialog.setSize(400, 200);//���úÿ��
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
		//Ϊ�����Ӽ�����
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		SignIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO �Զ����ɵķ������
				int flag = 0;
				try {
					flag = adminService.signInRun(flag,userNameFrame.getText(),String.valueOf(userPasswordFrame.getPassword()));
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO �Զ����ɵ� catch ��
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
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
						
					}else {
						Subscriber sub = new Subscriber(userNameFrame.getText());
						try {
							
							sub.display();
							
						} catch (Exception e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
						sub.listener();
						frame.dispose();
					}
				}else if(flag == 2){
//					userNameFrame.setText("������󣡣�");
					JOptionPane.showMessageDialog(frame, "�������");
					userPasswordFrame.setText("");
				} else {
					JOptionPane.showMessageDialog(frame, "�û������ڣ�");
					userPasswordFrame.setText("");
				}
				
			}
			
	});
		
		SignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
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
				// TODO �Զ����ɵķ������
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
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
					JOptionPane.showMessageDialog(dialog, "�û����ظ���");
				}
				
				son_userPasswordFrame.setText("");
				
			}
			
		});
	}
	
}

