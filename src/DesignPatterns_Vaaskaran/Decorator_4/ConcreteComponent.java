package Decorator;

class ConcreteComponent extends Component {
    @Override
    public void doJob() {
        System.out.println("I am from Concrete Decorator.Component, I am closed for modification.");
    }
}
