package com.wanyt.androidutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.wanyt.androidutils.utils.CommonUtil;
import com.wanyt.androidutils.utils.UtilsApplication;
import com.wanyt.androidutils.utils.UtilsDevice;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_statusbar_height)
    TextView tvStatusBarHeight;
    @BindView(R.id.tv_isphonesleeping)
    TextView tvIsPhongSleep;
    @BindView(R.id.tv_isfg)
    TextView isFg;
    @BindView(R.id.iv_appicon)
    ImageView ivAppicon;
    @BindView(R.id.tv_appversion)
    TextView tvVersion;
    @BindView(R.id.tv_imei)
    TextView tvIMEI;
    @BindView(R.id.tv_mac)
    TextView tvMac;
    @BindView(R.id.tv_operator)
    TextView tvOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_statusbar_height)
    public void statusbarHeight() {
        tvStatusBarHeight.setText("状态栏高度是：" + CommonUtil.getStatusBarHeight(this) + "px");
    }

    @OnClick(R.id.bt_isphonesleeping)
    public void isPhoneSleeping() {
        tvIsPhongSleep.setText(UtilsApplication.isPhoneSleeping(this) + "");
    }

    @OnClick(R.id.bt_isfg)
    public void isFG() {
        isFg.setText(UtilsApplication.isApplicationBackground(this) ? "应用处于后台" : "应用处于前台");
    }

    @OnClick(R.id.bt_appicon)
    public void getAppIcon() {
        ivAppicon.setBackgroundDrawable(UtilsApplication.getAppIcon(this));
    }

    @OnClick(R.id.bt_opennet)
    public void opennet() {
        UtilsApplication.openURL(this, "http://www.baidu.com");
    }

    @OnClick(R.id.bt_openmap)
    public void openmap() {
        UtilsApplication.showAddressOnMap(this, "北京");
    }

    @OnClick(R.id.bt_showappversion)
    public void appversion() {
        tvVersion.setText(UtilsApplication.getAppVersion(this));
    }

    @OnClick(R.id.bt_imei)
    public void imei() {
        tvIMEI.setText(UtilsDevice.getDeviceIMEI(this) + "");
    }

    @OnClick(R.id.bt_mac)
    public void mac() {
        tvMac.setText(UtilsDevice.getMacAddress(this) + "");
    }

    @OnClick(R.id.bt_operator)
    public void operator() {
        String networkOperator = UtilsDevice.getNetworkOperator(this);
        if (networkOperator.equals("46000") || networkOperator.equals("46002")) {
            tvOperator.setText("中国移动");
        } else if (networkOperator.equals("46001")) {
            tvOperator.setText("中国联通");
        } else if (networkOperator.equals("46003")) {
            tvOperator.setText("中国电信");
        } else {
            tvOperator.setText("UNKNOWN");
        }
    }

}
