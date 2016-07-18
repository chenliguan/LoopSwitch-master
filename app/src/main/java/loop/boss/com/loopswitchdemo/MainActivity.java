package loop.boss.com.loopswitchdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AutoSwitchView mAutoSwitchView;
    private AutoSwitchAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAutoSwitchView = (AutoSwitchView) findViewById(R.id.loopswitch);

        initViewPager();//初始化滑动页
    }

    /**
     * 初始化滑动页
     */
    private void initViewPager() {
        List<LoopModel> datas = new ArrayList<>();
        LoopModel model = null;
        LoopModel mode2 = null;
        LoopModel mode3 = null;
        LoopModel mode4 = null;
        LoopModel mode5 = null;
        model = new LoopModel("第一张", R.mipmap.loop_1);
        datas.add(model);
        mode2 = new LoopModel("第二张", R.mipmap.loop_2);
        datas.add(mode2);
        mode3 = new LoopModel("第三张", R.mipmap.loop_3);
        datas.add(mode3);
        mode4 = new LoopModel("第四张", R.mipmap.loop_4);
        datas.add(mode4);
        mode5 = new LoopModel("第五张", R.mipmap.loop_4);
        datas.add(mode5);

        List indicate = new ArrayList<>();
        indicate.add(R.mipmap.ic_indicator);
        indicate.add(R.mipmap.ic_indicator_c);

        mAdapter = new AutoSwitchAdapter(getApplicationContext(), datas);
        //条目点击事件监听
        mAdapter.setOnItemClickListener(new AutoSwitchAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                Log.e("position", "position:" + position);
            }
        });
        mAutoSwitchView.setAdapter(mAdapter);

        //初始化指示器
        mAutoSwitchView.initIndicate(indicate);
        mAdapter.notifyDataSetChanged();
    }

}
