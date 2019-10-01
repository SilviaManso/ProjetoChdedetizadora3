package com.projetos.projetochdedetizadora.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import static com.projetos.projetochdedetizadora.controller.TelaPrincipalController.icone;
import static com.projetos.projetochdedetizadora.controller.TelaPrincipalController.titulo;
import com.projetos.projetochdedetizadora.dao.CidadeDao;
import com.projetos.projetochdedetizadora.dao.ClienteDao;
import com.projetos.projetochdedetizadora.model.Cidade;
import com.projetos.projetochdedetizadora.model.Cliente;
import com.projetos.projetochdedetizadora.util.TipoPessoa;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class ClienteController implements Initializable, ICadastro {

    @FXML private HBox hbTopo;
    @FXML private ImageView imgViewTitulo;
    @FXML private Label lblTitulo;
    @FXML private HBox hbBase;
    @FXML private Button btnNovo;
    @FXML private Button btnSalvar;
    @FXML private Button btnExcluir;
    @FXML private TableView<Cliente> tableView;
    @FXML private JFXTextField tfId;
    @FXML private JFXTextField tfEndereco;
    @FXML private JFXComboBox<Cidade> cbCidade;
    @FXML private JFXTextField tfEmail;
    @FXML private JFXTextField tfObservacao;
    @FXML private JFXTextField tfPesquisar;
    @FXML private CheckBox chAtivo;
    @FXML private JFXTextField tfCep;
    @FXML private JFXTextField tfTelefone1;
    @FXML private JFXTextField tfTelefone2;
    @FXML private JFXTextField tfTelefone3;
    @FXML private JFXTextField tfCpfCnpj;
    @FXML private JFXTextField tfDescricao;
    @FXML private JFXComboBox<String> cbTipoPessoa;
    @FXML private JFXTextField tfNum;
    @FXML private JFXTextField tfComplemento;
    
    //variáveis para uso "interno" da classe
    private ClienteDao dao = new ClienteDao();
    private Cliente objetoSelecionado = new Cliente();
    private CidadeDao daoCidade = new CidadeDao();
    private ObservableList<Cliente> observableList = FXCollections.observableArrayList();
    private List<Cliente> listar;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //-----> Configuração da barra de título do form
        lblTitulo.setText("CADASTRO DE "+ toUpperCase(titulo));
        Image img = new Image(icone);
        imgViewTitulo.setImage(img);
        
        //----> CARREGAMENTO DO COMBOBOX
        cbTipoPessoa.setItems(TipoPessoa.tipoPessoa());
        cbCidade.setItems(daoCidade.comboBoxCidade());
        
        //---->CRIANDO COLUNAS E INSERINDO NA TAB
        criarColunasTabela();
        //---->ATUALIZANDO A TABELA
        atualizarTabela();
    }    

    @FXML
    private void novoRegistro(ActionEvent event) {
    }

    @FXML
    private void salvarRegistro(ActionEvent event) {
        Cliente objeto = new Cliente();
        
        //testa se o objeto não está vazio
        if (objetoSelecionado != null) {
            objeto.setId(objetoSelecionado.getId());
        }
        
        objeto.setDescricao(tfDescricao.getText());
        objeto.setEndereco(tfEndereco.getText());
        objeto.setNum(Integer.parseInt(tfNum.getText()));
        objeto.setComplemento(tfComplemento.getText());
        /* cbCidade banco */
        objeto.setCep(Long.parseLong(tfCep.getText()));
        objeto.setTelefone1(Long.parseLong(tfTelefone1.getText()));
        objeto.setTelefone2(Long.parseLong(tfTelefone2.getText()));
        objeto.setTelefone3(Long.parseLong(tfTelefone3.getText()));
        objeto.setTipoPessoa(cbTipoPessoa.getValue());
        objeto.setCpf_cnpj(Long.parseLong(tfCpfCnpj.getText()));
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
        //Criando a coluna das tabelas.
        TableColumn<Cliente, Long> colunaId = new TableColumn<>("ID");
        TableColumn<Cliente, String> colunaDescricao = new TableColumn<>("NOME");
        TableColumn<Cliente, Long> colunaTel1 = new TableColumn<>("TEL");
        
        //ADICONANDO COLUNAS A TABELA
        tableView.getColumns().addAll(colunaId, colunaDescricao, colunaTel1);
        
        //PROPRIEDADE QUE REPRESENTA OS CAMPOS NA TABELA -> relacionando com o model
        colunaId.setCellValueFactory(new PropertyValueFactory("id"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        colunaTel1.setCellValueFactory(new PropertyValueFactory("telefone1"));        
    }

    @Override
    public void atualizarTabela() {
        observableList.clear();
        
        listar = dao.consultar(tfPesquisar.getText());
        
        for (Cliente client: listar){
            observableList.add(client);
        }
        
        tableView.getItems().setAll(observableList);
        tableView.getSelectionModel().selectFirst();
    }

    @Override
    public void setCamposFormulario() {
        objetoSelecionado = tableView.getItems().get(tableView.getSelectionModel().getSelectedIndex());
        tfId.setText(String.valueOf(objetoSelecionado.getId()));
        tfEndereco.setText( objetoSelecionado.getEndereco());
        
       Cidade cidadeSelecionada = new Cidade();
          //  cidadeSelecionada.setId(objetoSelecionado.getCidade().getId());
           // cidadeSelecionada.setDescricao(objetoSelecionado.getCidade().getDescricao());
          //  cidadeSelecionada.setCep(objetoSelecionado.getCidade().getCep());
           // cidadeSelecionada.setUf(objetoSelecionado.getCidade().getUf());
            
            cbCidade.getSelectionModel().selectFirst();
            cbCidade.setValue(cidadeSelecionada);
       
        tfEmail.setText( objetoSelecionado.getEmail());
        tfObservacao.setText( objetoSelecionado.getObservacao());
        tfPesquisar.setText( objetoSelecionado.getPesquisar());
        chAtivo.setText( objetoSelecionado.getAtivo());
        tfCep.setText(StringValueOf(objetoSelecionado.getCep()));
        tfTelefone1.setText(String.valueOf(objetoSelecionado.getTelefone1()));
        tfTelefone2.setText(String.valueOf(objetoSelecionado.getTelefone1()));
        tfTelefone3.setText(String.valueOf(objetoSelecionado.getTelefone1()));
        tfCpfCnpj.setText( objetoSelecionado.getCpfCnpj());
        tfDescricao.setText( objetoSelecionado.getDescricao());
        
       // cbTipoPessoa.setValue objetoSelecionado.getDescricao());
       
        tfNum.setText(String.valueOf( objetoSelecionado.getNum()));
        tfComplemento.setText( objetoSelecionado.getComplemento());
      
       
    }

    @Override
    public void limparCamposFormulario() {
        objetoSelecionado = null;
        tfId.clear();
        tfEndereco.clear();
        cbCidade.getSelectionModel().select(-1);
        tfEmail.clear();
        tfObservacao.clear();
        tfPesquisar.clear();
        tfCep.clear();
        tfTelefone1.clear();
        tfTelefone2.clear();
        tfTelefone3.clear();
        tfCpfCnpj.clear();
        tfDescricao.clear();
        cbTipoPessoa.getSelectionModel().select(-1);
        tfNum.clear();
        tfComplemento.clear();
        
        tfDescricao.requestFocus();
        
    }

    @FXML
    private void filtrarRegistro(KeyEvent event) {
        atualizarTabela();
    }

    @FXML
    private void clicarTabela(MouseEvent event) {
         setCamposFormulario();
    }

    private String StringValueOf(Long cep) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
