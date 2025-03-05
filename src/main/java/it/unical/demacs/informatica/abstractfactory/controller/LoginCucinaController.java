package it.unical.demacs.informatica.abstractfactory.controller;

import it.unical.demacs.informatica.abstractfactory.database.DBManager;
import it.unical.demacs.informatica.abstractfactory.database.dao.CucinaDao;
import it.unical.demacs.informatica.abstractfactory.database.dao.implJDBC.CucinaDaoJDBC;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginCucinaController {

    private final CucinaDao cucinaDao = new CucinaDaoJDBC(DBManager.getInstance().getConnection());

    @PostMapping("/loginCucina")
    public @ResponseBody
    LoginResponse login(@RequestParam String cucina, @RequestParam String password) {
        boolean isAuthenticated = cucinaDao.verificaCredenziali(cucina, password);
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
