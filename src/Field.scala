package tictactoe

import javax.swing.JPanel
import java.awt.GridLayout
import java.awt.Dimension
import java.awt.event.ActionListener
import java.awt.event.ActionEvent

object Field {
    val SIZE = 200
    
}


class Field(model: Model) extends JPanel(new GridLayout(3,3)) {
    for (i <- 0 to 2) {
        for (j <- 0 to 2) {
            val square = new Square(i, j)
            square.setPreferredSize(new Dimension(Field.SIZE, Field.SIZE))

            square.addActionListener(new ActionListener {
                override def actionPerformed(e: ActionEvent): Unit = 
                    model.add(square.row, square.col)
            })

            add(square)
        }
    }

    setVisible(true)

}
