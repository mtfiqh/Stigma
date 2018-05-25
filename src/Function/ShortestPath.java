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
public class ShortestPath {
    
    private int col;
    private ArrayList<Double> Min = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();
    
    public void showMin()
    {
        System.out.println("Minimum : ");
        for(Double min : Min)
        {
            System.out.print(min + " ");
        }
        System.out.println("");
    }
    
    public void showPath()
    {
        System.out.println("Path : ");
        for(Integer pos : path)
        {
            System.out.print(pos + " ");
        }
        System.out.println("");
    }
    
    public ArrayList<Integer> getPath()
    {
        return this.path;
    }
    
    public String getPathText()
    {
        String result = "";
        for(Integer pos : path)
        {
            result = result.concat(pos + " ");
        }
        result = result.concat("\b");
        return result;
    }
    
    public double getMin()
    {
        double sum = 0;
        for(Double d : Min)
        {
            sum += d;
        }
        return sum;
    }
    
    public void printData(double data[][])
    {
        for(int i=0; i<data.length; i++)
        {
            for(int j=0; j<data.length; j++)
            {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    private void setZero(double data[][], int col)
    {
        path.add(col);
        for(int i=0; i<data.length; i++)
        {
            data[i][col] = 0;
        }
    }
    
    private double getMin(double data[][], int row)
    {
        double min = Integer.MAX_VALUE;
        for(int i=0; i<data.length; i++)
        {
            if(data[row][i]<=min && data[row][i]!=0)
            {
                min = data[row][i];
                col = i;
            }
        }
        Min.add(min);
        return min;
    }
    
    public void shortestPath(double data[][], int start, int finish)
    {
        col = start;
        while(col!=finish)
        {
            setZero(data, col);
            printData(data);
            System.out.println("MIN : " + getMin(data, col) + " COL : " + col + "\n");
        }
        path.add(finish);
    }
    
    public static void main (String[] args) {
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
        ShortestPath sp = new ShortestPath();
        int start = 0;
        int finish = 2;
        sp.shortestPath(data, start, finish);
        sp.showMin();
        //sp.showPath();
        System.out.println(sp.getPath().toString());
        System.out.println("Minimum : " + sp.getMin());
    }
}
