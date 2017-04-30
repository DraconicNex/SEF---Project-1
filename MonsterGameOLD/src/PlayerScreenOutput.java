import java.awt.*;

import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;

/*
 * this code is a modified version from the following web page
 * http://stackoverflow.com/questions/21077322/create-a-chess-board-with-jpanel
 */

public class PlayerScreenOutput extends ViewerType
{



    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][]gameBoardSquares;
    private JPanel chessBoard;
    private final JLabel message = new JLabel(
            "Pirates of the Penzance");
   // private static final String COLS = "ABCDEFGHI";
    private static Item[][] gameBoard ;
    private static int boardSize;
    private static ImageIcon icon;

    PlayerScreenOutput() 
    {
        initializeGui();
    }

    public final void initializeGui() 
    {
    	boardSize =Board.getBoardSize();
    	gameBoard  = Board.getGameBoard();
    	gameBoardSquares = new JButton[boardSize][boardSize];
    	 
    	
    	
    	
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("New")); // TODO - add functionality!
        tools.add(new JButton("Save")); // TODO - add functionality!
        tools.add(new JButton("Restore")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(new JButton("Resign")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(message);

       // gui.add(new JLabel("?"), BorderLayout.LINE_START);

        chessBoard = new JPanel(new GridLayout(0,9));
        chessBoard.setBackground(Color.CYAN);
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        gui.add(chessBoard);

        // create the game board squares
        
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int ii = 0; ii < gameBoardSquares.length; ii++) {
            for (int jj = 0; jj < gameBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                b.setBackground(Color.CYAN);
                
                // 'fill this in' using a transparent icon..
                
                if((gameBoard[jj][ii] instanceof Player) &&
        		        ((gameBoard[jj][ii].getItemChar()).equals(Integer.toString(1)))) 
                {
                	icon = new ImageIcon("src/player1.png");
                    b.setIcon(icon);
                    gameBoardSquares[jj][ii] = b;
                }
                
                else if((gameBoard[jj][ii] instanceof Player) &&
        		        ((gameBoard[jj][ii].getItemChar()).equals(Integer.toString(2)))) 
                {
                	icon = new ImageIcon("src/player2.png");
                    b.setIcon(icon);
                    gameBoardSquares[jj][ii] = b;
                }
                
                else if((gameBoard[jj][ii] instanceof Player) &&
        		        ((gameBoard[jj][ii].getItemChar()).equals(Integer.toString(3)))) 
                {
                	icon = new ImageIcon("src/player3.png");
                    b.setIcon(icon);
                    gameBoardSquares[jj][ii] = b;
                }
                
                else if((gameBoard[jj][ii] instanceof Player) &&
        		        ((gameBoard[jj][ii].getItemChar()).equals(Integer.toString(4)))) 
                {
                	icon = new ImageIcon("src/player4.png");
                    b.setIcon(icon);
                    gameBoardSquares[jj][ii] = b;
                }
                
                else if((gameBoard[jj][ii] instanceof Monster) &&
        		        ((gameBoard[jj][ii].getItemChar()).equals("M"))) 
                {
                	icon = new ImageIcon("src/monster.png");
                    b.setIcon(icon);
                    gameBoardSquares[jj][ii] = b;
                }
                else if((gameBoard[jj][ii] instanceof Wall) &&
        		        ((gameBoard[jj][ii].getItemChar()).equals("*"))) 
                {
                	icon = new ImageIcon("src/wall.png");
                    b.setIcon(icon);
                    gameBoardSquares[jj][ii] = b;
                }
                               
                else 
                {
                    icon = new ImageIcon("");
                    b.setIcon(icon);       
                    gameBoardSquares[jj][ii] = b;
                }
            }
        }

       
        
        for (int ii = 0; ii < boardSize; ii++) {
            for (int jj = 0; jj < boardSize; jj++) {
               
                   chessBoard.add(gameBoardSquares[jj][ii]);
                }
            }
        
    }

    public final JComponent getChessBoard() {
        return chessBoard;
    }

    public final JComponent getGui() {
        return gui;
    }

    public  void refreshBoard()
    {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                PlayerScreenOutput cb =
                        new PlayerScreenOutput();

                JFrame f = new JFrame(Integer.toString(boardSize));
                f.getContentPane().add(cb.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // ensures the minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }

}


/*--------------------     Code Not Neded----------------------------*/

//fill the chess board
//chessBoard.add(new JLabel(""));
// fill the top row
/* for (int ii = 0; ii < boardSize; ii++) {
    chessBoard.add(
            new JLabel(COLS.substring(ii, ii + 1),
            SwingConstants.CENTER));
}
*/