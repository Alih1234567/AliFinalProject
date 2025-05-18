package com.example.alifinalproject;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.WriteMode;

import java.io.InputStream;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ProductaddnameActivity2 extends AppCompatActivity {
    private static final String APP_KEY =  "kawxqygdpgzxqcd";//مفتاح التطبيق الذي استخرجناه
    public static final String TAG = "Dropbox";//‏استعمالها عند طباعة ملاحظات على الشاشة
    //مفتاح الاستعمال الحالي
    private static String currentAccessToken="sl.u.AFsRqZZiiar4NgePvR3DtIF1o6QSID3rS3EFH-_uPtxp7U7HVlQqavF7i3EQ7zYuD5lv-eaJcVTsRezDfA9qUrUabda50ErEh7KieQIT2cSouyDFNGLF4Wbv6dg3kqCVyM2DcPXTxXk2MkGGW02-g9puVpYw70ZGqEYfYrVIr63VMFtSh3Z72MWBAy5uBINfbSyD7Lf10g1AHwsUNxfACVPYZ8wrYWeEVWDOB_VNT3rok9UxF25yGa8VA3dQLqzpfk8XSLNin7WBoaiNzVAHIYIGKmIcGPi8ZVZqS4j-pSPJa7d_GXqzUfAg9g8-24p4rM70B5n0b8eai1RkUvk4DrX3vbYJPBRgOQ8NPT1ug47E1x_2sQgC756XdcKQjpdGsu3PXlAHF_rg_xSlKtiYn8AeC0Wj6tQ4XwdMUKoNTcti_V1p_cN13pxJTc-B5_a6JeysEf3XUSkWWITfgHi7Tdy2i-0HklFRQ9SbE1L7CSS4TimcvDIf6XgCYEFxcxoi9qsM_o3bGrc335mSBZaNSeRKMnQJJMeFlfJadnY2w5Qs25mGlbG_LIVYbiAMX_lsM38cAzY5dEnZ8CfWGuNntFVIwvR5x4mCHM73TV7a7aJxdxy97Ov_sj5rkivmm5yBDZp3pqn392r-cOo8ZS75s7oBX5yNrs1UX_TOL90_6CUe3H9y1kxvhQesdROMMhteAm1FZbYCd-bhlDENvqGeCXhNDEmaKYflJxOigz-JlPnT2acak0Ss4QOCi3r_AbL4jGsf1AeNbpx2J02ZQgbzfqeXyMLGt7LIj3SpfL8rCznXVAq9qibCqleZBAFNdwb1AE8gSRwryOhuzclVI9lS9JWlpFCxkDMCN99XTid8T81sVQbotjYCmiFzq3AcBqRdu9f7oKedTeZEFyJngnXbtdvjE5naD4ojv6p-4nzoJa68jzvI1Kaa9GrpaQJfvCMiamuzro0BtpgoTJ6Kz9EsNmkYGQPrtrb_sqVNmgUQCiKdQ5JeTt_hSFqUi42XgnXmjcKYyAPFbNqTFOKA8VPTV8y2XvQ9TkrB5zjz2yxOLkxADXZ9y9eNbbUeytyhvgsHEWAV3VmE72762plJSKD-GZw2WALOpL0-1456AqUGa28S_ON-oj8BcQZkUE3yEaul1NYStcNmxWUumhMvg_BPcLEC4HpWKP7Cf_vLck33ZmPN2TfNDrDguhW6_p_HFVmHg4UvjKQ8RjmGru9CtG3EMPjcLPa23IDCQDdimKq6FDZla_U-bvNwZMGmhHMcuO7VSlvOBWxWnRktvkUxGH4yZ-O21GC6zVtrrC5Vubv92AdecNWcLuOuIEvctQS5XC3GAB5EAvaSgbgopqFaIKBdBhptnGtTbYXxESOcxQDLLmbXIe6B53HOTKYXnh9yrrmC88-p39D97cA0gMlKDeHE2ChRCUx7isKDYw1tQCCUjnZFGg";//مفتاح الاستعمال الحالي
    /**
     // متنسق Client ل-dropbox, لتحميل الملفات
     */
    private DbxClientV2 dropboxClient;// الكائن المخصص للتعامل مع دروبوكس



private EditText etProName;
private EditText etDesc;
private EditText etPrice;
private Button btnPostPro;
private TextView tvUplodedImg;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         EdgeToEdge.enable(this);
         setContentView(R.layout.activity_productname2);

         etProName = findViewById(R.id.etProName);
         etDesc = findViewById(R.id.etDesc);
         etPrice = findViewById(R.id.etPrice);
         btnPostPro = findViewById(R.id.btnPostPro);
         tvUplodedImg = findViewById(R.id.tvUplodedImg);


     }
    @Override
    protected void onResume() {
        super.onResume(); // استدعاء دالة onResume في الفئة الأساسية
        if (currentAccessToken != null) { // التحقق مما إذا كان رمز الوصول الحالي ليس null
            if (dropboxClient == null) { // إذا كان العميل dropboxClient غير مهيأ
                Toast.makeText(getApplicationContext(), "Initializing Dropbox client.", Toast.LENGTH_SHORT).show(); // عرض رسالة توست
                DbxRequestConfig requestConfig = DbxRequestConfig.newBuilder("YourAppName/1.0").build(); // إنشاء تكوين طلب Dropbox
                dropboxClient = new DbxClientV2(requestConfig, currentAccessToken); // إنشاء عميل Dropbox جديد
            } else {
                Toast.makeText(getApplicationContext(), "Dropbox client already initialized.", Toast.LENGTH_SHORT).show(); // عرض رسالة توست
            }
        } else {
            Toast.makeText(getApplicationContext(), "Dropbox client not initialized.", Toast.LENGTH_SHORT).show(); // عرض رسالة توست
        }
    }
    /**
     * يحمّل الملف المحدد إلى دروب بوكس.
     * @param fileUri عنوان URI للملف المحدد.
     */
    public void uploadFileToDropBox(Uri fileUri) {
        Executor executor = Executors.newSingleThreadExecutor();//  executor for file upload
        executor.execute(new Runnable() {// Run the upload task on the executor
            @Override
            public void run() {// مقطع البرنامج الذي يعمل بالتوازي مع البرنامج الرئيسي
                try {
                    // Open the file input stream
                    InputStream inputStream = getContentResolver().openInputStream(fileUri);
                    // Upload the file to Dropbox
                    FileMetadata metadata = dropboxClient.files().uploadBuilder("/" + UUID.randomUUID().toString())
                            .withMode(WriteMode.OVERWRITE)
                            .uploadAndFinish(inputStream);
                    // ‏حتلنة الشاشة الرئيسية خلال تشغيل مقطع آخر بالتوازي
                    runOnUiThread(() -> tvUplodedImg.setText(metadata.getName()));
                    Log.d(TAG, "Upload successful: " + metadata.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }




    private void readAndValidateFields() {
    String productName = etProName.getText().toString().trim();
    String productDescription = etDesc.getText().toString().trim();
    String productPriceStr = etPrice.getText().toString().trim();

    if (productName.isEmpty()) {
        etProName.setError("Product name cannot be empty");
        return;
    }

    if (productDescription.isEmpty()) {
        etDesc.setError("Product description cannot be empty");
        return;
    }

    double productPrice;
    try {
        productPrice = Double.parseDouble(productPriceStr);
        if (productPrice <= 0) {
            etPrice.setError("Product price must be greater than zero");
            return;
        }
    } catch (NumberFormatException e) {
        etPrice.setError("Invalid price format");
        return;
    }

    // If all fields are valid, proceed with your logic
    Toast.makeText(this, "All fields are valid", Toast.LENGTH_SHORT).show();
}




     }

