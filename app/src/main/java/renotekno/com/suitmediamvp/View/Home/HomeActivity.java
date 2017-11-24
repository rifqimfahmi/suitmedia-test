package renotekno.com.suitmediamvp.View.Home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.Data.User.User;
import renotekno.com.suitmediamvp.MvpApp;
import renotekno.com.suitmediamvp.R;
import renotekno.com.suitmediamvp.Util.CommonUtils;
import renotekno.com.suitmediamvp.View.Base.BaseActivity;
import renotekno.com.suitmediamvp.View.Status.StatusActivity;

public class HomeActivity extends BaseActivity implements HomeMvpView{

    @BindView(R.id.nextBtn)
    Button mNextBtn;
    @BindView(R.id.nameInput)
    TextView mNameInput;

    HomePresenter homePresenter;

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        AppDataManager appDataManager = ((MvpApp) getApplication()).getAppDataManager();
        homePresenter = new HomePresenter(appDataManager);
        homePresenter.onAttach(this);
    }

    @OnClick (R.id.nextBtn)
    public void onNextBtnClick() {
        String name = mNameInput.getText().toString();

        if (!CommonUtils.isNameValid(name)) {
            Toast.makeText(this, R.string.invalid_empty_name, Toast.LENGTH_SHORT).show();
            return;
        }

        openUserActivity(name);
    }

    @Override
    public void openUserActivity(String name) {
        Intent intent = StatusActivity.getStartIntent(this);
        intent.putExtra(User.CHOOSED_NAME, name);
        startActivity(intent);
    }
}
