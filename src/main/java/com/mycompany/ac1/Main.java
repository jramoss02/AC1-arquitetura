import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaProdutoRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        Produto produto1 = new Produto();
        produto1.setProd_nome("Produto 1");
        produto1.setProd_qtd(10);
        produto1.setCategoria(new CategoriaProduto()); // Definir categoria

        Produto produto2 = new Produto();
        produto2.setProd_nome("Produto 2");
        produto2.setProd_qtd(20);
        produto2.setCategoria(new CategoriaProduto()); // Definir categoria

        produtoRepository.saveAll(Arrays.asList(produto1, produto2));

        CategoriaProduto categoria1 = new CategoriaProduto();
        categoria1.setCat_nome("Categoria 1");
        categoria1.setCat_descricao("Descrição da Categoria 1");

        CategoriaProduto categoria2 = new CategoriaProduto();
        categoria2.setCat_nome("Categoria 2");
        categoria2.setCat_descricao("Descrição da Categoria 2");

        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));

        // Exibir todos os produtos e categorias
        List<Produto> produtos = produtoRepository.findAll();
        produtos.forEach(System.out::println);

        List<CategoriaProduto> categorias = categoriaRepository.findAll();
        categorias.forEach(System.out::println);
    }
}
