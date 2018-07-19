package com.lubanjianye.biaoxuntong.ui.main.user;

import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lubanjianye.biaoxuntong.R;
import com.lubanjianye.biaoxuntong.base.BaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Author: lunious
 * Date: 2018/7/14 13:54
 * Description:
 */
public class UserFragment extends BaseFragment {
    @BindView(R.id.ll_qiandao)
    LinearLayout llQiandao;
    @BindView(R.id.main_bar_name)
    TextView mainBarName;
    @BindView(R.id.message_num)
    TextView messageNum;
    @BindView(R.id.ll_message)
    LinearLayout llMessage;
    @BindView(R.id.img_user_avatar)
    CircleImageView imgUserAvatar;
    @BindView(R.id.tv_user_name)
    AppCompatTextView tvUserName;
    @BindView(R.id.tv_user_company)
    AppCompatTextView tvUserCompany;
    @BindView(R.id.ic_erweima)
    ImageView icErweima;
    @BindView(R.id.rl_login)
    RelativeLayout rlLogin;
    @BindView(R.id.img_default_avatar)
    CircleImageView imgDefaultAvatar;
    @BindView(R.id.tv_default_name)
    AppCompatTextView tvDefaultName;
    @BindView(R.id.rl_no_login)
    RelativeLayout rlNoLogin;
    @BindView(R.id.ll_account)
    LinearLayout llAccount;
    @BindView(R.id.ll_share)
    LinearLayout llShare;
    @BindView(R.id.ll_company)
    LinearLayout llCompany;
    @BindView(R.id.ll_helper)
    LinearLayout llHelper;
    @BindView(R.id.ll_setting)
    LinearLayout llSetting;
    @BindView(R.id.ll_questions)
    LinearLayout llQuestions;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initEnvent(Bundle savedInstanceState) {

    }


    @OnClick({R.id.ll_qiandao, R.id.ll_message, R.id.ll_account, R.id.ll_share, R.id.ll_company, R.id.ll_helper, R.id.ll_setting, R.id.ll_questions})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_qiandao:
                break;
            case R.id.ll_message:
                break;
            case R.id.ll_account:
                break;
            case R.id.ll_share:
                break;
            case R.id.ll_company:
                break;
            case R.id.ll_helper:
                break;
            case R.id.ll_setting:
                break;
            case R.id.ll_questions:
                break;
        }
    }
}
