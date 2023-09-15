import java.util.*;

public class GraphAnalyzer {
    public static void main(String[] args) {
        GraphAnalyzer graphAnalyzer = new GraphAnalyzer();
        graphAnalyzer.execute();
    }

    private void execute() {
        Scanner sc = new Scanner(System.in);
        int numberOfEdges = readNumberOfEdges(sc);
        if (numberOfEdges >= 1) {
            Map<Integer, List<Integer>> graph = buildGraph(sc, numberOfEdges);
            int connectedComponentsNumber = countConnectedComponents(graph);
            System.out.println(connectedComponentsNumber);
        }
    }

    private int readNumberOfEdges(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Expected an integer for the number of edges. Try again.");
                sc.nextLine();
            }
        }
    }

    private Map<Integer, List<Integer>> buildGraph(Scanner sc,
                                                   int numberOfEdges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numberOfEdges; i++) {
            while (true) {
                try {
                    int vertexA = sc.nextInt();
                    int vertexB = sc.nextInt();

                    if (vertexA <= 0 || vertexB <= 0) {
                        throw new IllegalArgumentException();
                    }

                    graph.computeIfAbsent(vertexA, k -> new ArrayList<>()).add(vertexB);
                    graph.computeIfAbsent(vertexB, k -> new ArrayList<>()).add(vertexA);
                    break;

                } catch (InputMismatchException | IllegalArgumentException e) {
                    System.out.println("Invalid input. Expected positive integers for vertices. Try again.");
                    sc.nextLine();
                }
            }
        }
        return graph;
    }


    private int countConnectedComponents(Map<Integer, List<Integer>> graph) {
        int count = 0;
        Set<Integer> visitedVertices = new HashSet<>();
        for (Integer vertex : graph.keySet()) {
            if (!visitedVertices.contains(vertex)) {
                markConnectedComponentAsVisited(graph, vertex, visitedVertices);
                count++;
            }
        }
        return count;
    }

    private void markConnectedComponentAsVisited(Map<Integer, List<Integer>> graph,
                                                 int startingVertex,
                                                 Set<Integer> visitedVertices) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startingVertex);
        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            if (!visitedVertices.contains(currentVertex)) {
                visitedVertices.add(currentVertex);
                for (int neighbor : graph.get(currentVertex)) {
                    if (!visitedVertices.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
