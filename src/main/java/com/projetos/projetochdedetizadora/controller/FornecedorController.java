package com.projetos.projetochdedetizadora.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import static com.projetos.projetochdedetizadora.controller.TelaPrincipalController.icone;
import static com.projetos.projetochdedetizadora.controller.TelaPrincipalController.titulo;
import com.projetos.projetochdedetizadora.dao.CidadeDao;
import com.projetos.projetochdedetizadora.dao.FornecedorDao;
import com.projetos.projetochdedetizadora.model.Cidade;
import com.projetos.projetochdedetizadora.model.Fornecedor;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;


public class FornecedorController implements Initializable, ICadastro {

    @FXML private HBox hbTopo;
    @FXML private ImageView imgViewTitulo;
    @FXML private Label lblTitulo;
    @FXML private HBox hbBase;
    @FXML private Button btnNovo;
    @FXML private Button btnSalvar;
    @FXML private Button btnExcluir;
    @FXML private TableView<Fornecedor> tableView;
    @FXML private CheckBox chAtivo;
    @FXML private JFXTextField tfId;
    @FXML private JFXTextField tfDescricao;
    @FXML private JFXTextField tfCnpj;
    @FXML private JFXTextField tfEndereco;
    @FXML private JFXTextField tfNum;
    @FXML private JFXTextField tfComplemento;
    @FXML private JFXComboBox<Cidade> cbCidade;
    @FXML private JFXTextField tfTelefone;
    @FXML private JFXTextField tfTelefone2;
    @FXML private JFXTextField tfEmail;
    @FXML private JFXTextField tfObservacao;
    @FXML private JFXTextField tfPesquisar;
    @FXML private JFXTextField tfInsEstadual;
   
    //variáveis para uso "interno" da classe
    private FornecedorDao dao = new FornecedorDao();
    private Fornecedor objetoSelecionado = new Fornecedor();
    private CidadeDao daoCidade = new CidadeDao();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //-----> Configuração da barra de título do form
        lblTitulo.setText("CADASTRO DE "+ toUpperCase(titulo));
        Image img = new Image(icone);
        imgViewTitulo.setImage(img);
        
        //----> CARREGAMENTO DO COMBOBOX
        cbCidade.setItems(daoCidade.comboBoxCidade());       
    }    

    @FXML
    private void novoRegistro(ActionEvent event) {
    }

    @FXML
    private void salvarRegistro(ActionEvent event) {
        Fornecedor objeto = new Fornecedor();
        
        //testa se o objeto não está vazio
        if (objetoSelecionado != null) {
            objeto.setId(objetoSelecionado.getId());
        }
        
        objeto.setDescricao(tfDescricao.getText());
        objeto.setCnpj(Long.parseLong(tfCnpj.getText()));
        objeto.setInscricaoEstatual(tfInsEstadual.getText());
        objeto.setEndereco(tfEndereco.getText());
        objeto.setNum(Integer.parseInt(tfNum.getText()));
        objeto.setComplemento(tfComplemento.getText());
        /* combobox cidade */
        objeto.setTelefone1(Long.parseLong(tfTelefone.getText()));
        objeto.setTelefone2(Long.parseLong(tfTelefone2.getText()));
        objeto.setEmail(tfEmail.getText());
        objeto.setObservacao(tfObservacao.getText());
        
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
        
        objetoSelecionado = tableView.getItems().get(tableView.getSelectionModel().getSelectedIndex());
        tfId.setText(String.valueOf(objetoSelecionado.getId()));
        tfDescricao.setText( objetoSelecionado.getDescricao());
        //tfCnpj.setText( objetoSelecionado.getCnpj());
        tfEndereco.setText( objetoSelecionado.getEndereco());
        tfNum.setText( objetoSelecionado.getnum());
        tfComplemento.setText( objetoSelecionado.getComplemento());
        
       //  cbCidade.setText( objetoSelecionado.getCidade());
       
       
       tfTelefone.setText( objetoSelecionado.getTelefone());
       //tfTelefone2.setText( objetoSelecionado.getTelefone2());
       tfEmail.setText( objetoSelecionado.getEmail());
       tfObservacao.setText( objetoSelecionado.getObservacao());
       tfPesquisar.setText( objetoSelecionado.getPesquisar());
       tfInsEstadual.setText( objetoSelecionado.getEstadual());
       
    }

    @Override
    public void limparCamposFormulario() {
        objetoSelecionado = null;
        tfId.clear();
        tfDescricao.clear();
        tfCnpj.clear();
        tfEndereco.clear();
        tfNum.clear();
        tfComplemento.clear();
        cbCidade.getSelectionModel().select(-1);
        tfTelefone.clear();
        tfTelefone2.clear();
        tfEmail.clear();
        tfObservacao.clear();
        tfPesquisar.clear();
        tfInsEstadual.clear();
        tfDescricao.requestFocus();
       
        
        
    }

    @FXML
    private void clicarTabela(MouseEvent event) {
        setCamposFormulario();
    }
}
