package tictactoe

import javax.swing.JFrame
import java.awt.Dimension
import GUI.EXIT_ON_CLOSE
import java.awt.Component
import javax.swing.JPanel
import java.awt.BorderLayout
import javax.swing.JButton
import javax.swing.JComponent

object GUI {
    val EXIT_ON_CLOSE = 3;
}

class GUI(model: Model) extends JFrame {
    val statusPanel = new StatusPanel(model)
    add(BorderLayout.NORTH, statusPanel)

    val field = new Field(model)
    addWithWrapper(field)

    val buttonPanel = new ButtonPanel(model)
    add(BorderLayout.SOUTH, buttonPanel)



    pack()
    setDefaultCloseOperation(EXIT_ON_CLOSE)
    setResizable(true)
    setVisible(true)


    def addWithWrapper(c: JComponent) : Unit = 
        val capsule = new JPanel()
        capsule.add(c)
        add(BorderLayout.CENTER, capsule)

    def addWithWrapper(c: JComponent, borderLayout: String): Unit =
        val capsule = new JPanel()
        capsule.add(c)
        add(borderLayout, capsule)

    def update(): Unit =
        for (x <- field.getComponents()) {
            val square: Square = x.asInstanceOf[Square]
            square.setValue(model.getValue(square.row, square.col))
        }
        statusPanel.update()
    
    def isWin(): Unit =
        statusPanel.isWin(model.playerTurn)

    def tie(): Unit = 
        statusPanel.tie()

}