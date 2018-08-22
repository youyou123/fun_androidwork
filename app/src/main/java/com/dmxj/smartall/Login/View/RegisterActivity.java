package com.dmxj.smartall.Login.View;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmxj.smartall.Base.BaseActivity;
import com.dmxj.smartall.R;
import com.yatoooon.screenadaptation.ScreenAdapterTools;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mIvRegisterBack;
    private ImageView mIvRegisterLogo;
    /**
     * 手机号/用户名
     */
    private EditText mEditRegisterUsername;
    /**
     * 发送验证码
     */
    private EditText mEditRegisterCode;
    private TextView mTvRegisterSendCode;
    /**
     * 请输入6~12字母/数字
     */
    private EditText mEditRegisterPassword;
    private ImageView mIvRegisterWatchPassword;
    /**
     * 请确认密码
     */
    private EditText mEditRegisterPasswordAgain;
    private ImageView mIvRegisterWatchPasswordAgain;
    /**
     * 注册
     */
    private TextView mTvRegisterRegister;
    private CountDownTimer timer;

    private String strUsername, strPassword, strPasswordAgain, strCode;
    /**
     * 同意《DJ软件及许可证服务协议》
     */
    private CheckBox mCbRegisterXieyi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ScreenAdapterTools.getInstance().loadView(getWindow().getDecorView());
        initView();
    }

    private void initView() {
        mIvRegisterBack = (ImageView) findViewById(R.id.iv_register_back);
        mIvRegisterBack.setOnClickListener(this);
        mIvRegisterLogo = (ImageView) findViewById(R.id.iv_register_logo);
        mEditRegisterUsername = (EditText) findViewById(R.id.edit_register_username);
        mTvRegisterSendCode = (TextView) findViewById(R.id.tv_register_sendCode);
        mTvRegisterSendCode.setOnClickListener(this);
        mEditRegisterPassword = (EditText) findViewById(R.id.edit_register_password);
        mIvRegisterWatchPassword = (ImageView) findViewById(R.id.iv_register_watch_password);
        mIvRegisterWatchPassword.setOnClickListener(this);
        mEditRegisterPasswordAgain = (EditText) findViewById(R.id.edit_register_password_again);
        mIvRegisterWatchPasswordAgain = (ImageView) findViewById(R.id.iv_register_watch_password_again);
        mIvRegisterWatchPasswordAgain.setOnClickListener(this);
        mTvRegisterRegister = (TextView) findViewById(R.id.tv_register_register);
        mTvRegisterRegister.setOnClickListener(this);
        mEditRegisterCode = (EditText) findViewById(R.id.edit_register_code);
        setOnUserNameAndPassWordChange();
        mCbRegisterXieyi = (CheckBox) findViewById(R.id.cb_register_xieyi);
        mCbRegisterXieyi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_register_back:
                finish();
                break;
            case R.id.tv_register_sendCode:
                sendCode();
                break;
            case R.id.iv_register_watch_password:
                if (TextUtils.isEmpty(mEditRegisterPassword.getText().toString())) {
                    return;
                }
                if (mEditRegisterPassword.getTransformationMethod() instanceof HideReturnsTransformationMethod) {
                    mEditRegisterPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    mEditRegisterPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                break;
            case R.id.iv_register_watch_password_again:
                if (TextUtils.isEmpty(mEditRegisterPasswordAgain.getText().toString())) {
                    return;
                }
                if (mEditRegisterPasswordAgain.getTransformationMethod() instanceof HideReturnsTransformationMethod) {
                    mEditRegisterPasswordAgain.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    mEditRegisterPasswordAgain.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                break;
            case R.id.tv_register_register:
                break;
            case R.id.cb_register_xieyi:
                break;
        }
    }

    private void setOnUserNameAndPassWordChange() {
        mEditRegisterUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                strUsername = charSequence.toString();
                if (!TextUtils.isEmpty(strUsername) && !TextUtils.isEmpty(strPassword) && !TextUtils.isEmpty(strPasswordAgain) && !TextUtils.isEmpty(strCode)) {
                    mTvRegisterRegister.setSelected(true);
                    mCbRegisterXieyi.setVisibility(View.VISIBLE);
                } else {
                    mTvRegisterRegister.setSelected(false);
                    mCbRegisterXieyi.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mEditRegisterPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                strPassword = charSequence.toString();
                if (!TextUtils.isEmpty(strUsername) && !TextUtils.isEmpty(strPassword) && !TextUtils.isEmpty(strPasswordAgain) && !TextUtils.isEmpty(strCode)) {
                    mTvRegisterRegister.setSelected(true);
                    mCbRegisterXieyi.setVisibility(View.VISIBLE);
                } else {
                    mTvRegisterRegister.setSelected(false);
                    mCbRegisterXieyi.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mEditRegisterPasswordAgain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                strPasswordAgain = charSequence.toString();
                if (!TextUtils.isEmpty(strUsername) && !TextUtils.isEmpty(strPassword) && !TextUtils.isEmpty(strPasswordAgain) && !TextUtils.isEmpty(strCode)) {
                    mTvRegisterRegister.setSelected(true);
                    mCbRegisterXieyi.setVisibility(View.VISIBLE);
                } else {
                    mTvRegisterRegister.setSelected(false);
                    mCbRegisterXieyi.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mEditRegisterCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                strCode = charSequence.toString();
                if (!TextUtils.isEmpty(strUsername) && !TextUtils.isEmpty(strPassword) && !TextUtils.isEmpty(strPasswordAgain) && !TextUtils.isEmpty(strCode)) {
                    mTvRegisterRegister.setSelected(true);
                    mCbRegisterXieyi.setVisibility(View.VISIBLE);
                } else if (!TextUtils.isEmpty(strCode)) {
                    mTvRegisterSendCode.setSelected(true);
                } else {
                    mCbRegisterXieyi.setVisibility(View.INVISIBLE);
                    mTvRegisterRegister.setSelected(false);
                    mTvRegisterSendCode.setSelected(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private synchronized void sendCode() {
        timer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTvRegisterSendCode.setClickable(false);
                mTvRegisterSendCode.setText("(" + (millisUntilFinished / 1000) + "s)");
                mTvRegisterSendCode.setBackgroundResource(R.drawable.shape_login_edit);
                mTvRegisterSendCode.setTextColor(Color.parseColor("#FF597389"));
            }

            @Override
            public void onFinish() {
                mTvRegisterSendCode.setClickable(true);
                mTvRegisterSendCode.setPressed(false);
                mTvRegisterSendCode.setText("发送验证码");
                mTvRegisterSendCode.setBackgroundResource(R.drawable.sel_login_login);
                if (!TextUtils.isEmpty(mEditRegisterCode.getText().toString())) {
                    mTvRegisterSendCode.setTextColor(Color.parseColor("#FFFFFF"));
                } else {
                    mTvRegisterSendCode.setTextColor(Color.parseColor("#90A3B1"));
                }
            }
        }.start();
    }
}
