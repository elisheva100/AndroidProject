package com.example.owner.takeandgo.model.backEnd;

import android.content.ContentValues;

import com.example.owner.takeandgo.model.entities.Branch;
import com.example.owner.takeandgo.model.entities.Car;
import com.example.owner.takeandgo.model.entities.CarModel;
import com.example.owner.takeandgo.model.entities.Client;

import java.util.List;

/**
 * The interface contains definitions of system management functions
 */

public interface DB_manager {
    //region Car
    long addCar(ContentValues car) throws Exception;
    boolean isExistCar(long n);
    List<Car> getCars();
    //endregion

    //region client
    String addClient(ContentValues client) throws Exception;
    boolean isExistClient(String i);
    List<Client> getClients();
    //endregion

    //region branch
    int addBranch(ContentValues branch) throws Exception;
    boolean isExistBranch(int n);
    List<Branch> getBranches();
    //endregion

    //region model
    int addCarModel(ContentValues model) throws Exception;
    boolean isExistModel(int n);
    List<CarModel> getCarModels();
    //endregion

}
