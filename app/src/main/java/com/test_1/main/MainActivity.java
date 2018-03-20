package com.test_1.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.test_1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.ETC)
    CheckBox ETC;

    @BindView(R.id.NXT)
    CheckBox NXT;

    @BindView(R.id.XMR)
    CheckBox XMR;

    @BindView(R.id.DOGE)
    CheckBox DOGE;

    @BindView(R.id.thresh)
    EditText thresh;

    @BindView(R.id.time)
    EditText time;

    @OnClick(R.id.place)
    public void submit(){
        arr[4] = time.getText().toString();
        arr[5] = thresh.getText().toString();

        presenter.onSubmit(arr);
    }

    Unbinder unbinder;
    MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        presenter = new MainPresenterImp(this);

        ETC.setOnCheckedChangeListener(this);
        NXT.setOnCheckedChangeListener(this);
        DOGE.setOnCheckedChangeListener(this);
        XMR.setOnCheckedChangeListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    String arr[] = new String[6];

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.ETC:
                arr[1] = "ETC";
                break;
            case R.id.XMR:
                arr[2] = "XMR";
                break;
            case R.id.NXT:
                arr[0] = "NXT";
                break;
            case R.id.DOGE:
                arr[3] = "DOGE";
                break;
        }
    }

}
