/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

/**
 *
 * @author indon
 */
public class Dijksra {
    private static final int NO_PARENT = -1;
    
    private static void dijkstra(int[][] data, int start)
    {
        int nVertices = data[0].length;
        int[] shortestDistances = new int[nVertices];
        boolean[] added = new boolean[nVertices];
        
        for(int vertexIndex=0; vertexIndex<nVertices; vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }
        
        shortestDistances[start] = 0;
        int[] parents = new int[nVertices];
        parents[start] = NO_PARENT;
        
        for(int i=1; i<nVertices; i++)
        {
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for(int vertexIndex=0; vertexIndex<nVertices; vertexIndex++)
            {
                if(!added[vertexIndex] && shortestDistances[vertexIndex]<shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                    System.out.print(nearestVertex + " ");
                }
            }
            System.out.println("");
            
            added[nearestVertex] = true;
            
            for(int vertexIndex = 0; vertexIndex<nVertices; vertexIndex++) 
            {
                int edgeDistance = data[nearestVertex][vertexIndex];
                System.out.print(edgeDistance + " ");
                if(edgeDistance>0 && ((shortestDistance+edgeDistance)<shortestDistances[vertexIndex])) 
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
            System.out.println("");
        }
        
        printSolution(start, shortestDistances, parents);
    }
    
    private static void printSolution(int startVertex, int[] distances, int[] parents)
    {
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");
        
        for(int vertexIndex=0; vertexIndex<nVertices; vertexIndex++) 
        {
            if(vertexIndex!=startVertex)
            {
                System.out.print("\n" + startVertex + " -> ");
                System.out.print(vertexIndex + " \t\t ");
                System.out.print(distances[vertexIndex] + "\t\t");
                printPath(vertexIndex, parents);
            }
        }
    }
    
    private static void printPath(int currentVertex, int[] parents)
    {
        if(currentVertex == NO_PARENT)
        {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }
    
    public static void main(String[] args)
    {
        int[][] data = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                    { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                    { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                    { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                    { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                    { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
                                    { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
                                    { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                    { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        int[][] graph = {{0,6,3,0},
                         {6,0,4,1},
                         {3,4,0,1},
                         {0,1,1,0}
                        };
        dijkstra(graph, 1);
    }
}
