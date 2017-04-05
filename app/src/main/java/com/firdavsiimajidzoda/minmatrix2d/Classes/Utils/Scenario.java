package com.firdavsiimajidzoda.minmatrix2d.Classes.Utils;

/**
 * Created by firdavsiimajidzoda on 4/5/17.
 */

public class Scenario {
    public int matrix[][];
    public int minimumCost;
    public String gotThrough;
    public String path;

    public Scenario(int matrix[][], int min, String through, String path){
        this.matrix = matrix;
        minimumCost = min;
        gotThrough = through;
        this.path = path;
    }
}
