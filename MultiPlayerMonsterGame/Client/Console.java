import java.awt.EventQueue;
import java.rmi.*;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Console {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Console window = new Console();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}

	/**
	 * Create the application.
	 */
	public Console() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnJoinLobby = new JButton("JOIN LOBBY");

		btnJoinLobby.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnJoinLobby.setBounds(203, 380, 171, 51);
		frame.getContentPane().add(btnJoinLobby);
		
		JLabel lblLobby = new JLabel("WELCOME TO THE MONSTER GAME");
		lblLobby.setFont(new Font("Microsoft YaHei", Font.BOLD, 26));
		lblLobby.setBounds(71, 67, 482, 82);
		frame.getContentPane().add(lblLobby);	
		
		btnJoinLobby.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClientInterface player;
				int playerID = 10;
				System.out.println("player numberS: "+ playerID);
				try {
					System.out.println("player number1: "+ playerID);
					player = (ClientInterface)Naming.lookup("rmi://localhost/ABC");
					System.out.println("player number2: "+ playerID);
					playerID = player.joinLobby();
					
					lblLobby.setVisible(false);
					btnJoinLobby.setVisible(false);
					}catch (Exception arg0) {			
						JOptionPane.showMessageDialog(null, "Couldn't join Server");
					}
				System.out.println("player numberE: "+ playerID);
				
			}
		});
	}
}
