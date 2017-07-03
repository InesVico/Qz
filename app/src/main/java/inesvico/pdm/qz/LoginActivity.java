package inesvico.pdm.qz;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

import static java.security.AccessController.getContext;

public class LoginActivity extends AppCompatActivity {

    BarcodeDetector mBarcodeDetector;
    SparseArray mSparseArray;
    CameraSource mCamara;
    SurfaceView mDetectorQR;
    EditText mNombre;
    Button mEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mNombre = (EditText) findViewById(R.id.nombre);
        mEntrar = (Button) findViewById(R.id.entrar);
        mDetectorQR = (SurfaceView) findViewById(R.id.lectorQR);

        mBarcodeDetector = new BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.QR_CODE).build();

        mCamara = new CameraSource.Builder(this, mBarcodeDetector).setRequestedPreviewSize(640,480).build();

        //Listener QR
        mDetectorQR.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                // Permisos camara
                if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    try {
                        mCamara.start(mDetectorQR.getHolder());
                    } catch (IOException ie) {
                        Log.e("CAMERA SOURCE", ie.getMessage());
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"Son necesarios los permisos de cámara", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                mCamara.stop();
            }
        });
        // preparo el detector de QR
        mDetectorQR.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
            }
            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();

                if (barcodes.size() != 0) {
                    barcodes.valueAt(0).displayValue.toString();
                    // hacer algo
                }

                mDetectorQR.release();
            });
        };

        mDetectorQR.
    }
}
