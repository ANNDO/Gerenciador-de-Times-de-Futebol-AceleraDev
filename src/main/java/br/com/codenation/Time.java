package br.com.codenation;

import java.time.LocalDate;

public class Time {
    // dados do time
    private Long idTime;// Identificador do time
    private String nomeTime;//* Nome do Time
    private LocalDate dataCriacao;//* Data de criação do time
    private String corUniformePrincipal;//* Cor do uniforme principal do time
    private String corUniformeSecundario;// Cor do uniforme secundário do time
    private Long capitao; //id do jogador capitão

    public Time(Long idTime, String nomeTime, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario, Long capitao) {
        this.idTime = idTime;
        this.nomeTime = nomeTime;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
        this.capitao = capitao;
    }

    public Long getIdTime() {
        return idTime;
    }

    public void setIdTime(Long idTime) {
        this.idTime = idTime;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public void setCorUniformePrincipal(String corUniformePrincipal) {
        this.corUniformePrincipal = corUniformePrincipal;
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public void setCorUniformeSecundario(String corUniformeSecundario) {
        this.corUniformeSecundario = corUniformeSecundario;
    }

    public Long getCapitao() {
        return capitao;
    }

    public void setCapitao(Long capitao) {
        this.capitao = capitao;
    }


    public static TimeBuilder builder (){return new TimeBuilder();}

    public static class TimeBuilder {
        private Long idTime;
        private String nomeTime;
        private LocalDate dataCriacao;
        private String corUniformePrincipal;
        private String corUniformeSecundario;
        private Long capitao;

        public TimeBuilder setIdTime(Long idTime) {
            if(idTime == null){
                throw new NullPointerException("id do time não informado");
            }else{
                this.idTime = idTime;
                return this;
            }
        }

        public TimeBuilder setNomeTime(String nomeTime) {
            if(nomeTime == null){
                throw new NullPointerException("nome do time não informado");
            }else {
                this.nomeTime = nomeTime;
                return this;
            }
        }

        public TimeBuilder setDataCriacao(LocalDate dataCriacao) {
            if(dataCriacao == null){
                throw new NullPointerException("data de criação do time não inforamda");
            }else {
                this.dataCriacao = dataCriacao;
                return this;
            }
        }

        public TimeBuilder setCorUniformePrincipal(String corUniformePrincipal) {
            if(corUniformePrincipal == null){
                throw new NullPointerException("Cor do uniforme principal não informada");
            }else {
                this.corUniformePrincipal = corUniformePrincipal;
                return this;
            }
        }

        public TimeBuilder setCorUniformeSecundario(String corUniformeSecundario) {
            if(corUniformeSecundario == null){
                throw new NullPointerException("Cor do uniforme secundário não informada");
            }else {
                this.corUniformeSecundario = corUniformeSecundario;
                return this;
            }
        }

        public TimeBuilder setCapitao(Long capitao) {
            this.capitao = capitao;
            return this;
        }

        public Time build() {
            if(idTime == null){
                throw new NullPointerException("id do time não informado");
            }
            if(nomeTime == null){
                throw new NullPointerException("nome do time não informado");
            }
            if(dataCriacao == null){
                throw new NullPointerException("data de criação do time não inforamda");
            }
            if(corUniformePrincipal == null){
                throw new NullPointerException("Cor do uniforme principal não informada");
            }
            if(corUniformeSecundario == null){
                throw new NullPointerException("Cor do uniforme secundário não informada");
            }
            return new Time(idTime, nomeTime, dataCriacao, corUniformePrincipal, corUniformeSecundario, capitao);
        }



    }
}