package com.dragonforest.app.module3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dragonforest.app.common.beans.Modules;
import com.dragonforest.app.common.beans.Targets;
import com.dragonforest.app.common.util.NavigationUtil;
import com.dragonforest.app.modulecommnication.annotations.Module3;
import com.dragonforest.app.modulecommnication.utils.ModuleConfigurationManager;

@Module3
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        int i = v.getId();
        if (i == R.id.btn_goto_module1) {
            NavigationUtil.getInstance()
                    .with(this)
                    .module(Modules.MODULE_MODULE1)
                    .setTarget(Targets.TARGET_MODULE1_MAINACTIVITY)
                    .go();

        } else if (i == R.id.btn_goto_module2) {
            NavigationUtil.getInstance()
                    .with(this)
                    .module(Modules.MODULE_MODULE2)
                    .setTarget(Targets.TARGET_MODULE2_MAINACTIVITY)
                    .go();

        } else if (i == R.id.btn_goto_app) {
            NavigationUtil.getInstance()
                    .with(this)
                    .module(Modules.MODULE_APP)
                    .setTarget(Targets.TARGET_APP_MAINACTIVITY)
                    .go();

        }else if (i == R.id.btn_do_request) {
            String token = ModuleConfigurationManager.getInstance().getCurrentModuleConfiguration().getToken();
            Toast.makeText(this, "获得token:" + token, Toast.LENGTH_SHORT).show();
        }
    }
}
