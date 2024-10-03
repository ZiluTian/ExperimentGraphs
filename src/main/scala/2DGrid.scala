package ExperimentGraphs

import java.io._

object writeGridGraphx extends GraphxFormat{
  def main(args: Array[String]): Unit = {
   val width: Int = args(0).toInt
   val height: Int = args(1).toInt
   val saveName = f"/local/scratch/zilu/2DTorus_${width*height}_graphx.txt"
   val graph: Map[Long, Iterable[Long]] = GraphFactory.torus2D(width, height).adjacencyList()
   write(graph, saveName, schema)
 }  
}

object writeGridWithClockGraphx extends GraphxFormat {
    def main(args: Array[String]): Unit = {
        val width: Int = args(0).toInt
        val height: Int = args(1).toInt
        val saveName = f"2DTorus_${width*height}_clock_graphx.txt"
        // offset 1, set 0 for clock vertex. Same below.
        var graph: Map[Long, Iterable[Long]] = GraphFactory.torus2D(width, height, 1).adjacencyList()
        graph = graph + (0.toLong -> Range(0, width*height + 1).map(i => i.toLong))
        write(graph, saveName, schema)
    }
}


object writeGridWithClockGiraph extends GiraphFormat {
   defaultVertexValue = "0"
   defaultEdgeValue = "0"

   def main(args: Array[String]): Unit = {
      val width: Int = args(0).toInt
      val height: Int = args(1).toInt
      val saveName = f"2DTorus_${width*height}_clock_giraph.txt"
      // pw.write(f"[0,0,[${Range(0, width*height+1).map(i => f"[${i},0]").mkString(",")}]]\n")
      val graph: Map[Long, Iterable[Long]] = GraphFactory.torus2D(width, height, 1).adjacencyList()
      write(graph, saveName, schema)
   }
}

object writeGridGiraph extends GiraphFormat {
   defaultVertexValue = "0"
   defaultEdgeValue = "0"
   def main(args: Array[String]): Unit = {
      val width: Int = args(0).toInt
      val height: Int = args(1).toInt

      val saveName = f"2DTorus_${width*height}_giraph.txt"
      val graph: Map[Long, Iterable[Long]] = GraphFactory.torus2D(width, height).adjacencyList()
      write(graph, saveName, schema)
   }  
}
