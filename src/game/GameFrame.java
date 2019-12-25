package game;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

/*
 * 游戏窗口类
 * */
public class GameFrame extends Frame implements WindowListener{
	private GamePanel gamePanel;
	
	public GameFrame() {
		this.setTitle("AirBattle");
		this.setBounds(500, 200, 400, 660);
		
		this.gamePanel = new GamePanel();
		this.add(gamePanel);
		
		this.addWindowListener(this);
	}

	//WindowListener
    public void windowOpened(WindowEvent e) {
    	
    }
    
    public void windowClosing(WindowEvent e) {
//    	int re = javax.swing.JOptionPane.showConfirmDialog(this, "确定要退出吗？");
//    	if(re == JOptionPane.YES_OPTION) {
    		System.exit(0);
//    	}
    }
    public void windowClosed(WindowEvent e) {

    }
    public void windowIconified(WindowEvent e) {
    	
    }
    public void windowDeiconified(WindowEvent e) {
    	
    }
    public void windowActivated(WindowEvent e) {
    	
    }
    public void windowDeactivated(WindowEvent e) {
    	
    }
}
