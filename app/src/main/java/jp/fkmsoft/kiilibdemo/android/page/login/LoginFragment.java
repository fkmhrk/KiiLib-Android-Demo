package jp.fkmsoft.kiilibdemo.android.page.login;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import jp.fkmsoft.android.framework.bases.v4.BaseFragment;

import jp.fkmsoft.kiilibdemo.Constants;
import jp.fkmsoft.kiilibdemo.R;
import jp.fkmsoft.kiilibdemo.ViewUtils;
import jp.fkmsoft.kiilibdemo.page.login.LoginApp;
import jp.fkmsoft.kiilibdemo.page.login.LoginUI;
import jp.fkmsoft.libs.kiilib.apis.AppAPI;
import jp.fkmsoft.libs.kiilib.volley.KiiVolleyAPI;

/**
 * Fragment for Login page
 */
public class LoginFragment extends BaseFragment<LoginUI, LoginApp> {
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private RequestQueue mQueue;
    private AppAPI mAppApi;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mQueue = Volley.newRequestQueue(getActivity());
        mAppApi = new KiiVolleyAPI(mQueue, Constants.APP_ID, Constants.APP_KEY, Constants.BASE_URL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        ViewUtils.setClickListener(root, clickListener, R.id.button_login);

        return root;
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
            case R.id.button_login:
                app.performLogin(ui.getEmail(), ui.getPassword());
                break;
            }
        }
    };

    @Override
    protected LoginUI createUI(Context context) {
        return new LoginUIImpl(this);
    }

    @Override
    protected LoginApp createApp(Context context, LoginUI ui) {
        return new LoginAppImpl(ui, mAppApi);
    }

    @Override
    public void onStart() {
        super.onStart();
        mQueue.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        mQueue.stop();
    }
}
