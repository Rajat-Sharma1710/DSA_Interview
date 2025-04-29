package com.trees.binarySearchTrees;

import com.sun.security.jgss.GSSUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.trees.binarySearchTrees.Node.construct;

public class TargetSumPair {
    public static void main(String[] args) {
        Student stu = new Student();
        Class cl = stu.getClass();

//        System.out.println(cl.getName());
//
//        Method[] methodArray = cl.getDeclaredMethods();
//        for(Method method: methodArray){
//            System.out.println(method.getName());
//        }

        Student stu1 = new Student();
        Class c2 = stu1.getClass();

        System.out.println(cl == c2);
    }
}

class Student {
    int roll_no;
    String name;

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Dog {
    String name;
    float barkingSound;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBarkingSound() {
        return barkingSound;
    }

    public void setBarkingSound(float barkingSound) {
        this.barkingSound = barkingSound;
    }
}