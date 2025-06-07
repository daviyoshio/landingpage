package br.com.landingpage.model;

import br.com.landingpage.repository.CategoriaRepository;
import br.com.landingpage.repository.DepoimentoRepository; // 1. Importe o DepoimentoRepository
import br.com.landingpage.repository.ProdutoRepository; // (Boa prática ter todos os repositórios)
import br.com.landingpage.repository.TipoPersonalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // 2. Injete os outros repositórios
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private DepoimentoRepository depoimentoRepository;

    // ADICIONE ESTA LINHA:
    @Autowired
    private TipoPersonalizacaoRepository tipoPersonalizacaoRepository;

    @Override
    public void run(String... args) throws Exception {
        // VERIFICAÇÃO PARA NÃO DUPLICAR DADOS
        if (categoriaRepository.count() > 0) {
            return;
        }

        // --- CATEGORIA NECESSAIRES ---
        Categoria necessaires = new Categoria();
        necessaires.setNomeSingular("Necessaire");
        necessaires.setNomePlural("Necessaires Personalizadas");
        necessaires.setSlug("necessaires");
        necessaires.setDescricao("Crie necessaires únicas e personalizadas para presentes, viagens e organização pessoal.");
        necessaires.setImagemDestaqueUrl("/images/Produtos/Necessaires/Necessaire Gatinho.jpeg");
        necessaires.setUrlImagemPersonalizacao("/images/Produtos/Necessaires/Necessaire Premium.jpeg");
        categoriaRepository.save(necessaires); // Salva a categoria primeiro para ter um ID

        Produto p1 = new Produto("Para Profissionais Especiais", "Designs que celebram sua profissão com carinho e orgulho", "/images/Produtos/Necessaires/Necessaire 6.jpg", necessaires);
        Produto p2 = new Produto("Amor pelos Pets", "Porque nossos bichinhos merecem estar sempre conosco", "/images/Produtos/Necessaires/Necessaire Cachorrinho.png", necessaires);
        produtoRepository.saveAll(Arrays.asList(p1, p2)); // Salva os produtos

        // 3. Adicione os depoimentos para a categoria
        Depoimento dn1 = new Depoimento("Tati Oliveira", "\"Gente, que necessaire LINDA! 😍 A Rita ficou emocionada...\"", "/images/Produtos/Necessaires/Necessaire Rita 395x385 .png", necessaires);
        Depoimento dn2 = new Depoimento("Agatha Mendes", "\"Meu kit de necessaires chegou! Que organização PERFEITA!\"", "/images/Produtos/Necessaires/Necessaire Maria Maris.jpeg", necessaires);
        depoimentoRepository.saveAll(Arrays.asList(dn1, dn2));

        // --- CATEGORIA CANECAS ---
        Categoria canecas = new Categoria();
        canecas.setNomeSingular("Caneca");
        canecas.setNomePlural("Canecas Personalizadas");
        canecas.setSlug("canecas");
        canecas.setDescricao("Crie canecas únicas e personalizadas para presentes, empresas e eventos especiais.");
        canecas.setImagemDestaqueUrl("/images/Produtos/Caneca/Caneca 2.jpg");
        canecas.setUrlImagemPersonalizacao("/images/Produtos/Caneca/Copo Stanley.jpeg");
        categoriaRepository.save(canecas);

        Produto c1 = new Produto("Para Mães Guerreiras", "Designs que celebram a maternidade com humor e amor", "/images/Produtos/Caneca/Caneca 1.jpg", canecas);
        Produto c2 = new Produto("Kits Presente Luxuosos", "Embalagens que fazem o presente ainda mais especial", "/images/Produtos/Caneca/Caneca 3.jpg", canecas);
        produtoRepository.saveAll(Arrays.asList(c1, c2));

        // Adicione os depoimentos para canecas
        Depoimento dc1 = new Depoimento("Maria Santos", "\"Gente, olha que PERFEITA ficou a caneca da minha mãe! 😭❤️ Ela chorou quando viu.\"", "/images/Produtos/Caneca/Depoimento 1.png", canecas);
        depoimentoRepository.save(dc1);

        // --- CATEGORIA BOLSAS ---
        Categoria bolsas = new Categoria();
        bolsas.setNomeSingular("Bolsa");
        bolsas.setNomePlural("Bolsas Personalizadas");
        bolsas.setSlug("bolsas");
        bolsas.setDescricao("Carregue sua história todos os dias. Cada bolsa tote é uma obra de arte única.");
        bolsas.setImagemDestaqueUrl("/images/Produtos/Bolsa/Bolsa Tote 4 Estilos.jpeg");
        bolsas.setUrlImagemPersonalizacao("/images/Produtos/Bolsa/Tati Preparação Bolsa.png");
        categoriaRepository.save(bolsas);

        Produto b1 = new Produto("Elegância no Dia a Dia", "Bolsas que combinam sofisticação e praticidade", "/images/Produtos/Bolsa/790x770 Bolsas Tote Fundo Branco.png", bolsas);
        Produto b2 = new Produto("Personalidade Vibrante", "Cores que expressam sua energia e desenhos que contam sua história", "/images/Produtos/Bolsa/790x770 Bolsa Vermlha Fundo Branco.png", bolsas);
        produtoRepository.saveAll(Arrays.asList(b1, b2));

        // Adicione os depoimentos para bolsas
        Depoimento db1 = new Depoimento("Carla Fernandes", "\"Gente, que bolsa PERFEITA! 😍 As 'Mulheres Poderosas' ficaram lindas demais!\"", "/images/Produtos/Bolsa/790x770 Bolsas Mulheres Poderosas Experience.png", bolsas);
        depoimentoRepository.save(db1);

        // Dentro do método run(...) em DataLoader.java
// --- CATEGORIA ESTOJOS (VERSÃO ATUALIZADA) ---
        Categoria estojos = new Categoria();
        estojos.setNomeSingular("Estojo");
        estojos.setNomePlural("Estojos Personalizados");
        estojos.setSlug("estojos");
        estojos.setDescricao("Estojos personalizados que encantam crianças e organizam o material escolar com estilo e personalidade.");
        estojos.setImagemDestaqueUrl("/images/Produtos/Estojo/Estojo Tatiart.jpeg");
        estojos.setUrlImagemPersonalizacao("/images/Produtos/Estojo/Estojo Turma Animais.jpeg");
        categoriaRepository.save(estojos); // Salva a categoria para ter um ID

// --- Produtos específicos para Estojos ---
        Produto estojo1 = new Produto(
                "Conjuntos Coordenados",
                "Estojos e mochilas que combinam para um visual completo e organizado.",
                "/images/Produtos/Estojo/960x640 Estojo e Mochila.png", // Caminho da sua imagem
                estojos
        );

        Produto estojo2 = new Produto(
                "Heróis Favoritos",
                "Personagens que inspiram e acompanham seu filho todos os dias.",
                "/images/Produtos/Estojo/960x640 Estojo Homem Aranha.png", // Caminho da sua imagem
                estojos
        );

        Produto estojo3 = new Produto(
                "Designs Divertidos",
                "Formatos criativos que trazem alegria para a rotina escolar.",
                "/images/Produtos/Estojo/960x640 Abelhinas.png", // Caminho da sua imagem
                estojos
        );

        Produto estojo4 = new Produto(
                "Proteção para Óculos",
                "Estojos especiais que protegem os óculos com estilo e segurança.",
                "/images/Produtos/Estojo/960x640 Estojo Óculos.png", // Caminho da sua imagem
                estojos
        );

        Produto estojo5 = new Produto(
                "Nomes Personalizados",
                "Estojos únicos com o nome do seu filho, evitando trocas e perdas.",
                "/images/Produtos/Estojo/960x640 Estojo Ady.png", // Caminho da sua imagem
                estojos
        );

        Produto estojo6 = new Produto(
                "Estampas Exclusivas",
                "Padrões únicos que combinam com a personalidade de cada criança.",
                "/images/Produtos/Estojo/960x640 Estojo Gatinhos.png", // Caminho da sua imagem
                estojos
        );

// Salva todos os 6 produtos de uma vez
        produtoRepository.saveAll(Arrays.asList(estojo1, estojo2, estojo3, estojo4, estojo5, estojo6));

        // Adicione este bloco no final do método run() em DataLoader.java
// --- TIPOS DE PERSONALIZAÇÃO PARA A CATEGORIA 'ESTOJOS' ---
// (Certifique-se de ter injetado o TipoPersonalizacaoRepository no topo da classe)
        TipoPersonalizacao tipoEstojo1 = new TipoPersonalizacao();
        tipoEstojo1.setTitulo("Animais e Bichinhos");
        tipoEstojo1.setNomeIcone("heart");
        tipoEstojo1.setCategoria(estojos);
        tipoEstojo1.getItens().add(new ItemPersonalizacao("Estojos em formato de animais fofos", tipoEstojo1));
        tipoEstojo1.getItens().add(new ItemPersonalizacao("Estampas com pets e bichinhos", tipoEstojo1));
        tipoEstojo1.getItens().add(new ItemPersonalizacao("Designs com animais da floresta", tipoEstojo1));
        tipoEstojo1.getItens().add(new ItemPersonalizacao("Padrões com dinossauros", tipoEstojo1));
        tipoEstojo1.getItens().add(new ItemPersonalizacao("Temas marinhos com peixinhos", tipoEstojo1));

        TipoPersonalizacao tipoEstojo2 = new TipoPersonalizacao();
        tipoEstojo2.setTitulo("Personagens Favoritos");
        tipoEstojo2.setNomeIcone("tv");
        tipoEstojo2.setCategoria(estojos);
        tipoEstojo2.getItens().add(new ItemPersonalizacao("Super-heróis (Homem-Aranha, Batman)", tipoEstojo2));
        tipoEstojo2.getItens().add(new ItemPersonalizacao("Princesas e personagens Disney", tipoEstojo2));
        tipoEstojo2.getItens().add(new ItemPersonalizacao("Jogos populares como Minecraft e Roblox", tipoEstojo2));
        tipoEstojo2.getItens().add(new ItemPersonalizacao("Animes e mangás para os mais velhos", tipoEstojo2));

        TipoPersonalizacao tipoEstojo3 = new TipoPersonalizacao();
        tipoEstojo3.setTitulo("Temas Mágicos");
        tipoEstojo3.setNomeIcone("star");
        tipoEstojo3.setCategoria(estojos);
        tipoEstojo3.getItens().add(new ItemPersonalizacao("Unicórnios e arco-íris", tipoEstojo3));
        tipoEstojo3.getItens().add(new ItemPersonalizacao("Fadas e elementos mágicos", tipoEstojo3));
        tipoEstojo3.getItens().add(new ItemPersonalizacao("Espaço e planetas", tipoEstojo3));

        TipoPersonalizacao tipoEstojo4 = new TipoPersonalizacao();
        tipoEstojo4.setTitulo("Hobbies e Esportes");
        tipoEstojo4.setNomeIcone("gamepad-2");
        tipoEstojo4.setCategoria(estojos);
        tipoEstojo4.getItens().add(new ItemPersonalizacao("Futebol e times favoritos", tipoEstojo4));
        tipoEstojo4.getItens().add(new ItemPersonalizacao("Ballet e dança", tipoEstojo4));
        tipoEstojo4.getItens().add(new ItemPersonalizacao("Videogames e controles", tipoEstojo4));

        TipoPersonalizacao tipoEstojo5 = new TipoPersonalizacao();
        tipoEstojo5.setTitulo("Nomes e Iniciais");
        tipoEstojo5.setNomeIcone("text");
        tipoEstojo5.setCategoria(estojos);
        tipoEstojo5.getItens().add(new ItemPersonalizacao("Nome completo em designs criativos", tipoEstojo5));
        tipoEstojo5.getItens().add(new ItemPersonalizacao("Iniciais decoradas e estilizadas", tipoEstojo5));
        tipoEstojo5.getItens().add(new ItemPersonalizacao("Letras em diferentes estilos e fontes", tipoEstojo5));

        TipoPersonalizacao tipoEstojo6 = new TipoPersonalizacao();
        tipoEstojo6.setTitulo("Estampas Exclusivas");
        tipoEstojo6.setNomeIcone("sparkles");
        tipoEstojo6.setCategoria(estojos);
        tipoEstojo6.getItens().add(new ItemPersonalizacao("Padrões geométricos coloridos", tipoEstojo6));
        tipoEstojo6.getItens().add(new ItemPersonalizacao("Estampas tie-dye", tipoEstojo6));
        tipoEstojo6.getItens().add(new ItemPersonalizacao("Flores e elementos da natureza", tipoEstojo6));

// Salva todos os 6 tipos (e seus itens em cascata) no banco
        tipoPersonalizacaoRepository.saveAll(Arrays.asList(tipoEstojo1, tipoEstojo2, tipoEstojo3, tipoEstojo4, tipoEstojo5, tipoEstojo6));

// Adicione os depoimentos para a categoria de estojos também, se quiser
        // --- DEPOIMENTOS DA PÁGINA: Estojos.html ---
        Depoimento depEstojo1 = new Depoimento(
                "Tati Oliveira",
                "\"Meu filho ficou super empolgado com o estojo do Among Us! 🚀 Os personagens ficaram idênticos ao jogo! O zíper verde combinou perfeitamente com o tema. Ele não para de mostrar para os amigos! 😍\"",
                "/images/Produtos/Estojo/790x770 Estojo Among.png",
                estojos // Associa este depoimento à categoria 'estojos' que já criamos
        );

        Depoimento depEstojo2 = new Depoimento(
                "Ana Paula",
                "\"Os estojos de dinossauros do Bento ficaram perfeitos! 🦖 As cores vibrantes e os detalhes são incríveis! Meu filho adora os zíperes com os pingentes de dinossauros. Material super resistente para o dia a dia escolar! 🌟\"",
                "/images/Produtos/Estojo/790x770 Estojo Bento.png",
                estojos
        );

        Depoimento depEstojo3 = new Depoimento(
                "Agatha Mendes",
                "\"O estojo do Mickey ficou incrível! 🐭 Meu filho é apaixonado por quadrinhos e esse design em preto e branco com os detalhes coloridos ficou super estiloso. Ele é o mais animado da turma na hora de guardar os lápis! 📚\"",
                "/images/Produtos/Estojo/790x770 Estojo Mickey.png",
                estojos
        );

        Depoimento depEstojo4 = new Depoimento(
                "Luciana Consentino",
                "\"O kit de unicórnios é simplesmente mágico! 🦄✨ Minha filha ficou encantada com as carinhas fofas e as cores. O conjunto com três estojos diferentes ajuda muito na organização do material escolar. Qualidade incrível! 💕\"",
                "/images/Produtos/Estojo/790x770 Estojo Kit Unicornio.png",
                estojos
        );

        Depoimento depEstojo5 = new Depoimento(
                "Bruna Chanes",
                "\"O estojo da borboleta com o nome da minha filha ficou deslumbrante! 🦋 As cores azuis e douradas são lindas e o acabamento é impecável. Ela adora que tem o nome dela personalizado, facilita muito na escola! ✨\"",
                "/images/Produtos/Estojo/790x770 Estojo Celsa Schimidtz.png",
                estojos
        );

        Depoimento depEstojo6 = new Depoimento(
                "Carla Medeiros",
                "\"O estojo do Bob Esponja fez o maior sucesso! 🍍 Meu filho adora todos os personagens e as cores vibrantes. O tamanho é perfeito para todos os lápis e canetas da escola. Ele não troca por nada! 🌊🧽\"",
                "/images/Produtos/Estojo/790x770 Estojo Bob Esponja.png",
                estojos
        );

// Salva todos os 6 depoimentos da categoria Estojos de uma vez
        depoimentoRepository.saveAll(Arrays.asList(depEstojo1, depEstojo2, depEstojo3, depEstojo4, depEstojo5, depEstojo6));
    }
}
