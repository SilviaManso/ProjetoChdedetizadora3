package com.projetos.projetochdedetizadora.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import static com.projetos.projetochdedetizadora.controller.TelaPrincipalController.icone;
import static com.projetos.projetochdedetizadora.controller.TelaPrincipalController.titulo;
import com.projetos.projetochdedetizadora.model.Usuario;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class UsuarioController implements Initializable, ICadastro {

    @FXML private HBox hbTopo;
    @FXML private ImageView imgViewTitulo;
    @FXML private Label lblTitulo;
    @FXML private HBox hbBase;
    @FXML private Button btnNovo;
    @FXML private Button btnSalvar;
    @FXML private Button btnExcluir;
    @FXML private TableView<Usuario> tableView;
    @FXML private JFXTextField tfId;
    @FXML private JFXTextField tfPesquisar;
    @FXML private CheckBox chAtivo;
    @FXML private JFXPasswordField pwSenha;
    @FXML private JFXPasswordField pwConfirmarSenha;
    @FXML private JFXTextField tfLogin;
    
    private ObservableList<Usuario> observableList = FXCollections.observableArrayList();
    private List<Usuario> lista;
    private Usuario objetoSelecionado = new Usuario();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //-----> Configuração da barra de título do form
        lblTitulo.setText("CADASTRO DE "+ toUpperCase(titulo));
        Image img = new Image(icone);
        imgViewTitulo.setImage(img);
    }    

    @FXML
    private void novoRegistro(ActionEvent event) {
    }

    @FXML
    private void salvarRegistro(ActionEvent event) {
    }

    @FXML
    private void excluirRegistro(ActionEvent event) {
    }

    @Override
    public void criarColunasTabela() {
    }

    @Override
    public void atualizarTabela() {
    }

    @Override
    public void setCamposFormulario() {
        objetoSelecionado = tableView.getItems().get(tableView.getSelectionModel().getSelectedIndex());
        tfId.setText(String.valueOf(objetoSelecionado.getId()));
        tfPesquisar.setText( objetoSelecionado.getPesquisar());
        chAtivo.setText( objetoSelecionado.getAtivo());
        pwSenha.setText( objetoSelecionado.getSenha());
       // pwConfirmarSenhasetText( objetoSelecionado.getConfirmarSenha());
        tfLogin.setText( objetoSelecionado.getSenha());
       
    }

    @Override
    public void limparCamposFormulario() {
        Object objetoSelecionado = null;
        tfId.clear();
        tfPesquisar.clear();
        pwSenha.clear();
        pwConfirmarSenha.clear();
        tfLogin.clear();
        tfPesquisar.requestFocus();
        
    }

    @FXML
    private void clicarTabela(MouseEvent event) {
         setCamposFormulario();
    }
    
}
