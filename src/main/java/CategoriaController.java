import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaProdutoRepository categoriaRepository;

    @PostMapping("/inserir")
    public CategoriaProduto inserirCategoria(@RequestBody CategoriaProduto categoria) {
        return categoriaRepository.save(categoria);
    }

    @GetMapping("/mostrarTodos")
    public List<CategoriaProduto> mostrarTodasCategorias() {
        return categoriaRepository.findAll();
    }
}