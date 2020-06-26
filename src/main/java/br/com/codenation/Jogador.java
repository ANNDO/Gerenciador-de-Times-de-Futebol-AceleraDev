package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.InputMismatchException;

public class Jogador {

    // dados do jogador
    private Long id; // Identificador do Jogador
    private Long idTime; // Identificador do Time
    private String nome; // Nome do Jogador
    private LocalDate dataNascimento; // Data de nascimento do Jogador
    private Integer nivelHabilidade;// Nível de habilidade do jogador (0 a 100)
    private BigDecimal salario;// Salário do jogador

    public Jogador(Long id,Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        this.id = id;
        this.idTime = idTime;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nivelHabilidade = nivelHabilidade;
        this.salario = salario;

    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Long getIdTime() {
        return idTime;
    }

    public void setIdTime(Long idTime) {
        this.idTime = idTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {
        this.nivelHabilidade = nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public static JogadorBuilder builder (){return new JogadorBuilder();}

    public static class JogadorBuilder {
        private Long id;
        private Long idTime;
        private String nome;
        private LocalDate dataNascimento;
        private Integer nivelHabilidade;
        private BigDecimal salario;

        public JogadorBuilder setId(Long id) {
            if( id==null ){
                throw new NullPointerException("id do jogador não informado");
            }else{
                this.id = id;
                return this;
            }
        }
        public JogadorBuilder setIdTime(Long idTime) {
            if( idTime == null){
                throw new NullPointerException("id do time não informado");
            }else{
                this.idTime = idTime;
                return this;
            }
        }

        public JogadorBuilder setNome(String nome) {
            if( nome == null ){
                throw new NullPointerException("nome não informado");
            }else {
                this.nome = nome;
                return this;
            }
        }

        public JogadorBuilder setDataNascimento(LocalDate dataNascimento) {
            if( dataNascimento == null){
                throw new NullPointerException("data de nascimento não informado");
            }else{
                this.dataNascimento = dataNascimento;
                return this;
            }
        }

        public JogadorBuilder setNivelHabilidade(Integer nivelHabilidade) {
            if (nivelHabilidade == null){
                throw new NullPointerException("nível de habilidade não informado");
            }else if (nivelHabilidade>100 || nivelHabilidade < 0 ){
                throw new IllegalArgumentException("Nível deve ser um inteiro entre 0 e 100");
            }else{
                this.nivelHabilidade = nivelHabilidade;
                return this;
            }
        }

        public JogadorBuilder setSalario(BigDecimal salario) {
            if( salario == null){
                throw new NullPointerException("salário não informado");
            }else {
                this.salario = salario;
                return this;
            }
        }

        public Jogador build() {
            if(id ==null){
                throw new NullPointerException("id do jogador não informado");
            }
            if( idTime == null){
                throw new NullPointerException("id do time não informado");
            }
            if( nome == null ){
                throw new NullPointerException("nome não informado");
            }
            if( dataNascimento == null){
                throw new NullPointerException("data de nascimento não informado");
            }
            if (nivelHabilidade == null){
                throw new NullPointerException("nível de habilidade não informado");
            }else if (nivelHabilidade>100 || nivelHabilidade < 0 ){
                throw new IllegalArgumentException("Nível deve ser um inteiro entre 0 e 100");
            }
            if( salario == null) {
                throw new NullPointerException("salário não informado");
            }

            return new Jogador(id,idTime, nome, dataNascimento, nivelHabilidade, salario);
        }
    }


}
