package ExperimentGraphs

import cloudcity.lib.Graph._
import cloudcity.lib.Graph.GenerateGraph._

object writeStockMarketGraphx extends GraphxFormat {
    def main(args: Array[String]): Unit = {
        val markets: Int = args(0).toInt
        val tradersPerMarket: Int = args(1).toInt
        val saveName = f"stockMarket_${markets+tradersPerMarket}_graphx.txt"
        var graph: Map[Long, Iterable[Long]] = Map[Long, Iterable[Long]]()
        Range(0, markets).map(i => {
            val marketOffset = (i * tradersPerMarket + i)
            graph ++= BipartiteGraph(1, tradersPerMarket, marketOffset)
        })
        write(graph, saveName, schema)
    }
}

object writeStockMarketGiraph extends GiraphFormat {
    defaultVertexValue = "[[],[],[],[],[]]"
    defaultEdgeValue = "0"

    def main(args: Array[String]): Unit = {
        val markets: Int = args(0).toInt
        val tradersPerMarket: Int = args(1).toInt
        val saveName = f"stockMarket_${markets+tradersPerMarket}_giraph.txt"

        var graph: Map[Long, Iterable[Long]] = Map[Long, Iterable[Long]]()
        Range(0, markets).map(i => {
            val marketOffset = (i * tradersPerMarket + i)
            graph ++= BipartiteGraph(1, tradersPerMarket, marketOffset)
        })
        write(graph, saveName, schema)

//    val pw = new PrintWriter(new FileOutputStream(new File(f"stockMarket_${markets+tradersPerMarket}_giraph.txt"),false))
//    var market_id: Int = 0
//    Range(0, markets).foreach(_ => {
//       val traders = Range(market_id+1, market_id+1+tradersPerMarket)
//       // market 
//       pw.write(f"[$market_id,[[],[],[],[],[]],[${traders.map(i => f"[$i,0]").mkString(",")}]]\n")
//       pw.flush()
//       // traders. Each trader is connected to its market
//       traders.foreach(t => {
//          pw.write(f"[$t,[[],[],[],[],[]],[[$market_id,0]]]\n")
//          pw.flush()
//       })
//       market_id = market_id+tradersPerMarket+1
//    })
    
//    pw.close()
    }  
}