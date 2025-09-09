package pe.edu.upeu.asistencia.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.Participante;
import pe.edu.upeu.asistencia.repositorio.ParticipanteRepository;

@Controller
public class ParticipanteController {

    @FXML
    private ComboBox<Carrera> cbxCarrera;

    @FXML
    private ComboBox<TipoParticipante> cbxTipoParticipante;

    @FXML TableView<Participante> tableView;
    ObservableList<Participante> participantes;
    TableColumn<Participante,String> DniCol, NombreCol, ApellidoCol, CarreraCol, TipoPartCol;

    @Autowired
    ParticipanteRepository ps;

    @FXML
    public void initialize(){
        cbxCarrera.getItems().setAll(Carrera.values());
        cbxTipoParticipante.getItems().setAll(TipoParticipante.values());
        defenirNombresColumnas();

    }
    public void defenirNombresColumnas(){
        DniCol = new TableColumn("DNI");
        NombreCol = new TableColumn("Nombre");
        ApellidoCol = new TableColumn("Apellido");
        ApellidoCol.setMinWidth(200);
        CarreraCol = new TableColumn("Carrera");
        TipoPartCol = new TableColumn("Tipo Participante");
        TipoPartCol.setMinWidth(160);
        tableView.getColumns().addAll(DniCol,NombreCol, ApellidoCol, CarreraCol, TipoPartCol );
        Listarparticipantes();

    }
    public void Listarparticipantes(){
        DniCol.setCellValueFactory(cellDate->cellDate.getValue().getDni());
        participantes=FXCollections.observableList(ps.findAll());
        tableView.setItems(participantes);
    }
}
