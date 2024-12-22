package main;

public class Demo {

    public static void main(String[] args) {

        Topic topic = new Topic("PubSub Demo");

        Publisher publisher = new Publisher("PubSub Demo Publisher");

        OutputSubscriber op1 = new OutputSubscriber("Output1");
        OutputSubscriber op2 = new OutputSubscriber("Output2");

        publisher.register(topic);
        topic.subscribe(op1);
        topic.subscribe(op2);

        Message m1 = new Message("This is published message 1");
        publisher.publish(topic, m1);

        topic.unsubscribe(op2);

        Message m2 = new Message("This is published message 2");
        publisher.publish(topic, m2);
    }
}
