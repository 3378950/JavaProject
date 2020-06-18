package tools;

import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JFrame;
/**
 * 工具类
 */
public class GUITools {
	static Toolkit kit = Toolkit.getDefaultToolkit(); //Java提供的GUI默认工具类
	//将指定组件屏幕居中
	public static void center(Component c){
		int x = (kit.getScreenSize().width - c.getWidth())/2;
		int y = (kit.getScreenSize().height - c.getHeight())/2;
		c.setLocation(x,y);
	}
	//设置窗口图标
	public static void setTitleImage(JFrame frame,String titleIconPath){
		frame.setIconImage(kit.createImage(titleIconPath));
	}
	
}
