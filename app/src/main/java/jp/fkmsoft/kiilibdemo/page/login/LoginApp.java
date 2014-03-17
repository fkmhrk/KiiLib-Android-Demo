package jp.fkmsoft.kiilibdemo.page.login;

import jp.fkmsoft.android.framework.App;

/**
 * App APIs for Login page
 */
public interface LoginApp extends App {
    void performLogin(String email, String password);
}
