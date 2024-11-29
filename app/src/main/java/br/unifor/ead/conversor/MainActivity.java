package br.unifor.ead.conversor;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

import br.unifor.ead.conversor.modelos.Categoria;
import br.unifor.ead.conversor.modelos.UnidadeDeMedida;
import br.unifor.ead.conversor.util.Conversor;
import br.unifor.ead.conversor.util.Factory;

public class MainActivity extends AppCompatActivity {

    Factory factory = new Factory();
    Conversor conversor = new Conversor();
    Categoria categoria;
    UnidadeDeMedida unidadeOrigem;
    UnidadeDeMedida unidadeDestino;
    DecimalFormat decimalFormat = new DecimalFormat("#.#####");

    private Spinner spinnerCategoria, spinnerUnidadeOrigem, spinnerUnidadeDestino;
    private EditText editTextValorOrigem;
    private TextView textViewResultado;
    private Button buttonConverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculando os elementos do layout
        spinnerCategoria = findViewById(R.id.spinnerCategoria);
        spinnerUnidadeOrigem = findViewById(R.id.spinnerUnidadeOrigem);
        spinnerUnidadeDestino = findViewById(R.id.spinnerValorResultado);
        editTextValorOrigem = findViewById(R.id.editTextValorOrigem);
        textViewResultado = findViewById(R.id.textViewResultado);
        buttonConverter = findViewById(R.id.buttonConverter);

        // Configurar o ArrayAdapter da Categoria
        ArrayAdapter<Categoria> adapterCategoria = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, factory.getCategorias()
        );
        adapterCategoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Associar o adapter ao Spinner de Categoria
        spinnerCategoria.setAdapter(adapterCategoria);

        spinnerCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categoria = (Categoria) parent.getItemAtPosition(position);

                // Configurar o ArrayAdapter para as unidades de medida de acordo com a categoria
                ArrayAdapter<UnidadeDeMedida> adapterUnidades = new ArrayAdapter<>(
                        MainActivity.this, android.R.layout.simple_spinner_item, factory.getUnidades(categoria)
                );
                adapterUnidades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // Associar o adapter aos spinners de unidade de medida
                spinnerUnidadeOrigem.setAdapter(adapterUnidades);
                spinnerUnidadeDestino.setAdapter(adapterUnidades);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });

        // Listener do spinnerUnidadeOrigem
        spinnerUnidadeOrigem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                unidadeOrigem = (UnidadeDeMedida) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });

        // Listener do spinnerUnidadeDestino
        spinnerUnidadeDestino.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                unidadeDestino = (UnidadeDeMedida) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });

        // Listener do botão "Converter"
        buttonConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Capturar o valor inserido no EditText
                String valorTexto = editTextValorOrigem.getText().toString();

                // Verificar se o campo não está vazio
                if (!valorTexto.isEmpty()) {
                    // Converter o valor para um número
                    double valorOrigem = Double.parseDouble(valorTexto);

                    // Realizar a conversao
                    double resultado = conversor.converter(unidadeOrigem, unidadeDestino, valorOrigem);

                    // Exibir o resultado no TextView
                    textViewResultado.setText(decimalFormat.format(resultado));
                }
            }
        });

    }
}