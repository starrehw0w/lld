package main;

public class Message {

    private final String message;
    private final long timestamp;

    public Message(String message) {
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

}
