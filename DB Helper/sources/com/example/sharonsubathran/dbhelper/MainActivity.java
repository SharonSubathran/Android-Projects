package com.example.sharonsubathran.dbhelper;

import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnAddData;
    Button btnDelete;
    Button btnviewAll;
    Button btnviewUpdate;
    EditText editEmail;
    EditText editName;
    EditText editShow;
    EditText editTextId;
    DatabaseHelper myDb;

    /* renamed from: com.example.sharonsubathran.dbhelper.MainActivity$1 */
    class C01851 implements OnClickListener {
        C01851() {
        }

        public void onClick(View view) {
            if (MainActivity.this.myDb.deleteData(MainActivity.this.editTextId.getText().toString()).intValue() > null) {
                Toast.makeText(MainActivity.this, "Data Deleted", 1).show();
            } else {
                Toast.makeText(MainActivity.this, "Data not Deleted", 1).show();
            }
        }
    }

    /* renamed from: com.example.sharonsubathran.dbhelper.MainActivity$2 */
    class C01862 implements OnClickListener {
        C01862() {
        }

        public void onClick(View view) {
            if (MainActivity.this.myDb.updateData(MainActivity.this.editTextId.getText().toString(), MainActivity.this.editName.getText().toString(), MainActivity.this.editEmail.getText().toString(), MainActivity.this.editShow.getText().toString()) == 1) {
                Toast.makeText(MainActivity.this, "Data Update", 1).show();
            } else {
                Toast.makeText(MainActivity.this, "Data not Updated", 1).show();
            }
        }
    }

    /* renamed from: com.example.sharonsubathran.dbhelper.MainActivity$3 */
    class C01873 implements OnClickListener {
        C01873() {
        }

        public void onClick(View view) {
            if (MainActivity.this.myDb.insertData(MainActivity.this.editName.getText().toString(), MainActivity.this.editEmail.getText().toString(), MainActivity.this.editShow.getText().toString()) == 1) {
                Toast.makeText(MainActivity.this, "Data Inserted", 1).show();
            } else {
                Toast.makeText(MainActivity.this, "Data not Inserted", 1).show();
            }
        }
    }

    /* renamed from: com.example.sharonsubathran.dbhelper.MainActivity$4 */
    class C01884 implements OnClickListener {
        C01884() {
        }

        public void onClick(View view) {
            view = MainActivity.this.myDb.getAllData();
            if (view.getCount() == 0) {
                MainActivity.this.showMessage("Error", "Nothing found");
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            while (view.moveToNext()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Id :");
                stringBuilder.append(view.getString(0));
                stringBuilder.append("\n");
                stringBuffer.append(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append("Name :");
                stringBuilder.append(view.getString(1));
                stringBuilder.append("\n");
                stringBuffer.append(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append("Email :");
                stringBuilder.append(view.getString(2));
                stringBuilder.append("\n");
                stringBuffer.append(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append("Show :");
                stringBuilder.append(view.getString(3));
                stringBuilder.append("\n\n");
                stringBuffer.append(stringBuilder.toString());
            }
            MainActivity.this.showMessage("Data", stringBuffer.toString());
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0189R.layout.activity_main);
        this.myDb = new DatabaseHelper(this);
        this.editName = (EditText) findViewById(C0189R.id.editText_name);
        this.editEmail = (EditText) findViewById(C0189R.id.editText_email);
        this.editShow = (EditText) findViewById(C0189R.id.editText_show);
        this.editTextId = (EditText) findViewById(C0189R.id.editText_ID);
        this.btnAddData = (Button) findViewById(C0189R.id.button_add);
        this.btnviewAll = (Button) findViewById(C0189R.id.button_viewAll);
        this.btnviewUpdate = (Button) findViewById(C0189R.id.button_update);
        this.btnDelete = (Button) findViewById(C0189R.id.button_delete);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

    public void DeleteData() {
        this.btnDelete.setOnClickListener(new C01851());
    }

    public void UpdateData() {
        this.btnviewUpdate.setOnClickListener(new C01862());
    }

    public void AddData() {
        this.btnAddData.setOnClickListener(new C01873());
    }

    public void viewAll() {
        this.btnviewAll.setOnClickListener(new C01884());
    }

    public void showMessage(String str, String str2) {
        Builder builder = new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.show();
    }
}
