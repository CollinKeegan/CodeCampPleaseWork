package org.firstinspires.ftc.teamcode.teamcode.Utilities.Loggers;

import java.util.ArrayList;

public class TestWriter implements LogWriter {

    private java.util.List<String> lines = new ArrayList<>();
    private boolean stopCalled;

    public TestWriter(){
        stopCalled = false;
    }

    public void writeLine(String line){
        lines.add(line);
    }

    public java.util.List<String> getLines(){
        return lines;
    }

    public void stop(){
        stopCalled = true;
    }

    public boolean isStopCalled(){
        return stopCalled;
    }

}
