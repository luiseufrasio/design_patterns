package behavioral.strategy.playful;
public abstract class Duck {
    
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    
    public Duck() {}
    
    public abstract void display();
    
    public void performFly() {
        flyBehavior.fly();
    }
    
    public void performQuack() {
        quackBehavior.quack();
    }
    
    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }
    
    public void setFlyBehavior(FlyBehavior f) {
        flyBehavior = f;
    }
    
    public void setQuackBehavior(QuackBehavior q) {
        quackBehavior = q;
    }
}