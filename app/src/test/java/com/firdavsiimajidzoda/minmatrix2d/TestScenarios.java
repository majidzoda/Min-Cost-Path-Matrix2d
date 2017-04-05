package com.firdavsiimajidzoda.minmatrix2d;

import com.firdavsiimajidzoda.minmatrix2d.Classes.Controllers.MinimumCost;
import com.firdavsiimajidzoda.minmatrix2d.Classes.Utils.ConstantData;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by firdavsiimajidzoda on 4/5/17.
 */


/*
 * Test the scenarios from ConstantData.class
 */
public class TestScenarios {

    // Following methods test the value of Minimum Cost value, Got through the end and Minimum cost path value for each scenarios
    @Test
    public void testScenario1(){
        MinimumCost minimumCost = new MinimumCost(null, ConstantData.scenario1.matrix, 0, null, null, null);
        assertEquals(minimumCost.getMinimumCost(), ConstantData.scenario1.minimumCost);
        assertEquals(minimumCost.getGotThrough(), ConstantData.scenario1.gotThrough);
        assertEquals(minimumCost.getMinimumCostPath(), ConstantData.scenario1.path);
    }

    @Test
    public void testScenario2(){
        MinimumCost minimumCost = new MinimumCost(null, ConstantData.scenario2.matrix, 0, null, null, null);
        assertEquals(minimumCost.getMinimumCost(), ConstantData.scenario2.minimumCost);
        assertEquals(minimumCost.getGotThrough(), ConstantData.scenario2.gotThrough);
        assertEquals(minimumCost.getMinimumCostPath(), ConstantData.scenario2.path);
    }

    @Test
    public void testScenario3(){
        MinimumCost minimumCost = new MinimumCost(null, ConstantData.scenario3.matrix, 0, null, null, null);
        assertEquals(minimumCost.getMinimumCost(), ConstantData.scenario3.minimumCost);
        assertEquals(minimumCost.getGotThrough(), ConstantData.scenario3.gotThrough);
        assertEquals(minimumCost.getMinimumCostPath(), ConstantData.scenario3.path);
    }

    @Test
    public void testScenario4(){
        MinimumCost minimumCost = new MinimumCost(null, ConstantData.scenario4.matrix, 0, null, null, null);
        assertEquals(minimumCost.getMinimumCost(), ConstantData.scenario4.minimumCost);
        assertEquals(minimumCost.getGotThrough(), ConstantData.scenario4.gotThrough);
        assertEquals(minimumCost.getMinimumCostPath(), ConstantData.scenario4.path);
    }

    @Test
    public void testScenario5(){
        MinimumCost minimumCost = new MinimumCost(null, ConstantData.scenario5.matrix, 0, null, null, null);
        assertEquals(minimumCost.getMinimumCost(), ConstantData.scenario5.minimumCost);
        assertEquals(minimumCost.getGotThrough(), ConstantData.scenario5.gotThrough);
        assertEquals(minimumCost.getMinimumCostPath(), ConstantData.scenario5.path);
    }

    @Test
    public void testScenario7(){
        MinimumCost minimumCost = new MinimumCost(null, ConstantData.scenario7.matrix, 0, null, null, null);
        assertEquals(minimumCost.getMinimumCost(), ConstantData.scenario7.minimumCost);
        assertEquals(minimumCost.getGotThrough(), ConstantData.scenario7.gotThrough);
        assertEquals(minimumCost.getMinimumCostPath(), ConstantData.scenario7.path);
    }

    @Test
    public void testScenario8(){
        MinimumCost minimumCost = new MinimumCost(null, ConstantData.scenario8.matrix, 0, null, null, null);
        assertEquals(minimumCost.getMinimumCost(), ConstantData.scenario8.minimumCost);
        assertEquals(minimumCost.getGotThrough(), ConstantData.scenario8.gotThrough);
        assertEquals(minimumCost.getMinimumCostPath(), ConstantData.scenario8.path);
    }

    @Test
    public void testScenario9(){
        MinimumCost minimumCost = new MinimumCost(null, ConstantData.scenario9.matrix, 0, null, null, null);
        assertEquals(minimumCost.getMinimumCost(), ConstantData.scenario9.minimumCost);
        assertEquals(minimumCost.getGotThrough(), ConstantData.scenario9.gotThrough);
        assertEquals(minimumCost.getMinimumCostPath(), ConstantData.scenario9.path);
    }

    @Test
    public void testScenario10(){
        MinimumCost minimumCost = new MinimumCost(null, ConstantData.scenario10.matrix, 0, null, null, null);
        assertEquals(minimumCost.getMinimumCost(), ConstantData.scenario10.minimumCost);
        assertEquals(minimumCost.getGotThrough(), ConstantData.scenario10.gotThrough);
        assertEquals(minimumCost.getMinimumCostPath(), ConstantData.scenario10.path);
    }

    @Test
    public void testScenario11(){
        MinimumCost minimumCost = new MinimumCost(null, ConstantData.scenario11.matrix, 0, null, null, null);
        assertEquals(minimumCost.getMinimumCost(), ConstantData.scenario11.minimumCost);
        assertEquals(minimumCost.getGotThrough(), ConstantData.scenario11.gotThrough);
        assertEquals(minimumCost.getMinimumCostPath(), ConstantData.scenario11.path);
    }

    @Test
    public void testScenario12(){
        MinimumCost minimumCost = new MinimumCost(null, ConstantData.scenario12.matrix, 0, null, null, null);
        assertEquals(minimumCost.getMinimumCost(), ConstantData.scenario12.minimumCost);
        assertEquals(minimumCost.getGotThrough(), ConstantData.scenario12.gotThrough);
        assertEquals(minimumCost.getMinimumCostPath(), ConstantData.scenario12.path);
    }

    @Test
    public void testScenario13(){
        MinimumCost minimumCost = new MinimumCost(null, ConstantData.scenario13.matrix, 0, null, null, null);
        assertEquals(minimumCost.getMinimumCost(), ConstantData.scenario13.minimumCost);
        assertEquals(minimumCost.getGotThrough(), ConstantData.scenario13.gotThrough);
        assertEquals(minimumCost.getMinimumCostPath(), ConstantData.scenario13.path);
    }
}
