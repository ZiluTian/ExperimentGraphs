package ExperimentGraphs

object writeERMGraphx extends GraphxFormat {
    def main(args: Array[String]): Unit = {
        val vertices: Int = args(0).toInt
        val p: Double = args(1).toDouble
        val saveName = f"ERM_${p}_${vertices}_graphx.txt"
        var graph: Map[Long, Iterable[Long]] = GraphFactory.erdosRenyi(vertices, p, 1).adjacencyList()
        graph = graph + (0.toLong -> Range(0, vertices + 1).map(i => i.toLong))
        write(graph, saveName, schema)
    }
}

object writeERMGiraph extends GiraphFormat {
   defaultVertexValue = "[0, 0, 0, 0, 0]"
   defaultEdgeValue = "0"
   def main(args: Array[String]): Unit = {
        val vertices: Int = args(0).toInt
        val p: Double = args(1).toDouble
        val saveName = f"ERM_${p}_${vertices}_giraph.txt"
        var graph: Map[Long, Iterable[Long]] = GraphFactory.erdosRenyi(vertices, p, 1).adjacencyList()
        // Add clock vertex, which notifies how many days have passed
        graph = graph + (0.toLong -> Range(0, vertices + 1).map(i => i.toLong))
        write(graph, saveName, schema)
    }
}
