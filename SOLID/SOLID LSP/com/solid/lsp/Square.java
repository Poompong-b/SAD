package com.solid.lsp;

public class Square implements Shape {
    private int side;

    Square(int side) {
        this.side = side;
    }

    // @Override
    // public void setWidth(int width) {this.setSide(width);
    // }

    // @Override
    // public void setHeight(int height) {
    //     this.setSide(height);
    // }

    public void setSide(int side) {
        // super.setWidth(side);
        // super.setHeight(side);
        this.side = side;
    }

    public int getArea(){
        return side*side;
    }
}
