file://<WORKSPACE>/src/Model.scala
### java.lang.NoClassDefFoundError: sourcecode/Name

occurred in the presentation compiler.

action parameters:
offset: 1838
uri: file://<WORKSPACE>/src/Model.scala
text:
```scala
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
        for (x <_@@)
    
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

```



#### Error stacktrace:

```
scala.meta.internal.tokenizers.XmlParser$Xml$.UnpStart(XmlParser.scala:48)
	scala.meta.internal.tokenizers.XmlParser$Xml$.Unparsed(XmlParser.scala:47)
	scala.meta.internal.tokenizers.XmlParser$Xml$.XmlContent(XmlParser.scala:43)
	scala.meta.internal.tokenizers.XmlParser.$anonfun$XmlExpr$1(XmlParser.scala:24)
	scala.meta.shaded.internal.fastparse.internal.RepImpls$.rec$4(RepImpls.scala:226)
	scala.meta.shaded.internal.fastparse.internal.RepImpls$.rep$extension(RepImpls.scala:266)
	scala.meta.shaded.internal.fastparse.package$ByNameOps$.rep$extension(package.scala:202)
	scala.meta.internal.tokenizers.XmlParser.XmlExpr(XmlParser.scala:24)
	scala.meta.internal.tokenizers.LegacyScanner.$anonfun$getXml$2(LegacyScanner.scala:932)
	scala.meta.shaded.internal.fastparse.SharedPackageDefs.parseInputRaw(SharedPackageDefs.scala:69)
	scala.meta.shaded.internal.fastparse.SharedPackageDefs.parseInputRaw$(SharedPackageDefs.scala:45)
	scala.meta.shaded.internal.fastparse.package$.parseInputRaw(package.scala:6)
	scala.meta.shaded.internal.fastparse.Parsed$Extra.trace(Parsed.scala:139)
	scala.meta.shaded.internal.fastparse.Parsed$Extra.traced(Parsed.scala:118)
	scala.meta.internal.tokenizers.LegacyScanner.getXml(LegacyScanner.scala:936)
	scala.meta.internal.tokenizers.LegacyScanner.fetchLT$1(LegacyScanner.scala:295)
	scala.meta.internal.tokenizers.LegacyScanner.fetchToken(LegacyScanner.scala:303)
	scala.meta.internal.tokenizers.LegacyScanner.nextToken(LegacyScanner.scala:211)
	scala.meta.internal.tokenizers.LegacyScanner.foreach(LegacyScanner.scala:1011)
	scala.meta.internal.tokenizers.ScalametaTokenizer.uncachedTokenize(ScalametaTokenizer.scala:24)
	scala.meta.internal.tokenizers.ScalametaTokenizer.$anonfun$tokenize$1(ScalametaTokenizer.scala:17)
	scala.collection.concurrent.TrieMap.getOrElseUpdate(TrieMap.scala:961)
	scala.meta.internal.tokenizers.ScalametaTokenizer.tokenize(ScalametaTokenizer.scala:17)
	scala.meta.internal.tokenizers.ScalametaTokenizer$$anon$2.apply(ScalametaTokenizer.scala:332)
	scala.meta.tokenizers.Api$XtensionTokenizeDialectInput.tokenize(Api.scala:25)
	scala.meta.tokenizers.Api$XtensionTokenizeInputLike.tokenize(Api.scala:14)
	scala.meta.internal.pc.completions.KeywordsCompletions$.reverseTokens$lzyINIT1$1(KeywordsCompletions.scala:50)
	scala.meta.internal.pc.completions.KeywordsCompletions$.reverseTokens$1(KeywordsCompletions.scala:54)
	scala.meta.internal.pc.completions.KeywordsCompletions$.contribute(KeywordsCompletions.scala:56)
	scala.meta.internal.pc.completions.Completions.completions(Completions.scala:187)
	scala.meta.internal.pc.completions.CompletionProvider.completions(CompletionProvider.scala:86)
	scala.meta.internal.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:136)
```
#### Short summary: 

java.lang.NoClassDefFoundError: sourcecode/Name