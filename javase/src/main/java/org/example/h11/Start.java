package org.example.h11;

public class Start {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass outerClass2 = new OuterClass();

        OuterClass.StaticInnerClass stat = new OuterClass.StaticInnerClass();
        stat.method();

        // OuterClass.StaticInnerClass.method();
        OuterClass.StaticInnerClass.staticMethod();

        outerClass.outerMethod();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        OuterClass.InnerClass innerClass1 = outerClass2.new InnerClass();

    }
}
