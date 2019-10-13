package com.example.lab02_4;

public class FullTimeEmployees extends Employees {
    @Override
    public double tinhLuong()
    {
        return 500;
    }

    @Override
    public String toString()
    {
        // TODO Auto-generated method stub
        return super.toString() + " --> FullTime=" + tinhLuong();
    }

    }


