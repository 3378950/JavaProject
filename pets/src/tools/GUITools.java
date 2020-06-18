package tools;

import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JFrame;
/**
 * ������
 */
public class GUITools {
	static Toolkit kit = Toolkit.getDefaultToolkit(); //Java�ṩ��GUIĬ�Ϲ�����
	//��ָ�������Ļ����
	public static void center(Component c){
		int x = (kit.getScreenSize().width - c.getWidth())/2;
		int y = (kit.getScreenSize().height - c.getHeight())/2;
		c.setLocation(x,y);
	}
	//���ô���ͼ��
	public static void setTitleImage(JFrame frame,String titleIconPath){
		frame.setIconImage(kit.createImage(titleIconPath));
	}
	
}
