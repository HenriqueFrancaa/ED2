public class Aluno implements Comparable <Aluno>{
    private String matr;
    private String nome;
    private Double nota;
    private int faltas;

    public Aluno(String matr, String nome, Double nota, int faltas) {
        this.matr = matr;
        this.nome = nome;
        this.nota = nota;
        this.faltas = faltas;
    }
    @Override
    public int compareTo(Aluno aluno){
        return (this.getNota()).compareTo(aluno.getNota());
    }

    void setMatr(String matr){
        this.matr = matr;
    }
    void setNome(String nome){
        this.nome = nome;
    }
    void setNota(Double nota){
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
    Double getNota(){
        return this.nota;
    }
    int getFaltas(){
        return this.faltas;
    }

    
}