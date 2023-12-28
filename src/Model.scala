package tictactoe

object Model {
    
}

class Model() {
    val gui = new GUI(this)
    var playerTurn = 1
    var grid: Array[Array[Int]] = Array.ofDim[Int](3, 3)
    var isPressable = true


    def setUp(): Unit = 
        for (i <- 0 until grid.size) {
            for (j <- 0 until grid(0).size) {
                grid(i)(j) = 0
            }
        }
        updateGUI()
        gui.statusPanel.start()

    def add(row: Int, col: Int): Unit = 
        if (grid(row)(col) == 0 && isPressable) {
            grid(row)(col) = playerTurn

            //changes to other players turn
            playerTurn = 3 - playerTurn
            updateGUI()
        }

    def getValue(row: Int, col: Int): Int = 
        grid(row)(col)
    

    def isWin(): Boolean = 
        var result = false

        //rows
        for (i <- 0 until 3) {
            if ((grid(i)(0) == 1) && (grid(i)(1) == 1) && (grid(i)(2) == 1))
                result = true //p1 wins
            if ((grid(i)(0) == 2) && (grid(i)(1) == 2) && (grid(i)(2) == 2))
                result = true //p2 wins
        }

        //cols
        for (i <- 0 until 3) {
            if ((grid(0)(i) == 1) && (grid(1)(i) == 1) && (grid(2)(i) == 1))
                result = true //p1 wins
            if ((grid(0)(i) == 2) && (grid(1)(i) == 2) && (grid(2)(i) == 2))
                result = true //p2 wins
        }

        //diagonal
        if (grid(0)(0) == 1 && grid(1)(1) == 1 && grid(2)(2) == 1 || 
            grid(0)(2) == 1 && grid(1)(1) == 1 && grid(2)(0) == 1)
            result = true //p1 wins

        if (grid(0)(0) == 2 && grid(1)(1) == 2 && grid(2)(2) == 2 ||
            grid(0)(2) == 2 && grid(1)(1) == 2 &&grid(2)(0) == 2)
            result = true //p2 wins


        isPressable = !result
        result
    
    def isFull(): Boolean = 
        for (row <- grid)
            if (row.contains(0))
                return false
    
        isPressable = !isPressable
        true
        
    def printBoard(): Unit =
        for (rows <- grid) {
            for (tiles <- rows) {
                print(tiles + " ")
            }
            println()
        }
        println()


    def updateGUI() : Unit =
        gui.update()

        if (isWin()) {
            gui.isWin()
        } else if (isFull()) {
            gui.tie()
        }
}
