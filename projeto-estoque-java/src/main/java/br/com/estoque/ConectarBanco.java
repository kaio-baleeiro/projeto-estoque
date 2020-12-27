package br.com.estoque;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConectarBanco {
    protected static JdbcTemplate jdbcTemplate;
    protected static BasicDataSource dataSource;

    protected final static String DRIVE = "com.mysql.jdbc.Driver";
    protected final static String URL = "jdbc:mysql://localhost:3306/estoque?useTimezone=true&serverTimezone=UTC";
    protected final static String USERNAME = "Kaio";
    protected final static String PASSWORD = "bandtec";

    public void conectar(){
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DRIVE);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        jdbcTemplate = new JdbcTemplate(dataSource);
        
        System.out.println("Connected database");
    }
}
