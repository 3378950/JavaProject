package view;
import java.sql.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import server.AdminService;
import vo.UserPetItem;
import vo.petItem;
import tools.FileUtils;

public class Subscriber {
	/**
	 * 66 = 102
	 * cc = 204
	 */
	//��¼��ǰ�û�
	private String userName;
	
	private AdminService adminService;
	
	private JFrame frame; 
	private JPanel upPanel;
	private JPanel downPanel;
	private CardLayout cardLayout;
	private JPanel firstPanel;
	
	private JSplitPane splitPane;
	private JLabel store;
	private JLabel mine;
	private Color onColor;
	private Color offColor;
	private Color bGColor;
	private Color shopColor;
	private Color mineColor;
	private String[] shoptableHead = {"���","����","Ʒ��","�۸�","����"};
	private JScrollPane tablePanel;
	private JTable table;
	
	private JComboBox<String> choose_kind;
	private JComboBox<String> choose_varieties;
	private String[] kinds = {"ȫ��","è","��"};
	private String[] varieties = null;
	
	private JLabel welcome;
	private JLabel tip;
	private JTextField number;
	private JTextField unit;
	private JButton buy;
	
	private JLabel shop_photo;
	private String shop_photoName;
	private ImageIcon shop_background;
	//firstPanel����
	
	//lastPanel��ʼ
	private JPanel lastPanel;
	private JLabel title;
	private String[] userTableHead = {"���","����","Ʒ��","����","�ܼ�"};
	private JScrollPane user_tablePanel;
	private JTable user_table;
	
	
	private JButton exit;
	
	private JLabel mine_photo;
	private String mine_photoName;
	private ImageIcon mine_background;

	
	public Subscriber(String userName) {
		this.userName = userName;
		adminService = new AdminService();
		frame = new JFrame("��ӭ���ٳ����̵�");
		upPanel = new JPanel();
		downPanel = new JPanel();
		cardLayout = new CardLayout();
		onColor = new Color(255,255,255);
		offColor = new Color(204,204,204);
		
		bGColor = new Color(240,240,240);
		shopColor = new Color(255,244,77);
		mineColor = new Color(255,252,189);
		
		store = new JLabel("�̵�");
		mine = new JLabel("�ҵ�");
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,upPanel,downPanel);
		
		
		firstPanel = new JPanel();
		table = new JTable();
		tablePanel = new JScrollPane(table);
		
		
		choose_kind = new JComboBox<String>(kinds);
		choose_varieties = new JComboBox<String>();
		
		welcome = new JLabel("��ã�" + userName + "����ӭ���ٱ��ꡣ");
		tip = new JLabel("����������ź���Ҫ����������");
		number = new JTextField();
		unit = new JTextField();
		buy = new JButton("����");
		
		shop_photoName = "111.png";
		shop_background = new ImageIcon(shop_photoName);
		shop_photo = new JLabel(shop_background);
		
		
		lastPanel = new JPanel();
		title = new JLabel("�����嵥");
		user_table = new JTable();
		user_tablePanel = new JScrollPane(user_table);
		
	
		exit = new JButton("�˳�");
		
		mine_photoName = "22.jpg";
		mine_background = new ImageIcon(mine_photoName);
		mine_photo = new JLabel(mine_background);
	}
	
	public void display() throws Exception {
		Toolkit kit = Toolkit.getDefaultToolkit();
		frame.setIconImage(kit.createImage("timg.jpg"));
		//ͼ�����ý���
		
		//�������ʾ����
		frame.setSize(1000, 590);					//���ÿ��
		frame.setLocationRelativeTo(null);			//������ʾ
		frame.setResizable(false);					//��С���ɵ���
		frame.setLayout(null);
		
		frame.add(splitPane);
		
		splitPane.setBorder(null);
		splitPane.setBounds(10, 10, 968, 535);
		splitPane.setDividerLocation(35);
		splitPane.setDividerSize(0);
		
		upPanel.setLayout(null);
		
		store.setOpaque(true);
		store.setBackground(offColor);
		store.setHorizontalAlignment(JTextField.CENTER);
		store.setBounds(0, 0, 80, 32);
		
		mine.setOpaque(true);
		mine.setBackground(onColor);
		mine.setHorizontalAlignment(JTextField.CENTER);
		mine.setBounds(83, 0, 80, 32);
		upPanel.add(store);
		upPanel.add(mine);
		upPanel.setBackground(bGColor);
		
		downPanel.setLayout(cardLayout);
		downPanel.add(firstPanel);
		downPanel.add(lastPanel);
		
		table.getTableHeader().setReorderingAllowed(false);//�в����ƶ�
		table.getTableHeader().setResizingAllowed(false);//�����������
		table.setEnabled(false);  //���ɸ�������
		table.setBorder(null);
		
		
		showTable();
		
		tablePanel.setBounds(10, 10, 710, 280);
		tablePanel.setBorder(null);
		tablePanel.setBackground(bGColor);
		
	
		choose_kind.setBounds(735, 10, 100, 30);
		choose_varieties.setBounds(850, 10, 100, 30);
		varieties = adminService.queryVarietiesDataOfKind("ȫ��");
		choose_varieties.addItem("è&��");
		for(int i = 0;i < varieties.length;i++) {
			choose_varieties.addItem(varieties[i]);
		}
		
		welcome.setBounds(735, 60, 215, 30);
		welcome.setFont(new Font("Serief",Font.PLAIN,13));
		welcome.setHorizontalAlignment(JTextField.CENTER);
		
		tip.setBounds(735, 90, 215, 30);
		tip.setFont(new Font("Serief",Font.PLAIN,13));
		tip.setHorizontalAlignment(JTextField.CENTER);
		number.setBounds(735, 130, 100, 30);
		unit.setBounds(850, 130, 100, 30);
		buy.setBounds(735, 170, 215, 30);
		
		shop_background.setImage(shop_background.getImage().getScaledInstance(950, 200, Image.SCALE_DEFAULT));
		shop_photo.setBounds(12, 300, 950, 200);//950 290
		
		
		firstPanel.setBackground(shopColor);
		firstPanel.setLayout(null);
		firstPanel.add(tablePanel);
		firstPanel.add(choose_kind);
		firstPanel.add(choose_varieties);
		firstPanel.add(welcome);
		firstPanel.add(tip);
		firstPanel.add(number);
		firstPanel.add(unit);
		firstPanel.add(buy);
		firstPanel.add(shop_photo);
		
		
		title.setBounds(215, 5, 300, 20);
		title.setFont(new Font("Serief",Font.PLAIN,13));
		title.setHorizontalAlignment(JTextField.CENTER);
		
		user_table.getTableHeader().setReorderingAllowed(false);//�в����ƶ�
		user_table.getTableHeader().setResizingAllowed(false);//�����������
		user_table.setEnabled(false);  //���ɸ�������
		user_table.setBorder(null);
		
		showUserTable();
		user_tablePanel.setBounds(10, 30, 710, 280);
		user_tablePanel.setBorder(null);
		user_tablePanel.setBackground(bGColor);
		
		
		exit.setBounds(735, 170, 215, 30);
		
		mine_background.setImage(mine_background.getImage().getScaledInstance(950, 200, Image.SCALE_DEFAULT));
		mine_photo.setBounds(10, 290, 950, 200);
		
		lastPanel.setLayout(null);
		lastPanel.setBackground(mineColor);
		lastPanel.add(title);
		lastPanel.add(user_tablePanel);
		
		lastPanel.add(exit);
		lastPanel.add(mine_photo);
		
		cardLayout.last(downPanel);
		
		
		frame.setVisible(true);
	}
	public void listener() {
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		store.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				store.setBackground(onColor);
				mine.setBackground(offColor);
				cardLayout.first(downPanel);
			}
		});
		
		mine.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				mine.setBackground(onColor);
				store.setBackground(offColor);
				cardLayout.last(downPanel);
			}
		});
		
		choose_kind.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO �Զ����ɵķ������
				ArrayList<petItem> dataList;
				String kind = (String)e.getItem();
				try {
					if("ȫ��".equals(kind)) {
						dataList = adminService.queryAllData();
					}else {
						dataList = adminService.queryKindData(kind);
					}
					
					varieties = adminService.queryVarietiesDataOfKind(kind);
					if("è".equals(kind)) {
						choose_varieties.addItem("è");
					}else if("��".equals(kind)) {
						choose_varieties.addItem("��");
					}else if("ȫ��".equals(kind)) {
					choose_varieties.addItem("è�͹�");
					}
					
					for(int i = 0;i < varieties.length;i++) {
						choose_varieties.addItem(varieties[i]);
					}
					
					String[][] tbody = listToArray(dataList);
					TableModel dataModel = new DefaultTableModel(tbody,shoptableHead);
					table.setModel(dataModel);
					
					
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
			
		});
		
		choose_varieties.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO �Զ����ɵķ������
				ArrayList<petItem> dataList;
				String varieties = (String)e.getItem();
				try {
					
					if("è".equals(varieties)) {
						dataList = adminService.queryKindData("è");
					}else if("��".equals(varieties)) {
						dataList = adminService.queryKindData("��");
					}else if("è�͹�".equals(varieties)){
						dataList = adminService.queryAllData();
					}else{
						dataList = adminService.queryVarietiesData(varieties);
					}
					
					String[][] tbody = listToArray(dataList);
					TableModel dataModel = new DefaultTableModel(tbody,shoptableHead);
					table.setModel(dataModel);
					
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
			
		});
		
		
		buy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				
				try {
					String alert = adminService.buypets(Integer.valueOf(number.getText()).intValue(), Integer.valueOf(unit.getText()).intValue(),userName);
					
					ArrayList<petItem> dataList;
					String varieties = (String)choose_varieties.getSelectedItem();
					try {
						
						if("è".equals(varieties)) {
							dataList = adminService.queryKindData("è");
						}else if("��".equals(varieties)) {
							dataList = adminService.queryKindData("��");
						}else if("è�͹�".equals(varieties)){
							dataList = adminService.queryAllData();
						}else dataList = adminService.queryVarietiesData(varieties);
						
						String[][] tbody = listToArray(dataList);
						TableModel dataModel = new DefaultTableModel(tbody,shoptableHead);
						table.setModel(dataModel);
						 
					} catch (Exception e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
					
					UserPetItem pet = adminService.queryUserDataFromNumber(userName);
					number.setText("");
					unit.setText("");
					showUserTable();
					JOptionPane.showMessageDialog(firstPanel, alert);
					
					FileUtils.savePets(pet,userName);
				} catch (NumberFormatException | SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
			
		});
		

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				System.exit(0);
			}
			
		});
		
	}

	public void showTable() throws Exception {
		
		ArrayList<petItem> dataList = adminService.queryAllData();
		String[][] tbody = listToArray(dataList);
		//����ѯ���Ľ��Ϊtable��ֵ
		TableModel dataModel = new DefaultTableModel(tbody,shoptableHead);
		table.setModel(dataModel);
	}
	
	private String[][] listToArray(ArrayList<petItem> dataList) {
		// TODO �Զ����ɵķ������
		String[][] tbody = new String[dataList.size()][5];
		for(int i = 0; i < dataList.size();i++){
			petItem pet = dataList.get(i);
			tbody[i][0] = pet.getNumber() + "";
			tbody[i][1] = pet.getKind();
			tbody[i][2] = pet.getVarieties();
			tbody[i][3] = pet.getPrice() + "";
			tbody[i][4] = pet.getUnit() + "";
		}
		return tbody;
	}
	
	public void showUserTable() throws Exception {
		
		ArrayList<UserPetItem> dataList = adminService.queryAllUserData(userName);
		String[][] tbody = user_listToArray(dataList);
		//����ѯ���Ľ��Ϊtable��ֵ
		TableModel dataModel = new DefaultTableModel(tbody,userTableHead);
		user_table.setModel(dataModel);
	}
	
	private String[][] user_listToArray(ArrayList<UserPetItem> dataList) {
		// TODO �Զ����ɵķ������
		String[][] tbody = new String[dataList.size()][5];
		for(int i = 0; i < dataList.size();i++){
			UserPetItem pet = dataList.get(i);
			tbody[i][0] = pet.getNumber() + "";
			tbody[i][1] = pet.getKind();
			tbody[i][2] = pet.getVarieties();
			tbody[i][3] = pet.getUnit() + "";
			tbody[i][4] = pet.getTotal() + "";
		}
		return tbody;
	}
	
}
