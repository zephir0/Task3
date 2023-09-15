# TASK3 - GraphAnalyzer

GraphAnalyzer is a tool designed to analyze undirected graphs. The program determines the number of connected components
within a graph based on the edges provided.

## Structure Note

All functionalities of the program are contained within a single class, GraphAnalyzer, to maintain the simplicity and
clarity of the task.

## Usage

Run the program:

```  
java GraphAnalyzer.java
```  

## Input

- The first line takes an integer, representing the number of edges in the graph.
- The subsequent lines (equal to the number of edges) take two positive integers representing vertices.

Example:

```
5
1 2
2 3
3 4
5 6
7 8
```

The program's output will be:

```
3
```

This is because there are 3 connected components: {1, 2, 3, 4}, {5, 6}, and {7, 8}.

## Error Handling
- If a user provides non-positive integers for vertices or the number of edges, the program will prompt them to re-enter the correct data.