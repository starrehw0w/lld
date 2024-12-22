package main;

public class OutputSubscriber implements Subscriber {

    private String name;

    public OutputSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void consume(Message message) {
        System.out.println(
            "Subscriber : " + this.name + " // " + "Message : " + message.getMessage()
        );
    }
}
