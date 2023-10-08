package com.example.springconcepts.dynamic_proxy;

public class FairImpl implements Fair{
    @Override
    public void beerStall(Visitor visitor) {
        visitor.getStuff("beer");
    }

    @Override
    public void alcoholStall(Visitor visitor) {
        visitor.getStuff("alcohol");
    }

    @Override
    public void cigaretteStall(Visitor visitor) {
        visitor.getStuff("cigarette");
    }
}
