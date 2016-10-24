package co.simplon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class Main {

    static String databaseUrl = "jdbc:oracle:thin:SIMPLON/SIMPLON@LOCALHOST:1521:XE";

    static String requeteSql = "SELECT job, avg(sal) AS salaire_moyen FROM emp GROUP BY job";
    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new OracleDriver());

        Connection connexion = DriverManager.getConnection(databaseUrl);
        Statement requete = connexion.createStatement();
        ResultSet resultat = requete.executeQuery(requeteSql);
        while (resultat.next()) {
            String chain = resultat.getString("job");
            System.out.println(chain);
        }
        resultat.close();
        requete.close();
        connexion.close();
    }
}
