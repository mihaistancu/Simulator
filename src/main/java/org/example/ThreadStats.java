package org.example;

import java.util.HashSet;
import java.util.Set;

public class ThreadStats {
    private final AppThread thread;

    public ThreadStats(AppThread thread) {
        this.thread = thread;
    }

    public Set<Message> messagesProcessed(long start, long end) {
        long time = 0;
        Set<Message> messages = new HashSet<>();

        for (Processing processing : thread.processingList) {
            if (time >= start && time + processing.duration <= end) {
                messages.add(processing.message);
            }
            time += processing.duration;
        }

        return messages;
    }
}
