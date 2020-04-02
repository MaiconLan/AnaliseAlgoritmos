package buscaprimeiraocorrencia;

import java.util.ArrayList;
import java.util.List;

public class Element {

    private List<Integer> listPopulation11 = new ArrayList<>();
    private List<Integer> listPopulation21 = new ArrayList<>();
    private List<Integer> listPopulation42 = new ArrayList<>();

    private Long time;


    /*
        Executa o procedimento
    */
    public void execute() throws InterruptedException {
        fill();

        System.out.println("--------INICIO EXECUÇÃO----------");
        System.out.println("Elemento 11");
        find(2, listPopulation11);

        System.out.println("------------------");
        System.out.println("Elemento 21");
        find(2, listPopulation21);
        System.out.println("------------------");
        System.out.println("Elemento 42");
        find(2, listPopulation42);

        System.out.println("------------------");
        System.out.println("Elemento Médio de 11");
        find(6, listPopulation11);

        System.out.println("------------------");
        System.out.println("Elemento Médio 21");
        find(11, listPopulation21);

        System.out.println("------------------");
        System.out.println("Elemento Médio 42");
        find(21, listPopulation42);

        System.out.println("------------------");
        System.out.println("Elemento não existente 11");
        find(99999, listPopulation11);

        System.out.println("------------------");
        System.out.println("Elemento não existente 21");
        find(99999, listPopulation21);

        System.out.println("------------------");
        System.out.println("Elemento não existente 42");
        find(99999, listPopulation42);
        System.out.println("--------FIM EXECUÇÃO----------");
    }

    /*
        Popula as listas das de 11, 21 e 42 elementos
     */
    private void fill() {
        populate(listPopulation11, 11);
        populate(listPopulation21, 21);
        populate(listPopulation42, 42);
    }

    /*
        Popula a lista para o tamanho solicitado
     */
    private void populate(List<Integer> population, int size) {
        for (int i = 0; i < size; i++)
            population.add(i + 1);
    }

    /*
        Salva os milissegundos no início da execução
     */
    private void initCounter() {
        System.out.println("INICIANDO CONTADOR");
        time = System.currentTimeMillis();
    }

    /*
        Finaliza o contador, mostrando o tempo de execução em segundos
        Mostra também a contagem de iterações passada por parâmetro
     */
    private void finishCounter(Integer count) {
        System.out.println("FINALIZANDO CONTADOR: " + (System.currentTimeMillis() - time) / 1000 + " Segundos");
        System.out.println("CONTAGEM: " + count);
        time = null;
    }

    /*
        Busca na lista de população, o item a ser encontrado
     */
    private void find(Integer search, List<Integer> population) throws InterruptedException {
        initCounter();
        Integer count = 0;

        for (Integer integer : population) {
            Thread.sleep(1000L);
            count++;
            if (integer == search) {
                finishCounter(count);
                return;
            }

        }
        finishCounter(count);
    }
}
