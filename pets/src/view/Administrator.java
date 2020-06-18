package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import server.AdminService;
import vo.petItem;

import java.util.*;
public class Administrator {

	//管理员主面板组件声明
	//	private adminService adminService;
	private AdminService adminService;
	
	private JFrame frame;
	private JPanel panelLeft;
	private JPanel panelRight;
	private Color bgColor;
	private JScrollPane tablePanel;
	private JTable table;
	private JLabel photoLabel_left;
	private JLabel photoLabel_center;
	private JLabel photoLabel_right;
	
	private String photoName1;
	private String photoName2;
	private String photoName3;
	private ImageIcon photo1;
	private ImageIcon photo2;
	private ImageIcon photo3;
	
	private JComboBox<?> choose_kind;
	private JButton addButton;
	private JButton deleteButton;
	private JButton updateButton;
	private JButton exitButton;
	
	
	private String[] tableHead = {"编号","种类","品种","价格","数量"};
	
	private String[] choose = {"全部","猫","狗"};
	//管理员主面板组件声明结束
	
	//添加、删除、修改子面板及组件声明
	private JDialog addDialog;
	private JDialog deleteDialog;
	private JDialog updateDialog;
	//以下组件为三个子面板共用
	private JDialog sonDialog;
	private JPanel sonPanel;
	private JLabel noLabel;
	private JTextField noTF;
	private JLabel kindLabel;
	private JTextField kindTF;
	private JLabel varietiesLabel;
	private JTextField varietiesTF;
	private JLabel priceLabel;
	private JTextField priceTF;
	private JLabel unitLabel;
	private JTextField unitTF;
	private JButton all;
	//添加删除修改子面板及组件声明结束
	
	
//	@SuppressWarnings("unchecked")
	public Administrator() {
		adminService = new AdminService();
		//主面板及组件对象实例化
		frame = new JFrame("宠物商店管理");
		panelLeft = new JPanel();
		panelRight = new JPanel();
		
		bgColor = new Color(255,255,255);
		
		table = new JTable();
		tablePanel = new JScrollPane(table);
		
		photoName1 = "lalal.jpg";
		photoName2 = "pet2.jpeg";
		photoName3 = "pet3.jpg";
		
		photo1 = new ImageIcon(photoName1);
		photo2 = new ImageIcon(photoName2);
		photo3 = new ImageIcon(photoName3);
		
		choose_kind = new JComboBox<Object>(choose);
		addButton = new JButton("添加");
		deleteButton = new JButton("删除");
		updateButton = new JButton("修改");
		exitButton = new JButton("退出");
		//主面板及组件对象实例化结束
		
		//子面板及组件对象实例化
		addDialog = new JDialog(frame,"添加宠物",true);
		deleteDialog = new JDialog(frame,"删除宠物-请输入编号删除",true);
		updateDialog = new JDialog(frame,"修改宠物-情谨慎修改",true);
		sonDialog = new JDialog(frame,"",true);
		sonPanel = new JPanel();
		noLabel = new JLabel("宠物编号");
		kindLabel = new JLabel("宠物种类");
		varietiesLabel = new JLabel("宠物品种");
		priceLabel = new JLabel("宠物价格");
		unitLabel = new JLabel("宠物数量");
		noTF = new JTextField();
		kindTF = new JTextField();
		varietiesTF = new JTextField();
		priceTF = new JTextField();
		unitTF = new JTextField();
		all = new JButton("");
		//子面板及组件对象实例化结束
	}
	
	public void display() throws Exception {
		//图标设置
		Toolkit kit = Toolkit.getDefaultToolkit();
		frame.setIconImage(kit.createImage("title.jpg"));
		//图标设置结束
		
		//主面板显示设置
		frame.setSize(755, 798);					//设置宽高
		frame.setLocationRelativeTo(null);			//居中显示
		frame.setResizable(false);					//大小不可调整
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panelLeft);
		frame.getContentPane().add(panelRight);
		
		table.getTableHeader().setReorderingAllowed(false);//列不能移动
		table.getTableHeader().setResizingAllowed(false);//不可拉动表格
		table.setEnabled(false);  //不可更改数据
		table.setBorder(null);
		
//		table.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		showTable();
		//设置各组件大小及位置
		panelLeft.setBounds(14, 13, 723, 294);
		panelLeft.setBackground(bgColor);
		panelRight.setBounds(14, 320, 723, 430);
		panelRight.setBackground(bgColor);
		
		tablePanel.setBounds(14, 13, 710, 280);
		tablePanel.setBorder(null);
		tablePanel.setBackground(bgColor);
		
//		cat1.setImage(cat1.getImage().getScaledInstance(233, 233, Image.SCALE_DEFAULT));
//		cat2.setImage(cat2.getImage().getScaledInstance(233, 233, Image.SCALE_DEFAULT));
//		cat3.setImage(cat3.getImage().getScaledInstance(233, 233, Image.SCALE_DEFAULT));
		photo1.setImage(photo1.getImage().getScaledInstance(233, 233, Image.SCALE_DEFAULT));
		photo2.setImage(photo2.getImage().getScaledInstance(233, 233, Image.SCALE_DEFAULT));
		photo3.setImage(photo3.getImage().getScaledInstance(233, 233, Image.SCALE_DEFAULT));
		
		choose_kind.setBounds(264, 13, 200, 40);
		addButton.setBounds(104, 86, 200, 40);
		deleteButton.setBounds(421, 86, 200, 40);
		updateButton.setBounds(104, 173, 200, 40);
		exitButton.setBounds(421, 173, 200, 40);
		
		//添加组件
		panelLeft.setLayout(null);
		panelLeft.add(tablePanel);
		
		panelRight.setLayout(null);
		panelRight.add(choose_kind);
		panelRight.add(addButton);
		panelRight.add(deleteButton);
		panelRight.add(updateButton);
		panelRight.add(exitButton);
		photoLabel_center = new JLabel(photo2);
		photoLabel_center.setBounds(468, 210, 241, 207);
		panelRight.add(photoLabel_center);
		
		photoLabel_left = new JLabel(photo1);
		photoLabel_left.setBounds(235, 59, 249, 222);
		panelRight.add(photoLabel_left);
		photoLabel_right = new JLabel(photo3);
		photoLabel_right.setBounds(14, 210, 232, 207);
		panelRight.add(photoLabel_right);
		
		frame.setVisible(true);
		//主面板显示设置结束
		
		
		//子面板显示设置
		sonDialog.setSize(400, 600);					//设置宽高
		sonDialog.setLocationRelativeTo(null);
		
		addDialog.setSize(400, 600);					//设置宽高
		addDialog.setLocationRelativeTo(null);
		
		deleteDialog.setSize(400, 600);					//设置宽高
		deleteDialog.setLocationRelativeTo(null);
		
		updateDialog.setSize(400, 600);					//设置宽高
		updateDialog.setLocationRelativeTo(null);
		
		sonPanel.setLayout(null);
		
		Font font = new Font("Serief",Font.PLAIN,20);
		
		noLabel.setBounds(0, 20, 386, 20);
		noLabel.setFont(font);
		noLabel.setHorizontalAlignment(JTextField.CENTER);
//		noLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		noTF.setBounds(78, 50, 230, 30);
		noTF.setHorizontalAlignment(JTextField.CENTER);
		
		kindLabel.setBounds(0, 100, 386, 20);
		kindLabel.setFont(font);
		kindLabel.setHorizontalAlignment(JTextField.CENTER);
		
		kindTF.setBounds(78, 130, 230, 30);
		kindTF.setHorizontalAlignment(JTextField.CENTER);
		
		varietiesLabel.setBounds(0, 180, 386, 20);
		varietiesLabel.setFont(font);
		varietiesLabel.setHorizontalAlignment(JTextField.CENTER);
//		noLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		varietiesTF.setBounds(78, 210, 230, 30);
		varietiesTF.setHorizontalAlignment(JTextField.CENTER);
		
		priceLabel.setBounds(0, 260, 386, 20);
		priceLabel.setFont(font);
		priceLabel.setHorizontalAlignment(JTextField.CENTER);
//		noLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		priceTF.setBounds(78, 290, 230, 30);
		priceTF.setHorizontalAlignment(JTextField.CENTER);
		
		unitLabel.setBounds(0, 340, 386, 20);
		unitLabel.setFont(font);
		unitLabel.setHorizontalAlignment(JTextField.CENTER);
//		noLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		unitTF.setBounds(78, 370, 230, 30);
		unitTF.setHorizontalAlignment(JTextField.CENTER);
		
		all.setBounds(78, 450, 230, 40);
		
		sonPanel.add(noLabel);
		sonPanel.add(noTF);
		sonPanel.add(kindLabel);
		sonPanel.add(kindTF);
		sonPanel.add(varietiesLabel);
		sonPanel.add(varietiesTF);
		sonPanel.add(priceLabel);
		sonPanel.add(priceTF);
		sonPanel.add(unitLabel);
		sonPanel.add(unitTF);
		sonPanel.add(all);
		sonDialog.getContentPane().add(sonPanel);
		//子面板显示设置结束
	}
	
	public void showTable() throws Exception {
		
		ArrayList<petItem> dataList = adminService.queryAllData();
		String[][] tbody = listToArray(dataList);
		//将查询到的结果为table赋值
		TableModel dataModel = new DefaultTableModel(tbody,tableHead);
		table.setModel(dataModel);
	}
	
	private String[][] listToArray(ArrayList<petItem> dataList) {
		// TODO 自动生成的方法存根
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
	
	//清空输入框操作
	public void cleaner() {
		noTF.setText("");
		kindTF.setText("");
		varietiesTF.setText("");
		priceTF.setText("");
		unitTF.setText("");
	}
	
	public void listener() {
		//窗口关闭监听器
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		//添加操作
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				addDialog.getContentPane().add(sonPanel);
				all.setText("添加");
				addDialog.setVisible(true);
			}
			
		});
		
		//删除操作
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				deleteDialog.getContentPane().add(sonPanel);
				kindTF.setEditable(false);
				varietiesTF.setEditable(false);
				priceTF.setEditable(false);
				unitTF.setEditable(false);
				all.setText("删除");
				deleteDialog.setVisible(true);
			}
			
		});
		
		//修改操作
		updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				updateDialog.getContentPane().add(sonPanel);
				all.setText("修改");
				updateDialog.setVisible(true);
			}
			
		});
		
		//退出操作
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				System.exit(0);
			}
			
		});
		
		//下拉菜单操作
		choose_kind.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				ArrayList<petItem> dataList;
				String kind = (String)e.getItem();
				try {
					if("全部".equals(kind)) {
						dataList = adminService.queryAllData();
					}else {
						dataList = adminService.queryKindData(kind);
					}
					String[][] tbody = listToArray(dataList);
					TableModel dataModel = new DefaultTableModel(tbody,tableHead);
					table.setModel(dataModel);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
			
		});
		WindowAdapter WA = new WindowAdapter() {
						public void windowClosing(WindowEvent we) {
							cleaner();
						}
						
					};
					
		addDialog.addWindowListener(WA);
		deleteDialog.addWindowListener(WA);
		updateDialog.addWindowListener(WA);
		
		deleteDialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
//				deleteDialog.dispose();
				kindTF.setEditable(true);
				varietiesTF.setEditable(true);
				priceTF.setEditable(true);
				unitTF.setEditable(true);
			}
		});
		
		all.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if("添加".equals(all.getText())) {
					add_pets();
				}else if("删除".equals(all.getText())) {
					delete_pets();
				}else if("修改".equals(all.getText())) {
					update_pets();
				}
			}
			
		});		
	}
	
	public void renovate() {
		ArrayList<petItem> dataList;
		String kind = (String)choose_kind.getSelectedItem();
		try {
			if("全部".equals(kind)) {
				dataList = adminService.queryAllData();
			}else {
				dataList = adminService.queryKindData(kind);
			}
			String[][] tbody = listToArray(dataList);
			TableModel dataModel = new DefaultTableModel(tbody,tableHead);
			table.setModel(dataModel);
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
	}
	
	//添加方法
	public void add_pets() {
		try {
			if(Integer.valueOf(unitTF.getText()).intValue() < 1) {
				JOptionPane.showMessageDialog(addDialog, "数量太少，重新输入！");
			}else {
				int flag = adminService.addPets(Integer.valueOf(noTF.getText()).intValue(), kindTF.getText(), varietiesTF.getText(), Integer.valueOf(priceTF.getText()).intValue(), Integer.valueOf(unitTF.getText()).intValue());
				
				if(flag > 0) {
					addDialog.dispose();
					cleaner();
					renovate();
					JOptionPane.showMessageDialog(addDialog, "添加成功！");
				}
			}
		} catch (NumberFormatException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
			JOptionPane.showMessageDialog(addDialog, "输入格式错误！");
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
			JOptionPane.showMessageDialog(addDialog, "添加失败！");
		}
	}
	
	//修改方法
	public void update_pets() {
		try {
			if(Integer.valueOf(unitTF.getText()).intValue() < 1) {
				JOptionPane.showMessageDialog(addDialog, "数量太少，重新输入！");
			}else {
				int flag = adminService.updatePets(Integer.valueOf(noTF.getText()).intValue(), kindTF.getText(), varietiesTF.getText(), Integer.valueOf(priceTF.getText()).intValue(), Integer.valueOf(unitTF.getText()).intValue());
				if(flag > 0) {
					updateDialog.dispose();
					cleaner();
					renovate();
					JOptionPane.showMessageDialog(updateDialog, "修改成功！");
				}
			}
		} catch (NumberFormatException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			JOptionPane.showMessageDialog(updateDialog, "输入格式错误！");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			JOptionPane.showMessageDialog(updateDialog, "修改失败！");
		}

	}
	
	//删除方法
	public void delete_pets() {
		try {
			int flag = adminService.deletePets(Integer.valueOf(noTF.getText()).intValue());
			if(flag > 0) {
				deleteDialog.dispose();
				kindTF.setEditable(true);
				varietiesTF.setEditable(true);
				priceTF.setEditable(true);
				unitTF.setEditable(true);
				cleaner();
				renovate();
				JOptionPane.showMessageDialog(deleteDialog, "删除成功！");
			}
		} catch (NumberFormatException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			JOptionPane.showMessageDialog(deleteDialog, "输入格式错误！");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			JOptionPane.showMessageDialog(deleteDialog, "删除失败！");
		}
	}
	public static void main(String[] args) throws Exception {
		Administrator ad = new Administrator();
		ad.listener();
		ad.display();
		
	}
}