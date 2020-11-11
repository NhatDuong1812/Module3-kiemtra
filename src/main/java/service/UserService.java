package service;

import controller.ConnectDB;
import model.Produce;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {


    public boolean addProduce(Produce produce) {

        boolean isADDed = false;
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "insert into procducelist(id,name,prime,quantity,color,status)" + "values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, produce.getId());
            ps.setString(2, produce.getName());
            ps.setString(3, produce.getPrime());
            ps.setString(4, produce.getQuantity());
            ps.setString(5, produce.getColor());
            ps.setString(6, produce.getStatus());
            isADDed = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isADDed;
    }

    public boolean updateProduce(Produce produce) {
        boolean isUpdated = false;
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "update [users] set username = ?,password = ?,fullname = ?,email = ?" + "where user_id =?";


        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(6, produce.getId());
            ps.setString(1, produce.getName());
            ps.setString(2, produce.getPrime());
            ps.setString(3, produce.getQuantity());
            ps.setString(4, produce.getColor());
            ps.setString(5, produce.getStatus());

            isUpdated = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    public boolean deleteUser(Produce produce) {
        boolean isDeleted = false;

        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "DELETE FROM users WHERE user_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, produce.getId());
            isDeleted = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    public List<Produce> showAll() {
        List<Produce> list = new ArrayList<>();
        try {
            Connection connection = ConnectDB.getInstance().getConnection();
            String sql = "select *from producelist";
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String prime = rs.getString(3);
                String quantity = rs.getString(4);
                String color = rs.getString(5);
                String status = rs.getString(6);
                Produce produce = new Produce(id);
                list.add(produce);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
