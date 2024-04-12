package org.example;

public class Processing {
    public Message message;
    public Step step;
    public int duration;

    public Processing(Message message, Step step) {
        this.message = message;
        this.step = step;
        this.duration = step.handle(message);
    }
}
