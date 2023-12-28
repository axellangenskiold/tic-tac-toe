package tictactoe

import javax.swing.JTextField
import tictactoe.Square.value
import javax.swing.JButton
import java.awt.Dimension
import java.awt.Font

object Square {
    val PLAYER_ONE: String = "O"
    val PLAYER_TWO: String = "X"
    val FONT_SIZE: Int = 50

    var value = 0;

    
}


class Square(var row: Int, var col: Int) extends JButton(""){
    setBackground(java.awt.Color.BLACK)
    setVisible(true)
    setFocusable(false)
    setFont(new Font("ComicSans", Font.BOLD, Square.FONT_SIZE))


    def getIndex() : (Int, Int) = {
        (row, col)
    }

    def setValue(value: Int) : Unit = {
        if (Square.value == 0) {
            value match
                case 0 => setText("")

                case 1 => setText(Square.PLAYER_ONE)
                
                case 2 => setText(Square.PLAYER_TWO)
        }
    }

    def getValue() : Int = {
        Square.value
    }

}
