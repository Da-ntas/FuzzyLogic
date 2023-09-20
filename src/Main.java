// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.*;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o valor da experiencia: (0, 30)");
        double exp = entrada.nextDouble();

        System.out.println("Digite o valor da formacao: (0, 15)");
        double formacao = entrada.nextDouble();

        String caminho = "./gratificar.fcl";
        FIS fuzzy = FIS.load(caminho);

        fuzzy.setVariable("experiencia", exp);
        fuzzy.setVariable("formacao", formacao);

        fuzzy.evaluate();

        Variable gratificacao = fuzzy.getVariable("gratificacao");

        JFuzzyChart.get().chart(gratificacao, gratificacao.getDefuzzifier(), true);

        JFuzzyChart.get().chart(fuzzy);

    }
}