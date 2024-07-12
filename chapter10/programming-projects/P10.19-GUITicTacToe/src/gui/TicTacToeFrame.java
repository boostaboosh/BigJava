package gui;

import ticTacToe.TicTacToeGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicTacToeFrame extends JFrame
{
   private final int WIDTH = 1920;
   private final int HEIGHT = 1080;

   private TicTacToeGame ticTacToeGame;
   private JPanel panel;
   private BoardComponent boardComponent;
   private JLabel turnLabel;
   private JLabel winnerLabel;
   private JButton startOverButton;

   public TicTacToeFrame()
   {
      // setting up the game of tic-tac-toe
      this.ticTacToeGame = new TicTacToeGame();
      ticTacToeGame.askAndSetFirstMoveSymbol();

      // setting the frame size, close operation, and visibility
      this.setSize(WIDTH, HEIGHT);
      this.setTitle("Tic-Tac-Toe");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);

      // adding components to the frame
      panel = new JPanel();
      this.boardComponent = new BoardComponent();
      this.turnLabel = new JLabel("Turn: " + ticTacToeGame.getNextMoveSymbol());
      this.winnerLabel = new JLabel("Winner: Game Not Over");
      this.startOverButton = new JButton("Start Over");
      panel.add(boardComponent);
      panel.add(turnLabel);
      panel.add(winnerLabel);
      panel.add(startOverButton);
      this.add(panel);

      // adding mouse listener to grid
      class MousePressListener extends MouseAdapter
      {
         public void mousePressed(MouseEvent event)
         {
            // if game is not over play next move
            if (!ticTacToeGame.isOver())
            {
               // if empty square selected play move and draw symbol
               String move = boardComponent.getCell(event.getPoint());
               if (ticTacToeGame.isValidMove(move))
               {
                  ticTacToeGame.executeMove(move);
                  boardComponent.drawSymbol(ticTacToeGame.getLastMoveSymbol(), move);
               }
               // update turn label
               turnLabel.setText("Turn: " + ticTacToeGame.getNextMoveSymbol());
            }
            // if game is over show draw or winner
            if (ticTacToeGame.isOver())
            {
               if (ticTacToeGame.hasWinner())
               {
                  winnerLabel.setText("Winner: " + ticTacToeGame.getWinnerSymbol());
               }
               else
               {
                  winnerLabel.setText("Winner: Draw");
               }
            }
         }
      }
      this.boardComponent.addMouseListener(new MousePressListener());

      // adding event listener to button
      this.startOverButton.addActionListener
            ((ActionEvent event) ->
                  {
                     ticTacToeGame = new TicTacToeGame();
                     ticTacToeGame.askAndSetFirstMoveSymbol();
                     resetGUI();
                  }
            );
   }

   public void resetGUI()
   {
      this.boardComponent.resetBoard();
      this.turnLabel.setText("Turn: " + ticTacToeGame.getNextMoveSymbol());
      this.winnerLabel.setText("Winner: Game Not Over");
   }
}
