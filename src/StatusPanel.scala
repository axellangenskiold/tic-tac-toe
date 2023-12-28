package tictactoe

import javax.swing.JTextField
import java.awt.Font
import javax.swing.border.LineBorder
import java.awt.Dimension
import java.awt.Color

object StatusPanel {
    val FONT_SIZE: Int = 45
    val DEFAULT_COLOR = Color.WHITE
    val TIE_COLOR = Color.YELLOW
    val WIN_COLOR = Color.GREEN
}

class StatusPanel(model: Model) extends JTextField {
    setPreferredSize(new Dimension(600, 100))
    setHorizontalAlignment(0);
    setBorder(new LineBorder(Color.BLACK, 2));
    setFont(new Font("Arial",Font.BOLD,StatusPanel.FONT_SIZE ));
    setVisible(true)
    setForeground(Color.BLACK)
    setFocusable(false)


    def start() : Unit =
        setBackground(StatusPanel.DEFAULT_COLOR)
        setText("Player 1 starts with circles.")

    def update(): Unit =
        setText("Player " + model.playerTurn + "'s turn.")

    def isWin(player: Int): Unit = 
        setText("Player " + (3-model.playerTurn) + " has won") //3 - playerTurn to get opposite player
        setBackground(StatusPanel.WIN_COLOR)

    def tie(): Unit = 
        setText("It's a tie")
        setBackground(StatusPanel.TIE_COLOR)
}
