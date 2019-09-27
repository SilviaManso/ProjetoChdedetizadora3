
package com.projetos.projetochdedetizadora.model;



import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ordem serviço")

public class OrdemServico implements Serializable {
    @Id //chave primaria
    @GeneratedValue(strategy =GenerationType.IDENTITY)//auto incremente
    @Column(name="id", nullable = false)//coluna no banco de dados 
    private Long id; //NÃO pode ser nulo
    
   
    private String idCliente;  //RELACIONAMENTO
    private String idCidade; //RELACIONAMENTO
    private String idFuncionario;  //RELACIONAMENTO
    
    @Column(name="data pedido", length = 100, nullable = false)
    private LocalDate dataPedido; //NÃO pode ser nulo
    
    @Column(name="data serviço", length = 100, nullable =true)
    private LocalDate dataServico; //PODE ser nulo
    
    
    @Column(name="local", length = 100, nullable = false)
    private String local; //NÃO pode ser nulo
    
    @Column(name="complemento", length = 100, nullable = false)
    private String complemento; //PODE ser nulo
    
    @Column(name="area", length = 100, nullable = false)
    private float area; //PODE ser nulo
    
    @Column(name="situação visita", length = 100, nullable = false)
    private String situacaoVisita; //NÃO pode ser nulo
    
    @Column(name="praga", length = 100, nullable =true)
    private String praga; //PODE ser nulo
    
   
    private String idProduto;  //RELACIONAMENTO
    
    @Column(name="modalidade ordem serviço", length = 100, nullable = false)
    private String modalidadeOrdemServico; //NÃO pode ser nulo
    
    @Column(name="tempo garantia", length = 100, nullable = true)
    private int tempoGarantia; //PODE ser nulo
    
    @Column(name="valor", length = 100, nullable =true)
    private double valor; //PODE ser nulo

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDate getDataServico() {
        return dataServico;
    }

    public void setDataServico(LocalDate dataServico) {
        this.dataServico = dataServico;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getSituacaoVisita() {
        return situacaoVisita;
    }

    public void setSituacaoVisita(String situacaoVisita) {
        this.situacaoVisita = situacaoVisita;
    }

    public String getPraga() {
        return praga;
    }

    public void setPraga(String praga) {
        this.praga = praga;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getModalidadeOrdemServico() {
        return modalidadeOrdemServico;
    }

    public void setModalidadeOrdemServico(String modalidadeOrdemServico) {
        this.modalidadeOrdemServico = modalidadeOrdemServico;
    }

    public int getTempoGarantia() {
        return tempoGarantia;
    }

    public void setTempoGarantia(int tempoGarantia) {
        this.tempoGarantia = tempoGarantia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(String idCidade) {
        this.idCidade = idCidade;
    }
    
    
}
