/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.ArrayList;

/**
 *
 * @author indon
 */
public class Dijksra {
    private final int NO_PARENT = -1;
    private ArrayList<Double> distances = new ArrayList<>();
    private ArrayList<String> path = new ArrayList<>();
    
    public Dijksra(double[][] data, int start, int finish)
    {
        int nVertices = data[0].length;
        double[] shortestDistances = new double[nVertices];
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
            double shortestDistance = Integer.MAX_VALUE;
            
            for(int vertexIndex=0; vertexIndex<nVertices; vertexIndex++)
            {
                if(!added[vertexIndex] && shortestDistances[vertexIndex]<shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }
            
            added[nearestVertex] = true;
            
            for(int vertexIndex = 0; vertexIndex<nVertices; vertexIndex++) 
            {
                double edgeDistance = data[nearestVertex][vertexIndex];
                
                if(edgeDistance>0 && ((shortestDistance+edgeDistance)<shortestDistances[vertexIndex]) && nearestVertex!=finish) 
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
        }
        
        solution(start, shortestDistances, parents);
        setAll(start,finish,shortestDistances);
        for(String a : path)
        {
            System.out.println(a);
        }
    }
    
    public ArrayList<String> getPath()
    {
        return this.path;
    }
    
    public ArrayList<Double> getMin()
    {
        return this.distances;
    }
    
    private void setAll(int start, int finish, double[] distances)
    {
        System.out.println(start);
        System.out.println(finish);
        ArrayList<String> tmp = new ArrayList<>();
        for(String pos : path)
        {
            if(pos.startsWith(String.valueOf(finish + " ")) && pos.endsWith(String.valueOf(start + " ")))
            {
                int x = path.indexOf(pos) + 1;
                this.distances.add(distances[x]);
                tmp.add(pos);
            }
        }
        path = tmp;
    }
    
    private void solution(int startVertex, double[] distances, int[] parents)
    {
        int nVertices = distances.length;
        
        for(int vertexIndex=0; vertexIndex<nVertices; vertexIndex++)
        {
            if(vertexIndex!=startVertex)
            {
                path(vertexIndex, parents, "");
            }
        }
    }
    
    private void path(int currentVertex, int[] parents, String tmp)
    {
        if(currentVertex == NO_PARENT)
        {
            path.add(tmp);
            tmp = "";
            return;
        }
        path(parents[currentVertex], parents, tmp+=String.valueOf(currentVertex) + " ");
    }
    
    public static void main(String[] args)
    {
//        int[][] data = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
//                                    { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
//                                    { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
//                                    { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
//                                    { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
//                                    { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
//                                    { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
//                                    { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
//                                    { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        double[][] graph = {{0,6,3,0},
                         {6,0,4,1},
                         {3,4,0,1},
                         {0,1,1,0}
                        };
        double data[][] = new double[][]{{0, 0, 1.1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.38, 0, 0, 0, 0, 0},
                                         {1.1, 0, 0, 0, 0, 0, 0.36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.68, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 0.22, 0, 0, 0.45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.17, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0.22, 0, 0.41, 0, 0, 0, 0, 0, 0, 0, 0.99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 0.41, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                         {0, 0, 0.36, 0, 0, 0, 0, 0.55, 0.74, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0.45, 0, 0, 0.55, 0, 0, 0, 0, 0.76, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 0, 0, 0.74, 0, 0, 0.59, 0, 0, 0, 0, 0.16, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 0, 0, 0, 0, 0.59, 0, 0.36, 0, 0, 0, 0.78, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0.36, 0, 0.21, 0, 0, 0, 0.69, 0, 0, 0, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 0, 0, 0, 0.76, 0, 0, 0.21, 0, 0.48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.48, 0, 0.13, 0, 0, 0.52, 0, 0, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 0.99, 0, 0, 0, 0, 0, 0, 0, 0.13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.94, 0},
                                         {0, 0, 0, 0, 0, 0, 0, 0, 0.16, 0.78, 0, 0, 0, 0, 0, 0, 0, 0.85, 0, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.69, 0, 0, 0, 0, 0, 0.32, 1.37, 0, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.52, 0, 0, 0.32, 0, 0, 0, 0, 0.67, 0, 0, 0},
                                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.85, 1.37, 0, 0, 0, 1.4, 0, 0, 0, 0},
                                         {0, 0.38, 0.68, 0.17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.4, 0, 0, 1, 0, 0, 1.5},
                                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.67, 0, 0, 1, 0, 0.1, 0, 0},
                                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.1, 0, 0.62, 0.38},
                                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.94, 0, 0, 0, 0, 0, 0, 0, 0.62, 0, 1},
                                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.5, 0, 0.38, 1, 0},
                                        };
        Dijksra dj = new Dijksra(graph, 0, 1);
        System.out.println("PATH : " + dj.getPath().toString());
        System.out.println("MIN : " + dj.getMin());
    }
}
