package jp.fkmsoft.kiilibdemo.android.page.login;

import jp.fkmsoft.android.framework.bases.BaseApp;
import jp.fkmsoft.kiilibdemo.android.utils.AppUtils;
import jp.fkmsoft.kiilibdemo.page.login.LoginApp;
import jp.fkmsoft.kiilibdemo.page.login.LoginUI;
import jp.fkmsoft.libs.kiilib.apis.AppAPI;
import jp.fkmsoft.libs.kiilib.entities.KiiUser;

/**
 * Implementation of LoginApp
 */
class LoginAppImpl extends BaseApp<LoginUI> implements LoginApp{

    private AppAPI mAppApi;

    LoginAppImpl(LoginUI ui, AppAPI appAPI) {
        super(ui);
        this.mAppApi = appAPI;
    }

    @Override
    public void performLogin(String email, String password) {
        if (AppUtils.isEmpty(email)) {
            return;
        }
        if (AppUtils.isEmpty(password)) {
            return;
        }

        // login and get token

        ui.showProgress("Login Demo application");

        mAppApi.loginAsUser(email, password, new AppAPI.LoginCallback() {
            @Override
            public void onSuccess(String token, KiiUser user) {
                ui.hideProgress();
                ui.showToast("Login is succeeded!");
            }

            @Override
            public void onError(int status, String body) {
                ui.hideProgress();
                ui.showToast("Login is failed status=" + status);
            }
        });
    }
}
