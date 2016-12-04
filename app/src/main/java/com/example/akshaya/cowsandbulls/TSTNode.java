package com.example.akshaya.cowsandbulls;

/**
 * Created by sivagami on 21/9/16.
 */

public class TSTNode {

    char data;
    public boolean isEnd;
    TSTNode left, middle, right;

    public TSTNode(char data) {
        this.data = data;
        this.isEnd = false;
        this.left = null;
        this.middle = null;
        this.right = null;
    }
}
