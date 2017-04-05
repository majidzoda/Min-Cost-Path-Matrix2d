package com.firdavsiimajidzoda.minmatrix2d.Classes.Utils;

/**
 * Created by firdavsiimajidzoda on 4/5/17.
 */


/**
 * This class includes constant scenario values for testing
 */
public class ConstantData {

    // Sample inputs
    public static final Scenario scenario1 = new Scenario(new int [][] {
            { 3, 4, 1, 2, 8, 6},
            { 6, 1, 8, 2, 7, 4},
            { 5, 9, 3, 9, 9, 5},
            { 8, 4, 1, 3, 2, 6},
            { 3, 7, 2, 8, 6, 4}
    }, 16, "YES", "1 2 3 4 4 5");

    public static final Scenario scenario2 = new Scenario(new int[][]{
            {3, 4, 1, 2, 8, 6,},
            {6, 1, 8, 2, 7, 4,},
            {5, 9, 3, 9, 9, 5},
            {8, 4, 1, 3, 2, 6},
            {3, 7, 2, 1, 2, 3}
    }, 11, "YES", "1 2 1 5 4 5");

    public static final Scenario scenario3 = new Scenario(new int[][]{
            {19, 10, 19, 10, 19},
            {21, 23, 20, 19, 12},
            {21, 23, 20, 19, 12},
    }, 48, "NO", "1 1 1");

    public static final Scenario scenario4 = new Scenario(new int[][]{
            {5, 8, 5, 3, 5}
    }, 26, "YES", "1 1 1 1 1");

    public static final Scenario scenario5 = new Scenario(new int[][]{
            {5},
            {8},
            {5},
            {3},
            {5}
    }, 3, "YES", "4");

    public static final Scenario scenario7 = new Scenario(new int[][]{
            {}
    }, 0, "NO", "");

    public static final Scenario scenario8 = new Scenario(new int[][]{
            {69, 10, 19, 10, 19},
            {51, 23, 20, 19, 12},
            {60, 12, 20, 11, 10}
    }, 0, "NO", "");

    public static final Scenario scenario9 = new Scenario(new int[][]{
            {60, 3, 3, 6},
            {6, 3, 7, 9},
            {5, 6, 8, 3}
    }, 14, "YES", "3 1 1 3");

    public static final Scenario scenario10 = new Scenario(new int[][]{
        {6,3,-5,9},
        {-5,2,4,10},
        {3,-2,6,10},
        {6,-1,-2,10}
    }, 0, "YES", "2 3 4 1");

    public static final Scenario scenario11 = new Scenario(new int[][]{
            {51, 51},
            {0,51},
            {51, 51},
            {5, 5}
    }, 10, "YES", "4 4");

    public static final Scenario scenario12 = new Scenario(new int[][]{
            {51, 51, 51},
            {0, 51, 51},
            {51, 51, 51},
            {5, 5, 51}
    }, 10, "NO", "4 4");

    public static final Scenario scenario13 = new Scenario(new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
    }, 20, "YES", "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1");
}