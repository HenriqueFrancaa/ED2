class Produto {
    private String codigo, descricao, fornecedor;
    private Double preco;
    private int estoque;


    Produto(String codigo, String descricao, String fornecedor, Double preco, int estoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.preco = preco;
        this.estoque = estoque;
    }

    String getCodigo() {
        return codigo;
    }

    void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    String getDescricao() {
        return descricao;
    }

    void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    String getFornecedor() {
        return fornecedor;
    }

    void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    Double getPreco() {
        return preco;
    }

    void setPreco(Double preco) {
        this.preco = preco;
    }

    int getEstoque() {
        return estoque;
    }

    void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub

       return "Codigo: " + this.codigo + " Descrição: " + this.descricao + " Fornecedor: " + this.fornecedor + 
        " Preço: " + this.estoque + " Estoque:" + this.estoque;

    }

    public int CompareTo(){
        
        return 0;
    }
    
}
