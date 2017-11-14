package com.example.owner.takeandgo.controller;
import com.example.owner.takeandgo.model.entities.Car;
import java.util.ArrayList;
import java.util.List;
import com.example.owner.takeandgo.model.backEnd.AgencyConsts;
import com.example.owner.takeandgo.model.datasource.List_DBManager;
import com.example.owner.takeandgo.model.backEnd.DB_manager;
/**
 * Created by תאיר on 14/11/2017.
 */

public class program {


    public static void main(String[] args)
    {
        Car c1=new Car (12,44,45,67);
       Car c2 = new Car (1355,3454,4,5);
        List<Car> list1 = new ArrayList<>();;
        //list1.addCar(CarToContentValue(c1));
        list1.add(c2);
            System.out.println("yshhh");
        System.out.println("tair");
    }
}
