package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	HashMap<Long,Jogador> listaDeJogadores = new HashMap<>();//hashmap dos jogadores (key = id jogador,value = jogador)
	HashMap<Long, Time> listaDeTimes = new HashMap<>();// hashmap dos times (key = id time, value = time)

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if (listaDeTimes.containsKey(id)){
			throw new IdentificadorUtilizadoException();
		}else{
			br.com.codenation.Time novotime = new br.com.codenation.Time.TimeBuilder()
					.setIdTime(id)
					.setNomeTime(nome)
					.setDataCriacao(dataCriacao)
					.setCorUniformePrincipal(corUniformePrincipal)
					.setCorUniformeSecundario(corUniformeSecundario)
					.build();
			listaDeTimes.put(id,novotime);
		}
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if(listaDeJogadores.containsKey(id) ){
			throw new IdentificadorUtilizadoException();
		}else if(!listaDeTimes.containsKey(idTime)){
			throw new TimeNaoEncontradoException();
		}else{
			Jogador novojogador = new Jogador.JogadorBuilder()
					.setId(id)
					.setIdTime(idTime)
					.setNome(nome)
					.setDataNascimento(dataNascimento)
					.setNivelHabilidade(nivelHabilidade)
					.setSalario(salario).build();
			listaDeJogadores.put(id,novojogador);

		}
	}

	public void definirCapitao(Long idJogador) {

		if(!listaDeJogadores.containsKey(idJogador)){
			throw new JogadorNaoEncontradoException();
		}else{
			Long idTime = listaDeJogadores.get(idJogador).getIdTime();
			listaDeTimes.get(idTime). setCapitao(idJogador);

		}
	}

	public Long buscarCapitaoDoTime(Long idTime) {

		if (!listaDeTimes.containsKey(idTime)){
			throw new TimeNaoEncontradoException();
		}else if(listaDeTimes.get(idTime).getCapitao() == null)
		{
			throw new CapitaoNaoInformadoException();
		}else{
			return listaDeTimes.get(idTime).getCapitao();
		}
	}

	public String buscarNomeJogador(Long idJogador) {

		if(!listaDeJogadores.containsKey(idJogador)){
			throw new JogadorNaoEncontradoException();
		}else{
			return listaDeJogadores.get(idJogador).getNome();

		}
	}

	public String buscarNomeTime(Long idTime) {
		if(!listaDeTimes.containsKey(idTime)){
			throw new TimeNaoEncontradoException();
		}else{
			return listaDeTimes.get(idTime).getNomeTime();
		}
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if(!listaDeTimes.containsKey(idTime)){
			throw new TimeNaoEncontradoException();
		}else{
			return listaDeJogadores.values().stream()
					.filter(jogador -> idTime.equals(jogador.getIdTime()))
					.sorted(Comparator.comparing(Jogador::getId))
					.map(Jogador::getId)
					.collect(Collectors.toList());
		}
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if(!listaDeTimes.containsKey(idTime)){
			throw new TimeNaoEncontradoException();
		}else{
			return listaDeJogadores.values().stream()
					.filter(jogador -> idTime.equals(jogador.getIdTime()))
					.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed())
					.map(Jogador::getId)
					.sorted(Comparator.reverseOrder())
					.findFirst().get();
		}
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		if(!listaDeTimes.containsKey(idTime)){
			throw new TimeNaoEncontradoException();
		}else{
			return listaDeJogadores.values().stream()
					.filter(jogador -> idTime.equals(jogador.getIdTime()))
					.sorted(Comparator.comparing(Jogador::getDataNascimento))
					.map(Jogador::getId)
					.sorted(Comparator.naturalOrder())
					.findFirst().get();
		}
	}

	public List<Long> buscarTimes() {
		return listaDeTimes.keySet().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		if(!listaDeTimes.containsKey(idTime)){
			throw new TimeNaoEncontradoException();
		}else{
			return listaDeJogadores.values().stream().filter(jogador -> idTime.equals(jogador.getIdTime()))
					.sorted(Comparator.comparing(Jogador::getSalario).reversed())
					.map(Jogador::getId)
					.sorted(Comparator.reverseOrder())
					.findFirst().get();
		}
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if(!listaDeJogadores.containsKey(idJogador)){
			throw new JogadorNaoEncontradoException();
		}else{
			return listaDeJogadores.get(idJogador).getSalario();

		}
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> listaDosTops = new ArrayList<>();
		if(listaDeJogadores.isEmpty()){
			return listaDosTops;
		}else {
			listaDeJogadores.values().stream()
					.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed())
					.limit(top)
					.map(Jogador::getId)
					.sorted(Comparator.reverseOrder())
					.forEach(listaDosTops::add);
		}
		return listaDosTops;
	}

}
