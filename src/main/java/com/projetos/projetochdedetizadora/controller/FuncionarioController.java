package com.projetos.projetochdedetizadora.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import static com.projetos.projetochdedetizadora.controller.TelaPrincipalController.icone;
import static com.projetos.projetochdedetizadora.controller.TelaPrincipalController.titulo;
import com.projetos.projetochdedetizadora.dao.CidadeDao;
import com.projetos.projetochdedetizadora.dao.FuncionarioDao;
import com.projetos.projetochdedetizadora.model.Cidade;
import com.projetos.projetochdedetizadora.model.Cliente;
import com.projetos.projetochdedetizadora.model.Funcionario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;


public class FuncionarioController implements Initializable, ICadastro {

    @FXML private HBox hbTopo;
    @FXML private ImageView imgViewTitulo;
    @FXML private HBox hbBase;
    @FXML private Button btnNovo;
    @FXML private Button btnSalvar;
    @FXML private Button btnExcluir;
    @FXML private TableView<Funcionario> tableView;
    @FXML private JFXTextField tfId;
    @FXML private JFXTextField tfDescricao;
    @FXML private JFXTextField tfPesquisar;
    @FXML private CheckBox chAtivo;
    @FXML private JFXTextField tfFuncao;
    @FXML private JFXTextField tfEndereco;
    @FXML private JFXTextField tfNum;
    @FXML private JFXComboBox<Cidade> cbCidade;
    @FXML private JFXTextField tfTelefone;
    @FXML private Label lblTitulo;
    
    //variáveis para uso "INTERNO" da classe
    private FuncionarioDao dao = new FuncionarioDao();
    private Funcionario objetoSelecionado = new Funcionario();
    private CidadeDao daoCidade = new CidadeDao();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //-----> CONFIGURAÇÃO DA BARRA DE TÍTULO DO FORM.
        lblTitulo.setText("CADASTRO DE "+ toUpperCase(titulo));
        Image img = new Image(icone);
        imgViewTitulo.setImage(img); 
        
        //----> CARREGAMENTO DO COMBOBOX UF
        cbCidade.setItems(daoCidade.comboBoxCidade());
    }    

    @FXML
    private void novoRegistro(ActionEvent event) {
    }

    @FXML
    private void salvarRegistro(ActionEvent event) {
        Funcionario objeto = new Funcionario();
            
        //testa se o objeto não está vazio
        if (objetoSelecionado != null) {
            objeto.setId(objetoSelecionado.getId());
        }
        
        objeto.setDescricao(tfDescricao.getText());
        objeto.setEndereco(tfEndereco.getText());
        objeto.setNum(Integer.parseInt(tfNum.getText()));
        /* combobox */
        objeto.setFuncao(tfFuncao.getText());
        objeto.setTelefone1(Long.parseLong(tfTelefone.getText()));
        
        if (chAtivo.isSelected()){
            objeto.setStatus(true);
        } else {
            objeto.setStatus(false);
        }
        
        //verifica o retorno do método salvar.
        dao.salvar(objeto);
        
        atualizarTabela();
        limparCamposFormulario();
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
    }

    @Override
    public void limparCamposFormulario() {
    }
}