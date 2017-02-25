package ru.stqa.pft.homework;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Summoner on 17.02.2017.
 */


public class TestDistance {

    @Test
    public void testDistance() {
        //for (int i = 0;i < 4;i++) {


            Point p1 = new Point(2,4);
            Point p2 = new Point(4, 4);
            Point p3 = new Point(6,7);

            Assert.assertEquals(p1.distance(p2), p2.distance(p3));

        //}
    }


}
