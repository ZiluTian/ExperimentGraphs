package ExperimentGraphs

object writeSBMGraphx extends GraphxFormat {
    def main(args: Array[String]): Unit = {
        val vertices: Int = args(0).toInt
        val p: Double = args(1).toDouble
        val q: Double = args(2).toDouble
        val blocks: Int = args(3).toInt
        val saveName = f"SBM_${p}_${q}_${blocks}_${vertices}_graphx.txt"
        var graph: Map[Long, Iterable[Long]] = GraphFactory.stochasticBlock(vertices, p, q, blocks, 1).adjacencyList()
        graph = graph + (0.toLong -> Range(0, vertices + 1).map(i => i.toLong))
        write(graph, saveName, schema)
    }
}

// Pregel / Giraph format
object writeSBMGiraph extends GiraphFormat {
   defaultVertexValue = "[0, 0, 0, 0, 0]"
   defaultEdgeValue = "0"
   def main(args: Array[String]): Unit = {
        val vertices: Int = args(0).toInt
        val p: Double = args(1).toDouble
        val q: Double = args(2).toDouble
        val blocks: Int = args(3).toInt
        val saveName = f"SBM_${p}_${q}_${blocks}_${vertices}_giraph.txt"
        var graph: Map[Long, Iterable[Long]] = GraphFactory.stochasticBlock(vertices, p, q, blocks, 1).adjacencyList()
        // Add clock vertex, which notifies how many days have passed
        graph = graph + (0.toLong -> Range(0, vertices + 1).map(i => i.toLong))
        write(graph, saveName, schema)
    }
}