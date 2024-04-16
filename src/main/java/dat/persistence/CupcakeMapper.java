package dat.persistence;

import dat.entities.Bottom;
import dat.entities.Top;
import dat.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CupcakeMapper
{
    public static Map<Integer, Top> getTopMap(ConnectionPool connectionPool) throws DatabaseException
    {
        Map<Integer, Top> topMap = new HashMap<>();

        String sql = "SELECT * FROM top";
        try (Connection connection = connectionPool.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                int topId = resultSet.getInt("top_id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                Top top = new Top(topId, name, price);
                topMap.put(topId, top);
            }
        }
        catch (SQLException e)
        {
            throw new DatabaseException("Error getting tops", e.getMessage());
        }
        return topMap;
    }

    public static Map<Integer, Bottom> getBottomMap(ConnectionPool connectionPool) throws DatabaseException
    {
        Map<Integer, Bottom> bottomMap = new HashMap<>();

        String sql = "SELECT * FROM bottom";
        try (Connection connection = connectionPool.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                int bottomId = resultSet.getInt("bottom_id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                Bottom bottom = new Bottom(bottomId, name, price);
                bottomMap.put(bottomId, bottom);
            }
        }
        catch (SQLException e)
        {
            throw new DatabaseException("Error getting bottoms", e.getMessage());
        }
        return bottomMap;
    }
}
