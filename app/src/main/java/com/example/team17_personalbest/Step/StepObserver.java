package com.example.team17_personalbest.Step;

import com.example.team17_personalbest.User;

import java.util.Calendar;

public interface StepObserver {
    public void updateSteps(int steps, User user, Calendar calendar);
}
