package ExperimentGraphs

import java.io._
import cloudcity.lib.Graph._
import cloudcity.lib.Graph.GenerateGraph._

object writeGridGraphx extends GraphxFormat{
  def main(args: Array[String]): Unit = {
   val width: Int = args(0).toInt
   val height: Int = args(1).toInt
   val saveName = f"2DTorus_${width*height}_graphx.txt"
   val graph: Map[Long, Iterable[Long]] = Torus2DGraph(width, height)
   write(graph, saveName, schema)
 }  
}

object writeGridWithClockGraphx extends GraphxFormat {
    def main(args: Array[String]): Unit = {
        val width: Int = args(0).toInt
        val height: Int = args(1).toInt
        val saveName = f"2DTorus_${width*height}_clock_graphx.txt"
        // offset 1, set 0 for clock vertex. Same below.
        var graph: Map[Long, Iterable[Long]] = Torus2DGraph(width, height, 1)
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
      val graph: Map[Long, Iterable[Long]] = Torus2DGraph(width, height, 1)
      write(graph, saveName, schema)
   }
}

object writeGridGiraph extends GiraphFormat {
   defaultVertexValue = "0"
   defaultEdgeValue = "0"
   def main(args: Array[String]): Unit = {
      val width: Int = args(0).toInt
      val height: Int = args(1).toInt

      val pw = new PrintWriter(new FileOutputStream(new File(f"2DTorus_${width*height}_giraph.txt"),false))
      val graph: Map[Long, Iterable[Long]] = Torus2DGraph(width, height)
      pw.close()
   }  
}