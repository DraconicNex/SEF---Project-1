import java.awt.EventQueue;
import java.rmi.*;
import java.util.Random;

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
	public void initialize() {
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
		
		JButton btnPosition1 = new JButton("Postion 1");
		btnPosition1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//makeVisible();
			}
		});
		btnPosition1.setVisible(false);
		btnPosition1.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnPosition1.setBounds(81, 234, 150, 40);
		frame.getContentPane().add(btnPosition1);
		
		JButton btnPosition2 = new JButton("Postion 2");
		btnPosition2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//makeVisible();
			}
		});
		btnPosition2.setVisible(false);
		btnPosition2.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnPosition2.setBounds(355, 234, 150, 40);
		frame.getContentPane().add(btnPosition2);
		
		JButton btnPosition3 = new JButton("Postion 3");
		btnPosition3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//makeVisible();
			}
		});
		btnPosition3.setVisible(false);
		btnPosition3.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnPosition3.setBounds(81, 347, 150, 40);
		frame.getContentPane().add(btnPosition3);
		
		JButton btnPosition4 = new JButton("Postion 4");
		btnPosition4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//makeVisible();
			}
		});
		btnPosition4.setVisible(false);
		btnPosition4.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnPosition4.setBounds(355, 347, 150, 40);
		frame.getContentPane().add(btnPosition4);
		
		btnJoinLobby.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClientInterface player = null;
				int playerID = 0;
				
				try {

					player = (ClientInterface)Naming.lookup("rmi://localhost/ABC");
					playerID = player.joinLobby();
					System.out.println("player number: "+ playerID);
					
					lblLobby.setVisible(false);
					btnJoinLobby.setVisible(false);
					}catch (Exception arg0) {			
						JOptionPane.showMessageDialog(null, "Couldn't join Server");
					}
				 
				if((playerID != 0)&&(player != null)){
					GameCheck GameStatus = new GameCheck(player, playerID);
					GameStatus.start();
	
					lblLobby.setText("PLEASE SELECT A START POSITION");
					lblLobby.setVisible(true);
					btnPosition1.setVisible(true);
					btnPosition2.setVisible(true);
					btnPosition3.setVisible(true);
					btnPosition4.setVisible(true);
				}

				
			}
		});
	}

}
