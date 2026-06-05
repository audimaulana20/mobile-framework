package automation.module.login;

import automation.base.BaseSteps;

public interface LoginSteps extends BaseSteps {

    void loginToApp(String username, String password);
}