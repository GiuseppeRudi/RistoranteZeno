package it.unical.demacs.informatica.abstractfactory.controller;


import it.unical.demacs.informatica.abstractfactory.database.DBManager;
import it.unical.demacs.informatica.abstractfactory.database.dao.TavoloDA0;
import it.unical.demacs.informatica.abstractfactory.database.dao.implJDBC.TavoloDA0JDBC;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final TavoloDA0 tavolodao = new TavoloDA0JDBC(DBManager.getInstance().getConnection());

    @PostMapping("/login")
    public @ResponseBody
    LoginResponse login(@RequestParam String numeroTavolo, @RequestParam String password) {
        boolean isAuthenticated = tavolodao.verificaCredenziali(numeroTavolo, password);
        if (isAuthenticated) {
            return new LoginResponse(true);
        } else {
            return new LoginResponse(false);
        }
    }

    public static class LoginResponse {
        private boolean success;

        public LoginResponse(boolean success) {
            this.success = success;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }
    }
}