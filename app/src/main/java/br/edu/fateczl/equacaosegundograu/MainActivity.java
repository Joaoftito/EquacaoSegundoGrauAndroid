package br.edu.fateczl.equacaosegundograu;

/*
 * @author: João Francisco Alves da Silva
 */

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etNumA;
    private EditText etNumB;
    private EditText etNumC;
    private TextView tvDelta;
    private TextView tvX1;
    private TextView tvX2;
    private TextView tvErro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvInicio = findViewById(R.id.tvInicio);
        etNumA = findViewById(R.id.etNumA);
        etNumB = findViewById(R.id.etNumB);
        etNumC = findViewById(R.id.etNumC);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        tvDelta = findViewById(R.id.tvDelta);
        tvDelta.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvX1 = findViewById(R.id.tvX1);
        tvX1.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvX2 = findViewById(R.id.tvX2);
        tvX2.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvErro = findViewById(R.id.tvErro);

        btnCalcular.setOnClickListener(click -> bhaskara());

    }

    private void bhaskara() {
        int a = Integer.parseInt(etNumA.getText().toString());
        int b = Integer.parseInt(etNumB.getText().toString());
        int c = Integer.parseInt(etNumC.getText().toString());

        if (a == 0) {
            String erro = getString(R.string.zero_a);
            tvErro.setText(erro);
        } else {
            double delta = (b * b) - (4 * a * c);

            if (delta < 0) {
                String erro = getString(R.string.delta_menor_0);
                tvErro.setText(erro);
            } else {

                if (delta == 0) {
                    double x1 = (- b + delta) / (2 * a);
                    String primeiroX = Double.toString(x1);
                    String resultadoDelta = Double.toString(delta);
                    tvDelta.setText(resultadoDelta);
                    tvX1.setText(primeiroX);

                } else {
                    double x1 = (- b + delta) / (2 * a);
                    double x2 = (- b - delta) / (2 * a);
                    String primeiroX = Double.toString(x1);
                    String segundoX = Double.toString(x2);
                    String resultadoDelta = Double.toString(delta);

                    tvDelta.setText(resultadoDelta);
                    tvX1.setText(primeiroX);
                    tvX2.setText(segundoX);
                }
            }
        }
    }
}