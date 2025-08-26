package peru.edu.upeu.asistencia.control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

@Controller
public class asistenciaController {
    @FXML
    TextField txtNum1,txtNum2;
    @FXML
    Label txtResul;
    @FXML
    public void sumar(){
        double num1 = Double.parseDouble(txtNum1.getText());
        double num2 = Double.parseDouble(txtNum2.getText());
        double resultado = num1 + num2;
        txtResul.setText(String.valueOf(resultado));
    }

}
