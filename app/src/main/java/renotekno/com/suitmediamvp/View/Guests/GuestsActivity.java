package renotekno.com.suitmediamvp.View.Guests;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.Data.Guest.Adapter.GuestsAdapter;
import renotekno.com.suitmediamvp.Data.Guest.Model.Guest;
import renotekno.com.suitmediamvp.Data.User.User;
import renotekno.com.suitmediamvp.MvpApp;
import renotekno.com.suitmediamvp.R;
import renotekno.com.suitmediamvp.View.Base.BaseActivity;

public class GuestsActivity extends BaseActivity implements GuestsMvpView {

    GuestsPresenter mGuestsPresenter;

    @BindView(R.id.guestsList)
    RecyclerView mGuestsList;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.emptyView)
    LinearLayout mEmptyView;

    public static final int CHOOSE_REQ_REQ = 4;
    public static final int CHOOSE_REQ_RES = 4200;
    public static final int CHOOSE_LOADER_ID = 41;

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, GuestsActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guests);
        ButterKnife.bind(this);

        AppDataManager appDataManager = ((MvpApp) getApplication()).getAppDataManager();
        mGuestsPresenter = new GuestsPresenter(appDataManager, this);
        mGuestsPresenter.onAttach(this);
        mGuestsPresenter.configRecyclerView();
        mGuestsPresenter.loadGuestsData(this);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mGuestsPresenter.reloadData(GuestsActivity.this);
            }
        });
    }

    @Override
    public void initRecyclerView(GridLayoutManager gridLayoutManager, GuestsAdapter guestsAdapter) {
        mGuestsList.setHasFixedSize(true);
        mGuestsList.setLayoutManager(gridLayoutManager);
        mGuestsList.setAdapter(guestsAdapter);
    }

    @Override
    public void guestChoosed(Guest guest) {
        Intent intent = new Intent();
        intent.putExtra(User.CHOOSED_GUEST_NAME, guest.getName());
        intent.putExtra(User.CHOOSED_GUEST_TOAST, guest.getToastText());
        setResult(GuestsActivity.CHOOSE_REQ_RES, intent);
        finish();
    }

    @Override
    public void showLoadingIndicator() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void showErrorToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoadingIndicator() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void notifyDataLoaded() {
        mGuestsList.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showEmptyView() {
        mEmptyView.setVisibility(View.VISIBLE);
        mGuestsList.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideEmptyView() {
        mEmptyView.setVisibility(View.INVISIBLE);
        mGuestsList.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean isEmptyView() {
        return mGuestsList.getVisibility() == View.INVISIBLE;
    }

}
