package com.kalkulatorek.lukasz.kalkulatorek;

/**
 * Created by Lukasz on 2016-12-15.
 */
public class Addition implements MathematicalOperation {
    private final String operationType="+";

    @Override
    public float Calculate(float x, float y)
    {
        return x+y;
    }

    @Override
    public String GetOperationType()
    {
        return operationType;
    }
}
