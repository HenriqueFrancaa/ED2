package Dados;

public class Produto implements Comparable <Produto>{
    private String cod;
    private String descricao;
    private String fornecedor;
    private Double preco;
    private int estoque;

    @Override
    public int compareTo(Produto p){
        return this.cod.compareTo(p.cod);
    }

    public Produto(String c){
        this.cod = c;
    }

    public Produto(String c, String d, String f, Double p, int e){
        this.cod = c;
        this.descricao = d;
        this.fornecedor = f;
        this.preco = p;
        this.estoque = e;
    }

    @Override
    public String toString(){
        return "Código: " + this.cod + "\nDescrição: " + this.descricao + "\nFornecedor: "
        + this.fornecedor + "\nPreço: R$" + this.preco + "\nEm Estoque: " + this.estoque + "\n";
    }

    void setCod(String c){
        this.cod = c;
    }
    
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
    public String getCod(){
        return this.cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getFornecedor() {
        return this.fornecedor;
    }

    public Double getPreco() {
        return this.preco;
    }

    public int getEstoque() {
        return this.estoque;
    }
    
    



}