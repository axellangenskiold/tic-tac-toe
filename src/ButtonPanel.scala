package tictactoe

import javax.swing.JPanel
import javax.swing.JButton
import java.awt.event.ActionListener
import java.awt.event.ActionEvent

class ButtonPanel(model: Model) extends JPanel {
    val newGameButton = new JButton("New Game")
    newGameButton.addActionListener(new ActionListener {
        override 
        def actionPerformed(e: ActionEvent): Unit = 
            model.setUp()
    })


    add(newGameButton)
    setVisible(true)
}
