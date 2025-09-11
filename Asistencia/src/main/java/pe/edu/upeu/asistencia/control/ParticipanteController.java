package pe.edu.upeu.asistencia.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.Participante;
import pe.edu.upeu.asistencia.repositorio.ParticipanteRepository;
import pe.edu.upeu.asistencia.servicio.ParticipanteServicioI;

@Controller
public class ParticipanteController {

    @FXML
    private ComboBox<Carrera> cbxCarrera;

    @FXML
    private ComboBox<TipoParticipante> cbxTipoParticipante;

    @FXML TableView<Participante> tableView;
    ObservableList<Participante> participantes;
    TableColumn<Participante,String> DniCol, NombreCol, ApellidoCol, CarreraCol, TipoPartCol;
    TableColumn<Participante, Void>opcionescol;

    @Autowired
    ParticipanteServicioI ps;

    @FXML TextField txtDni, txtNombres, txtApellidos;
    int indexE=-1;

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
        opcionescol= new TableColumn("Opciones");
        opcionescol.setMinWidth(200);
        tableView.getColumns().addAll(DniCol,NombreCol, ApellidoCol, CarreraCol, TipoPartCol ,  opcionescol);
        Listarparticipantes();

    }
    public void agregarAccionBotones(){
        Callback<TableColumn<Participante,Void>, TableCell<Participante,Void>> cellFactory = param -> new TableCell<>() {

            Button btnEditar = new Button("Editar");
            Button btnEliminar = new Button("Eliminar");
            {
                btnEditar.setOnAction((event) -> {
                    Participante participante = getTableView().getItems().get(getIndex());
                    editarParticipantes(participante, getIndex());
                });
                btnEliminar.setOnAction((event) -> {
                    eliminarParticipante(getIndex());
                });
            }
            @Override
            public void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if(empty){
                    setGraphic(null);
                }else {
                    HBox hBox = new HBox(btnEditar,btnEliminar );
                    hBox.setSpacing(10);
                    setGraphic(hBox);
                }
            }


            };
        opcionescol.setCellFactory(cellFactory);
    }
    public void Listarparticipantes(){
        DniCol.setCellValueFactory(cellDate->cellDate.getValue().getDni());
        NombreCol.setCellValueFactory(cellDate->cellDate.getValue().getNombre());
        ApellidoCol.setCellValueFactory(cellDate->cellDate.getValue().getApellidos());
        CarreraCol.setCellValueFactory(cellDate-> new SimpleStringProperty(cellDate.getValue().getCarrera().toString()));
        TipoPartCol.setCellValueFactory(cellDate-> new SimpleStringProperty(cellDate.getValue().getTipoParticipante().toString()));
        agregarAccionBotones();
        participantes=FXCollections.observableArrayList(ps.findAll());
        tableView.setItems(participantes);
    }

    @FXML
    public void crearParticipante(){
        Participante participante = new Participante();
        participante.setDni(new SimpleStringProperty(txtDni.getText()));
        participante.setNombre(new SimpleStringProperty(txtNombres.getText()));
        participante.setApellidos(new SimpleStringProperty(txtApellidos.getText()));
        participante.setCarrera(cbxCarrera.getValue());
        participante.setTipoParticipante(cbxTipoParticipante.getValue());
        if(indexE==-1){
            ps.save(participante);
        }else{
            ps.update(participante, indexE);
            indexE=-1;
        }
        limpiarFormulario();
        Listarparticipantes();
    }

    public void limpiarFormulario(){
        txtDni.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        cbxCarrera.getSelectionModel().clearSelection();
        cbxTipoParticipante.getSelectionModel().clearSelection();
    }

    public void editarParticipantes(Participante p,int index){
        txtDni.setText(p.getDni().getValue());
        txtNombres.setText(p.getNombre().getValue());
        txtApellidos.setText(p.getApellidos().getValue());
        cbxCarrera.getSelectionModel().select(p.getCarrera());
        cbxTipoParticipante.getSelectionModel().select(p.getTipoParticipante());
        indexE=index;
    }

    public void eliminarParticipante(int index){
        ps.delete(index);
        Listarparticipantes();
    }
}
