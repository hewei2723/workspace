package cn.lttac.todaynews;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyFragment extends Fragment {

    private TextView textUsername;
    private RecyclerView recyclerView;
    private Button btnLogout;
    private DatabaseHelper dbHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);

        dbHelper = new DatabaseHelper(getContext());
        SharedPreferences preferences = requireActivity().getSharedPreferences("login_prefs", Context.MODE_PRIVATE);
        textUsername = view.findViewById(R.id.textView_username);
        recyclerView = view.findViewById(R.id.recyclerView_articles);
        btnLogout = view.findViewById(R.id.button_logout);

        // 从 SharedPreferences 中获取用户名并设置到全局单例中
        String username = preferences.getString("username", "未登录");
        GlobalData.getInstance().setUsername(username);
        textUsername.setText("当前登录账号：" + username);

        // 显示文章列表
        Cursor cursor = dbHelper.getUserArticles(username);
        List<String> articles = new ArrayList<>();
        while (cursor.moveToNext()) {
            articles.add(cursor.getString(0)); // 获取文章标题
        }
        // 配置 RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ArticleAdapter adapter = new ArticleAdapter(articles); // 使用自定义 Adapter
        recyclerView.setAdapter(adapter);

        // 退出登录
        btnLogout.setOnClickListener(v -> {
            preferences.edit().clear().apply(); // 清除登录状态
            GlobalData.getInstance().setUsername(null); // 清除全局变量
            Intent intent = new Intent(getActivity(), MainActivity.class); // 跳转到登录界面
            startActivity(intent);
            requireActivity().finish();
        });
        return view;
    }
}

// 假设你有其他类需要访问 username：
class AnotherClass {
    public void someMethod() {
        String username = GlobalData.getInstance().getUsername();
        // 使用 username 进行操作
    }
}