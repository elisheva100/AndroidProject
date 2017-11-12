package com.example.owner.takeandgo.model.backEnd;

import android.content.ContentValues;

import com.example.owner.takeandgo.model.entities.Branch;
import com.example.owner.takeandgo.model.entities.Car;
import com.example.owner.takeandgo.model.entities.CarModel;
import com.example.owner.takeandgo.model.entities.Client;
import com.example.owner.takeandgo.model.entities.Order;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Created by Owner on 11/11/2017.
 */

//TODO: Take care of casting all the formats like: dates, enums and classes
public class AgencyConsts {
    public static class BranchConst {
        public static final String ADRESS = "adress";
        public static final String PARKING = "parking";
        public static final String BRANCH_NUMBER = "branchNumber";

    }
    public static class CarConst {
        public static final String BRANCH_NUMBER = "branchNumber";
        public static final String MODEL_TYPE = "modelType";
        public static final String MILEAGE= "mileage";
        public static final String NUMBER = "number";
    }
    public static class CarModelConst {
        public static final String CODE = "code";
        public static final String COMPANY_NAME = "companyName";
        public static final String MODEL_NAME = "modelName";
        public static final String ENGINE_CAPACITY = "engineCapacity";
        public static final String GEARBOX = "gearbox";
        public static final String SEATS = "seats";
    }
    public static class ClientConst {
        public static final String FIRST_NAME = "firstName";
        public static final String lAST_NAME = "lastName";
        public static final String ID = "_id";
        public static final String EMAIL = "email";
        public static final String CREDIT_CARD = "creditCard";
        public static final String BIRTHDAY = "birthday";
    }
    public static class OrderConst {
        public static final String CLIENT_NUMBER = "clientNumber";
        public static final String OPEN = "open";
        public static final String CAR_NUMBER = "carNumber";
        public static final String RENT_START = "rentStart";
        public static final String RENT_END = "rentEnd";
        public static final String MILEAGE_START = "mileageStart";
        public static final String MILEAGE_END = "mileageEnd";
        public static final String GAS_FILLED = "gasFilled";
        public static final String GAS_LITERS = "gasLiters";
        public static final String FINAL_BILLING= "finalBilling";
        public static final String ORDER_NUMBER= "orderNumber";
    }
    public static ContentValues BranchToContentValues(Branch branch) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(BranchConst.ADRESS, String.valueOf(branch.getAdress()));
        contentValues.put(BranchConst.PARKING, branch.getParking());
        contentValues.put(BranchConst.BRANCH_NUMBER, branch.getBranchNumber());

        return contentValues;
    }
    public static ContentValues CarToContentValues(Car car) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(CarConst.BRANCH_NUMBER,car.getBranchNumber());
        contentValues.put(CarConst.MODEL_TYPE, car.getModelType());
        contentValues.put(CarConst.MILEAGE, car.getMileage());
        contentValues.put(CarConst.NUMBER, car.getNumber());

        return contentValues;
    }
    public static ContentValues CarModelToContentValues(CarModel carModel) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(CarModelConst.CODE,carModel.getCode());
        contentValues.put(CarModelConst.COMPANY_NAME,carModel.getCompanyName());
        contentValues.put(CarModelConst.MODEL_NAME,carModel.getModelName());
        contentValues.put(CarModelConst.ENGINE_CAPACITY,carModel.getEngineCapacity());
        contentValues.put(CarModelConst.GEARBOX, String.valueOf(carModel.getGearbox()));
        contentValues.put(CarModelConst.SEATS,carModel.getSeats());
        return contentValues;
    }
    public static ContentValues ClientToContentValues(Client client) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ClientConst.FIRST_NAME, client.getFirstName());
        contentValues.put(ClientConst.lAST_NAME, client.getLastName());
        contentValues.put(ClientConst.ID, client.getId());
        contentValues.put(ClientConst.EMAIL, client.getEmail());
        contentValues.put(ClientConst.CREDIT_CARD, client.getCreditCard());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // like MySQL Format
        String dateString = contentValues.getAsString(ClientConst.BIRTHDAY);
        try {
            client.setBirthday(dateFormat.parse(dateString));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return contentValues;
    }
    public static ContentValues OrderToContentValues(Order order) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(OrderConst.CLIENT_NUMBER, order.getClientNumber());
        contentValues.put(OrderConst.OPEN, order.isOpen());
        contentValues.put(OrderConst.CAR_NUMBER, order.getCarNumber());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // like MySQL Format
        String dateStartString = contentValues.getAsString(OrderConst.RENT_START);
        try {
            order.setRentStart(dateFormat.parse(dateStartString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String dateEndString = contentValues.getAsString(OrderConst.RENT_END);
        try {
            order.setRentEnd(dateFormat.parse(dateEndString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        contentValues.put(OrderConst.MILEAGE_START, order.getMileageStart());
        contentValues.put(OrderConst.MILEAGE_END, order.getMileageEnd());
        contentValues.put(OrderConst.GAS_FILLED, order.isGasFilled());
        contentValues.put(OrderConst.GAS_LITERS, order.getGasLiters());
        contentValues.put(OrderConst.FINAL_BILLING, order.getFinalBilling());
        contentValues.put(OrderConst.ORDER_NUMBER, order.getOrderNumber());



        return contentValues;
    }
}