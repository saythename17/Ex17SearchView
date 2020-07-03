package com.icandothisallday2020.ex17searchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //onCreate()메소드 실행 후 OptionMenu 를 만드는 작업을 위해
    //자동으로 실행 되는 콜백 메소드

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar,menu);
        //inflate()를 통해 만든 MenuItem 객체에서
        //SearchView 의 아이디를 얻어와 참조하기
        MenuItem item=menu.findItem(R.id.menu_search);
        searchView=(SearchView)item.getActionView();
        //SearchView 의 hint 글씨 변경
        searchView.setQueryHint("검색어 입력..");
        searchView.setQuery("검색어 입력..",false);//true: 바로 검색됨
        //소프트키패드(소프트웨어적으로 올라오는 키패드,자판)의 검색버튼
        //-(돋보기 아이콘)을 클릭하는 것을 듣는 리스너
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //Submit : 제출하다 - 검색기능에서 가장많이 사용
            @Override          //사용자가 입력한 문자열┐
            public boolean onQueryTextSubmit(String query) {//Query(질문하다)
                Toast.makeText(MainActivity.this,query+"-검색",Toast.LENGTH_SHORT).show();
                return false;
            }
            //SearchView's EditText 글씨 변경(입력)할때마다 실행되는 callback method
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
