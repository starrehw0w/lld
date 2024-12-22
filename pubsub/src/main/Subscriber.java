package main;

import java.util.HashSet;

public interface Subscriber {

    public void consume(Message message);
}
