package com.example.owner.takeandgo.model.backEnd;
import android.content.ContentValues;
import com.example.owner.takeandgo.model.entities.Branch;
import com.example.owner.takeandgo.model.entities.Car;
import com.example.owner.takeandgo.model.entities.CarModel;
import com.example.owner.takeandgo.model.entities.Client;
import java.util.ArrayList;
import java.util.List;
//import static com.example.owner.takeandgo.model.backEnd.AgencyConst.CarToContentValues;


public class List_DBManager implements DB_manager{

    //static lists
    static List<Car> cars;
    static List<Branch> branches;
    static List<CarModel> carModels;
    static List<Client> clients;

    //static inner class
    static {
        cars = new ArrayList<>();
        branches = new ArrayList<>();
        carModels = new ArrayList<>();
        clients = new ArrayList<>();
    }

    //car***********
    @Override
    //add car to cars' list
    public long addCar(ContentValues car) {
        Car item = null;//ContentValuesToCar(car);//TODO: to create this func
        cars.add(item);
        return item.getNumber();
    }

    @Override
    //removes car from cars' list
    public boolean removeCar(long num) {
        Car carToRemove = null;
        for (Car item : cars) //search for item with the same number
            if (item.getNumber() == num) {
                carToRemove = item;
                break;
            }
        return cars.remove(carToRemove);
    }

    @Override
    //updates item in cars' list
    public boolean updateCar(long num, ContentValues values) {
        Car car = null;//ContentValuesToCar(values); //sets car details
        car.setNumber(num);
        for (int i = 0; i < cars.size(); i++)
            if (cars.get(i).getNumber() == num) {
                cars.set(i,car);
                return true; //Return true if the update succeeded
            }
        return false; //Returns false if the update failed
    }

    @Override
    //returns cars' list
    public List<Car> getCars() {
        return cars;
    }

    //client**************
    @Override
    //adds client to clients' list
    public String addClient(ContentValues client) {
        Client item = null;//ContentValuesToClient(client);//TODO: to create this func
        clients.add(item);
        return item.getId();
    }

    @Override
    //removes client from the list
    public boolean removeClient(String id) {
        Client clientToRemove = null;
        for (Client item : clients) //search for item with the same number
            if (item.getId() == id) {
                clientToRemove = item;
                break;
            }
        return clients.remove(clientToRemove);
    }

    @Override
    //updates item in clients' list
    public boolean updateClient(String id, ContentValues values) {
        Client client = null;//ContentValuesToClient(values); //sets client details
        client.setId(id);
        for (int i = 0; i < clients.size(); i++)
            if (clients.get(i).getId() == id) {
                clients.set(i,client);
                return true; //Return true if the update succeeded
            }
        return false; //Returns false if the update failed
    }

    @Override
    //returns clients' list
    public List<Client> getClients() {
        return clients;
    }

    //branch*************
    @Override
    //adds branch to branches' list
    public int addBranch(ContentValues branch) {
        Branch item = null;//ContentValuesToBranch(branch);//TODO: to create this func
        branches.add(item);
        return item.getBranchNumber();
    }

    @Override
    //removes branch from branches' list
    public boolean removeBranch(int num) {
        Branch branchToRemove = null;
        for (Branch item : branches) //search for item with the same number
            if (item.getBranchNumber() == num) {
                branchToRemove = item;
                break;
            }
        return branches.remove(branchToRemove);
    }

    @Override
    //updates item in branches' list
    public boolean updateBranch(int num, ContentValues values) {
        Branch branch = null;//ContentValuesToBranch(values); //sets branch details
        branch.setBranchNumber(num);
        for (int i = 0; i < branches.size(); i++)
            if (branches.get(i).getBranchNumber() == num) {
                branches.set(i,branch);
                return true; //Return true if the update succeeded
            }
        return false; //Returns false if the update failed
    }

    @Override
    //returns branches' list
    public List<Branch> getBranches() { return branches; }

    //model**********
    @Override
    //adds model to car models' list
    public int addCarModel(ContentValues model) {
        CarModel item = null;//ContentValuesToCarModel(model); //TODO: to create this func
        carModels.add(item);
        return item.getCode();
    }

    @Override
    //removes model from car models' list
    public boolean removeCarModel(int num) {
        CarModel carModelToRemove = null;
        for (CarModel item : carModels) //search for item with the same number
            if (item.getCode() == num) {
                carModelToRemove = item;
                break;
            }
        return cars.remove(carModelToRemove);
    }

    @Override
    //updates item in car models' list
    public boolean updateCarModel(int num, ContentValues values) {
        CarModel carModel = null;//ContentValuesToCarModel(values); //sets car model details
        carModel.setCode(num);
        for (int i = 0; i < carModels.size(); i++)
            if (carModels.get(i).getCode() == num) {
                carModels.set(i,carModel);
                return true; //Return true if the update succeeded
            }
        return false; //Returns false if the update failed
    }

    @Override
    //returns car models' list
    public List<CarModel> getCarModels() {
        return carModels;
    }
}
