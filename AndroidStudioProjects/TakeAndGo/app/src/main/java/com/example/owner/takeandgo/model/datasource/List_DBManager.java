package com.example.owner.takeandgo.model.datasource;
import android.content.ContentValues;

import com.example.owner.takeandgo.model.backEnd.DB_manager;
import com.example.owner.takeandgo.model.entities.Branch;
import com.example.owner.takeandgo.model.entities.Car;
import com.example.owner.takeandgo.model.entities.CarModel;
import com.example.owner.takeandgo.model.entities.Client;
import java.util.ArrayList;
import java.util.List;
import static com.example.owner.takeandgo.model.backEnd.AgencyConsts.ContentValuesToBranch;
import static com.example.owner.takeandgo.model.backEnd.AgencyConsts.ContentValuesToCar;
import static com.example.owner.takeandgo.model.backEnd.AgencyConsts.ContentValuesToCarModel;
import static com.example.owner.takeandgo.model.backEnd.AgencyConsts.ContentValuesToClient;

public class List_DBManager implements DB_manager {

    //static lists
    public static List<Car> cars;
    public static List<Branch> branches;
    public static List<CarModel> carModels;
    public static List<Client> clients;

    //static inner class
    static {
        cars = new ArrayList<>();
        branches = new ArrayList<>();
        carModels = new ArrayList<>();
        clients = new ArrayList<>();
    }

    //region car
    @Override
    //add car to cars' list
    public long addCar(ContentValues car) throws Exception {
        Car item = ContentValuesToCar(car);
        if (isExistCar(item.getNumber()))
            throw new Exception ("This car is already exists!!");
        try{ cars.add(item);}
        catch (Exception e){ throw new Exception(e.getMessage());}
        return item.getNumber();
    }

    @Override
    //checks if there is a car with the same number
    public boolean isExistCar(long n) {
        for (Car item : cars)
            if(item.getNumber()==n)
                return true;
        return false;
    }

    @Override
    //returns cars' list
    public List<Car> getCars() {return cars;}
    //endregion

    //region client
    @Override
    //adds client to clients' list
    public String addClient(ContentValues client) throws Exception {
        Client item = ContentValuesToClient(client);
        if (isExistClient(item.getId()))
            throw new Exception("This client is already exists!!");
        try{clients.add(item);}
        catch (Exception e){ throw new Exception(e.getMessage());}
        return item.getId();
    }

    @Override
    //checks if there is a client with that id
    public boolean isExistClient(String i)
    {
        for (Client item : clients)
            if(item.getId()==i)
                return true;
        return false;
    }

    @Override
    //returns clients' list
    public List<Client> getClients() {
        return clients;
    }
    //endregion

    //region branch
    @Override
    //adds branch to branches' list
    public int addBranch(ContentValues branch) throws Exception {
        Branch item = ContentValuesToBranch(branch);
        if (isExistBranch(item.getBranchNumber()))
            throw new Exception("This branch is already exists!!");
        try {branches.add(item);}
        catch (Exception e){ throw new Exception(e.getMessage());}
        return item.getBranchNumber();
    }

    @Override
    //checks if there is a client with that id
    public boolean isExistBranch(int n)
    {
        for (Branch item : branches)
            if(item.getBranchNumber()==n)
                return true;
        return false;
    }

    @Override
    //returns branches' list
    public List<Branch> getBranches() { return branches; }
    //endregion

    //region model
    @Override
    //adds model to car models' list
    public int addCarModel(ContentValues model) throws Exception {
        CarModel item = ContentValuesToCarModel(model);
        if (isExistModel(item.getCode()))
            throw new Exception("This model is already exists!!");
        try {carModels.add(item);}
        catch (Exception e){ throw new Exception(e.getMessage());}
        return item.getCode();
    }

    @Override
    //checks if there is a model with that code
    public boolean isExistModel(int n)
    {
        for (CarModel item : carModels)
            if(item.getCode()==n)
                return true;
        return false;
    }

    @Override
    //returns car models' list
    public List<CarModel> getCarModels() {
        return carModels;
    }

    //endregion

}



