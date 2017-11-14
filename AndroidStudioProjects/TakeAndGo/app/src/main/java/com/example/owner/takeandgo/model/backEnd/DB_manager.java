package com.example.owner.takeandgo.model.backEnd;

import android.content.ContentValues;

import com.example.owner.takeandgo.model.entities.Branch;
import com.example.owner.takeandgo.model.entities.Car;
import com.example.owner.takeandgo.model.entities.CarModel;
import com.example.owner.takeandgo.model.entities.Client;

import java.util.List;

/**
 *
 */

public interface DB_manager {
    //Car
    long addCar(ContentValues car) throws Exception;
    boolean removeCar(long num);
    boolean updateCar(long num, ContentValues values);
    List<Car> getCars();
    //client
    String addClient(ContentValues client);
    boolean removeClient(String id);
    boolean updateClient(String id, ContentValues values);
    List<Client> getClients();
    //branch
    int addBranch(ContentValues branch);
    boolean removeBranch(int num);
    boolean updateBranch(int num, ContentValues values);
    List<Branch> getBranches();
    //model
    int addCarModel(ContentValues model);
    boolean removeCarModel(int num);
    boolean updateCarModel(int num, ContentValues values);
    List<CarModel> getCarModels();

}
