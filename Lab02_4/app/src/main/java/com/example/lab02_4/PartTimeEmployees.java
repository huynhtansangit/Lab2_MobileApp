package com.example.lab02_4;

public class PartTimeEmployees  extends Employees
{
    @Override
    public double tinhLuong() {
        // TODO Auto-generated method stub
        return 150;     }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + " --> PartTime=" + tinhLuong();
    }
}
