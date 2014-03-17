package jp.fkmsoft.kiilibdemo.android.page.login;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import jp.fkmsoft.android.framework.bases.v4.BaseUI;
import jp.fkmsoft.android.framework.dialog.v4.ProgressDialogFragment;
import jp.fkmsoft.kiilibdemo.R;
import jp.fkmsoft.kiilibdemo.ViewUtils;
import jp.fkmsoft.kiilibdemo.page.login.LoginUI;

/**
 * Implementation of LoginUI
 */
class LoginUIImpl extends BaseUI<LoginFragment> implements LoginUI{
    LoginUIImpl(LoginFragment fragment) {
        super(fragment);
    }

    @Override
    public String getEmail() {
        return ViewUtils.getValueOfEditText(getRootView(), R.id.edit_email);
    }

    @Override
    public String getPassword() {
        return ViewUtils.getValueOfEditText(getRootView(), R.id.edit_password);
    }

    @Override
    public void showToast(String message) {
        Activity activity = getActivity();
        if (activity == null) { return; }

        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(String message) {
        Fragment fragment = getFragment();
        if (fragment == null) { return; }

        ProgressDialogFragment dialog = ProgressDialogFragment.newInstance(null, message);
        dialog.show(fragment.getFragmentManager(), ProgressDialogFragment.FRAGMENT_TAG);
    }
}
