package jp.fkmsoft.kiilibdemo.page.login;

import jp.fkmsoft.android.framework.UI;

/**
 * UI APIs for Login page
 */
public interface LoginUI extends UI {
    String getEmail();

    String getPassword();

    void showToast(String message);

    void showProgress(String message);

    void hideProgress();
}
