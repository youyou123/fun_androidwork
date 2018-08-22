package com.dmxj.smartall.Login.View;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dmxj.smartall.Base.BaseActivity;
import com.dmxj.smartall.R;
import com.yatoooon.screenadaptation.ScreenAdapterTools;

public class LoginActivity extends BaseActivity implements View.OnClickListener {


    private ImageView ivLoginLogo;
    /**
     * 手机号/用户名
     */
    private EditText editLoginUsername;
    /**
     * 请输入密码
     */
    private EditText editLoginPassword;
    private ImageView ivLoginWatchPassword;
    private FrameLayout frameLoginPassword;
    /**
     * 登录
     */
    private TextView tvLoginLogin;
    /**
     * 注册
     */
    private TextView tvLoginRegister;
    private ImageView ivLoginBack;
    /**
     * 第三方登录
     */
    private TextView tvLoginThird;
    private ImageView ivLoginQq;
    private ImageView ivLoginWeibo;
    private ImageView ivLoginWechart;
    private RelativeLayout rlLoginThird;
    private String strUsername;
    private String strPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ScreenAdapterTools.getInstance().loadView(getWindow().getDecorView());
        initView();
    }


    private void initView() {
        ivLoginLogo = (ImageView) findViewById(R.id.iv_login_logo);
        editLoginUsername = (EditText) findViewById(R.id.edit_login_username);
        editLoginPassword = (EditText) findViewById(R.id.edit_login_password);
        ivLoginWatchPassword = (ImageView) findViewById(R.id.iv_login_watch_password);
        ivLoginWatchPassword.setOnClickListener(this);
        frameLoginPassword = (FrameLayout) findViewById(R.id.frame_login_password);
        tvLoginLogin = (TextView) findViewById(R.id.tv_login_login);
        tvLoginLogin.setOnClickListener(this);
        tvLoginRegister = (TextView) findViewById(R.id.tv_login_register);
        tvLoginRegister.setOnClickListener(this);
        ivLoginBack = (ImageView) findViewById(R.id.iv_login_back);
        ivLoginBack.setOnClickListener(this);
        tvLoginThird = (TextView) findViewById(R.id.tv_login_third);
        tvLoginThird.setOnClickListener(this);
        ivLoginQq = (ImageView) findViewById(R.id.iv_login_qq);
        ivLoginQq.setOnClickListener(this);
        ivLoginWeibo = (ImageView) findViewById(R.id.iv_login_weibo);
        ivLoginWeibo.setOnClickListener(this);
        ivLoginWechart = (ImageView) findViewById(R.id.iv_login_wechart);
        ivLoginWechart.setOnClickListener(this);
        rlLoginThird = (RelativeLayout) findViewById(R.id.rl_login_third);
        setOnUserNameAndPassWordChange();

    }

    private void setOnUserNameAndPassWordChange() {
        editLoginUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                strUsername = charSequence.toString();
                if (!TextUtils.isEmpty(strUsername) && !TextUtils.isEmpty(strPassword)) {
                    tvLoginLogin.setSelected(true);
                } else {
                    tvLoginLogin.setSelected(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editLoginPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                strPassword = charSequence.toString();
                if (!TextUtils.isEmpty(strUsername) && !TextUtils.isEmpty(strPassword)) {
                    tvLoginLogin.setSelected(true);
                } else {
                    tvLoginLogin.setSelected(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_login_watch_password:
                if(TextUtils.isEmpty(editLoginPassword.getText().toString())){
                    return;
                }
                if (editLoginPassword.getTransformationMethod() instanceof HideReturnsTransformationMethod) {
                    editLoginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    editLoginPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                break;
            case R.id.tv_login_login:
                break;
            case R.id.tv_login_register:
                Intent goRegister = new Intent(getApplication(), RegisterActivity.class);
                startActivity(goRegister);
                break;
            case R.id.iv_login_back:
                finish();
                break;
            case R.id.tv_login_third:
                if (rlLoginThird.getVisibility() == View.VISIBLE) {
                    rlLoginThird.setVisibility(View.GONE);
                } else {
                    rlLoginThird.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.iv_login_qq:
                break;
            case R.id.iv_login_weibo:
                break;
            case R.id.iv_login_wechart:
                break;
        }
    }
}
