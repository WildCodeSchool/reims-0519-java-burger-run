package com.wildcodeschool.BurgerRun.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.wildcodeschool.BurgerRun.entities.ScoreBDD;

public class SteakScoreRepository {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/burger_run?serverTimezone=GMT";
    private final static String DB_USER = "bigmac";
    private final static String DB_PASSWORD = "BurgerKing4Life!";

    public static List<ScoreBDD> selectAll() {
        try(
            Connection connection = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM score ORDER BY steak_score DESC LIMIT 10;"
            );
            ResultSet resulSet = statement.executeQuery();
        ) {
            List<ScoreBDD> scores = new ArrayList<ScoreBDD>();

            while(resulSet.next()){
                int id = resulSet.getInt("id");
                String nickname = resulSet.getString("nickname");
                int steak_score = resulSet.getInt("steak_score");
                scores.add(new ScoreBDD(id, nickname, steak_score));
            }

            return scores;
        }
        catch (SQLException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "", e
            );
        }
    }

    public static ScoreBDD selectById(int id) {
        try(
            Connection connection = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM score WHERE id=?"
            );
        ) {
            statement.setInt(1, id);

            try(
                ResultSet resulSet = statement.executeQuery();
            ) {
                if(resulSet.next()){
                    String nickname = resulSet.getString("nickname");
                    int steak_score = resulSet.getInt("steak_score");
                    return new ScoreBDD(id, nickname, steak_score);
                }
                else {
                    throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR, "unknown id in table score"
                    );
                }
            }
        }
        catch (SQLException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "", e
            );
        }
    }
    public static int insert(
        String nickname,
        int steak_score
    ) {
        try(
            Connection connection = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO score (nickname, steak_score) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );
        ) {
            statement.setString(1, nickname);
            statement.setInt(2, steak_score);
    
            if(statement.executeUpdate() != 1) {
                throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "failed to insert data"
                );
            }
    
            try(
                ResultSet generatedKeys = statement.getGeneratedKeys();
            ) {
                if(generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
                else {
                    throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR, "failed to get inserted id"
                    );
                }
            }
        }
        catch (SQLException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "", e
            );
        }
    }
}
