package com.haya.android_java_realm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    EditText mName, age;
    TextView mIndex;
//    ListView index;
    Button mSaveButton;
    Button mGetButton;

    Realm realm;

    String getName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mName = findViewById(R.id.edit_name);
//        age = findViewById(R.id.age);
//        saveButton = findViewById(R.id.saveButton);
        mIndex = findViewById(R.id.index);
//
        mSaveButton = findViewById(R.id.save_button);

        mGetButton = findViewById(R.id.get_button);
//        // listビュー作成
//        ListView listView = new ListView(this);
//        setContentView(listView);
//
//        //アプリの起動時にRealmを初期化する必要があります。
//        //今回はMainActivityが最初のページなので、onCreateに初期化処理Realm.init()を書きます。
//        //また、RealmのインスタンスはRealm.getDefaultInstance()で指定します。
//        //以下のようになればOKです。
        Realm.init(this);
        realm = Realm.getDefaultInstance();
//
//        //保存処理を記述する時は.beginTransaction(),.commitTransaction()の間に記述します。
//        //また、新規保存時はRealm経由でモデルをインスタンス化します。

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();

                SampleModel model = realm.createObject(SampleModel.class);
//        model.setName("GODIVA");
                model.setName(mName.getText().toString());
                String mResult = model.getName();
                realm.commitTransaction();
                mIndex.setText(mResult);
            }
        });

        mGetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();

                SampleModel model = realm.createObject(SampleModel.class);
//        model.setName("GODIVA");
                mIndex.setText(getName);
                realm.commitTransaction();
            }
        });

//
//        //RealmQueryで読み込むデータモデルの情報を持ち、
//        // RealmResultsで実際にデータを取得します。
//
//        RealmQuery<SampleModel> query = realm.where(SampleModel.class);
//        RealmResults<SampleModel> result = query.findAll();
//
//        for (int i=0;i<result.size();i++){
//            System.out.println(result.get(i).getName());
//            System.out.println(result.get(i).getAge());
//        }

    }
}