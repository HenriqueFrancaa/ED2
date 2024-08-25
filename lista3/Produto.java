class Produto {
    private String codigo, descricao, fornecedor;
    private Double preco;
    private int estoque;


    Produto(String codigo) {
        this.codigo = codigo;
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
    
    

    
    
}
