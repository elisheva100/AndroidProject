package com.example.owner.takeandgo.model.datasource;

import android.content.ContentValues;
import android.util.Log;

import com.example.owner.takeandgo.model.backEnd.DB_manager;
import com.example.owner.takeandgo.model.backEnd.AgencyConsts;
import com.example.owner.takeandgo.model.entities.Branch;
import com.example.owner.takeandgo.model.entities.Car;
import com.example.owner.takeandgo.model.entities.CarModel;
import com.example.owner.takeandgo.model.entities.Client;

import org.json.JSONArray;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TODO continue that process : creare sql for table
public class MySQL_DBManager implements DB_manager {

    private final String UserName="taicohen";
    private final String WEB_URL = "http://"+UserName+".vlab.jct.ac.il/php_files/"; //TODO i am not sure that this is the correct url

    private boolean updateFlag = false;
    private void SetUpdate() { updateFlag = true; }

    public void printLog(String message) { Log.d(this.getClass().getName(),"\n"+message); }

    public void printLog(Exception message) { Log.d(this.getClass().getName(),"Exception-->\n"+message); }

    //region car
    @Override
    public long addCar(ContentValues car) throws Exception {
        try {
            String result = PHPtools.POST(WEB_URL + "/add_car.php", car);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addCar:\n" + result);
            return id;
        } catch (IOException e) {
            printLog("addCar Exception:\n" + e);
            return -1;
        }
    }

    @Override
    public List<Car> getCars() {
        List<Car> result = new ArrayList<Car>();

        try {
            String str = PHPtools.GET(WEB_URL + "/get_cars.php");
            JSONArray array = new JSONObject(str).getJSONArray("cars");

            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                ContentValues contentValues = PHPtools.JsonToContentValues(jsonObject);
                Car car = AgencyConsts.ContentValuesToCar(contentValues);
                result.add(car);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //endregion

    //region client
    @Override
    public String addClient(ContentValues client) throws Exception {
        try {
            String result = PHPtools.POST(WEB_URL + "/add_client.php", client);
            //long id = Long.parseLong(result);
            if (result != null)
                SetUpdate();
            printLog("addClient:\n" + result);
            return result;
        } catch (IOException e) {
            printLog("addClient Exception:\n" + e);
            return null;
        }
    }

    @Override
    public boolean isExistClient(String i) { //TODO this func- have to create php for it
        return false;
    }

    @Override
    public List<Client> getClients() {
        List<Client> result = new ArrayList<Client>();
        try {
            String str = PHPtools.GET(WEB_URL + "/get_client.php");
            JSONArray array = new JSONObject(str).getJSONArray("clients");

            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                ContentValues contentValues = PHPtools.JsonToContentValues(jsonObject);
                Client client = AgencyConsts.ContentValuesToClient(contentValues);
                result.add(client);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //endregion

    //region branch
    @Override
    public int addBranch(ContentValues branch) throws Exception {
        try {
            String result = PHPtools.POST(WEB_URL + "/add_branch.php", branch);
            int id = Integer.parseInt(result);
            if (id > 0)
                SetUpdate();
            printLog("addBranch:\n" + result);
            return  id;
        } catch (IOException e) {
            printLog("addBranch Exception:\n" + e);
            return -1;
        }
    }

    @Override
    public List<Branch> getBranches() {
        List<Branch> result = new ArrayList<Branch>();
        try {
            String str = PHPtools.GET(WEB_URL + "/get_Branches.php");
            JSONArray array = new JSONObject(str).getJSONArray("branches");

            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                ContentValues contentValues = PHPtools.JsonToContentValues(jsonObject);
                Branch branch = AgencyConsts.ContentValuesToBranch(contentValues);
                result.add(branch);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //endregion

    //region car model
    @Override
    public int addCarModel(ContentValues model) throws Exception {
        try {
            String result = PHPtools.POST(WEB_URL + "/add_car_model.php", model);
            int id = Integer.parseInt(result);
            if (id > 0)
                SetUpdate();
            printLog("addCar:\n" + result);
            return id;
        } catch (IOException e) {
            printLog("addCar Exception:\n" + e);
            return -1;
        }
    }

    @Override
    public List<CarModel> getCarModels() {
        List<CarModel> result = new ArrayList<CarModel>();
        try {
            String str = PHPtools.GET(WEB_URL + "/get_carModels.php");
            JSONArray array = new JSONObject(str).getJSONArray("carModels");

            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                ContentValues contentValues = PHPtools.JsonToContentValues(jsonObject);
                CarModel carModel = AgencyConsts.ContentValuesToCarModel(contentValues);
                result.add(carModel);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //endregion
}
