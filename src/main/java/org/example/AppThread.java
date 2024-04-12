package org.example;

import java.util.ArrayList;
import java.util.List;

public class AppThread {
    public final List<Processing> processingList = new ArrayList<>();
    public long used = 0;

    public void process(Message message, Step step) {
        var processing = new Processing(message, step);
        processingList.add(processing);
        used += processing.duration;
    }
}
