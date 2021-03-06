package com.example.team17_personalbest;

import com.example.team17_personalbest.Step.Day;
import com.example.team17_personalbest.Step.StepHistory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
public class StepHistoryTest {

    @Test
    public void test_History(){
        StepHistory stepHistory = new StepHistory();
        int numDays = 28;

        for(int i = 0; i < numDays; i++){
            Day day = new Day(i);
            day.setPlannedSteps(i*10);
            day.setNormalSteps(i*100);
            stepHistory.updateHist(day);
        }

        ArrayList<Day> hist = stepHistory.getHist();
        int j = numDays-1;
        for(int i = 0; i < numDays; i++){
            assertEquals(i*100, hist.get(j).getNormalSteps());
            assertEquals(i*10, hist.get(j).getPlannedSteps());
            j--;
        }

    }

    @Test
    public void test_getYesterdayStep(){
        StepHistory stepHistory = new StepHistory();
        int numDays = 7;

        for(int i = 0; i < numDays; i++){
            Day day = new Day((i%7) + 1);
            day.setPlannedSteps(i+1);
            day.setNormalSteps(i);
            stepHistory.updateHist(day);
        }

        assertEquals(stepHistory.getYesterdayStep(), 11);
    }

    @Test
    public void test_setHist(){
        StepHistory stepHistory = new StepHistory();
        int numDays = 28;

        for(int i = 0; i < numDays; i++){
            Day day = new Day(i);
            day.setPlannedSteps(i*10);
            day.setNormalSteps(i*100);
            stepHistory.updateHist(day);
        }

        StepHistory stepHistory2 = new StepHistory();

        stepHistory2.setHist(stepHistory.getHist());

        ArrayList<Day> hist = stepHistory2.getHist();
        int j = numDays-1;
        for(int i = 0; i < numDays; i++){
            assertEquals(i*100, hist.get(j).getNormalSteps());
            assertEquals(i*10, hist.get(j).getPlannedSteps());
            j--;
        }
    }

}