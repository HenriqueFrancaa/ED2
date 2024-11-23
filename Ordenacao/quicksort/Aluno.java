public class Aluno{
    private String matr;
    private String nome;
    private double nota;
    private int faltas;

    public Aluno(String matr, String nome, double nota, int faltas) {
        this.matr = matr;
        this.nome = nome;
        this.nota = nota;
        this.faltas = faltas;
    }

    void setMatr(String matr){
        this.matr = matr;
    }
    void setNome(String nome){
        this.nome = nome;
    }
    void setNota(double nota){
        this.nota = nota;
    }
    void setFaltas(int faltas){
        this.faltas = faltas;
    }

    String getMatr(){
        return this.matr;
    }

    String getNome(){
        return this.nome;
    }
    double getNota(){
        return this.nota;
    }
    int getFaltas(){
        return this.faltas;
    }

    
}