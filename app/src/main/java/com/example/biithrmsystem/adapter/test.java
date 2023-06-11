package com.example.biithrmsystem.adapter;

public interface test {
    void sum();

    void add();

}

abstract class Naju {
    abstract void sum();

    abstract int sum1();

    void sss() {

    }
}


class Saifu implements test {

    @Override
    public void sum() {

    }

    @Override
    public void add() {

    }
}

class attif extends Naju {
    @Override
    void sum() {

    }

    @Override
    int sum1() {
        return 0;
    }
}