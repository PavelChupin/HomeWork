package ru.stqa.pft.homework;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Summoner on 17.02.2017.
 */


public class TestDistance {

    @Test
    public void testDistance() {
        Point p1 = new Point(20, 8);
        Point p2 = new Point(6, 60);

        Assert.assertEquals(p1.distance(p2),53.85164807134504);
    }


}
