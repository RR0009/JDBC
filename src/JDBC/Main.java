package JDBC;


import lombok.SneakyThrows;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Class.forName("com.mysql.cj.jdbc.Driver");


        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/hibernateDbCar", "root", "King0009");

        CallableStatement callableStatement = connection.prepareCall("select * from my_Car");

       ResultSet resultSet = callableStatement.executeQuery();
       List<Car> cars = new ArrayList<>();

       while (resultSet.next()) {
            int anInt = resultSet.getInt(1);
            String anString = resultSet.getString(2);
            cars.add(new Car(anInt, anString));

        }
        System.out.println(cars);


        connection.close();
    }
}





